package ui;

import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JButton addPatientBtn;

    Dashboard() {

        setTitle("Hospital Dashboard");
        setSize(500,400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addPatientBtn = new JButton("Add Patient");
        addPatientBtn.setBounds(150,100,180,50);
        add(addPatientBtn);

        addPatientBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        new AddPatientForm();
    }
}