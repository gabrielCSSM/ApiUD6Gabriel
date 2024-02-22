package api.gabriel.controlador;

import api.gabriel.modelo.Juego;
import api.gabriel.repositorio.RepositorioJuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api6/juego")
public class ControladorJuego {
    @Autowired
    private RepositorioJuego juegoRepo;

    @GetMapping("/byID")
    public List<Juego> juegosPorID() {
        return juegoRepo.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    @GetMapping("/byName")
    public List<Juego> juegosPorNombre() {
        return juegoRepo.findAll(Sort.by(Sort.Direction.ASC,"nombre"));
    }
    @GetMapping("/{id}")
    public Juego obtenerJuego(@PathVariable long id) {
        return juegoRepo.findById(id).orElseThrow(() ->
                new RuntimeException("JUEGO no ENCONTRADO / no EXISTE")
        );
    }
}
