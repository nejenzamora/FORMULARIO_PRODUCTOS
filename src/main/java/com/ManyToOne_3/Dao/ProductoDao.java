package com.ManyToOne_3.Dao;

import com.ManyToOne_3.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoDao extends JpaRepository<Producto, Long> {

}
