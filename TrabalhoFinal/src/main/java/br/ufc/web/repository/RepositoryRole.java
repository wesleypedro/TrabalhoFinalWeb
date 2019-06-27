package br.ufc.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.web.model.Role;

public interface RepositoryRole extends JpaRepository<Role, String> {
	Role findByPapel(String papel);
}
