package com.andrade.NeuroChatIA.domain.ports;

public interface GenerativeAiApiService {

  String generateContent(String objective, String context);
}
