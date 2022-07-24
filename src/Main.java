import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        RecordBook cr = new RecordBook();
        String input, s;
        int ch, sel;

        input = JOptionPane.showInputDialog(
                "Enter 1 to Insertion Sort\n Enter 2 to Bubble Sort\n Enter 3 to Seletion Sort\n Enter 4 to exit");
        sel = Integer.parseInt(input);

        while (true) {
            input = JOptionPane.showInputDialog(
                    "Enter 1 to add\n Enter 2 to View All Entries\n Enter 3 to Search\n Enter 4 to update\n Enter 5 to delete\n Enter 6 to exit");
            ch = Integer.parseInt(input);

            switch (ch) {
                case 1:
                    cr.addPerson();
                    break;
                case 2:
                    cr.viewEntries();
                    break;
                case 3:
                    s = JOptionPane.showInputDialog("Enter name to search:");
                    cr.searchPerson(s);
                    break;
                case 4:
                    s = JOptionPane.showInputDialog("Enter reg no to Update");
                    cr.updatePerson(Integer.parseInt(s));
                    cr.savePersons();
                    break;
                case 5:
                    s = JOptionPane.showInputDialog("Enter name to delete:");
                    cr.deletePerson(s);
                    break;
                case 6:
                    cr.savePersons();
                    switch (sel) {
                        case 1:
                            cr.insertionSort();
                            break;
                        case 2:
                            cr.bubbleSort();
                            break;
                        case 3:
                            cr.selectionSort();
                            break;
                        case 4:
                            System.exit(0);
                    }
                    System.exit(0);
                    break;
            }
        }
    }
}
