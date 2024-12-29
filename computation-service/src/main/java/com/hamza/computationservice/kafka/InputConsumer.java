package com.hamza.computationservice.kafka;

import com.hamza.computationservice.model.ComputationResult;
import com.hamza.computationservice.model.PolynomialInput;
import com.hamza.computationservice.service.ComputationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InputConsumer {
    private final ComputationService computationService;
    private final ResultProducer resultProducer;

    public InputConsumer(ComputationService computationService, ResultProducer resultProducer) {
        this.computationService = computationService;
        this.resultProducer = resultProducer;
    }

    @KafkaListener(topics = "input-topic", groupId = "computation-group")
    public void consume(PolynomialInput input) {
        String polynomial = input.getPolynomial();
        boolean simplify = input.isSimplify();

        // Perform computations
        var roots = computationService.computeRoots(polynomial);
        var factorizedForm = computationService.factorizePolynomial(polynomial);

        // Create result object
        var result = new ComputationResult(polynomial, roots, factorizedForm);

        // Send result to Kafka
        resultProducer.sendResult(result);
    }
}
