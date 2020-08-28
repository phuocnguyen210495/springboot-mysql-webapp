package edu.northeastern.cs5200.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
  
@RestController
public class SpringRestTemplateController {
    @Autowired
    private RestTemplate restTemplate;

 
    @GetMapping("/testGetApi")
    public String getJson(){
        String url="https://www.zappos.com/";    
        ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String json = results.getBody();

        return json;
    }
    
    
 
}