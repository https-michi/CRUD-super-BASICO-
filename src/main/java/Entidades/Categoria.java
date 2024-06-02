package Entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Categoria
 *
 */
@Entity
@Table(name = "tb_categoria")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoria_id", nullable = false)
	private Integer categoriaId;
	
	@Column(name = "nombre_categoria", nullable = false)
	private String nomCategoria;
	
	//@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
	//(private List<Producto> productos;
	
	public Categoria() {
		super();
	}

	public Categoria(String nomCategoria) {
		super();
		this.nomCategoria = nomCategoria;
	}

	public Categoria(Integer categoriaId, String nomCategoria) {
		super();
		this.categoriaId = categoriaId;
		this.nomCategoria = nomCategoria;
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getNomCategoria() {
		return nomCategoria;
	}

	public void setNomCategoria(String nomCategoria) {
		this.nomCategoria = nomCategoria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
   
}

