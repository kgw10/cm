package com.community.service;

import com.community.Dto.ChatMessageDto;
import com.community.entity.ChatMessage;
import com.community.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatMessageRepository chatMessageRepository;

    public List<ChatMessage> getAllMessages() {
        return chatMessageRepository.findAll();
    }

    public void saveMessage(ChatMessageDto chatMessageDto) {
        ChatMessage message = new ChatMessage();
        message.setUser(chatMessageDto.getUser());
        message.setMessage(chatMessageDto.getMessage());
        chatMessageRepository.save(message);
    }
}