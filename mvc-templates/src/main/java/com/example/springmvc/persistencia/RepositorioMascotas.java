package com.example.springmvc.persistencia;

import com.example.springmvc.modelo.Imagen;
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

    public Imagen obtenerImagenPorId(Integer idMascota) {
        final Imagen imagen = new Imagen();
        imagen.setNombre("perrito.png");
        imagen.setMascotaId(idMascota);
        imagen.setContenidoBase64("data:image/png;base64,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");
        return imagen;
    }

}