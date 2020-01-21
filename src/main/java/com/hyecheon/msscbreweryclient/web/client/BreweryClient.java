package com.hyecheon.msscbreweryclient.web.client;

import com.hyecheon.msscbreweryclient.web.model.BeerDto;
import java.net.URI;
import java.util.UUID;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

  public final String BEER_PATH_V1 = "/api/v1/beer/";
  public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";

  @Setter
  private String apiHost;

  private final RestTemplate restTemplate;

  public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public BeerDto getBeerById(UUID beerId) {
    return restTemplate.getForObject(apiHost + BEER_PATH_V1 + beerId.toString(), BeerDto.class);
  }

  public URI saveNewBeer(BeerDto beerDto) {
    return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto);
  }

  public void updateBeer(UUID uuid, BeerDto beerDto) {
    restTemplate.put(apiHost + BEER_PATH_V1 + "/" + uuid.toString(), beerDto);
  }

  public void deleteBeer(UUID beerId) {
    restTemplate.delete(apiHost + BEER_PATH_V1 + "/" + beerId);
  }

  public CustomerDto getCustomerById(UUID customerId) {
    return restTemplate
        .getForObject(apiHost + CUSTOMER_PATH_V1 + customerId.toString(), CustomerDto.class);
  }

  public URI saveNewCustomer(CustomerDto customerDto) {
    return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDto);
  }

  public void updateCustomer(UUID customerId, CustomerDto customerDto) {
    restTemplate.put(apiHost + CUSTOMER_PATH_V1 + customerId, customerDto);
  }

  public void deleteCustomer(UUID customerId) {
    restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + customerId);
  }
}

