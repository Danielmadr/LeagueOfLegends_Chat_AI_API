package com.andrade.NeuroChatIA.application;

import com.andrade.NeuroChatIA.domain.excepion.ChampionNotFoundException;
import com.andrade.NeuroChatIA.domain.model.Champion;
import com.andrade.NeuroChatIA.domain.ports.ChampionsRepository;

public record AskChampionUseCase(ChampionsRepository repository) {
  public String askChampion(Long championId, String userQuestion) {
    Champion champion = repository.findById(championId).orElseThrow(
            () -> new ChampionNotFoundException(championId)
    );
    String context = champion.generateContextByQuestion(userQuestion);

    return context;
  }
}
