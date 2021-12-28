package br.com.musicaecafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.musicaecafe.model.Comentarios;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentarios, Long> {
	
	public List<Comentarios> findAllByComenteContainingIgnoreCase(String comente);
}

