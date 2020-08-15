package sbspj.repository;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbspj.bean.ProductBean;

@Repository(value="productRepo")
@Resource(name="ProductBean")

public interface ProductRepository extends JpaRepository<ProductBean, Integer> {

}
