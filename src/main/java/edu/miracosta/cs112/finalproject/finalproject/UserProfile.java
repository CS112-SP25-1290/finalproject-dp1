package edu.miracosta.cs112.finalproject.finalproject;
//https://docs.google.com/presentation/d/10QLem-FvxP4YuuniVW6cXjAO_EQVNtpJh8cYje8c4rM/edit?usp=sharing

import java.util.ArrayList;

/**
 * Represents the user profile, including weight and calorie tracking.
 */

public class UserProfile {
    private String name;
    private double weight;
    private int age;
    private int consumedCalories;
    private int dailyCalorieGoal;
    private ArrayList<WorkoutPlan> workouts = new ArrayList<>();

    public UserProfile(String name, double weight, int age, int consumedCalories, int dailyCalorieGoal) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.consumedCalories = consumedCalories;
        this.dailyCalorieGoal = dailyCalorieGoal;
    }

    public UserProfile(String name, double weight, int age, int dailyCalorieGoal) {
        this(name, weight, age, 0, dailyCalorieGoal);
    }

    public void addCalories(int calories) throws InvalidCaloriesException {
        if (calories < 0) {
            throw new InvalidCaloriesException("Calories cannot be negative.");
        }
        consumedCalories += calories;
    }

    public int getRemainingCalories() {
        return dailyCalorieGoal - consumedCalories;
    }

    public void addWorkout(WorkoutPlan workout) {
        workouts.add(workout);
    }

    public String getWorkoutSummary() {
        if (workouts.isEmpty()) return "No workouts logged yet.";
        StringBuilder sb = new StringBuilder("Workout Summary:\n");
        for (WorkoutPlan w : workouts) {
            sb.append(w.toString()).append("\n");
        }
        return sb.toString();
    }

    // Getters and Setters...
    public String getName() { return name; }
    public double getWeight() { return weight; }
    public int getAge() { return age; }
    public int getConsumedCalories() { return consumedCalories; }
    public int getDailyCalorieGoal() { return dailyCalorieGoal; }

    public void setName(String name) { this.name = name; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setAge(int age) { this.age = age; }
    public void setConsumedCalories(int consumedCalories) { this.consumedCalories = consumedCalories; }
    public void setDailyCalorieGoal(int dailyCalorieGoal) { this.dailyCalorieGoal = dailyCalorieGoal; }

    @Override
    public String toString() {
        return "UserProfile{" +
                "Name: " + name + '\'' +
                ", Weight: " + weight +
                ", Age: " + age +
                "\nCalories Consumed: " + consumedCalories +
                ", Daily Calorie Goal: " + dailyCalorieGoal +
                '}';
    }
}
