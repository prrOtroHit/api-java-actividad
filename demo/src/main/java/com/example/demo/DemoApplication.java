package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/productos")
public class DemoApplication {

    private static List<Producto> productos = new ArrayList<>();

    static {
        productos.add(new Producto(1, "Laptop", 1200));
        productos.add(new Producto(2, "Mouse", 25));
        productos.add(new Producto(3, "Teclado", 75));
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // --- Modelos de datos
    public static class Producto {
        public int id;
        public String nombre;
        public double precio;

        public Producto(int id, String nombre, double precio) {
            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
        }
    }

    // --- Endpoints de la API

    // GET: Obtiene todos los productos
    @GetMapping
    public List<Producto> getProductos() {
        return productos;
    }

    // POST: Crea un nuevo producto
    @PostMapping
    public Producto crearProducto(@RequestBody Producto nuevoProducto) {
        productos.add(nuevoProducto);
        return nuevoProducto;
    }

    // TAREA: Agregar un endpoint PUT para actualizar un producto.
    // Deberá recibir el ID en el path y los datos en el body.
    @PutMapping("/{id}")
    public void actualizarProducto(@PathVariable int id, @RequestBody Producto productoActualizado) {
        // Lógica para encontrar y actualizar el producto
    }

    // TAREA: Agregar un endpoint DELETE para eliminar un producto.
    // Deberá recibir el ID en el path.
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable int id) {
        // Lógica para encontrar y eliminar el producto
    }
}