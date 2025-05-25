package com.example.analise_dados_usuarios.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.analise_dados_usuarios.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonParseException;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> users(@RequestBody String usersJson) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("timestamp", new Date());
        try {
            userService.saveUserListToMemory(usersJson);

            response.put("message", "Arquivo recebido com sucesso");
            response.put("user_count", userService.getUserCount());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }
}