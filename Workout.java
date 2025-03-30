https://docs.google.com/presentation/d/10QLem-FvxP4YuuniVW6cXjAO_EQVNtpJh8cYje8c4rM/edit?usp=sharing

public class Workout extends FitnessRecord {
    private String type;
    private int duration;
    private double caloriesBurned; 

   
    public Workout() {
        super();
        this.type = "";
        this.duration = 0;
        this.caloriesBurned = 0.0;
    }

  
    public Workout(String date, String type, int duration, double caloriesBurned) {
        super(date);
        this.type = type;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }


    @Override
    public void logDetails() {
        System.out.println("Workout Date: " + getDate());
        System.out.println("Type: " + type);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Calories Burned: " + caloriesBurned + " kcal");
    }


    @Override
    public double calculateCalories() {
        return caloriesBurned;
    }


    @Override
    public String toString() {
        return "Workout{" +
                "type='" + type + '\'' +
                ", duration=" + duration +
                ", caloriesBurned=" + caloriesBurned +
                ", date=" + getDate() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Workout workout = (Workout) o;

        if (duration != workout.duration) return false;
        if (Double.compare(workout.caloriesBurned, caloriesBurned) != 0) return false;
        return type != null ? type.equals(workout.type) : workout.type == null;
    }
}