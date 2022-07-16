import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

class RecordBook {
    ArrayList persons;

    RecordBook() {
        persons = new ArrayList();
        loadPersons();
    }

    void viewEntries() {
        String output = "";
        for (int i = 0; i < persons.size(); i++) {
            PersonInfo p = (PersonInfo) persons.get(i);
            output += "Reg No: " + p.regNo + "  Name: " + p.name + "  Address: " + p.address + "  Phone no: " + p.phoneNumber + "\n";
        }
        JOptionPane.showMessageDialog(null, output);
    }

    //adding a person
    void addPerson() {
        String value = JOptionPane.showInputDialog("Enter Reg No:");
        int regNo = Integer.parseInt(value);
        String name = JOptionPane.showInputDialog("Enter name:");
        String add = JOptionPane.showInputDialog("Enter address:");
        String pNum = JOptionPane.showInputDialog("Enter phone number:");
        //Creating Person info object
        PersonInfo p = new PersonInfo(regNo, name, add, pNum);

        persons.add(p);
    }

    //searching for a person
    void searchPerson(String n) {
        for (int i = 0; i < persons.size(); i++) {
            PersonInfo p = (PersonInfo) persons.get(i);
            if (n.equals(p.name)) {
                p.display();
            }
        }
    }

    //deleting a person
    void deletePerson(String n) {
        for (int i = 0; i < persons.size(); i++) {
            PersonInfo p = (PersonInfo) persons.get(i);
            if (n.equals(p.name)) {
                persons.remove(i);
            }
        }
    }

    //saving person record
    void savePersons() {
        try {
            PersonInfo p;
            String line;
            FileWriter fw = new FileWriter("persons.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < persons.size(); i++) {
                p = (PersonInfo) persons.get(i);
                line = p.regNo + "," + p.name + "," + p.address + "," + p.phoneNumber;
                //write line to persons.text
                pw.println(line);
            }
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException ioEX) {
            System.out.println(ioEX);
        }
    }


    //Insertion Sort
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
                        line = p.regNo + "," + p.name + "," + p.address + "," + p.phoneNumber;
                        pw.println(line);
                    }
                }

            }
            pw.flush();
            pw.close();
            fw.close();
        } catch (
                IOException ioEX) {
            System.out.println(ioEX);
        }

    }


    //loading person record from text file
    void loadPersons() {
        String tokens[] = null;
        String name, add, ph;
        String value;
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
                int regNo = Integer.parseInt(value);
                PersonInfo p = new PersonInfo(regNo, name, add, ph);
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