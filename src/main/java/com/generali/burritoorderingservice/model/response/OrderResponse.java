package com.generali.burritoorderingservice.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.generali.burritoorderingservice.model.ingredient.Extra;
import com.generali.burritoorderingservice.model.ingredient.Protein;
import com.generali.burritoorderingservice.model.ingredient.Salsa;
import com.generali.burritoorderingservice.model.ingredient.Tortilla;
import com.generali.burritoorderingservice.model.ingredient.Vegetable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "orderId", "existingOrder", "tortilla", "protein",
        "vegetable_1", "vegetable_2", "vegetable_3", "salsa", "extra" })
public class OrderResponse {

    private int orderId;
    private boolean existingOrder;
    private Tortilla tortilla;
    private Protein protein;
    private Vegetable vegetable_1;
    private Vegetable vegetable_2;
    private Vegetable vegetable_3;
    private Salsa salsa;
    private Extra extra;

}
