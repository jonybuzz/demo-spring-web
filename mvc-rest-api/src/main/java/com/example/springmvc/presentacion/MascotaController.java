package com.example.springmvc.presentacion;

import com.example.springmvc.modelo.Mascota;
import com.example.springmvc.persistencia.RepositorioMascotas;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MascotaController {

    private final RepositorioMascotas repoMascotas;

    public MascotaController() {
        this.repoMascotas = new RepositorioMascotas();
    }

    @GetMapping("/mascotas")
    public ResponseEntity<List<Mascota>> obtenerTodas() {
        return ResponseEntity.status(200).body(repoMascotas.obtenerTodas());
    }

    @PostMapping("/mascotas")
    public ResponseEntity crear(@RequestBody Mascota mascota) {
        System.out.println("Creando mascota...");
        System.out.println(mascota);
        validarNuevaMascota(mascota);
        return ResponseEntity.status(201).body(mascota);
    }

    private void validarNuevaMascota(Mascota mascota) {
        if(mascota.getNombre() == null) {
            throw new IllegalArgumentException("El nombre es obligatorio, elegí otro");
        }
    }

}
