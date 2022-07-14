import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AddressBook ab = new AddressBook();
        String input, s;
        int ch, sel;

        input = JOptionPane.showInputDialog("Enter 1 to Insertion Sort\n Enter 2 to Bubble Sort\n Enter 3 to Quick Sort\n Enter 4 to exit");
        sel = Integer.parseInt(input);

        while (true) {
            input = JOptionPane.showInputDialog("Enter 1 to add\n Enter 2 to View All Entries\n Enter 3 to Search\n Enter 4 to delete\n Enter 5 to exit");
            ch = Integer.parseInt(input);

            switch (ch) {
                case 1 -> ab.addPerson();
                case 2 -> ab.viewEntries();
                case 3 -> {
                    s = JOptionPane.showInputDialog("Enter name to search:");
                    ab.searchPerson(s);
                }
                case 4 -> {
                    s = JOptionPane.showInputDialog("Enter name to delete:");
                    ab.deletePerson(s);
                }
                case 5 -> {
                    ab.savePersons();
                    System.exit(0);
                }
            }
        }
    }
}
