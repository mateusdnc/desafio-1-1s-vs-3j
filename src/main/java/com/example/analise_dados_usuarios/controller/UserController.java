package com.example.analise_dados_usuarios.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.StreamSupport;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

@Controller
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public ResponseEntity<Map<String, Object>> users(@RequestBody String usersJson) {
        Map<String, Object> response = new LinkedHashMap <>();
        response.put("timestamp", new Date());
        try {
            JsonElement jsonElement = JsonParser.parseString(usersJson);
            response.put("message", "Arquivo recebido com sucesso");
            response.put("user_count", StreamSupport.stream(jsonElement.getAsJsonArray().spliterator(), false)
                    .filter(JsonElement::isJsonObject)
                    .filter(e -> e.getAsJsonObject().has("nome"))
                    .count()
            );

        } catch (JsonParseException e) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }
}