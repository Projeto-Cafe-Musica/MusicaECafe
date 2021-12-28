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
	@Table(name = "tb_tema") 
	public class Tema {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotBlank(message = "O atributo descrição não pode estar vazio e deve ter um mínimo de 5 caracteres e no máximo 1000 caracteres")
		@Size(min = 5, max = 1000) 
		private String descricao;
		
		@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
		@JsonIgnoreProperties("tema")
		private List<Postagem> postagem;
		
		

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
}