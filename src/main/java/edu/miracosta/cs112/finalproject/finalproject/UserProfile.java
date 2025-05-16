package edu.miracosta.cs112.finalproject.finalproject;
//https://docs.google.com/presentation/d/10QLem-FvxP4YuuniVW6cXjAO_EQVNtpJh8cYje8c4rM/edit?usp=sharing

import java.util.ArrayList;

/**
 * Represents the user profile, including weight and calorie tracking.
 */
public class UserProfile {
    private String name;
    private int age;
    private double weight;
    private int dailyCalorieGoal;
    private ArrayList<Integer> calorieHistory = new ArrayList<>();

    // Inner class for calorie calculation
    public class CalorieCalculator {
        public int calculateCaloriesBurned(int minutes, String type) {
            if (type.equalsIgnoreCase("Cardio")) {
                return minutes * 10;
            } else if (type.equalsIgnoreCase("Strength")) {
                return minutes * 8;
            }
            return minutes * 5; // Default for other workouts
        }
    }

    // Constructor
    public UserProfile(String name, int age, double weight, int dailyCalorieGoal) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.dailyCalorieGoal = dailyCalorieGoal;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public void addCalories(int calories) throws InvalidCaloriesException {
        if (calories < 0) throw new InvalidCaloriesException("Calories cannot be negative!");
        calorieHistory.add(calories);
    }

    public int getTotalCalories() {
        return calorieHistory.stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public String toString() {
        return "User: " + name + ", Age: " + age + ", Weight: " + weight + "kg, Daily Goal: " + dailyCalorieGoal + " calories";
    }
}