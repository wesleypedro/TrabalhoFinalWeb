package br.ufc.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.ufc.web.model.ModelUsuario;
import br.ufc.web.repository.RepositoryUsuario;

@Repository
public class UserDetailsServiceImplementacao implements UserDetailsService {
	
	@Autowired
	private RepositoryUsuario rUsuario;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		ModelUsuario usuario = rUsuario.findByEmail(email);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
	}

}
