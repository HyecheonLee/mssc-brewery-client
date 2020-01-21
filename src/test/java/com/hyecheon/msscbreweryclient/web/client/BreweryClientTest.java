package com.hyecheon.msscbreweryclient.web.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.hyecheon.msscbreweryclient.web.model.BeerDto;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BreweryClientTest {

  @Autowired
  BreweryClient client;

  @Test
  void getBeerById() {
    final var dto = client.getBeerById(UUID.randomUUID());
    assertThat(dto).isNotNull();
  }
}