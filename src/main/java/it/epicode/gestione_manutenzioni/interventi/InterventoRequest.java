package it.epicode.gestione_manutenzioni.interventi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
// dto per la creazione di un intervento
public class InterventoRequest {
    // data, numero, descrizione, tecnicoId, aziendaId
    private LocalDate data;
    private String numero;
    private String descrizione;
    private Long tecnicoId;
    private Long aziendaId;

}
