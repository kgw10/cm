package com.community.control;

import com.community.Dto.ChatMessageDto;
import com.community.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @GetMapping
    public String showChatPage(Model model) {
        model.addAttribute("messages", chatService.getAllMessages());
        return "chat";
    }

    @PostMapping("/send")
    public String sendMessage(ChatMessageDto chatMessageDto) {
        chatService.saveMessage(chatMessageDto);
        return "redirect:/";
    }
}