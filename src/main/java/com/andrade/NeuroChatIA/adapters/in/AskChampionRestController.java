package com.andrade.NeuroChatIA.adapters.in;

import com.andrade.NeuroChatIA.application.AskChampionUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Champions")
@RestController
@RequestMapping("/champions")
public record AskChampionRestController(AskChampionUseCase useCase) {
  @Tag(name = "Champions", description = "Endpoint to ask a question about a champion")
  @PostMapping("/{championId}/ask")
  public AskChampionResponse askChampion(@PathVariable Long championId, @RequestBody AskChampionRequest userQuestion) {

    String answer = useCase.askChampion(championId, userQuestion.userQuestion());

    return new AskChampionResponse(answer);
  }

  public record AskChampionRequest(String userQuestion) {
  }

  public record AskChampionResponse(String context) {
  }
}
