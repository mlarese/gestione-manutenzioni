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
    public List<TecnicoResponse> findAll() {
        return tecnicoService.findAll();
    }

    // GET http://localhost:8080/api/tecnici/1
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TecnicoDettaglioResponse findById(@PathVariable Long id) {
        return tecnicoService.findTecnicoResponseById(id);
    }

    // POST http://localhost:8080/api/tecnici
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponse save(@RequestBody TecnicoRequest request) {
        return tecnicoService.save(request);
    }

    // PUT http://localhost:8080/api/tecnici/1
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tecnico modify(@PathVariable Long id, @RequestBody TecnicoRequest request) {
        return tecnicoService.modify(id, request);
    }

    // DELETE http://localhost:8080/api/tecnici/1
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        tecnicoService.delete(id);
    }
}
