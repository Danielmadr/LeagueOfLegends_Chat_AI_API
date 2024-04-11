package com.andrade.NeuroChatIA.application;

import com.andrade.NeuroChatIA.domain.model.Champion;
import com.andrade.NeuroChatIA.domain.ports.ChampionsRepository;

import java.util.List;

public record ListChampionsUseCase(ChampionsRepository repository) {

  public List<Champion> findAll() {
    return repository.findAll();
  }

}
