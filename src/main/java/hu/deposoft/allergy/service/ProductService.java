package hu.deposoft.allergy.service;

import hu.deposoft.allergy.domain.Product;

public interface ProductService {
  Product getProduct(String barcode);
}
