package com.andrade.NeuroChatIA.application;

import com.andrade.NeuroChatIA.domain.model.Champion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ListChampionsUseCaseIntegrationTest {

  @Autowired
  private ListChampionsUseCase listChampionsUseCase;

  @Test
  public void testFindAll() {
    List<Champion> testList = listChampionsUseCase.findAll();

    Assertions.assertEquals(12, testList.size());
  }
}
