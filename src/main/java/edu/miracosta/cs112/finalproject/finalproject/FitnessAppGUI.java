package edu.miracosta.cs112.finalproject.finalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FitnessAppGUI extends JFrame {
    private UserProfile user;
    private JTextField calorieField;
    private JTextArea outputArea;
    private int workoutIndex = 0;

    private WorkoutPlan[] workouts = {
            new StrengthWorkout(
                    "Full Body Strength", 45, 400,
                    new String[]{"Barbell Squats", "Push-ups", "Deadlifts", "Overhead Press"}
            ),
            new CardioWorkout(
                    "Interval Running", 30, 500,
                    new String[]{"Warm-up Jog 5 min", "Sprint 1 min", "Jog 2 min", "Cool-down Walk 5 min"}
            ),
            new StrengthWorkout(
                    "Upper Body Blast", 50, 450,
                    new String[]{"Bench Press", "Pull-ups", "Shoulder Press", "Tricep Dips"}
            ),
            new CardioWorkout(
                    "Cycling Intervals", 40, 600,
                    new String[]{"Pedal Fast 1 min", "Recover 2 min", "Repeat 5x", "Cool Down 5 min"}
            ),
            new StrengthWorkout(
                    "Core Strength", 35, 350,
                    new String[]{"Plank (1 min)", "Bicycle Crunches", "Russian Twists", "Leg Raises", "Mountain Climbers"}
            )
    };


    private Meal[] meals = {
            new Meal("Grilled Chicken Breast", 40, 300),
            new Meal("Salmon with Quinoa", 35, 450),
            new Meal("Egg Omelette", 25, 200),
            new Meal("Greek Yogurt with Nuts", 20, 250),
            new Meal("Tofu Stir Fry", 30, 350),
            new Meal("Turkey Sandwich", 28, 400),
            new Meal("Lentil Soup", 18, 300),
            new Meal("Protein Smoothie", 30, 275),
            new Meal("Grilled Veggie Wrap", 22, 320)
    };

    public FitnessAppGUI(UserProfile user, WorkoutPlan[] workouts) {
        if (user == null) {
            throw new IllegalArgumentException("UserProfile cannot be null.");
        }
        this.user = user;
        this.workouts = workouts;

        // Set look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        setTitle("Fitness Tracker");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("\uD83D\uDCAA Fitness Tracker");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        calorieField = new JTextField(10);
        calorieField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        calorieField.setFont(new Font("SansSerif", Font.PLAIN, 16));

        JLabel calorieLabel = new JLabel("Enter Calories Consumed:");
        calorieLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));

        JButton submitButton = new JButton("Track Calories");
        JButton workoutButton = new JButton("Suggest Workout");
        JButton dietButton = new JButton("Suggest Diet");

        Font buttonFont = new Font("SansSerif", Font.BOLD, 14);
        submitButton.setFont(buttonFont);
        workoutButton.setFont(buttonFont);
        dietButton.setFont(buttonFont);

        submitButton.setBackground(new Color(76, 175, 80));
        workoutButton.setBackground(new Color(33, 150, 243));
        dietButton.setBackground(new Color(255, 193, 7));

        submitButton.setForeground(Color.WHITE);
        workoutButton.setForeground(Color.WHITE);
        dietButton.setForeground(Color.BLACK);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.WHITE);
        inputPanel.add(calorieLabel);
        inputPanel.add(calorieField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(submitButton);
        buttonPanel.add(workoutButton);
        buttonPanel.add(dietButton);

        outputArea = new JTextArea(10, 60);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("\uD83D\uDCCB Your Progress"));

        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(inputPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(scrollPane);

        add(mainPanel);

        submitButton.addActionListener(e -> handleCalorieTracking());
        workoutButton.addActionListener(e -> suggestWorkout());
        dietButton.addActionListener(e -> suggestDiet());

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
            user.addCalories(calories);
            outputArea.setText(user.toString());
        } catch (NumberFormatException | InvalidCaloriesException e) {
            outputArea.setText("Error: " + e.getMessage());
        }
    }

    private void suggestWorkout() {
        WorkoutPlan suggestedWorkout = workouts[workoutIndex];
        workoutIndex = (workoutIndex + 1) % workouts.length;
        user.addWorkout(suggestedWorkout);

        StringBuilder builder = new StringBuilder();
        builder.append("Suggested Workout:\n").append(suggestedWorkout).append("\n");

        builder.append("Exercises:\n");
        for (String exercise : suggestedWorkout.getExercises()) {
            builder.append("- ").append(exercise).append("\n");
        }

        builder.append("\n").append(user.getWorkoutSummary());
        outputArea.setText(builder.toString());
    }

    private void suggestDiet() {
        Random random = new Random();
        Meal suggestedMeal = meals[random.nextInt(meals.length)];
        outputArea.setText("Suggested Meal:\n" + suggestedMeal.toString());
    }
}