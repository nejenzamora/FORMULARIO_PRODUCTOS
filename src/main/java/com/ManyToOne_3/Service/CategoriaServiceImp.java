package com.ManyToOne_3.Service;

import com.ManyToOne_3.Dao.CategoriaDao;
import com.ManyToOne_3.Entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImp implements CategoriaService{

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    public List<Categoria> findAll(){
        return categoriaDao.findAll();
    }
}
