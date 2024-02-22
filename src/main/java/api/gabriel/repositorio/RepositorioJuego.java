package api.gabriel.repositorio;

import api.gabriel.modelo.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioJuego extends JpaRepository<Juego, Long> {
    //List<Juego> juegosPorID();
    //List<Juego> juegosPorNombre();
}
