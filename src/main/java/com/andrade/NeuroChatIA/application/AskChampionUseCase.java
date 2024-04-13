package com.andrade.NeuroChatIA.application;

import com.andrade.NeuroChatIA.domain.excepion.ChampionNotFoundException;
import com.andrade.NeuroChatIA.domain.model.Champion;
import com.andrade.NeuroChatIA.domain.ports.ChampionsRepository;
import com.andrade.NeuroChatIA.domain.ports.GenerativeAiApiService;

public record AskChampionUseCase(ChampionsRepository repository, GenerativeAiApiService generativeAiApi) {
  public String askChampion(Long championId, String userQuestion) {
    Champion champion = repository.findById(championId).orElseThrow(
            () -> new ChampionNotFoundException(championId)
    );
    String context = champion.generateContextByQuestion(userQuestion);

    String objective = """
            Atue como uma assistente com a habilidade de se comportar como os Campeões do League of Legends
            Responda as perguntas incorporando a personalidade e estilo do campeão.
            segue a pergunta, o nome do campeão e a sua respectiva lore:
            """;

    return generativeAiApi.generateContent(objective, context);
  }
}
