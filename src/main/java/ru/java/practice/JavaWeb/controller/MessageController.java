package ru.java.practice.JavaWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.java.practice.JavaWeb.exceptions.NotFoundExceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
public class MessageController {
    public List<Map<String,String>> messages = new ArrayList<Map<String,String>>(){{
        add(new HashMap<String, String>() {{put("id", "1"); put("text", "First message");}});
        add(new HashMap<String, String>() {{put("id", "2"); put("text", "Second message");}});
        add(new HashMap<String, String>() {{put("id", "3"); put("text", "Third message");}});
        add(new HashMap<String, String>() {{put("id", "4"); put("text", "Forth message");}});
    }};
    @GetMapping
    public List<Map<String,String>> list(){
        return messages;
    }

    @GetMapping("{id}")
    public Map<String,String> getOne(@PathVariable String id){
        return messages.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundExceptions::new);

    }
}
