package com.example.springmvc.presentacion;

import com.example.springmvc.modelo.Dueño;
import com.example.springmvc.persistencia.RepositorioDueños;
import com.example.springmvc.persistencia.RepositorioMascotas;
import com.example.springmvc.presentacion.dto.MisDatos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerfilController {

    private final RepositorioDueños repoDueños;

    public PerfilController() {
        this.repoDueños = new RepositorioDueños();
    }

    @GetMapping("/mis-datos/{idUsuario}")
    public ResponseEntity<MisDatos> obtenerMisDatos(@PathVariable Integer idUsuario) {
        MisDatos misDatos = new MisDatos();
        if (idUsuario == 1) {
            Dueño dueño = repoDueños.obtenerJose();
            misDatos.setNombre(dueño.getNombre());
            misDatos.setMascotas(dueño.getMascotas());
            return ResponseEntity.status(200).body(misDatos);
        }
        if (idUsuario == 2) {
            Dueño dueño = repoDueños.obtenerLuna();
            misDatos.setNombre(dueño.getNombre());
            misDatos.setMascotas(dueño.getMascotas());
            return ResponseEntity.status(200).body(misDatos);
        }
        return ResponseEntity.status(404).build();
    }

}
