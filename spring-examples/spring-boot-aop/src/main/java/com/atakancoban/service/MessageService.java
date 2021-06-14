package com.atakancoban.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String mesajVer(String param) {
        System.out.println("Message service ");
        return param;
    }
}