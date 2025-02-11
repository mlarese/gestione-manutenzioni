package it.epicode.gestione_manutenzioni.interventi;

import it.epicode.gestione_manutenzioni.aziende.Azienda;
import it.epicode.gestione_manutenzioni.tecnico.Tecnico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "interventi")

public class Intervento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    // data numero tecnico descrizione
    private LocalDate data;
    private String numero;
    @ManyToOne
    Azienda azienda;
    @ManyToOne
    private Tecnico tecnico;

}
