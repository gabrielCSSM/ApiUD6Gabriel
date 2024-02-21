package api.gabriel.repositorio;

import api.gabriel.modelo.Juego;
import api.gabriel.modelo.Puntuacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioPuntuacion extends JpaRepository<Puntuacion, Long> {
    List<Puntuacion> puntuacionesPorID();
    List<Puntuacion> puntuacionesPorNombre();
    List<Puntuacion> puntuacionesPorPuntos();
}
