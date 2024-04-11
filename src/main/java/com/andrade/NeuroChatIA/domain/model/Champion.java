package com.andrade.NeuroChatIA.domain.model;

public record Champion(
        Long id,
        String name,
        String role,
        String lore,
        String imageUrl
) {
  public String generateContextByQuestion(String userQuestion) {
    return """
            Pergunta do usário: %s
            Nome do campeão: %s
            Função do campeão: %s
            Lore do campeão: %s
            """.formatted(userQuestion, this.name, this.role, this.lore);
  }
}
