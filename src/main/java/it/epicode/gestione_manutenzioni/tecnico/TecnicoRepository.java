package it.epicode.gestione_manutenzioni.tecnico;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    public Tecnico findByMatricola(String matricola);
    public boolean existsByMatricola(String matricola);
}
