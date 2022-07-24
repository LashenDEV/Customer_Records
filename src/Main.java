import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        RecordBook cr = new RecordBook();
        String input, s;
        int ch, sel;

        input = JOptionPane.showInputDialog(
                "Enter 1 to Insertion Sort\nEnter 2 to Bubble Sort\nEnter 3 to Seletion Sort\nEnter 4 to Exit");
        sel = Integer.parseInt(input);

        while (true) {
            input = JOptionPane.showInputDialog(
                    "Enter 1 to add\nEnter 2 to View All Entries\nEnter 3 to Search\nEnter 4 to update\nEnter 5 to delete\nEnter 6 to save data and exit");
            ch = Integer.parseInt(input);

            switch (ch) {
                case 1:
                    cr.addCustomer();
                    break;
                case 2:
                    cr.viewEntries();
                    break;
                case 3:
                    s = JOptionPane.showInputDialog("Enter reg no to search:");
                    cr.searchCustomer(Integer.parseInt(s));
                    break;
                case 4:
                    s = JOptionPane.showInputDialog("Enter reg no to Update");
                    cr.updateCustomer(Integer.parseInt(s));
                    cr.saveCustomers();
                    break;
                case 5:
                    s = JOptionPane.showInputDialog("Enter reg no to delete:");
                    cr.deleteCustomer(Integer.parseInt(s));
                    break;
                case 6:
                    cr.saveCustomers();
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
