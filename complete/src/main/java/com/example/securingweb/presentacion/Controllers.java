package com.example.securingweb.presentacion;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class Controllers {

    @RequestMapping(method = GET, path = {"/","/home"})
    public String homeView(){
        //retorna el html ubicado en src/main/resources/templates
        //luego de procesarlo con el view engine Thymeleaf
        return "home";
    }

    @RequestMapping(method = GET, path = "/hello")
    public String helloView(Model model, Authentication auth){
        //se agrega un objeto al modelo para que Thymeleaf lo pueda usar
        //durante el procesamiento
        model.addAttribute("nombre", "Juanito");
        //se puede usar el objeto auth para obtener datos de la sesion
        model.addAttribute("usuarioLogeado", auth.getName());
        return "hello";
    }

    @RequestMapping(method = GET, path = "/login")
    public String loginView(Model model){
        model.addAttribute("nombre", "Juanito");
        return "login";
    }
}
