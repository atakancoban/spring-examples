package com.atakancoban.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atakancoban.model.User;

@RestController
@RequestMapping("/user")
@Api(value = "Benim User API ddkumantasyonum")
public class UserController {

    private List<User> userList = new ArrayList<>();

    @PostConstruct
    public void init() {
    	userList.add(new User(1, "Test User", new Date()));
    }

    @PostMapping
    @ApiOperation(value = "Yeni User Ekleme metodu", notes = "Bu metodu dikkatli kullan")
    public ResponseEntity<User> kaydet(@RequestBody @ApiParam(value = "userbilgisi") User User) {
    	userList.add(User);
        return ResponseEntity.ok(User);
    }

    @GetMapping
    @ApiOperation(value = "User listesi metodu", notes = "Bu metod tümünü getirir")
    public ResponseEntity<List<User>> tumunuListele() {
        return ResponseEntity.ok(userList);
    }
}
