package DiaryTest;

import javax.swing.*;
import java.time.LocalDate;

public class Main {
    private static final Diary diary = new Diary();
    private static final LocalDate localDate = LocalDate.now();

    public static void main(String[] args) {
       goToMainMenu();

    }


    public  static void goToMainMenu() {
        String mainMenu =  "\n" + """
                ==========
                Welcome to DiaryBook:
                 1 ->Create an entry
                 2 ->View entry
                 3 ->Count entry
                 4 ->Delete entry
                 5 ->Edit dairy
                 6 ->Exit
                """;

        String userInput = input(mainMenu);
        switch (userInput.charAt(0)) {
            case '1' -> createEntry();
            case '2' -> viewEntry();
            case '3' -> countEntry();
            case '4' -> deleteEntry();
            case '5' -> {
                try {
                userInput = input("""
                         1 -> Edit title
                         2 -> Edit body
                         3 -> Cancel
                        """);
                }catch (NumberFormatException e){

                    goToMainMenu();
                }
                switch (userInput.charAt(0)){
                    case '1' -> editTopic();
                    case '2' -> editContent();
                    default -> displayDiary("Invalid input, select a valid option");
                }goToMainMenu();
            }
            case '6' -> exit();
            default -> displayDiary("Invalid input, select a valid option ");

        }goToMainMenu();
    }
    public static void editContent() {
        int contentId = Integer.parseInt(input("Enter the id of the content to edit"));
        String content = input("Edit content");
       diary.editContent(contentId,content);
       goToMainMenu();
    }

    public static void editTopic() {
        int index = Integer.parseInt(input("Enter the id of the topic to edit"));
        String topic = input("Edit topic");
        diary.editTopic(index,topic);
        goToMainMenu();

    }


    public static void createEntry() {
        Entry entry = new Entry();
       entry.setTopic(input("Enter the title to create a memory"));
        entry.setContent(input("Enter the body to create a memory"));
       diary.addEntry(entry);
       displayDiary(" Diary created successfully" + (localDate));
       goToMainMenu();
    }


    public static void viewEntry() {
     try {
         int id = Integer.parseInt(input("Enter diary id to view"));
         displayDiary(String.valueOf(diary.viewEntry(id)));
         goToMainMenu();

     } catch (IndexOutOfBoundsException e) {
         displayDiary(e.getMessage() + "  Input the correct id");
         goToMainMenu();
        }
    }

    private static void countEntry() {
        displayDiary("Total number of entries is: " + diary.getNumberOfEntries());
        goToMainMenu();
    }

    public static void deleteEntry() {
        try {
            int entryId = Integer.parseInt((input("Enter id of entry you want to delete")));
            diary.deleteEntry(entryId);
            displayDiary("Content deleted successfully");
            goToMainMenu();
        } catch (IndexOutOfBoundsException e) {
            displayDiary(e.getMessage() + "  input the correct id");
            goToMainMenu();
        }
    }


    public static void exit() {
        System.exit(1);
        goToMainMenu();
    }



    private static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    public  static void displayDiary(String prompt){
        JOptionPane.showMessageDialog(null, prompt);

    }


}