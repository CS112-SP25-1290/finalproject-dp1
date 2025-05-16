package edu.miracosta.cs112.finalproject.finalproject;

/**
 * Strength workout extending WorkoutPlan.
 */
public class StrengthWorkout extends WorkoutPlan {
    public StrengthWorkout(String name, int duration) {
        super(name, duration);
    }

    @Override
    public String getWorkoutType() {
        return "Strength Training";
    }
}