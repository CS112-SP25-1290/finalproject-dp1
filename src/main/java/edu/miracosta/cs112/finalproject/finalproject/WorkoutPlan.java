package edu.miracosta.cs112.finalproject.finalproject;
/**
 * Abstract class defining workout plan blueprint.
 */
public abstract class WorkoutPlan {
    protected String name;
    protected int duration; // Minutes
    protected int caloriesBurned; // Calories estimated per session

    public WorkoutPlan(String name, int duration, int caloriesBurned) {
        this.name = name;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    public abstract String getWorkoutType();

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    @Override
    public String toString() {
        return "Workout: " + name + ", Duration: " + duration + " minutes, Calories Burned: " + caloriesBurned;
    }
}
