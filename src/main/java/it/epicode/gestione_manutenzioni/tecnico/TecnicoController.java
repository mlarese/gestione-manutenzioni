package it.epicode.gestione_manutenzioni.tecnico;

import it.epicode.gestione_manutenzioni.general.responses.CreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tecnici")
@RequiredArgsConstructor
public class TecnicoController {
    private final TecnicoService tecnicoService;

    @GetMapping
    // GET http://localhost:8080/api/tecnici
    @ResponseStatus(HttpStatus.OK)
    public List<Tecnico> findAll() {
        return tecnicoService.findAll();
    }

    // GET http://localhost:8080/api/tecnici/1
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tecnico findById(@PathVariable Long id) {
        return tecnicoService.findById(id);
    }

    // POST http://localhost:8080/api/tecnici
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponse save(@RequestBody TecnicoRequest request) {
        return tecnicoService.save(request);
    }

}
