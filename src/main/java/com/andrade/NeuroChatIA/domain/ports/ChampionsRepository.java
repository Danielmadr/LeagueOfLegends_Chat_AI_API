package com.andrade.NeuroChatIA.domain.ports;

import com.andrade.NeuroChatIA.domain.model.Champion;

import java.util.List;
import java.util.Optional;

public interface ChampionsRepository {
  List<Champion> findAll();

  Optional<Champion> findById(Long championId);
}
