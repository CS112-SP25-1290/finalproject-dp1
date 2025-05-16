package edu.miracosta.cs112.finalproject.finalproject;

/**
 * Strength workout extending WorkoutPlan.
 */
public class StrengthWorkout extends WorkoutPlan {

    public StrengthWorkout() {
        super("Strength Training", 45, 400);
    }

    public StrengthWorkout(String name, int duration, int caloriesBurned) {
        super(name, duration, caloriesBurned);
    }

    @Override
    public String getWorkoutType() {
        return "Strength Training - Includes weight lifting, squats, lunges, and core exercises.";
    }
}