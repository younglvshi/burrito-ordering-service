package com.generali.burritoorderingservice.controller;

import com.generali.burritoorderingservice.model.ingredient.Protein;
import com.generali.burritoorderingservice.model.ingredient.Salsa;
import com.generali.burritoorderingservice.model.ingredient.Tortilla;
import com.generali.burritoorderingservice.model.request.Burrito;
import com.generali.burritoorderingservice.model.response.OrderIdResponse;
import com.generali.burritoorderingservice.model.response.OrderResponse;
import com.generali.burritoorderingservice.service.BurritoOrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurritoOrderControllerTest {

    private BurritoOrderController controller;
    private AutoCloseable closeable;
     private BurritoOrderService orderService;

    @Before
    public void setup() {
        orderService = mock(BurritoOrderService.class);
        controller = new BurritoOrderController(orderService);
    }

    //GET tests
    @Test
    public void testGetExistingOrder() {
        OrderResponse orderResponse = createMockOrderResponse();
        when(orderService.getOrder(100)).thenReturn(orderResponse);
        ResponseEntity<OrderResponse> response = controller.getExistingOrder(100);
        assertEquals(200, response.getStatusCodeValue());

    }

    private OrderResponse createMockOrderResponse() {
        OrderResponse response = new OrderResponse();
        response.setOrderId(100);
        response.setExistingOrder(true);
        response.setTortilla(Tortilla.FLOUR);
        response.setProtein(Protein.BEEF);
        response.setSalsa(Salsa.MEDIUM);
        return response;
    }

    @Test
    public void testGetException() {
        when(orderService.getOrder(100)).thenThrow(RuntimeException.class);
        ResponseEntity<OrderResponse> response = controller.getExistingOrder(100);
        assertEquals(500, response.getStatusCodeValue());
    }

    //POST tests
    @Test
    public void testPostNewOrder() {
        Burrito burrito = createMockBurrito();
        doNothing().when(orderService).saveOrder(eq(burrito), anyInt());

        ResponseEntity<OrderIdResponse> response = controller.createNewOrder(burrito);
        assertEquals(201, response.getStatusCodeValue());
    }

    @Test
    public void testPostException() {
        Burrito burrito = createMockBurrito();
        doThrow(RuntimeException.class).when(orderService).saveOrder(any(), anyInt());
        ResponseEntity<OrderIdResponse> response = controller.createNewOrder(burrito);
        assertEquals(500, response.getStatusCodeValue());
    }

    private Burrito createMockBurrito() {
        Burrito b = new Burrito();
        b.setTortilla("flour");
        b.setProtein("bean");
        b.setSalsa("mild");
        return b;
    }

}
