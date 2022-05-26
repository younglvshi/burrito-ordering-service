package com.generali.burritoorderingservice.service;

import com.generali.burritoorderingservice.model.ingredient.Extra;
import com.generali.burritoorderingservice.model.ingredient.Protein;
import com.generali.burritoorderingservice.model.ingredient.Salsa;
import com.generali.burritoorderingservice.model.ingredient.Tortilla;
import com.generali.burritoorderingservice.model.ingredient.Vegetable;
import com.generali.burritoorderingservice.model.jpa.BurritoOrder;
import com.generali.burritoorderingservice.model.request.Burrito;
import com.generali.burritoorderingservice.model.response.OrderResponse;
import com.generali.burritoorderingservice.repository.BurritoOrderRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class BurritoOrderService {

    @Autowired
    private BurritoOrderRepository repository;

    /**
     * Any exception will result in the 500 error from Controller
     */
    public void saveOrder(Burrito burrito, int orderId) {
        BurritoOrder order = createBurritoOrder(burrito, orderId);
        repository.save(order);
    }

    /**
     * If no such entity then return an empty response and still 200 from Controller.
     * Any other exception will result in the 500 error from Controller
     */
    public OrderResponse getOrder(int orderId) {
        try {
            BurritoOrder order = repository.getReferenceById(orderId);
            return createOrderResponse(order, orderId);
        } catch (EntityNotFoundException e) {
            return createEmptyResponse(orderId);
        }
    }

    private BurritoOrder createBurritoOrder(Burrito burrito, int orderId) {
        BurritoOrder order = new BurritoOrder();
        order.setOrderId(orderId);
        order.setTortilla(Tortilla.getTortilla(burrito.getTortilla()));
        order.setProtein(Protein.getProtein(burrito.getProtein()));
        order.setSalsa(Salsa.getSalsa(burrito.getSalsa()));

        if (StringUtils.isNotBlank(burrito.getVegetable_1())) {
            order.setVegetable_1(Vegetable.getVegetable(burrito.getVegetable_1()));
        }
        if (StringUtils.isNotBlank(burrito.getVegetable_2())) {
            order.setVegetable_2(Vegetable.getVegetable(burrito.getVegetable_2()));
        }
        if (StringUtils.isNotBlank(burrito.getVegetable_3())) {
            order.setVegetable_3(Vegetable.getVegetable(burrito.getVegetable_3()));
        }
        if (StringUtils.isNotBlank(burrito.getExtra())) {
            order.setExtra(Extra.AVOCADO);
        }

        return order;
    }

    private OrderResponse createOrderResponse(BurritoOrder order, int orderId) {
        OrderResponse response = new OrderResponse();
        response.setOrderId(orderId);
        response.setExistingOrder(true);
        response.setTortilla(order.getTortilla());
        response.setProtein(order.getProtein());
        response.setSalsa(order.getSalsa());
        response.setVegetable_1(order.getVegetable_1());
        response.setVegetable_2(order.getVegetable_2());
        response.setVegetable_3(order.getVegetable_3());
        response.setExtra(order.getExtra());

        return response;
    }

    private OrderResponse createEmptyResponse(int orderId) {
        OrderResponse response = new OrderResponse();
        response.setOrderId(orderId);
        response.setExistingOrder(false);
        return response;
    }
}
