package com.ManyToOne_3.Service;

import com.ManyToOne_3.Entity.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoriaService {

    public List<Categoria> findAll();
}
