package it.epicode.gestione_manutenzioni.aziende;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aziende")
@RequiredArgsConstructor
public class AziendaController {
    private final AziendaService aziendaService;

    // sortBy è una stringa contenenete il nome del campo su cui ordinare aggiungere
    // ',desc' per ordinare in modo decrescente esempio 'nome,desc'
    // esegue l'ordinamento in base al campo nome in ordine decrescente
    @GetMapping
    private Page<Azienda> findAll(@RequestParam int page, @RequestParam int recordPerPagina, @RequestParam String sortBy) {
        // trasformare questi parametri in un pageable esiste la classe PageRequest
        // che è quella deputata a creare il pageable
        Pageable pageable = PageRequest.of(page, recordPerPagina, Sort.by(sortBy));
        return aziendaService.findAll(pageable);
    }

}
