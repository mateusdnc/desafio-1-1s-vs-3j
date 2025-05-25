package com.example.analise_dados_usuarios.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.analise_dados_usuarios.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserService {

    static List<User> userList; //stores the list of users in memory

    public void saveUserListToMemory(String json) throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        UserService.userList = mapper.readValue(json, new TypeReference<List<User>>() {
        });

        userList.forEach(user -> System.out.println(user.getNome()));
    }

    public long getUserCount() {
        return userList.stream().count();
    }
}
