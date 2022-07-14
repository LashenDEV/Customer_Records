import javax.swing.*;

class PersonInfo {
    String name;
    String address;
    String phoneNumber;

    PersonInfo(String n, String a, String p) {
        name = n;
        address = a;
        phoneNumber = p;
    }

    void display() {
        JOptionPane.showMessageDialog(null, "Name: " + name + "\nAddress: " + address + "\nPhone no: " + phoneNumber);
    }
}