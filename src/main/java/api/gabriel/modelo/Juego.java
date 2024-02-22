package api.gabriel.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity(name = "juego")
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotBlank(message = "El nombre NO puede estar vacio")
    String nombre;

    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Puntuacion> puntuacions;
    public Juego() {
    }

    public Juego(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
