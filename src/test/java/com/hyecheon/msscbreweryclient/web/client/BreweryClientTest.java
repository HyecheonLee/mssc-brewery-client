package com.hyecheon.msscbreweryclient.web.client;

import static org.assertj.core.api.Assertions.assertThat;

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
  void getCustomerById() {
    final var dto = client.getBeerById(UUID.randomUUID());
    assertThat(dto).isNotNull();
  }

  @Test
  void testSaveNewCustomer() {
    //givn
    final var beerDto = BeerDto.builder().beerName("New Beer").build();

    final var uri = client.saveNewBeer(beerDto);

    assertThat(beerDto).isNotNull();

    System.out.println(uri.toString());
  }

  @Test
  void testUpdateBeer() {
    //givn
    final var beerDto = BeerDto.builder().beerName("New Beer").build();

    client.updateBeer(UUID.randomUUID(), beerDto);
  }

  @Test
  void testDeleteBeer() {
    client.deleteBeer(UUID.randomUUID());
  }
  @Test
  void getBeerById() {
    final var dto = client.getBeerById(UUID.randomUUID());
    assertThat(dto).isNotNull();
  }

  @Test
  void testSaveNewBeer() {
    //givn
    final var customerDto = CustomerDto.builder().name("New Customer").build();

    final var uri = client.saveNewCustomer(customerDto);

    assertThat(customerDto).isNotNull();

    System.out.println(uri.toString());
  }

  @Test
  void testUpdateCustomer() {
    //givn
    final var customerDto = CustomerDto.builder().name("New Customer").build();

    client.updateCustomer(UUID.randomUUID(), customerDto);
  }

  @Test
  void testDeleteCustomer() {
    client.deleteCustomer(UUID.randomUUID());
  }

}