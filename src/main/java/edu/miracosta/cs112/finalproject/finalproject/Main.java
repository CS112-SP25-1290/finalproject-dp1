package edu.miracosta.cs112.finalproject.finalproject;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Enter your name:");
        double weight = Double.parseDouble(JOptionPane.showInputDialog("Enter your weight in pounds:"));
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age:"));
        int goal = Integer.parseInt(JOptionPane.showInputDialog("Enter your daily calorie goal:"));

        // Create the UserProfile
        UserProfile user = new UserProfile(name, weight, age, goal);


        WorkoutPlan[] workouts = {
                new StrengthWorkout("Full Body Strength", 45, 400, new String[]{"Barbell Squats", "Push-ups", "Deadlifts", "Overhead Press"}),
                new CardioWorkout("Interval Running", 30, 500, new String[]{"Warm-up Jog 5 min", "Sprint 1 min", "Jog 2 min", "Cool-down Walk 5 min"}),
                new StrengthWorkout("Upper Body Blast", 50, 450, new String[]{"Bench Press", "Pull-ups", "Shoulder Press", "Tricep Dips"}),
                new CardioWorkout("Cycling Intervals", 40, 600, new String[]{"Pedal Fast 1 min", "Recover 2 min", "Repeat 5x", "Cool Down 5 min"}),
                new StrengthWorkout("Core Strength", 35, 350, new String[]{"Plank (1 min)", "Bicycle Crunches", "Russian Twists", "Leg Raises", "Mountain Climbers"})
        };

        new FitnessAppGUI(user, workouts);

        // Example Workouts


        System.out.println(user.getWorkoutSummary());
    }
}
