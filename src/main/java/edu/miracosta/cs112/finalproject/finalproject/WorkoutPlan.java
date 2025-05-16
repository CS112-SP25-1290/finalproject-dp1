package edu.miracosta.cs112.finalproject.finalproject;
/**
 * Abstract class defining workout plan blueprint.
 */
public abstract class WorkoutPlan {
    protected String name;
    protected int duration; // Minutes

    public WorkoutPlan(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public abstract String getWorkoutType();

    @Override
    public String toString() {
        return "Workout: " + name + ", Duration: " + duration + " minutes.";
    }
}