package com.sandwichwizard.sandwichguys.sandwichwizard;

/**
 * Created by andrewdaniel on 3/6/15.
 */
public class SandwichIngredients {


    public enum IngredientTypes {
        MEATS,
        CHEESES,
        VEGETABLES,
        CONDIMENT,
        MISCELLANEOUS
    }

    public static IngredientTypes getIngredientType(String name){

        name = name.toLowerCase();
        //TODO fix this class some more
        if(isCheese(name))
            return IngredientTypes.CHEESES;
        else if (isMeat(name))
            return IngredientTypes.MEATS;
        else if (isVegetable(name))
            return IngredientTypes.VEGETABLES;
        else if (isCondiment(name))
            return IngredientTypes.CONDIMENT;
        else
            return IngredientTypes.MISCELLANEOUS;
    }

    private static boolean isCheese(String name) {
        if(name.contains("cheese")
                || name.contains("parmesan")
                || name.contains("cheddar")
                || name.contains("pepperjack")
                || name.contains("munster")
                || name.contains("colby")
                || name.contains("swiss")
                || name.contains("american"))
            return true;
        return false;
    }

    private static boolean isMeat(String name) {
        if(name.contains("pork")
                || name.contains("chicken")
                || name.contains("ham")
                || name.contains("turkey")
                || name.contains("salami")
                || name.contains("pepperoni")
                || name.contains("beef"))
            return true;
        else
            return false;
    }

    private static boolean isVegetable(String name){

        if (name.contains("lettuce")
                || name.contains("pepper")
                || name.contains("tomato")
                || name.contains("onion")
                || name.contains("pickle"))
            return true;
        else
            return false;
    }

    private static boolean isCondiment(String name){
        if(name.contains("ketchup")
                || name.contains("oil")
                || name.contains("mustard")
                || name.contains("dressing"))
            return true;
        else
            return false;
    }
}
