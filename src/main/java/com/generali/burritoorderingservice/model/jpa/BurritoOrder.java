package com.generali.burritoorderingservice.model.jpa;

import com.generali.burritoorderingservice.model.ingredient.Extra;
import com.generali.burritoorderingservice.model.ingredient.Protein;
import com.generali.burritoorderingservice.model.ingredient.Salsa;
import com.generali.burritoorderingservice.model.ingredient.Tortilla;
import com.generali.burritoorderingservice.model.ingredient.Vegetable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BurritoOrder {

    @Id
    @Column
    private int orderId;

    @Column
    private Tortilla tortilla; //(one of):  {corn, flour} not_null

    @Column
    private Protein protein; // (one of):  {bean, beef, chicken, pork, shrimp, steak} not_null

    @Column
    private Vegetable vegetable_1; //  (one of):  {cabbage, corn, jalapenos} nullable

    @Column
    private Vegetable vegetable_2; //  (one of):  {cabbage, corn, jalapenos} nullable

    @Column
    private Vegetable vegetable_3; //  (one of):  {cabbage, corn, jalapenos} nullable

    @Column
    private Salsa salsa; //  (one of):  {mild, medium, hot} not_null

    @Column
    private Extra extra; //  (one of):  {avocado} nullable
}
