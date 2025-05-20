package edu.miracosta.cs112.finalproject.finalproject;

import java.util.ArrayList;
import java.util.Arrays;

public class CardioWorkout extends WorkoutPlan {
    private ArrayList<String> exercises;

    public CardioWorkout(String name, int duration, int caloriesBurned, String[] exercises) {
        super(name, duration, caloriesBurned);
        this.exercises = new ArrayList<>(Arrays.asList(exercises));
    }

    @Override
    public ArrayList<String> getExercises() {
        return exercises;
    }

    @Override
    public String getWorkoutType() {
        return "Cardio Training - Includes exercises like: " + String.join(", ", exercises);
    }

    @Override
    public String toString() {
        return super.toString() + "\nExercises: " + String.join(", ", exercises);
    }
}
