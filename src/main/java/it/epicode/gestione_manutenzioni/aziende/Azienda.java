package it.epicode.gestione_manutenzioni.aziende;

import it.epicode.gestione_manutenzioni.interventi.Intervento;
import it.epicode.gestione_manutenzioni.tecnico.Tecnico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "aziende")

public class Azienda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    // nome indirizzo telefono tecnici interventi
    private String nome;
    private String indirizzo;
    private String telefono;
    @OneToMany
    private Set<Tecnico> tecnici = new HashSet<>();
    @OneToMany(mappedBy = "azienda")
    private Set<Intervento> interventi = new HashSet<>();

}
