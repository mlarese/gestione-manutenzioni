package it.epicode.gestione_manutenzioni.aziende;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// dto per restituire i dati alla select delle aziende
public class AziendaSelectResponse {
    private Long id;
    private String nome;
}
