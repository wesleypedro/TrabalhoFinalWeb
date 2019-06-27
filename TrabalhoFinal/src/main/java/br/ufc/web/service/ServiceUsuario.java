package br.ufc.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.ufc.web.model.ModelUsuario;
import br.ufc.web.model.Role;
import br.ufc.web.repository.RepositoryRole;
import br.ufc.web.repository.RepositoryUsuario;

@Service
public class ServiceUsuario {
	
	@Autowired
	RepositoryUsuario rUsuario;
	
	
	@Autowired
	RepositoryRole rRole;
	
	public int usuarioCadastrar(ModelUsuario usuario) {
		
		System.out.println("antes primeiro if");
		
		if(rUsuario.findByEmail(usuario.getEmail()) != null 
			|| rUsuario.findByCpf(usuario.getCpf()) != null) {
			
			System.out.println("retorno 0");
			return 0;
		}
		
		
		System.out.println(usuario.getBairro());
		System.out.println(usuario.getCidade());
		System.out.println(usuario.getCpf());
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getNome());
		System.out.println(usuario.getSenha());
		
		
		Role role = rRole.findByPapel("ROLE_USER");
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		usuario.setRoles(roles);
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		rUsuario.save(usuario);
		
		System.out.println("retorno 1");
		return 1;
	}
	
}
