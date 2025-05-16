package edu.miracosta.cs112.finalproject.finalproject;
public class Main {
    public static void main(String[] args) {
        UserProfile user = new UserProfile("Bob", 160.0, 24, 0, 2500);


        // Launch GUI
        new FitnessAppGUI(user);

        // Example Workouts
        WorkoutPlan workout1 = new StrengthWorkout("Strength Training", 45, 400);
        WorkoutPlan workout2 = new CardioWorkout("Running", 40, 600);
        WorkoutPlan workout3 = new StrengthWorkout("Weight Lifting", 60, 500);
        WorkoutPlan workout4 = new CardioWorkout("Cycling", 30, 350);
        WorkoutPlan workout5 = new StrengthWorkout("HIIT", 30, 450);

        System.out.println(workout1);
        System.out.println(workout2);
        System.out.println(workout3);
        System.out.println(workout4);
        System.out.println(workout5);

        System.out.println(user.getWorkoutSummary());
    }
}
