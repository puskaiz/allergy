package hu.deposoft.allergy.adapter.dm;

import hu.deposoft.allergy.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class DmProductMapper {
  public Product map(DmProduct dmProduct) {
    Product product = new Product();
    product.setBarcode(dmProduct.getGtin());
    product.setName(dmProduct.getName());
    product.setIngredients(dmProduct.getIngredients());
    return product;
  }
}
