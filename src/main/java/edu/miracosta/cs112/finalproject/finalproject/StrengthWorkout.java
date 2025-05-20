package edu.miracosta.cs112.finalproject.finalproject;

import java.util.ArrayList;
import java.util.Arrays;

public class StrengthWorkout extends WorkoutPlan {
    private ArrayList<String> exercises;

    public StrengthWorkout(String name, int duration, int caloriesBurned, String[] exercises) {
        super(name, duration, caloriesBurned);
        this.exercises = new ArrayList<>(Arrays.asList(exercises));
    }

    @Override
    public String getWorkoutType() {
        return "Strength Training - Includes exercises like: " + String.join(", ", exercises);
    }

    @Override
    public String toString() {
        return super.toString() + "\nExercises: " + String.join(", ", exercises);
    }

    @Override
    public ArrayList<String> getExercises() {
        return exercises;
    }
}
