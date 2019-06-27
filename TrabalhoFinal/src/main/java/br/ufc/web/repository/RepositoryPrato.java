package br.ufc.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.web.model.ModelPrato;

@Repository
public interface RepositoryPrato extends JpaRepository<ModelPrato, Long>{
	List<ModelPrato> findAllByNome(String nome);
//	ModelPrato findByCodigo();
}
