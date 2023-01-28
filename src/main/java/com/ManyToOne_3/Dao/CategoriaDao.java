package com.ManyToOne_3.Dao;

import com.ManyToOne_3.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaDao extends JpaRepository<Categoria, Long> {
}
