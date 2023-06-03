package hxari.spring.server;

import hxari.spring.server.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositori untuk entitas Product.
 * Menggunakan Spring Data JPA untuk operasi CRUD (Create, Read, Update, Delete) pada entitas Product.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{}
