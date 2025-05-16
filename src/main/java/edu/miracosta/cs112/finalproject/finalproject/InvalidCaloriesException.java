package edu.miracosta.cs112.finalproject.finalproject;
/**
 * Custom exception for invalid calorie input.
 */
public class InvalidCaloriesException extends Exception {
    public InvalidCaloriesException(String message) {
        super(message);
    }
}