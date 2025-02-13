package it.epicode.gestione_manutenzioni.tecnico;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.epicode.gestione_manutenzioni.aziende.Azienda;
import it.epicode.gestione_manutenzioni.interventi.Intervento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tecnici")

public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    // nome cognome matricola
    private String nome;
    private String cognome;
    @Column(unique = true)
    private String matricola;
    @Column(unique = true)
    private String codiceFiscale;
    private Boolean attivo=true;
    private String email;

    @ManyToOne
    // per System.out
    @ToString.Exclude
    @JsonIgnoreProperties("tecnici")
    Azienda azienda;

    @ToString.Exclude
    @JsonIgnoreProperties("tecnico")
    @OneToMany(mappedBy = "tecnico")
    private Set<Intervento> interventi = new HashSet<>();

}
