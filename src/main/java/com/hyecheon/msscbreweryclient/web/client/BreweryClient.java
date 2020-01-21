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
}

