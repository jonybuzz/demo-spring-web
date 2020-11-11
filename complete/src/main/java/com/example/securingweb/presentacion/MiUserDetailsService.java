package com.example.securingweb.presentacion;

import com.example.securingweb.negocio.dominio.Usuario;
import com.example.securingweb.persistencia.UsuariosDao;
import static java.util.Arrays.asList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MiUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //solo a modo de ejemplo se crea una lista con usuarios precargados
        UsuariosDao usuariosDao = new UsuariosDao();
        List<Usuario> usuarios = usuariosDao.getAll();
        Usuario usuario = usuarios.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst().orElseThrow(() -> new UsernameNotFoundException("No existe el usuario."));
        
        //Spring espera que el componente retorne un objeto
        //que cumpla con la interfaz UserDetails
        //Aca lo genero a partir de la clase de dominio Usuario
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return asList(new SimpleGrantedAuthority(usuario.getRol()));
            }

            @Override
            public String getPassword() {
                return usuario.getPassword();
            }

            @Override
            public String getUsername() {
                return usuario.getUsername();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }

}
