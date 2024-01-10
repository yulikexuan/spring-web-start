//: webstart.repository.ProductRepository


package webstart.repository;


import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import webstart.domain.model.Product;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public interface ProductRepository {

    List<Product> PRODUCTS = new CopyOnWriteArrayList<>();

    void save(Product product);

    List<Product> findAll();

    static ProductRepository of() {
        return new ProductRepositoryImpl();
    }

}

final class ProductRepositoryImpl implements ProductRepository {

    @Override
    public void save(@NonNull final Product product) {
        PRODUCTS.add(product);
    }

    @Override
    public List<Product> findAll() {
        if (PRODUCTS.isEmpty()) {
            PRODUCTS.add(Product.of(
                    "TIMEMORE Chestnut C3 Max Manual Coffee Grinder",
                    14464));
        }
        return ImmutableList.copyOf(PRODUCTS);
    }

}

///:~