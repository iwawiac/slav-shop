package pl.hireme.slavshop.orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository <Order, Long> {

}
