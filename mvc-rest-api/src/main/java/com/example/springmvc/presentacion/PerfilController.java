package com.example.springmvc.presentacion;

import com.example.springmvc.modelo.Dueño;
import com.example.springmvc.persistencia.RepositorioDueños;
import com.example.springmvc.presentacion.dto.MisDatos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@CrossOrigin
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

    @GetMapping("/mis-datos") //usando sesion
    public ResponseEntity<MisDatos> obtenerMisDatos(@RequestHeader("Authorization") String idSesion) {

        Map<String, Object> atributosSesion = SesionManager.get().obtenerAtributos(idSesion);

//        Date fechaInicioSesion = (Date) atributosSesion.get("fechaInicio");

        Dueño dueñoSesion = (Dueño) atributosSesion.get("dueño");
        System.out.println("Obteniendo datos de: " + dueñoSesion);

        if (dueñoSesion == null) {
            return ResponseEntity.status(404).build();
        }

        //lo que quiera hacer con el dueño
        MisDatos misDatos = new MisDatos();
        Dueño dueño = repoDueños.obtenerTodos().stream().filter(d -> d.getId() == dueñoSesion.getId()).findFirst().get();
        misDatos.setNombre(dueño.getNombre());
        misDatos.setMascotas(dueño.getMascotas());
        return ResponseEntity.status(200).body(misDatos);

    }

}
