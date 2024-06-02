package dao;

import java.util.List;

import Entidades.Categoria;

public interface ICategoriaDAO {
	void crearCategoria(Categoria categoria);
	Categoria buscarPorIdCategoria(Integer id);
	List<Categoria>buscarCategoria();
	void actualizarCategoria(Categoria categoria);
	void eliminarCategoria( Integer id);

}
