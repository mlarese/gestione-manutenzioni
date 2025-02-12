package it.epicode.gestione_manutenzioni.aziende;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AziendaRunner  implements CommandLineRunner {
    private final AziendaRepository aziendaRepository;
    private final Faker faker;
    @Override
    public void run(String... args) throws Exception {

        for(int i = 0; i < 50; i++){
            Azienda azienda = new Azienda();
            azienda.setNome(faker.company().name());
            azienda.setIndirizzo(faker.address().fullAddress());
            aziendaRepository.save(azienda);
        }

    }
}
