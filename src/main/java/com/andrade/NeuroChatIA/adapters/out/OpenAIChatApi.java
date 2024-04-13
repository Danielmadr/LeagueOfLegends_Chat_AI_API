package com.andrade.NeuroChatIA.adapters.out;

import com.andrade.NeuroChatIA.domain.ports.GenerativeAiApiService;
import feign.FeignException;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@ConditionalOnProperty(name = "generative-ai.provider", havingValue = "openai", matchIfMissing = true)
@FeignClient(name = "openai", url = "${openai.base-url}", configuration = OpenAIChatApi.Config.class)
public interface OpenAIChatApi extends GenerativeAiApiService {

  @PostMapping("/v1/chat/completions")
  OpenAIResponse chatCompletion(OpenAIRequest openAIRequest);

  @Override
  default String generateContent(String objective, String context) {
    String model = "gpt-3.5-turbo";
    List<Message> messages = List.of(
            new Message("system", objective),
            new Message("user", context));

    OpenAIRequest request = new OpenAIRequest(model, messages);
    try {
      OpenAIResponse response = chatCompletion(request);

      return response.choices().getFirst().message().content();
    } catch (FeignException fe) {
      return "It went badly. communication error " + fe.getMessage();
    } catch (Exception ex) {
      return "It went badly. the response doesn't have the expected format " + ex.getMessage();
    }
  }

  record OpenAIRequest(String model, List<Message> messages) {
  }

  record Message(String role, String content) {
  }

  record OpenAIResponse(List<Choice> choices) {
  }

  record Choice(Message message) {
  }

  class Config {
    @Bean
    public RequestInterceptor requestInterceptor(@Value("${openai.api-key}") String apiKey) {
      return requestTemplate -> requestTemplate.header(
              HttpHeaders.AUTHORIZATION, "Bearer " + apiKey);
    }

  }

}
