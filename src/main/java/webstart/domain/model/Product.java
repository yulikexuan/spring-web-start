//: webstart.domain.model.Product.java


package webstart.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Product {

    String name;
    long price;

}///:~