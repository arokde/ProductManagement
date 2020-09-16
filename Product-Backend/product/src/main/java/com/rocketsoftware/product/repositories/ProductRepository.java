package com.rocketsoftware.product.repositories;

import com.rocketsoftware.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {


}

