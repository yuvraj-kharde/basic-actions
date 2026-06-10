import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Basic Automation Script
 * Simple automation tasks for everyday workflows
 */
//author: Yuvraj Kharde
public class BasicAutomation {

    private static final DateTimeFormatter FORMATTER = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Log a message with timestamp
     */
    public static void logMessage(String message) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        System.out.println("[" + timestamp + "] " + message);
    }

    /**
     * Print basic system information
     */
    public static void taskPrintSystemInfo() {
        logMessage("=== System Information ===");
        System.out.println("OS Name: " + System.getProperty("os.name"));
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Working Directory: " + System.getProperty("user.dir"));
        System.out.println("User: " + System.getProperty("user.name"));
    }

    /**
     * Perform basic file operations
     */
    public static void taskFileOperations() {
        logMessage("=== File Operations ===");
        
        String logFile = "automation.log";
        
        try {
            // Create and write to log file
            FileWriter writer = new FileWriter(logFile);
            writer.write("Automation started\n");
            writer.write("Timestamp: " + LocalDateTime.now() + "\n");
            writer.write("Status: Running\n");
            writer.close();
            
            logMessage("Log file created: " + logFile);
            
            // Read and display log file
            BufferedReader reader = new BufferedReader(new FileReader(logFile));
            String line;
            logMessage("Log file content:");
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + line);
            }
            reader.close();
            
        } catch (IOException e) {
            logMessage("Error in file operations: " + e.getMessage());
        }
    }

    /**
     * Process a list of items
     */
    public static void taskProcessItems() {
        logMessage("=== Processing Items ===");
        
        List<String> items = new ArrayList<>();
        items.add("task1");
        items.add("task2");
        items.add("task3");
        items.add("task4");
        items.add("task5");
        
        for (int i = 0; i < items.size(); i++) {
            logMessage("Processing " + (i + 1) + ": " + items.get(i));
        }
    }

    /**
     * Perform calculations
     */
    public static void taskPerformCalculations() {
        logMessage("=== Performing Calculations ===");
        
        int[] numbers = {10, 20, 30, 40, 50};
        int sum = 0;
        
        for (int num : numbers) {
            sum += num;
        }
        
        double average = (double) sum / numbers.length;
        logMessage("Sum of numbers: " + sum);
        logMessage("Average: " + String.format("%.2f", average));
    }

    /**
     * Main automation function
     */
    public static void main(String[] args) {
        logMessage("Starting Basic Automation Script");
        System.out.println();
        
        try {
            taskPrintSystemInfo();
            System.out.println();
            
            taskFileOperations();
            System.out.println();
            
            taskProcessItems();
            System.out.println();
            
            taskPerformCalculations();
            System.out.println();
            
            logMessage("Automation completed successfully!");
            
        } catch (Exception e) {
            logMessage("Error occurred: " + e.getMessage());
            System.exit(1);
        }
    }
}
