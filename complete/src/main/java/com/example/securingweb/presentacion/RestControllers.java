package com.example.securingweb.presentacion;

import com.example.securingweb.negocio.dominio.Usuario;
import com.example.securingweb.persistencia.UsuariosDao;
import java.util.List;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllers {

    @RequestMapping(method = GET, path = "/rest/usuarios")
    public List<Usuario> usuarios() {
        return new UsuariosDao().getAll();
    }

    @RequestMapping(method = GET, path = "/rest/usuarios/{username}")
    public Usuario usuarios(@PathVariable String username) {
        UsuariosDao usuariosDao = new UsuariosDao();
        List<Usuario> usuarios = usuariosDao.getAll();
        Usuario usuario = usuarios.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst().orElseThrow(() -> new UsernameNotFoundException("No existe el usuario."));
        return usuario;
    }

    @RequestMapping(method = POST, path = "/rest/usuarios")
    public void crearUsuario(@RequestBody Usuario usuario) {
        System.out.println("Creando usuario " + usuario.getUsername() + "...");
    }

}
