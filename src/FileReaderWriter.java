import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FileReaderWriter {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        System.out.print("Enter filename (without extension): ");
        String filename = scanner.nextLine() + ".txt";

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1️⃣  Write to file");
            System.out.println("2️⃣  Read file");
            System.out.println("3️⃣  Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    writeToFile(filename);
                    break;
                case "2":
                    readFromFile(filename);
                    break;
                case "3":
                    System.out.println("👋 Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("❌ Invalid choice, please try again.");
            }
        }
    }

    private static void writeToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            System.out.println("Type your lines (type 'exit' to stop writing):");
            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) break;
                String timestamp = LocalDateTime.now().format(formatter);
                writer.write("[" + timestamp + "] " + input);
                writer.newLine();
            }
            System.out.println("✅ Lines saved successfully to " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    private static void readFromFile(String filename) {
        System.out.println("\n--- Reading from " + filename + " ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean empty = true;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                empty = false;
            }
            if (empty) System.out.println("(File is empty)");
        } catch (FileNotFoundException e) {
            System.out.println("⚠️ File not found. Try writing something first.");
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }
}
