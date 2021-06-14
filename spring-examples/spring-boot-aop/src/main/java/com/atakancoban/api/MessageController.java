package com.atakancoban.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atakancoban.service.MessageService;
import com.atakancoban.service.OtherMessageService;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private OtherMessageService otherMessageService;

    @PostMapping
    public ResponseEntity<String> ornekMethod(@RequestBody String message) {
    	otherMessageService.mesaj(message);
        return ResponseEntity.ok(messageService.mesajVer(message));
    }
}