//: webstart.service.ProductService


package webstart.service;


import webstart.domain.model.Product;

import java.util.List;


public interface ProductService {

    void addProduct(Product product);

    List<Product> findAll();

}///:~