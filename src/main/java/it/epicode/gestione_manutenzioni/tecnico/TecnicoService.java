package it.epicode.gestione_manutenzioni.tecnico;

import it.epicode.gestione_manutenzioni.general.responses.CreateResponse;
import it.epicode.gestione_manutenzioni.mail.EmailService;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class TecnicoService {
    private final TecnicoRepository tecnicoRepository;
    private final EmailService emailService;
    @Value("${messages.new.tecnico.subject}")
    private String newTecnicoSubject;

    @Value("${messages.new.tecnico.body}")
    private String newTecnicoBody;
    // metodo per trovare tutti i dipendenti
    public List<TecnicoResponse> findAll() {
        // trasforma la lista di tecnici recuperata con findAll
        // in una lista di TecnicoResponse usando il metodo che abbia creato nel service
        List<TecnicoResponse> response =  tecnicoResponseListFromEntityList(tecnicoRepository.findAll());
        return response;
    }

    public Tecnico modify(Long id, TecnicoRequest request) {
        Tecnico tecnico = findById(id);
        BeanUtils.copyProperties(request, tecnico);
        tecnicoRepository.save(tecnico);
        return tecnico;
    }

    //metodo per inserire un dipendente
    // invio una email di notifica per inserimento tecnico
    public CreateResponse save(@Valid TecnicoRequest request)   {
        System.out.println("Dentro service");
        if(tecnicoRepository.existsByMatricola(request.getMatricola())){
            throw new EntityExistsException("Tecnico già esistente");
        }

        if(tecnicoRepository.existsByCodiceFiscale(request.getCodiceFiscale())){
            throw new EntityExistsException("Tecnico già esistente: controllo su codice fiscale");
        }

        Tecnico tecnico = tecnicoFromRequest(request);

        tecnicoRepository.save(tecnico);
        CreateResponse response = new CreateResponse();
        BeanUtils.copyProperties(tecnico, response);

        try {
            emailService.sendEmail(
                    tecnico.getEmail(), newTecnicoSubject, newTecnicoBody + " "
                            +tecnico.getEmail()) ;
        } catch (MessagingException e) {
            System.out.println("Errore invio email");
        }

        return response;

    }

    // metodo per trovare un dipendente per id
    public Tecnico findById(Long id) {
        if(!tecnicoRepository.existsById(id)){
            throw new EntityNotFoundException("Tecnico non trovato");
        }
        return tecnicoRepository.findById(id).get();
    }

    @Transactional
    public TecnicoDettaglioResponse findTecnicoResponseById(Long id){
        if(!tecnicoRepository.existsById(id)){
            throw new EntityNotFoundException("Tecnico non trovato");
        }

        Tecnico tecnico = tecnicoRepository.findById(id).get();

        TecnicoDettaglioResponse response = new TecnicoDettaglioResponse();
        BeanUtils.copyProperties(tecnico, response);
        response.setInterventi(tecnico.getInterventi());
        response.setAziendaId(tecnico.getAzienda().getId());

        return response;

    }

    public void delete(Long id) {
        Tecnico tecnico = findById(id);
        tecnicoRepository.deleteById(id);
    }


    public TecnicoResponse tecnicoResponseFromEntity(Tecnico tecnico){
        TecnicoResponse response = new TecnicoResponse();
        BeanUtils.copyProperties(tecnico, response);
        return response;
    }

    public List<TecnicoResponse> tecnicoResponseListFromEntityList(List<Tecnico> tecnici){
        return tecnici.stream().map(this::tecnicoResponseFromEntity).toList();
    }

    public Tecnico tecnicoFromRequest(TecnicoRequest request){
        Tecnico tecnico = new Tecnico();
        BeanUtils.copyProperties(request, tecnico);
        return tecnico;
    }


}
