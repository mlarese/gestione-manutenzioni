package it.epicode.gestione_manutenzioni.tecnico;

import it.epicode.gestione_manutenzioni.general.responses.CreateResponse;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TecnicoService {
    private final TecnicoRepository tecnicoRepository;

    // metodo per trovare tutti i dipendenti
    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    public Tecnico modify(Long id, TecnicoRequest request) {
        Tecnico tecnico = findById(id);
        BeanUtils.copyProperties(request, tecnico);
        tecnicoRepository.save(tecnico);
        return tecnico;
    }

    //metodo per inserire un dipendente
    public CreateResponse save(TecnicoRequest request) {
        if(tecnicoRepository.existsByMatricola(request.getMatricola())){
            throw new EntityExistsException("Tecnico già esistente");
        }

        if(tecnicoRepository.existsByCodiceFiscale(request.getCodiceFiscale())){
            throw new EntityExistsException("Tecnico già esistente: controllo su codice fiscale");
        }

        Tecnico tecnico = new Tecnico();
        BeanUtils.copyProperties(request, tecnico);
        tecnicoRepository.save(tecnico);

        CreateResponse response = new CreateResponse();
        BeanUtils.copyProperties(tecnico, response);

        return response;

    }

    // metodo per trovare un dipendente per id
    public Tecnico findById(Long id) {
        if(!tecnicoRepository.existsById(id)){
            throw new EntityNotFoundException("Tecnico non trovato");
        }
        return tecnicoRepository.findById(id).get();
    }

    public void delete(Long id) {
        Tecnico tecnico = findById(id);
        tecnicoRepository.deleteById(id);
    }

}
