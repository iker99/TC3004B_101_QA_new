package com.example.calculator_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class CalculatorApiApplicationTests {

    private static final int PORT = 8080;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testAddition() {
        String url = "http://localhost:" + PORT + "/api/calculator/calculate";
        
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("num1", "5");
        params.add("num2", "3");
        params.add("operator", "+");

        ResponseEntity<Map> response = restTemplate.postForEntity(url, params, Map.class);
        
        assertNotNull(response.getBody());
        assertEquals(8.0, response.getBody().get("result"));
    }

    @Test
    void testSubtraction() {
        String url = "http://localhost:" + PORT + "/api/calculator/calculate";
        
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("num1", "10");
        params.add("num2", "4");
        params.add("operator", "-");

        ResponseEntity<Map> response = restTemplate.postForEntity(url, params, Map.class);
        
        assertNotNull(response.getBody());
        assertEquals(6.0, response.getBody().get("result"));
    }

    @Test
    void testDefaultOperation() {
        String url = "http://localhost:" + PORT + "/api/calculator/calculate";
        
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("num1", "7");
        params.add("num2", "2");
        params.add("operator", "invalid_operator"); // Should default to addition

        ResponseEntity<Map> response = restTemplate.postForEntity(url, params, Map.class);
        
        assertNotNull(response.getBody());
        assertEquals(9.0, response.getBody().get("result"));
    }

    @Test
    void testNegativeNumbers() {
        String url = "http://localhost:" + PORT + "/api/calculator/calculate";
        
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("num1", "-5");
        params.add("num2", "-3");
        params.add("operator", "+");

        ResponseEntity<Map> response = restTemplate.postForEntity(url, params, Map.class);
        
        assertNotNull(response.getBody());
        assertEquals(-8.0, response.getBody().get("result"));
    }
}
