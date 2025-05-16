package edu.miracosta.cs112.finalproject.finalproject;
public class Main {
    public static void main(String[] args) {
        UserProfile user = new UserProfile("John Doe", 30, 80, 2000);

        // Launch GUI
        new FitnessAppGUI(user);

        // Example Workouts
        WorkoutPlan workout1 = new StrengthWorkout("Weight Lifting", 40);
        WorkoutPlan workout2 = new CardioWorkout("Running", 30);

        System.out.println(workout1);
        System.out.println(workout2);
    }
}
