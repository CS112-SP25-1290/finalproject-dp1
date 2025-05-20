package edu.miracosta.cs112.finalproject.finalproject;

import java.util.ArrayList;

public abstract class WorkoutPlan {
    protected String name;
    protected int duration; // Minutes
    protected int caloriesBurned; // Estimated calories
    protected ArrayList<String> exercises;

    public WorkoutPlan(String name, int duration, int caloriesBurned) {
        this.name = name;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.exercises = new ArrayList<>();
    }

    public abstract String getWorkoutType();

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public ArrayList<String> getExercises() {
        return exercises;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Workout: ").append(name)
                .append("\nType: ").append(getWorkoutType())
                .append("\nDuration: ").append(duration).append(" minutes")
                .append("\nCalories Burned: ").append(caloriesBurned)
                .append("\nExercises:\n");

        for (String exercise : exercises) {
            sb.append(" - ").append(exercise).append("\n");
        }

        return sb.toString();
    }
}