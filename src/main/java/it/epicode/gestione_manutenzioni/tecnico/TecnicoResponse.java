package it.epicode.gestione_manutenzioni.tecnico;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// dto per la find all
public class TecnicoResponse {
    private Long id;
    private String nome;
    private String cognome;
    private boolean attivo;
    private String matricola;
    private String codiceFiscale;

}
