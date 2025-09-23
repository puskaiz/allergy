package hu.deposoft.allergy.adapter.dm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DmProduct {
  private String gtin;
  private List<DmDescriptionGroups> descriptionGroups;
  private DmTitle title;
  private DmBrand brand;

  public Set<String> getIngredients() {
    return descriptionGroups.stream()
        .filter(group -> "Összetevők".equals(group.getHeader()))
        .flatMap(group -> group.getContentBlocks().stream())
        .filter(s -> s.getTexts() != null)
        .flatMap(block -> block.getTexts().stream())
        .flatMap(s -> Arrays.stream(s.split(",")).map(String::trim).map(String::toLowerCase))
        .collect(java.util.stream.Collectors.toSet());
  }

  @JsonIgnore
  public String getName() {
    if (brand != null && brand.getName() != null && title != null && title.getHeadline() != null) {
      return String.format(
          "%s - %s", StringUtils.capitalize(brand.getName().toLowerCase()), title.getHeadline());
    }
    if (brand != null && brand.getName() != null) {
      return StringUtils.capitalize(brand.getName().toLowerCase());
    }
    if (title != null && title.getHeadline() != null) {
      return title.getHeadline();
    }
    return null;
  }
}
