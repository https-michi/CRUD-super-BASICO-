package Controller;

import java.util.List;

import Entidades.Categoria;
import dao.CategoriaDAOimpl;

public class DemoRunCRUD {
    
    private static CategoriaDAOimpl categoriaDAO = new CategoriaDAOimpl();

    public static void main(String[] args) {
        // Crear una nueva categoría
        crearCategoria("Diseño");

        // Buscar categoría por ID
        //buscarPorIdCategoria(3);

        // Actualizar una categoría existente
        //actualizarCategoria(3, "electronica");

        // Buscar todas las categorías
        //buscarCategorias();

        // Eliminar una categoría por ID
        //eliminarCategoria(1);
    }

    private static void crearCategoria(String nombreCategoria) {
        Categoria nuevaCategoria = new Categoria(nombreCategoria);
        categoriaDAO.crearCategoria(nuevaCategoria);
        System.out.println("Categoría creada: " + nuevaCategoria);
    }

    private static void buscarPorIdCategoria(int id) {
        Categoria categoria = categoriaDAO.buscarPorIdCategoria(id);
        if (categoria != null) {
            System.out.println("Categoría encontrada: " + categoria);
        } else {
            System.out.println("Categoría con ID " + id + " no encontrada.");
        }
    }

    private static void buscarCategorias() {
        List<Categoria> categorias = categoriaDAO.buscarCategoria();
        System.out.println("Categorías encontradas:");
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
    }

    private static void actualizarCategoria(int id, String nuevoNombre) {
        Categoria categoria = categoriaDAO.buscarPorIdCategoria(id);
        if (categoria != null) {
            categoria.setNomCategoria(nuevoNombre);
            categoriaDAO.actualizarCategoria(categoria);
            System.out.println("Categoría actualizada: " + categoria);
        } else {
            System.out.println("Categoría con ID " + id + " no encontrada.");
        }
    }

    private static void eliminarCategoria(int id) {
        categoriaDAO.eliminarCategoria(id);
        System.out.println("Categoría con ID " + id + " eliminada.");
    }
}