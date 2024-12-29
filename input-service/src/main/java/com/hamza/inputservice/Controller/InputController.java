package com.hamza.inputservice.Controller;

import com.hamza.inputservice.kafka.InputProducer;
import com.hamza.inputservice.model.PolynomialInput;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/input")
public class InputController {

    private final InputProducer inputProducer;

    public InputController(InputProducer inputProducer) {
        this.inputProducer = inputProducer;
    }

    @PostMapping
    public ResponseEntity<String> receiveInput(@Valid @RequestBody PolynomialInput input) {
        inputProducer.sendMessage(input);
        return ResponseEntity.ok("Input successfully sent to Kafka.");
    }
}
