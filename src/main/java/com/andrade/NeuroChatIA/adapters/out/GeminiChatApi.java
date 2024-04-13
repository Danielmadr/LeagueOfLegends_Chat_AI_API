package com.andrade.NeuroChatIA.adapters.out;

import com.andrade.NeuroChatIA.domain.ports.GenerativeAiApiService;
import feign.FeignException;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@ConditionalOnProperty(name = "generative-ai.provider", havingValue = "gemini")
@FeignClient(name = "geminiApi", url = "${gemini.base-url}", configuration = GeminiChatApi.Config.class)
public interface GeminiChatApi extends GenerativeAiApiService {

  @PostMapping("/v1beta/models/gemini-pro:generateContent")
  GeminiAIResponse textOnlyInput(GeminiAiRequest openAIRequest);

  @Override
  default String generateContent(String objective, String context) {
    String prompt = """
            %s
            %s
            """.formatted(objective, context);

    GeminiAiRequest request = new GeminiAiRequest(
            List.of(new Content(List.of(new Part(prompt))))
    );

    try {
      GeminiAIResponse response = textOnlyInput(request);

      return response.candidates().getFirst().content().parts().getFirst().text();
    } catch (FeignException fe) {
      return "It went badly. communication error " + fe.getMessage();
    } catch (Exception ex) {
      return "It went badly. the response doesn't have the expected format " + ex.getMessage();
    }
  }

  record GeminiAiRequest(List<Content> contents) {
  }

  record Content(List<Part> parts) {
  }

  record Part(String text) {
  }

  record GeminiAIResponse(List<Candidate> candidates) {
  }

  record Candidate(Content content) {
  }


  class Config {
    @Bean
    public RequestInterceptor requestInterceptor(@Value("${gemini.api-key}") String apiKey) {
      return requestTemplate -> requestTemplate.query("key", apiKey);
    }
  }
}