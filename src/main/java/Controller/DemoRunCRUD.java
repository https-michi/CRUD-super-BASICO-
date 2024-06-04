package Controller;

import java.util.List;
import java.util.Scanner;
import Entidades.Categoria;
import dao.CategoriaDAOimpl;

public class DemoRunCRUD {
    
    private static CategoriaDAOimpl categoriaDAO = new CategoriaDAOimpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            int opcion;
            do {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Crear una nueva categoría");
                System.out.println("2. Buscar categoría por ID");
                System.out.println("3. Actualizar una categoría existente");
                System.out.println("4. Buscar todas las categorías");
                System.out.println("5. Eliminar una categoría por ID");
                System.out.println("6. Salir");
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nombre de la nueva categoría:");
                        String nombreNuevaCategoria = scanner.nextLine();
                        crearCategoria(nombreNuevaCategoria);
                        break;
                    case 2:
                        System.out.println("Ingrese el ID de la categoría a buscar:");
                        int idCategoriaBuscar = scanner.nextInt();
                        buscarPorIdCategoria(idCategoriaBuscar);
                        break;
                    case 3:
                        System.out.println("Ingrese el ID de la categoría a actualizar:");
                        int idCategoriaActualizar = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.println("Ingrese el nuevo nombre de la categoría:");
                        String nuevoNombreCategoria = scanner.nextLine();
                        actualizarCategoria(idCategoriaActualizar, nuevoNombreCategoria);
                        break;
                    case 4:
                        buscarCategorias();
                        break;
                    case 5:
                        System.out.println("Ingrese el ID de la categoría a eliminar:");
                        int idCategoriaEliminar = scanner.nextInt();
                        eliminarCategoria(idCategoriaEliminar);
                        break;
                    case 6:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
            } while (opcion != 6);
        } finally {
            categoriaDAO.close();
            scanner.close();
        }
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
        if (categorias != null) {
            for (Categoria categoria : categorias) {
                System.out.println(categoria);
            }
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
