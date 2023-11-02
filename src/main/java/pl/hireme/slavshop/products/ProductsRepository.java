package pl.hireme.slavshop.products;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductsRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.type = :type")
    Page<Product> findByType(@Param("type") ProductType type, Pageable pageable);

}
