package com.sandwichwizard.sandwichguys.sandwichwizard;

/**
 * Created by andrewdaniel on 3/15/15.
 */
public class Ingredient {
    private SandwichIngredients.IngredientTypes type;
    private String ingredientName;

    public String getName(){
        return ingredientName;
    }

    public void setName(String newName){
        this.ingredientName = newName;
    }

    public void setType(SandwichIngredients.IngredientTypes newType){
        this.type = newType;
    }
}
