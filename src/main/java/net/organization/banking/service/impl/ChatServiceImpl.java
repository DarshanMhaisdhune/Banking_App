package net.organization.banking.service.impl;

import net.organization.banking.service.ChatService;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;
import org.springframework.ai.chat.model.Generation;


import java.util.List;


@Service
public class ChatServiceImpl implements ChatService {

    private final OllamaChatModel chatModel;

    public ChatServiceImpl (OllamaChatModel chatModel){
        this.chatModel =chatModel;
    }

    @Override
    public String chatWithAI(String promptText) {
        Prompt prompt = new Prompt(promptText);
        List<Generation> response = chatModel.call(prompt).getResults();
        return response.get(0).getOutput().getText();

    }
}
