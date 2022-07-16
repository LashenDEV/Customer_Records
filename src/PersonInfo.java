import javax.swing.*;

class PersonInfo {
    int regNo;
    String name;
    String address;
    String phoneNumber;

    PersonInfo(int r, String n, String a, String p) {
        regNo = r;
        name = n;
        address = a;
        phoneNumber = p;
    }

    void display() {
        JOptionPane.showMessageDialog(null, "Reg No: " + regNo + "\nName: " + name + "\nAddress: " + address + "\nPhone no: " + phoneNumber);
    }
}