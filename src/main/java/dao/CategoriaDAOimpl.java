package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import Entidades.Categoria;

public class CategoriaDAOimpl implements ICategoriaDAO {

	private EntityManager entityManager;

	// Constructor que inicializa el EntityManager
	public CategoriaDAOimpl() {
		entityManager = Persistence.createEntityManagerFactory("ProCRUD").createEntityManager();
	}

	// Método para crear una nueva categoría
	@Override
	public void crearCategoria(Categoria categoria) {
		try {
			entityManager.getTransaction().begin(); // Inicia la transacción
			entityManager.persist(categoria); // Inserta la categoría en la base de datos
			entityManager.getTransaction().commit(); // Confirma la transacción
		} catch (Exception e) {
			System.out.println("Ocurrió un error: " + e.getMessage());
		} finally {
			entityManager.clear();
		}
	}

	@Override
	public Categoria buscarPorIdCategoria(Integer id) {
		return null;
	}

	@Override
	public List<Categoria> buscarCategoria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarCategoria(Integer id) {
		// TODO Auto-generated method stub

	}

}
