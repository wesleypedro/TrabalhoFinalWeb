package br.ufc.web.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {

	@Id
	private String papel;

	@ManyToMany(mappedBy = "roles")
	private List<ModelUsuario> usuarios;
	
//	@Override
	public String getAuthority() {
		return this.papel;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}
	
	
	public List<ModelUsuario> getPessoas() {
		return usuarios;
	}
	
	public void setUsuarios(List <ModelUsuario> usuarios) {
		this.usuarios = usuarios;
	}
}
