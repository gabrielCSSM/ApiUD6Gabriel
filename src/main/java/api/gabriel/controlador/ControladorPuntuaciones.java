package api.gabriel.controlador;

import api.gabriel.modelo.Juego;
import api.gabriel.modelo.Puntuacion;
import api.gabriel.repositorio.RepositorioJuego;
import api.gabriel.repositorio.RepositorioPuntuacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ControladorPuntuaciones {

    @Autowired
    private RepositorioPuntuacion puntRepo;
    @Autowired
    private  RepositorioJuego juegoRepo;

    @GetMapping("/all/byID")
    public List<Puntuacion> puntuacionesPorID() {
        return puntRepo.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    @GetMapping("/all/byName")
    public List<Puntuacion> puntuacionesPorNombre() {
        return puntRepo.findAll(Sort.by(Sort.Direction.ASC,"nombre"));
    }

    @GetMapping("/all/byScore")
    public List<Puntuacion> puntuacionesPorPuntos() {
        return puntRepo.findAll(Sort.by(Sort.Direction.ASC,"puntuacion"));
    }
}
