import java.io.*;
import java.util.Scanner;

public class FileReaderWriter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter filename (without extension): ");
        String filename = scanner.nextLine() + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            System.out.println("Type something to save to the file (type 'exit' to stop):");
            String input;
            while (true) {
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) break;
                writer.write(input);
                writer.newLine();
            }
            System.out.println("✅ Text saved successfully to " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }

        System.out.println("\n--- File contents ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }

        scanner.close();
    }
}
