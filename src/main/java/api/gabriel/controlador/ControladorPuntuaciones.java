package api.gabriel.controlador;

import api.gabriel.modelo.Juego;
import api.gabriel.modelo.Puntuacion;
import api.gabriel.repositorio.RepositorioJuego;
import api.gabriel.repositorio.RepositorioPuntuacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api6/puntuacion")
public class ControladorPuntuaciones {

    @Autowired
    private RepositorioPuntuacion puntRepo;
    @Autowired
    private RepositorioJuego juegoRepo;

    @GetMapping()
    public List<Puntuacion> obtenerTodos() {
        return puntRepo.findAll();
    }

    @GetMapping("/byName")
    public List<Puntuacion> puntuacionesPorNombre() {
        return puntRepo.findAll(Sort.by(Sort.Direction.ASC, "jugador"));
    }

    @GetMapping("/byScore/high")
    public List<Puntuacion> puntuacionesAltas() {
        return puntRepo.findAll(Sort.by(Sort.Direction.DESC, "puntuacion"));
    }

    @GetMapping("/byScore/low")
    public List<Puntuacion> puntuacionesBajas() {
        return puntRepo.findAll(Sort.by(Sort.Direction.ASC, "puntuacion"));
    }

    @GetMapping("/{id}")
    public Puntuacion obtenerPuntuacion(@PathVariable long id) {
        return puntRepo.findById(id).orElseThrow(() ->
                new RuntimeException("PUNTUACION no ENCONTRADA / no EXISTE")
        );
    }

    @PostMapping("/juego/{id}")
    public Puntuacion añadirPuntuacion(@PathVariable long id, @RequestBody Puntuacion p) {
        Juego jtemp = juegoRepo.findById(id).orElseThrow(() -> new RuntimeException("PUNTUACION no ENCONTRADA / no EXISTE"));
        p.setJuego(jtemp);
        return puntRepo.save(p);
    }

    @PutMapping("/{id}")
    public Puntuacion modificarPuntuacion(@PathVariable long id, @RequestBody Puntuacion p) {
        return puntRepo.findById(id).map(punttemp -> {
            punttemp.setJugador(p.getJugador() != null ? p.getJugador() : punttemp.getJugador());
            punttemp.setPuntuacion(p.getPuntuacion());
            return puntRepo.save(punttemp);
        }).orElseThrow(() -> new RuntimeException("PUNTUACION no ENCONTRADA / no EXISTE"));
    }

    @DeleteMapping("/{id}")
    public void eliminarPuntuacion(@PathVariable long id) {
        puntRepo.deleteById(id);
    }
}
