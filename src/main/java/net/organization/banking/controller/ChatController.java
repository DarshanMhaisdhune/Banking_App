package net.organization.banking.controller;

import net.organization.banking.service.impl.ChatServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatServiceImpl chatService;

    public ChatController(ChatServiceImpl chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public String chat(@RequestBody Map<String, String>request){
        String prompt = request.get("prompt");
        return chatService.chatWithAI(prompt);
    }
}
