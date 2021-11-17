package com.example.springmvc.presentacion;

import com.example.springmvc.modelo.Mascota;
import com.example.springmvc.persistencia.RepositorioMascotas;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MascotaController {

    private final RepositorioMascotas repoMascotas;
    private final Handlebars handlebars;

    public MascotaController() {
        this.repoMascotas = new RepositorioMascotas();
        this.handlebars = new Handlebars();
    }

//    Rest API controller:

//    @GetMapping("/mascotas")
//    public ResponseEntity<List<Mascota>> obtenerTodas() {
//        return ResponseEntity.status(200).body(repoMascotas.obtenerTodas());
//    }

    @GetMapping(value = "/mascotas", produces = MediaType.TEXT_HTML_VALUE) //-> importante en Spring
    public ResponseEntity<String> obtenerVistaDeTodas() throws IOException {

        Template template = handlebars.compile("/templates/index");
        List<Mascota> mascotas = repoMascotas.obtenerTodas();
        Map<String, Object> model = new HashMap<>();
        model.put("mascotas", mascotas);

        String html = template.apply(model);

        return ResponseEntity.status(200).body(html);
    }

//    Spark route:

//    get("mascotas", (req, res) -> {
//        Map<String, Object> model = new HashMap<>();
//        model.put("mascotas", mascotas);
//        return new HandlebarsTemplateEngine().render(
//                new ModelAndView(model, "/templates/mascotas")
//        );
//    });

}
