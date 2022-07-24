import javax.swing.*;

class CustomerInfo {
    int regNo;
    String name;
    String address;
    String phoneNumber;
    int quantity;
    int totalAmount;

    CustomerInfo(int r, String n, String a, String p, int q, int tamount) {
        regNo = r;
        name = n;
        address = a;
        phoneNumber = p;
        quantity = q;
        totalAmount = tamount;
    }

    void display() {
        JOptionPane.showMessageDialog(null, "Reg No: " + regNo + "\nName: " + name + "\nAddress: " + address +
         "\nPhone no: " + phoneNumber + "\nQuantity: " + quantity + "\nTotal Amount: " + totalAmount);
    }
}