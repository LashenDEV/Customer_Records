import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AddressBook ab = new AddressBook();
        String input, s;
        int ch;

        while (true) {
            input = JOptionPane.showInputDialog("Enter 1 to add\n Enter 2 to Search\n Enter 3 to delete\n Enter 4 to exit");
            ch = Integer.parseInt(input);

            switch (ch) {
                case 1 -> ab.addPerson();
                case 2 -> {
                    s = JOptionPane.showInputDialog("Enter name to search:");
                    ab.searchPerson(s);
                }
                case 3 -> {
                    s = JOptionPane.showInputDialog("Enter name to delete:");
                    ab.deletePerson(s);
                }
                case 4 -> {
                    ab.savePersons();
                    System.exit(0);
                }
            }
        }
    }
}
