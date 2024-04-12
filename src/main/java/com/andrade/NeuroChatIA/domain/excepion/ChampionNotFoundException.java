package com.andrade.NeuroChatIA.domain.excepion;


public class ChampionNotFoundException extends RuntimeException {
  public ChampionNotFoundException(Long championId) {
    super("Champion with id -> %d not found.".formatted(championId));
  }
}
