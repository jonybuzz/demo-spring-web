package com.example.springmvc.persistencia;

import com.example.springmvc.modelo.Mascota;
import com.example.springmvc.modelo.Raza;

import java.util.List;

import static java.util.Arrays.asList;

public class RepositorioMascotas {

    public List<Mascota> obtenerTodas() {
        Mascota mimi = new Mascota();
        mimi.setNombre("Mimi");
        mimi.setRaza(Raza.PERRO);
        Mascota felix = new Mascota();
        felix.setNombre("Felix");
        felix.setRaza(Raza.GATO);
        Mascota bob = new Mascota();
        bob.setNombre("Bob");
        bob.setRaza(Raza.GATO);
        return asList(mimi, felix, bob);
    }

}
