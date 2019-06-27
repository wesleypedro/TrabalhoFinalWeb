package br.ufc.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.web.model.ModelUsuario;

@Repository
public interface RepositoryUsuario extends JpaRepository<ModelUsuario, Long>{
	ModelUsuario findByEmail(String email);
	ModelUsuario findByCpf(String cpf);
}
