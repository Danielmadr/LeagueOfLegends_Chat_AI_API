package com.andrade.NeuroChatIA.domain.ports;

import com.andrade.NeuroChatIA.domain.model.Champions;

import java.util.List;
import java.util.Optional;

public interface ChampionsRepository {
    List<Champions> findAll();

    Optional<Champions> findById(Long championId);
}
