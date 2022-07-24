import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

class RecordBook {
    ArrayList persons;
    private String qty;

    RecordBook() {
        persons = new ArrayList();
        loadPersons();
    }

    void viewEntries() {
        String output = "";
        for (int i = 0; i < persons.size(); i++) {
            PersonInfo p = (PersonInfo) persons.get(i);
            output += "Reg No: " + p.regNo + "  Name: " + p.name + "  Address: " + p.address + "  Phone no: "
                    + p.phoneNumber + " Quantitie: " + p.quantitie + " Total Amount: " + p.totalAmount +"\n";
        }
        JOptionPane.showMessageDialog(null, output);
    }

    // adding a person
    void addPerson() {
        String value = JOptionPane.showInputDialog("Enter Reg No:");
        int regNo = Integer.parseInt(value);
        String name = JOptionPane.showInputDialog("Enter name:");
        String add = JOptionPane.showInputDialog("Enter address:");
        String pNum = JOptionPane.showInputDialog("Enter phone number:");
        String qty = JOptionPane.showInputDialog("Enter Quantitie:");
        int quantitie = Integer.parseInt(qty);
        String tAmount = JOptionPane.showInputDialog("Enter Total Amount:");
        int totalAmount = Integer.parseInt(tAmount);
        // Creating Person info object
        PersonInfo p = new PersonInfo(regNo, name, add, pNum, quantitie, totalAmount);

        persons.add(p);
    }

    // searching for a person
    void searchPerson(String n) {
        for (int i = 0; i < persons.size(); i++) {
            PersonInfo p = (PersonInfo) persons.get(i);
            if (n.equals(p.name)) {
                p.display();
            }
        }
    }

    // update for a person
    void updatePerson(Integer n) {
        String input, name, address, phoneno, qty, amount;
        int sel;
        for (int i = 0; i < persons.size(); i++) {
            PersonInfo p = (PersonInfo) persons.get(i);
            System.out.println(n);
            if (n.equals(p.regNo)) {
                input = JOptionPane.showInputDialog(
                    "Enter 1 to change your name\n Enter 2 to change your Address\n Enter 3 to change your Phone No\n Enter 4 to change your Quntitie\n Enter 5 to change Total Amount");
            sel = Integer.parseInt(input);

            switch (sel) {
                case 1:
                    name = JOptionPane.showInputDialog("change your name : ");
                    p.name = name;
                    p.display();
                    break;
                case 2:
                    address = JOptionPane.showInputDialog("change your Address : ");
                    p.address = address;
                    p.display();
                    break;
                case 3:
                    phoneno = JOptionPane.showInputDialog("change your PhoneNo : ");
                    p.phoneNumber = phoneno;
                    p.display();
                    break;
                case 4:
                    qty = JOptionPane.showInputDialog("change your Quntitie : ");
                    p.quantitie = Integer.parseInt(qty);
                    p.display();
                    break;
                case 5:
                    amount = JOptionPane.showInputDialog("change your Total Amount : ");
                    p.totalAmount = Integer.parseInt(amount);
                    p.display();
                    break;
            }
        }
    }
    }

    // deleting a person
    void deletePerson(String n) {
        for (int i = 0; i < persons.size(); i++) {
            PersonInfo p = (PersonInfo) persons.get(i);
            if (n.equals(p.name)) {
                persons.remove(i);
            }
        }
    }

    // saving person record
    void savePersons() {
        try {
            PersonInfo p;
            String line;
            FileWriter fw = new FileWriter("persons.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < persons.size(); i++) {
                p = (PersonInfo) persons.get(i);
                line = p.regNo + "," + p.name + "," + p.address + "," + p.phoneNumber + "," + p.quantitie + "," + p.totalAmount;
                // write line to persons.text
                pw.println(line);
            }
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException ioEX) {
            System.out.println(ioEX);
        }
    }

    // Insertion Sort
    void insertionSort() {

        int[] reg_nos = new int[persons.size()];

        for (int i = 0; i < reg_nos.length; i++) {
            PersonInfo p = (PersonInfo) persons.get(i);
            reg_nos[i] = p.regNo;
        }
        InsertionSort is = new InsertionSort();
        int[] sorted_list = is.sort(reg_nos);

        try {
            PersonInfo p;
            String line;
            FileWriter fw = new FileWriter("sorted_persons.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int j = 0; j < persons.size(); j++) {
                for (int i = 0; i < persons.size(); i++) {
                    p = (PersonInfo) persons.get(i);
                    if (sorted_list[j] == p.regNo) {
                        line = p.regNo + "," + p.name + "," + p.address + "," + p.phoneNumber + "," + p.quantitie + "," + p.totalAmount;
                        pw.println(line);
                    }
                }

            }
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException ioEX) {
            System.out.println(ioEX);
        }

        int[] quantities = new int[persons.size()];
        for (int i = 0; i < quantities.length; i++) {
            PersonInfo p = (PersonInfo) persons.get(i);
            quantities[i] = p.quantitie;
        }
        
        int[] sorted_list_qty = is.sort(quantities);

        try {
            PersonInfo p;
            String line;
            FileWriter fw = new FileWriter("sorted_qty_persons.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int j = 0; j < persons.size(); j++) {
                for (int i = 0; i < persons.size(); i++) {
                    p = (PersonInfo) persons.get(i);
                    if (sorted_list_qty[j] == p.quantitie) {
                        line = p.regNo + "," + p.name + "," + p.address + "," + p.phoneNumber + "," + p.quantitie + "," + p.totalAmount;
                        pw.println(line);
                    }
                }

            }
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException ioEX) {
            System.out.println(ioEX);
        }

    }

    // Bubble Sort
    void bubbleSort() {

        int[] reg_nos = new int[persons.size()];

        for (int i = 0; i < reg_nos.length; i++) {
            PersonInfo p = (PersonInfo) persons.get(i);
            reg_nos[i] = p.regNo;
        }
        BubbleSort bs = new BubbleSort();
        int[] sorted_list = bs.sort(reg_nos);

        try {
            PersonInfo p;
            String line;
            FileWriter fw = new FileWriter("sorted_persons.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int j = 0; j < persons.size(); j++) {
                for (int i = 0; i < persons.size(); i++) {
                    p = (PersonInfo) persons.get(i);
                    if (sorted_list[j] == p.regNo) {
                        line = p.regNo + "," + p.name + "," + p.address + "," + p.phoneNumber + "," + p.quantitie + "," + p.totalAmount;
                        pw.println(line);
                    }
                }

            }
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException ioEX) {
            System.out.println(ioEX);
        }

        int[] quantities = new int[persons.size()];
        for (int i = 0; i < quantities.length; i++) {
            PersonInfo p = (PersonInfo) persons.get(i);
            quantities[i] = p.quantitie;
        }
        
        int[] sorted_list_qty = bs.sort(quantities);

        try {
            PersonInfo p;
            String line;
            FileWriter fw = new FileWriter("sorted_qty_persons.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int j = 0; j < persons.size(); j++) {
                for (int i = 0; i < persons.size(); i++) {
                    p = (PersonInfo) persons.get(i);
                    if (sorted_list_qty[j] == p.quantitie) {
                        line = p.regNo + "," + p.name + "," + p.address + "," + p.phoneNumber + "," + p.quantitie + "," + p.totalAmount;
                        pw.println(line);
                    }
                }

            }
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException ioEX) {
            System.out.println(ioEX);
        }

    }

    // Selection Sort
    void selectionSort() {

        int[] reg_nos = new int[persons.size()];

        for (int i = 0; i < reg_nos.length; i++) {
            PersonInfo p = (PersonInfo) persons.get(i);
            reg_nos[i] = p.regNo;
        }
        SelectionSort ss = new SelectionSort();
        int[] sorted_list = ss.sort(reg_nos);

        try {
            PersonInfo p;
            String line;
            FileWriter fw = new FileWriter("sorted_persons.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int j = 0; j < persons.size(); j++) {
                for (int i = 0; i < persons.size(); i++) {
                    p = (PersonInfo) persons.get(i);
                    if (sorted_list[j] == p.regNo) {
                        line = p.regNo + "," + p.name + "," + p.address + "," + p.phoneNumber + "," + p.quantitie + "," + p.totalAmount;
                        pw.println(line);
                    }
                }

            }
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException ioEX) {
            System.out.println(ioEX);
        }

        int[] quantities = new int[persons.size()];
        for (int i = 0; i < quantities.length; i++) {
            PersonInfo p = (PersonInfo) persons.get(i);
            quantities[i] = p.quantitie;
        }
        
        int[] sorted_list_qty = ss.sort(quantities);

        try {
            PersonInfo p;
            String line;
            FileWriter fw = new FileWriter("sorted_qty_persons.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int j = 0; j < persons.size(); j++) {
                for (int i = 0; i < persons.size(); i++) {
                    p = (PersonInfo) persons.get(i);
                    if (sorted_list_qty[j] == p.quantitie) {
                        line = p.regNo + "," + p.name + "," + p.address + "," + p.phoneNumber + "," + p.quantitie + "," + p.totalAmount;
                        pw.println(line);
                    }
                }

            }
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException ioEX) {
            System.out.println(ioEX);
        }

    }

    // loading person record from text file
    void loadPersons() {
        String tokens[] = null;
        String name, add, ph;
        String value, tAmount;
        try {
            FileReader fr = new FileReader("sorted_persons.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                tokens = line.split(",");
                value = tokens[0];
                name = tokens[1];
                add = tokens[2];
                ph = tokens[3];
                qty = tokens[4];
                tAmount = tokens[5];
                int regNo = Integer.parseInt(value);
                int totalAmount=Integer.parseInt(tAmount);
                int quantitie =Integer.parseInt(qty);
                PersonInfo p = new PersonInfo(regNo, name, add, ph, quantitie, totalAmount);
                persons.add(p);
                line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException ioEX) {
            System.out.println(ioEX);
        }
    }
}