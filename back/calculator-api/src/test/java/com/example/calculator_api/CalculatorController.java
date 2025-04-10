package com.example.calculator_api;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorController{
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testAddition() {
        ResponseEntity<Calculator> response = restTemplate.getForEntity("/api/calculator/calculate?num1=5&num2=3&operator=+", Calculator.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("8", response.getBody().result());
    }

    @Test
    public void testAdditionWithDecimalNumbers() {
        ResponseEntity<Calculator> response = restTemplate.getForEntity("/api/calculator/calculate?num1=5.5&num2=3.2&operator=+", Calculator.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("0", response.getBody().result());
    }

    @Test
    public void testSubtraction() {
        ResponseEntity<Calculator> response = restTemplate.getForEntity("/api/calculator/calculate?num1=5&num2=3&operator=-", Calculator.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("2", response.getBody().result());
    }

    @Test
    public void testSubtractionWithNegativeNumbers() {
        ResponseEntity<Calculator> response = restTemplate.getForEntity("/api/calculator/calculate?num1=-5&num2=-3&operator=-", Calculator.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("0", response.getBody().result());
    }
}