package edu.miracosta.cs112.finalproject.finalproject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI interface for tracking calories and workouts.
 */
public class FitnessAppGUI extends JFrame {
    private UserProfile user;
    private JTextField calorieField;
    private JTextArea outputArea;

    public FitnessAppGUI(UserProfile user) {
        if (user == null) {
            throw new IllegalArgumentException("UserProfile cannot be null.");
        }
        this.user = user;

        setTitle("Fitness Tracker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Using absolute positioning

        // Label
        JLabel calorieLabel = new JLabel("Enter Calories Consumed:");
        calorieLabel.setBounds(20, 20, 180, 30);
        add(calorieLabel);

        // Input field
        calorieField = new JTextField();
        calorieField.setBounds(200, 20, 150, 30);
        add(calorieField);

        // Button
        JButton submitButton = new JButton("Track Calories");
        submitButton.setBounds(130, 70, 130, 30);
        add(submitButton);

        // Output area
        outputArea = new JTextArea();
        outputArea.setBounds(20, 120, 350, 120);
        outputArea.setEditable(false);
        add(outputArea);

        // Action Listener for button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCalorieTracking();
            }
        });

        setVisible(true);
    }

    /**
     * Validates and processes calorie input from the user.
     */
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

            user.addCalories(calories); // Assumes method may throw InvalidCaloriesException
            outputArea.setText("Total Calories Tracked: " + user.getTotalCalories());

        } catch (NumberFormatException e) {
            outputArea.setText("Error: Invalid input. Please enter a number.");
        } catch (InvalidCaloriesException e) {
            outputArea.setText("Error: " + e.getMessage());
        }
    }
}
