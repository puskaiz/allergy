package hu.deposoft.allergy.domain;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
  private String name;
  private String barcode;
  private Set<String> ingredients;
}
