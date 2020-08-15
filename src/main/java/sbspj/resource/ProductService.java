package sbspj.resource;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service(value="productService")
@Transactional
@Resource(name = "productRepo")
public class ProductService {

}
