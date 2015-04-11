package com.sandwichwizard.sandwichguys.sandwichwizard;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * Menu object that reads in sandwich data from a file and places the 
 * information into a list.
 * 
 * @author Kyle Ferris, Rose Walton
 */
public class SandwichMenu {
    // The singleton representing the sandwich menu
    private static SandwichMenu menu;
    //stores all the sandwich objects
    private ArrayList<Sandwich> sandwiches;
    private Random rangen;

    /*
     * Reads in sandwich data from a file of the format
     * Sandwich ID#
     * Sandwich Name
     * Sandwich Recipe URL
     *
     * usage: SandwichMenu(R.raw.sandwich_ingredients, this)
     */
    public SandwichMenu(int file, Context context) {
        sandwiches = new ArrayList<Sandwich>();
        rangen = new Random();

        Scanner fileIn = new Scanner(context.getResources().openRawResource(file));
        boolean moreSandwiches = true;

        while (moreSandwiches) {
            // Add a new sandwich to the database
            sandwiches.add(parseNextSandwich(fileIn));

            if (!fileIn.hasNextLine())
                moreSandwiches = false;
        }
    }

    /**
     * Creates the sandwich menu. Returns the number of sandwiches that were deserialized
     *
     * @param context
     * @return the number of deserialized sandwiches
     */
    public static int deserializeSandwichMenu(Context context) {
        menu = new SandwichMenu(R.raw.sandwich_ingredients, context);
        return menu.getSandwiches().size();
    }

    public static SandwichMenu getSingleton() {
        return menu;
    }

    /**
     * This is a helper function which parses the sandwich from the sandwiches file, adding ingredients and such
     *
     * @param fileIn the file scanner
     * @return the completely instantiated sandwich object
     */
    private Sandwich parseNextSandwich(Scanner fileIn) {
        // The integer in the sandwich file
        String id = fileIn.nextLine().trim();
        // The name of the sandwich
        String name = fileIn.nextLine().trim();
        // Where the sandwich comes from
        String url = fileIn.nextLine().trim();
        // Make the sandwich
        Sandwich sandwich = new Sandwich(id, name, url);

        while (!fileIn.hasNextInt() && fileIn.hasNextLine()) {
            // Create the new ingredient and set the name and type
            Ingredient newIngredient = new Ingredient();
            newIngredient.setName(fileIn.nextLine());
            // Get the type of the ingredient
            SandwichIngredients.IngredientTypes type = SandwichIngredients.getIngredientType(newIngredient.getName());
            newIngredient.setType(type);
            sandwich.addIngredient(newIngredient);
        }
        return sandwich;
    }

    /*
     * Compares quiz result to sandwich database to get closest match.
     */
    public Sandwich getSandwich(String id) {
        int maxMatchCount = 0;
        int sandwichIndex = -1;

        for (int i = 0; i < sandwiches.size(); i++) {

            String tempId = sandwiches.get(i).getId();
            int matchCount = 0;
            if (id.charAt(0) == tempId.charAt(0)) {
                for (int j = 1; j < id.length(); j++) {
                    if (id.charAt(j) == tempId.charAt(j))
                        matchCount++;
                }
                if (matchCount > maxMatchCount) {
                    maxMatchCount = matchCount;
                    if (maxMatchCount >= 3)
                        sandwichIndex = i;
                }
            }

        }
        if (sandwichIndex == -1)
            return null;

        return sandwiches.get(sandwichIndex);
    }

    /*
     * Compares quiz result to sandwich database to get closest match for
     * fruity sandwiches.
     */
    public Sandwich getSandwich(boolean fruity, String id) {
        ArrayList<Sandwich> fruitySandwiches = new ArrayList<Sandwich>();
        fruitySandwiches.add(sandwiches.get(5));
        fruitySandwiches.add(sandwiches.get(6));
        fruitySandwiches.add(sandwiches.get(7));
        fruitySandwiches.add(sandwiches.get(9));
        fruitySandwiches.add(sandwiches.get(11));

        int maxMatchCount = 0;
        int sandwichIndex = -1;

        for (int i = 0; i < fruitySandwiches.size(); i++) {

            String tempId = fruitySandwiches.get(i).getId();
            int matchCount = 0;

            if (id.charAt(0) == tempId.charAt(0)) {
                for (int j = 1; j < id.length(); j++) {
                    if (id.charAt(j) == tempId.charAt(j))
                        matchCount++;
                }
                if (matchCount > maxMatchCount) {
                    maxMatchCount = matchCount;
                    sandwichIndex = i;
                }
            }

        }
        if (sandwichIndex == -1)
            return null;

        return fruitySandwiches.get(sandwichIndex);
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    /**
     * Returns a totally random sandwich, dude
     *
     * @return Sandwich randomly
     */
    public Sandwich getSandwich() {
        return sandwiches.get(rangen.nextInt(sandwiches.size()));
    }

}
