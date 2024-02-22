package api.gabriel.controlador;

import api.gabriel.modelo.Juego;
import api.gabriel.repositorio.RepositorioJuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api6/juego")
public class ControladorJuego {
    @Autowired
    private RepositorioJuego juegoRepo;

    @GetMapping
    public List<Juego> obtenerTodos() {
        return juegoRepo.findAll();
    }

    @GetMapping("/byName")
    public List<Juego> juegosPorNombre() {
        return juegoRepo.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
    }

    @GetMapping("/{id}")
    public Juego obtenerJuego(@PathVariable long id) {
        return juegoRepo.findById(id).orElseThrow(() ->
                new RuntimeException("JUEGO no ENCONTRADO / no EXISTE")
        );
    }

    @PostMapping()
    public Juego meterJuego(@RequestBody Juego j) {
        return juegoRepo.save(j);
    }

    @PutMapping("/{id}")
    public Juego modificarJuego(@PathVariable long id, @RequestBody Juego juego) {
        return juegoRepo.findById(id).map(juegotemp -> {
            juegotemp.setNombre(juego.getNombre());
            return juegoRepo.save(juegotemp);
        }).orElseThrow(() -> new RuntimeException("JUEGO no ENCONTRADO"));
    }

    @DeleteMapping("/{id}")
    public void quitarJuego(@PathVariable long id) {
        juegoRepo.deleteById(id);
    }
}
