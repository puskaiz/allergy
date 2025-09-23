package hu.deposoft.allergy.adapter.dm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DmDescriptionGroups {
  private String header;
  @JsonProperty("contentBlock")
  private List<DmContentBlock> contentBlocks;
}
