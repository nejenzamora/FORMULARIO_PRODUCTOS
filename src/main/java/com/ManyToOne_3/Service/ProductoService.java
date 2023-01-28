package com.ManyToOne_3.Service;

import com.ManyToOne_3.Entity.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductoService {

    public Producto save(Producto producto);
    public Producto FindById(Long id);
    public List<Producto> findAll();
    public void delete(Long id);

}
