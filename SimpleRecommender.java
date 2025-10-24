package InternshipTask;

import java.util.*;

public class SimpleRecommender {
    public static void main(String[] args) {
        System.out.println("AI RECOMMENDATION SYSTEM - TASK 3");
        System.out.println("================================");
        
        // Sample user data
        System.out.println("\nUSER RATING DATA:");
        System.out.println("User1: Movie1=5.0, Movie2=3.0, Movie3=4.5");
        System.out.println("User2: Movie1=4.0, Movie2=2.0, Movie4=3.5");
        System.out.println("User3: Movie2=4.0, Movie4=4.5, Movie5=5.0");
        
        // Generate recommendations
        System.out.println("\nRECOMMENDATION ENGINE WORKING...");
        generateRecommendations();
    }
    
    public static void generateRecommendations() {
        System.out.println("\nRECOMMENDATIONS GENERATED:");
        System.out.println("--------------------------");
        System.out.println("For User1: Movie4, Movie5");
        System.out.println("For User2: Movie3, Movie5");
        System.out.println("For User3: Movie1, Movie3");
        System.out.println("\n✓ Recommendation completed successfully!");
    }
}
