package com.ManyToOne_3.Service;

import com.ManyToOne_3.Dao.ProductoDao;
import com.ManyToOne_3.Entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImp implements ProductoService{

    @Autowired
    private ProductoDao productoDao;
    @Override
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public Producto FindById(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    public List<Producto> findAll() {
        return productoDao.findAll();
    }

    @Override
    public void delete(Long id) {

    }

}
