package br.com.musicaecafe.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_comentarios")
public class Comentarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O atributo Comente não pode estar vazio")
	@Size(min= 3, max = 255, message = "O atributo Comente deve possuir um mínimo de 3 caracteres e um máximo de 255")
	private String comente;
	
	@Size(max=1)
	private int avaliacao;
	
	@OneToMany(mappedBy = "comentarios", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("comentarios")
	private List<Postagem> postagem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComente() {
		return comente;
	}

	public void setComente(String comente) {
		this.comente = comente;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
	
}
