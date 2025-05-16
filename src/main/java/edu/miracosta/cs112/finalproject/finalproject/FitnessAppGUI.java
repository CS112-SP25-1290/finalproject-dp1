package edu.miracosta.cs112.finalproject.finalproject;

import java.util.Random;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class FitnessAppGUI extends JFrame {
    private UserProfile user;
    private JTextField calorieField;
    private JTextArea outputArea;

    private final int frameWidth = 800;
    private final int frameHeight = 600;

    public FitnessAppGUI(UserProfile user) {
        if (user == null) {
            throw new IllegalArgumentException("UserProfile cannot be null.");
        }
        this.user = user;

        setTitle("Fitness Tracker");
        setSize(frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Center calculation helper
        int inputWidth = 150;
        int inputX = (frameWidth - inputWidth) / 2;

        // Label (can be a bit left to input)
        JLabel calorieLabel = new JLabel("Enter Calories Consumed:");
        calorieLabel.setBounds(inputX - 180, 20, 160, 30);  // left of input field
        add(calorieLabel);

        // Text field centered
        calorieField = new JTextField();
        calorieField.setBounds(inputX, 20, inputWidth, 30);
        add(calorieField);

        // Buttons centered with some vertical spacing
        int buttonWidth = 150;
        int buttonHeight = 30;
        int buttonX = (frameWidth - buttonWidth) / 2;

        JButton submitButton = new JButton("Track Calories");
        submitButton.setBounds(buttonX, 70, buttonWidth, buttonHeight);
        add(submitButton);

        JButton workoutButton = new JButton("Suggest Workout");
        workoutButton.setBounds(buttonX, 110, buttonWidth, buttonHeight);
        add(workoutButton);

        JButton dietButton = new JButton("Suggest Diet");
        dietButton.setBounds(buttonX, 150, buttonWidth, buttonHeight);
        add(dietButton);

        // Output area in JScrollPane (not centered, fills below buttons)
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(20, 200, frameWidth - 40, 330);
        add(scrollPane);

        // Action listeners
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCalorieTracking();
            }
        });

        workoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suggestWorkout();
            }
        });

        dietButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suggestDiet();
            }
        });

        setVisible(true);
    }

    private void handleCalorieTracking() {
        String input = calorieField.getText().trim();

        if (input.isEmpty()) {
            outputArea.setText("Error: Please enter a valid number for calories.");
            return;
        }

        try {
            int calories = Integer.parseInt(input);
            if (calories < 0) {
                outputArea.setText("Error: Calories cannot be negative.");
                return;
            }

            try {
                user.addCalories(calories);
                outputArea.setText(user.toString());
            } catch (InvalidCaloriesException e) {
                outputArea.setText("Error: " + e.getMessage());
            }

        } catch (NumberFormatException e) {
            outputArea.setText("Error: Invalid input. Please enter a number.");
        }
    }

    private void suggestWorkout() {
        WorkoutPlan suggestedWorkout = workouts[workoutIndex];
        workoutIndex = (workoutIndex + 1) % workouts.length; // cycle through array
        user.addWorkout(suggestedWorkout);
        outputArea.setText(user.getWorkoutSummary());
    }

    private int workoutIndex = 0;
    private WorkoutPlan[] workouts = {
            new StrengthWorkout("Strength Training", 45, 400),
            new CardioWorkout("Running", 40, 600),
            new StrengthWorkout("Weight Lifting", 60, 500),
            new CardioWorkout("Cycling", 30, 350),
            new StrengthWorkout("HIIT", 30, 450)
    };
    private void suggestDiet() {
        Random random = new Random();
        int idx = random.nextInt(meals.length);
        Meal suggestedMeal = meals[idx];
        outputArea.setText("Suggested Meal:\n" + suggestedMeal.toString());
    }

    private Meal[] meals = {
            new Meal("Grilled Chicken Breast", 40, 300),
            new Meal("Salmon with Quinoa", 35, 450),
            new Meal("Egg Omelette", 25, 200),
            new Meal("Greek Yogurt with Nuts", 20, 250),
            new Meal("Tofu Stir Fry", 30, 350),
            new Meal("Turkey Sandwich", 28, 400)
    };
}

