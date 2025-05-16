package edu.miracosta.cs112.finalproject.finalproject;

public class Meal {
    private String name;
    private int protein; // grams
    private int calories;

    public Meal(String name, int protein, int calories) {
        this.name = name;
        this.protein = protein;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getProtein() {
        return protein;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return name + " - Protein: " + protein + "g, Calories: " + calories;
    }
}
