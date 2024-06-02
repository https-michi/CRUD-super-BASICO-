package Controller;

import java.util.List;

import Entidades.Categoria;
import dao.CategoriaDAOimpl;

public class DemoRunCRUD {
	public static void main(String[] args) {
		CategoriaDAOimpl categoriaDAO = new CategoriaDAOimpl();

		// Crear una nueva categoría
		Categoria nuevaCategoria = new Categoria();
		nuevaCategoria.setNomCategoria("Electrónica");
		categoriaDAO.crearCategoria(nuevaCategoria);

		// Buscar categoría por ID
		Categoria categoria = categoriaDAO.buscarPorIdCategoria(nuevaCategoria.getCategoriaId());
		System.out.println("Categoría encontrada: " + categoria.getNomCategoria());

		// Actualizar categoría
		categoria.setNomCategoria("Electrodomésticos");
		categoriaDAO.actualizarCategoria(categoria);

		// Buscar todas las categorías
		List<Categoria> categorias = categoriaDAO.buscarCategoria();
		for (Categoria c : categorias) {
			System.out.println("Categoría: " + c.getNomCategoria());

		// Eliminar categoría
		categoriaDAO.eliminarCategoria(categoria.getCategoriaId());

		}
	}
}
