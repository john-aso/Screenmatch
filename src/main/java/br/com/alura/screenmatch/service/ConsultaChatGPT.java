package br.com.alura.screenmatch.service;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;

public class ConsultaChatGPT {

    private static final OpenAIClient client =
            OpenAIOkHttpClient.fromEnv();

    public static String obterTraducao(String texto) {

        ResponseCreateParams params = ResponseCreateParams.builder()
                .input("Traduza para o português o seguinte texto: " + texto)
                .model(ChatModel.GPT_5_2)
                .build();

        Response resposta = client.responses().create(params);

        return resposta.output().stream()
                .flatMap(item -> item.message().stream())
                .flatMap(message -> message.content().stream())
                .flatMap(content -> content.outputText().stream())
                .map(outputText -> outputText.text())
                .findFirst()
                .orElse("");
    }
}