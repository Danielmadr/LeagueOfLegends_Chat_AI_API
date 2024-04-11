package com.andrade.NeuroChatIA.adapters.in;

import com.andrade.NeuroChatIA.application.ListChampionsUseCase;
import com.andrade.NeuroChatIA.domain.model.Champion;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Champions")
@RestController
@RequestMapping("/champions")
public record ListChampionsRestController(ListChampionsUseCase useCase) {
  @Tag(name = "Champions", description = "Endpoint to list all champions")
  @GetMapping
  public List<Champion> findAllChampions() {
    return useCase.findAll();
  }
}
