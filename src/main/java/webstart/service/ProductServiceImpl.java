//: webstart.service.ProductServiceImpl.java


package webstart.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webstart.domain.model.Product;
import webstart.repository.ProductRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public final class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

}///:~