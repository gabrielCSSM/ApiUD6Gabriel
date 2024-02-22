package api.gabriel.controlador;

import api.gabriel.modelo.Juego;
import api.gabriel.modelo.Puntuacion;
import api.gabriel.repositorio.RepositorioJuego;
import api.gabriel.repositorio.RepositorioPuntuacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api6/puntuacion")
public class ControladorPuntuaciones {

    @Autowired
    private RepositorioPuntuacion puntRepo;
    @Autowired
    private  RepositorioJuego juegoRepo;

    @GetMapping()
    public List<Puntuacion> obtenerTodos() {
        return puntRepo.findAll();
    }

    @GetMapping("/byName")
    public List<Puntuacion> puntuacionesPorNombre() {
        return puntRepo.findAll(Sort.by(Sort.Direction.ASC,"jugador"));
    }

    @GetMapping("/byScore/high")
    public List<Puntuacion> puntuacionesAltas() {
        return puntRepo.findAll(Sort.by(Sort.Direction.DESC,"puntuacion"));
    }
    @GetMapping("/byScore/low")
    public List<Puntuacion> puntuacionesBajas() {
        return puntRepo.findAll(Sort.by(Sort.Direction.ASC,"puntuacion"));
    }
}
