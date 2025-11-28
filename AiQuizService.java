package com.aiquiz.quiz.service;

import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AiQuizService {

    @Autowired
    private VertexAiGeminiChatModel chatModel;

    public String gerarPergunta(String tema) {

        Prompt prompt = new Prompt(
                "Crie uma pergunta objetiva sobre o tema: " + tema +
                        ". Gere também a resposta correta e uma explicação."
        );

        return chatModel.call(prompt)
                .getResult()   // ChatResponse
                .getOutput()   // Content
                .getText();    // <- aqui está o texto!
    }
}
