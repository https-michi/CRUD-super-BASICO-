package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import Entidades.Categoria;

public class CategoriaDAOimpl implements ICategoriaDAO {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public CategoriaDAOimpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ProCRUD");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void crearCategoria(Categoria categoria) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(categoria);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public Categoria buscarPorIdCategoria(Integer id) {
        Categoria categoria = null;
        try {
            categoria = entityManager.find(Categoria.class, id);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
        return categoria;
    }

    @Override
    public List<Categoria> buscarCategoria() {
        List<Categoria> categorias = null;
        try {
            Query query = entityManager.createQuery("SELECT c FROM Categoria c");
            categorias = query.getResultList();
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
        return categorias;
    }

    @Override
    public void actualizarCategoria(Categoria categoria) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(categoria);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public void eliminarCategoria(Integer id) {
        try {
            entityManager.getTransaction().begin();
            Categoria categoria = entityManager.find(Categoria.class, id);
            if (categoria != null) {
                entityManager.remove(categoria);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}
