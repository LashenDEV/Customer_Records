import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

class AddressBook {
    ArrayList persons;

    AddressBook() {
        persons = new ArrayList();
        loadPersons();
    }

    void viewEntries() {
        String output = "";
        for (int i = 0; i < persons.size(); i++) {
            PersonInfo p = (PersonInfo) persons.get(i);
            output += "Name: " + p.name + "  Address: " + p.address + "  Phone no: " + p.phoneNumber + "\n";
        }
        JOptionPane.showMessageDialog(null, output);
    }

    //adding a person
    void addPerson() {
        String name = JOptionPane.showInputDialog("Enter name:");
        String add = JOptionPane.showInputDialog("Enter address:");
        String pNum = JOptionPane.showInputDialog("Enter phone number:");
        //Creating Person info object
        PersonInfo p = new PersonInfo(name, add, pNum);
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
                line = p.name + "," + p.address + "," + p.phoneNumber;
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

    //loading person record from text file
    void loadPersons() {
        String tokens[] = null;
        String name, add, ph;
        try {
            FileReader fr = new FileReader("persons.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                tokens = line.split(",");
                name = tokens[0];
                add = tokens[1];
                ph = tokens[2];
                PersonInfo p = new PersonInfo(name, add, ph);
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