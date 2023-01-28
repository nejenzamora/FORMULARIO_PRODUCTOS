package com.ManyToOne_3.Controllers;

import com.ManyToOne_3.Entity.Categoria;
import com.ManyToOne_3.Entity.Producto;
import com.ManyToOne_3.Service.CategoriaService;
import com.ManyToOne_3.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/productos")
public class ProductoController {


    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listarProductos(){
        return new ResponseEntity<>(productoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> listarCategorias(){
        return new ResponseEntity<>(categoriaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Long id){
        return new ResponseEntity<>(productoService.FindById(id), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
       Producto productoEncontrado =(Producto) productoService.FindById(id);

        if (productoEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            productoEncontrado.setNombre(producto.getNombre());
            productoEncontrado.setPrecio(producto.getPrecio());
            productoEncontrado.setImagen(producto.getImagen());
            productoEncontrado.setCategoria(producto.getCategoria());
            return new ResponseEntity<>(productoService.save(productoEncontrado), HttpStatus.CREATED);

        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable Long id){
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    
}
