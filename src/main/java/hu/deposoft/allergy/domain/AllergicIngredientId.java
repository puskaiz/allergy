package hu.deposoft.allergy.domain;

import jakarta.persistence.Column;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllergicIngredientId implements Serializable {
    @Column(name = "username")
    private String user;

  private String ingredient;
}
