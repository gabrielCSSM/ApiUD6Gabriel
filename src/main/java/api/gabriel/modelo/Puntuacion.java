package api.gabriel.modelo;

import jakarta.persistence.*;

@Entity(name = "puntuacion")
public class Puntuacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String jugador;

    int puntuacion;

    @ManyToOne
    @JoinColumn(name = "ref_juego")
    private Juego juego;

    public Puntuacion() {
    }

    public Puntuacion(String jugador, int puntuacion, Juego juego) {
        this.jugador = jugador;
        this.puntuacion = puntuacion;
        this.juego = juego;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego j) {
        this.juego = j;
    }
}
