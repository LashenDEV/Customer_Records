import javax.swing.*;

class PersonInfo {
    int regNo;
    String name;
    String address;
    String phoneNumber;
    int quantitie;
    int totalAmount;

    PersonInfo(int r, String n, String a, String p, int q, int tamount) {
        regNo = r;
        name = n;
        address = a;
        phoneNumber = p;
        quantitie = q;
        totalAmount = tamount;
    }

    void display() {
        JOptionPane.showMessageDialog(null, "Reg No: " + regNo + "\nName: " + name + "\nAddress: " + address +
         "\nPhone no: " + phoneNumber + "\nQuantitie: " + quantitie + "\nTotal Amount: " + totalAmount);
    }
}