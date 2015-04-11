package com.sandwichwizard.sandwichguys.sandwichwizard;

import java.util.LinkedList;
import java.util.List;

/*
 * Represents a sandwich, and contains relevant information, such as a unique
 * sandwich id (also indicates sandwich qualities), the sandwich name, and a
 * URL of a recipe for the sandwich
 * 
 * @author Kyle Ferris, Rose Walton
 */
public class Sandwich {
    /*
     * id number of sandwich
     *
     * 1st number = meatiness (1 = vegitarian 2 = omnivore 3 = carnivore)
     * 2nd number = spiciness (1 = least spicy 3 = most spicy)
     * 3rd number = messiness (1 = clean as a baby's bottom 3 = Philly Cheesesteak level shit)
     * 4th number = healthiness (1 = unhealthy 2 = healthy)
     * 5th number = cheesiness (1 = least 3 = most)
     * 6th number = riskiness (1 = ham and cheese type stuff 3 = mango pulled pork business)
     * 7th number = fruityness (1 = yes, 2 = no)
     * 8th number = hotness (1 = hot 2 = cold)
     */
    private String id;
    //name of the sandwich
    private String name;
    //website of where the sandwich recipe can be found
    private String recipeURL;

    private int picture = 0;

    private List<Ingredient> ingredients;

    /*
     * Constructs a sandwich object and assigns the specified sandwich ID, name,
     * and recipe location.
     *
     * @String id -unique number to identify the sandwich
     * @String name -name of the sandwich
     * @String recipeURL -url of a recipe for the sandwich
     */
    public Sandwich (String id, String name, String recipeURL) {
        this.setId(id);
        this.setName(name);
        this.setRecipeURL(recipeURL);
        this.ingredients = new LinkedList<Ingredient>();
        this.setPicture();
        // Gets a new array of ingredients, with all elements set to false
    }

    /*
    * Returns the sandwich picture as an integer (R.drawable.[picture])
    * @return int picture
    */
    public int getPicture() {
        return picture;
    }

    private void setPicture() {
        picture = R.drawable.baked_bean;
        /*
        switch (name) {
            case "baked bean":
                picture = R.drawable.baked_bean;
                break;
            case "blt":
                picture = R.drawable.blt;
                break;
            case "bourbon mango pulled pork":
                picture = R.drawable.bourbon_mango_pulled_pork;
                break;
            case "bourbon mango pulled summer squash":
                picture = R.drawable.bourbon_mango_pulled_summer_squash;
                break;
            case "brie and apple grilled cheese":
                picture = R.drawable.brie_and_apple_grilled_cheese;
                break;
            case "chicken pot pie enpenada":
                picture = R.drawable.chicken_pot_pie_enpenada;
                break;
            case "corn dog":
                picture = R.drawable.corn_dog;
                break;
            case "drunken grilled cheese":
                picture = R.drawable.drunken_grilled_cheese;
                break;
            case "egg and broccolini":
                picture = R.drawable.egg_and_broccolini;
                break;
            case "grilled cashew butter and blueberry":
                picture = R.drawable.grilled_cashew_butter_and_blueberry;
                break;
            case "inside out grilled ham and cheese":
                picture = R.drawable.inside_out_grilled_ham_and_cheese;
                break;
            case "italian sloppy joe":
                picture = R.drawable.italian_sloppy_joe;
                break;
            case "leftover dog pile":
                picture = R.drawable.leftover_dog_pile;
                break;
            case "meatball":
                picture = R.drawable.meatball;
                break;
            case "mediterranean chicken gyro":
                picture = R.drawable.mediterranean_chicken_gyro;
                break;
            case "peanut butter and fruit":
                picture = R.drawable.peanut_butter_and_fruit;
                break;
            case "pickled tuna salad":
                picture = R.drawable.pickled_tuna_salad;
                break;
            case "portabella mushroom cheesesteak":
                picture = R.drawable.portabella_mushroom_cheesesteak;
                break;
            case "puerto sagua cuban sandwich":
                picture = R.drawable.puerto_sagua_cuban_sandwich;
                break;
            case "sloppy joe":
                picture = R.drawable.sloppy_joe;
                break;
            case "stromboli":
                picture = R.drawable.stromboli;
                break;
            case "sweet and spicy caramelized onion bbq":
                picture = R.drawable.sweet_and_spicy_caramelized_onion_bbq;
                break;
            case "sweet and spicy turkey":
                picture = R.drawable.sweet_and_spicy_turkey;
                break;
            case "tofu banh mi":
                picture = R.drawable.tofu_banh_mi;
                break;
            case "turkey avocado":
                picture = R.drawable.turkey_avocado;
                break;
            case "turkey french dip":
                picture = R.drawable.turkey_french_dip;
                break;
            case "vegetable panini":
                picture = R.drawable.vegetable_panini;
                break;
            case "vegetarian meatball parm":
                picture = R.drawable.vegetarian_meatball_parm;
                break;
            default:
                picture = R.drawable.meatball;
                break;
        }
        */
    }

    /*
     * Returns the unique sandwich ID value.
     * @return String id
     */
    public String getId() {
        return id;
    }
    /*
     * Sets the unique sandwich ID value.
     * @param String id
     */
    public void setId(String id) {
        this.id = id;
    }

    /*
     * Returns the sandwich name.
     * @return String name
    */
    public String getName() {
        return name;
    }

    /*
     * Sets the sandwich name.
     * @param String name
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * Returns the URL location of the sandwich recipe.
     * @return String recipeURL
     */
    public String getRecipeURL() {
        return recipeURL;
    }

    /*
     * Sets the URL location of the sandwich recipe.
     * @param String recipeURL
     */
    public void setRecipeURL(String recipeURL) {
        this.recipeURL = recipeURL;
    }

    @Override
    public String toString() {
        return name + "\n" + recipeURL;
    }

    public void addIngredient(Ingredient newIngredient) {
        ingredients.add(newIngredient);
    }

}
