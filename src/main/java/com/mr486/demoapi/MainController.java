package com.mr486.demoapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController {

  @GetMapping("/")
  public Map<String, String> greet(@RequestParam(name = "nom", required = false) String name) {
    String message = "";
    String color= "";

    if(name != null && !name.isEmpty()) {
      if(name.equals("darling")) {
        message = "❤\uFE0F ❤\uFE0F ❤\uFE0F Coucou mon Amour ❤\uFE0F ❤\uFE0F ❤\uFE0F";
        color = "RED";
      } else {
        message = "Bonjour " + name + "!";
        color = "GREEN";
      }

    } else {
      message = "Hello World!";
      color = "BLACK";
    }
    return Map.of("message", message, "color", color);
  }

}
