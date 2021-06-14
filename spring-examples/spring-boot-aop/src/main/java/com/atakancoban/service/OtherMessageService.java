package com.atakancoban.service;

import org.springframework.stereotype.Service;

@Service
public class OtherMessageService {

    public void mesaj(String param) {
        System.out.println("OtherMessageService param:");
    }
}