package com.example.springmvc.presentacion;

import com.example.springmvc.modelo.Dueño;
import com.example.springmvc.persistencia.RepositorioDueños;
import com.example.springmvc.presentacion.dto.LoginRequest;
import com.example.springmvc.presentacion.dto.LoginResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
public class LoginController {

    private final RepositorioDueños repoDueños;

    public LoginController() {
        this.repoDueños = new RepositorioDueños();
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {

        //validamos user/pass y buscamos datos de ese usuario para agregar en la sesión

        Dueño dueño = repoDueños.obtenerLuna(); //hardcode: siempre loguea a Jose
        System.out.println("Login: " + loginRequest);
        System.out.println("Login: " + dueño);

        SesionManager sesionManager = SesionManager.get();
        String idSesion = sesionManager.crear("dueño", dueño);

        return new LoginResponse(idSesion);
    }

}
