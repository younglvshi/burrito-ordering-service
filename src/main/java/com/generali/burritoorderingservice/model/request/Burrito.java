package com.generali.burritoorderingservice.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A json with simple Strings for ingredients.
 * When processed and saved to database, they are converted to enum.
 * If there is any typo, the ingredient is taken as the default.
 * Check ../ingredient/Vegetable#getVegetable() for an example
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Burrito {

    private String tortilla; //(one of):  {corn, flour}
    private String protein; // (one of):  {bean, beef, chicken, pork, shrimp, steak}
    private String vegetable_1; //  (zero or one of):  {cabbage, corn, jalapenos}
    private String vegetable_2; //  (zero or one of):  {cabbage, corn, jalapenos}
    private String vegetable_3; //  (zero or one of):  {cabbage, corn, jalapenos}
    private String salsa; //  (one of):  {mild, medium, hot}
    private String extra; //  (zero or one of):  {avocado}
}
