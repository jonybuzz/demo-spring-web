package com.example.springmvc.persistencia;

import com.example.springmvc.modelo.Mascota;
import com.example.springmvc.modelo.Raza;

import java.util.List;

import static java.util.Arrays.asList;

public class RepositorioMascotas {

    public List<Mascota> obtenerTodas() {
        Mascota mimi = new Mascota();
        mimi.setId(1);
        mimi.setNombre("Mimi");
        mimi.setRaza(Raza.PERRO);
        Mascota felix = new Mascota();
        felix.setId(2);
        felix.setNombre("Felix");
        felix.setRaza(Raza.GATO);
        Mascota bob = new Mascota();
        bob.setId(3);
        bob.setNombre("Bob");
        bob.setRaza(Raza.GATO);
        Mascota pachi = new Mascota();
        pachi.setId(4);
        pachi.setNombre("Pachi");
        pachi.setRaza(Raza.PERRO);
        pachi.setActiva(false);
        return asList(mimi, felix, bob, pachi);
    }

}
