package hu.deposoft.allergy.adapter.dm;

import hu.deposoft.allergy.domain.Product;
import hu.deposoft.allergy.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class DmProductService implements ProductService {
  private final DmProductMapper mapper;

  @Value("${dm.product.url}")
  private String dmUrl;

  private final RestTemplate restTemplate = new RestTemplate();

  @Override
  public Product getProduct(String barcode) {
    try {
      ResponseEntity<DmProduct> response =
          restTemplate.exchange(dmUrl + barcode, HttpMethod.GET, null, DmProduct.class);

      if (response.getStatusCode().is2xxSuccessful()) {
        return mapper.map(response.getBody());
      }
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
    return null;
  }
}
