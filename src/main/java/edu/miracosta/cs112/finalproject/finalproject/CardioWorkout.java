package edu.miracosta.cs112.finalproject.finalproject;

/**
 * Cardio workout extending WorkoutPlan.
 */
public class CardioWorkout extends WorkoutPlan {
    public CardioWorkout() {
        super("Cardio Training", 40, 600);
    }

    public CardioWorkout(String name, int duration, int caloriesBurned) {
        super(name, duration, caloriesBurned);
    }

    @Override
    public String getWorkoutType() {
        return "Cardio Training - Includes sprint intervals, cycling, jump rope, and burpees.";
    }
}