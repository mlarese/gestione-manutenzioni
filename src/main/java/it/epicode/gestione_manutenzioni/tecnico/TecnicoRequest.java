package it.epicode.gestione_manutenzioni.tecnico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TecnicoRequest {
    private String nome;
    private String cognome;
    private String matricola;
    private String codiceFiscale;
}
