package paswrdmngr.models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_NAME = "accounts.ser";

    public static void saveToFile(List<Account> accounts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(FILE_NAME))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Account> loadFromFile() {
        List<Account> accounts = new ArrayList<>();
        
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(FILE_NAME))) {
            accounts = (List<Account>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No existing file found. Starting with empty list.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading from file: " + e.getMessage());
        }
        
        return accounts;
    }
}