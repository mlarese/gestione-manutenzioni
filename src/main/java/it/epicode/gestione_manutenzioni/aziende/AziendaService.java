package it.epicode.gestione_manutenzioni.aziende;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AziendaService {
    private final AziendaRepository aziendaRepository;


    public Page<Azienda> findAll(Pageable pageable) {
        return aziendaRepository.findAll(pageable);
    }

}
