package edu.miracosta.cs112.finalproject.finalproject;

/**
 * Cardio workout extending WorkoutPlan.
 */
public class CardioWorkout extends WorkoutPlan {
    public CardioWorkout(String name, int duration) {
        super(name, duration);
    }

    @Override
    public String getWorkoutType() {
        return "Cardio Training";
    }
}