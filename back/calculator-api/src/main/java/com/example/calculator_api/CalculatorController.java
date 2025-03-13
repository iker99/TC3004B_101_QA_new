package com.example.calculator_api;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @CrossOrigin(origins = "http://localhost:8000")
    @PostMapping("/calculate")
    public Map<String, Object> calculate(@RequestParam double num1, @RequestParam double num2, @RequestParam String operator) {
        Map<String, Object> response = new HashMap<>();
        double result;
        switch (operator) {
            case "-":
                result = num1 - num2;
                break;
            default:
                result = num1 + num2;
                break;
        }
        response.put("result", result);
        return response;
    }
}