package it.epicode.gestione_manutenzioni.tecnico;

import it.epicode.gestione_manutenzioni.interventi.Intervento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TecnicoDettaglioResponse {
    private Long id;
    private String nome;
    private String cognome;
    private boolean attivo;
    private Long aziendaId;
    private Set<Intervento> interventi;
}
