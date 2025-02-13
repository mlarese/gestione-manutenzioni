package it.epicode.gestione_manutenzioni.tecnico;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TecnicoRequest {
    @NotBlank(message = "Il campo nome non puo essere vuoto")
    private String nome;
    @NotBlank(message = "Il campo cognome non puo essere vuoto")
    private String cognome;

    @NotBlank(message = "Il campo matricola non puo essere vuoto")
    @Size(min = 8, max = 8, message = "La matricola deve essere di 8 caratteri")
    private String matricola;

    private String codiceFiscale;
    @NotNull(message = "Il campo aziendaId non puo essere vuoto")
    private Long aziendaId;

    @NotBlank(message = "Il campo email non puo essere vuoto")
    @Email(message = "Email non valida")
    private String email;
}
