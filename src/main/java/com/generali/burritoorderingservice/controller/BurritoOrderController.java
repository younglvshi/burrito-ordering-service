package com.generali.burritoorderingservice.controller;

import com.generali.burritoorderingservice.model.request.Burrito;
import com.generali.burritoorderingservice.model.response.OrderIdResponse;
import com.generali.burritoorderingservice.model.response.OrderResponse;
import com.generali.burritoorderingservice.service.BurritoOrderService;
import com.generali.burritoorderingservice.util.OrderIdGenerator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class BurritoOrderController {

    @Autowired
    private BurritoOrderService orderService;

    /**
     * Better to have a JSON schema for the request body and a validation mechanism for it.
     */
    @PostMapping(value = "/orders", produces = {"application/json"})
    public ResponseEntity<OrderIdResponse> createNewOrder(@RequestBody Burrito burrito) {
        try {
            int orderId = OrderIdGenerator.getNextId();
            orderService.saveOrder(burrito, orderId);
            return new ResponseEntity<>(new OrderIdResponse(orderId), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * If there is no such order for the orderId, then return an empty json and 200
     * But for any other exception from server, return 500
     */
    @GetMapping(value = "/orders/{orderId}", produces = {"application/json"})
    public ResponseEntity<OrderResponse> getExistingOrder(@PathVariable int orderId) {
        try {
            OrderResponse order = orderService.getOrder(orderId);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
