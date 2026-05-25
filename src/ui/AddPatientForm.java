package ui;

import database.DBConnection;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddPatientForm extends JFrame implements ActionListener {

    JLabel nameLabel, ageLabel, genderLabel, diseaseLabel;

    JTextField nameField, ageField, genderField, diseaseField;

    JButton saveBtn;

    AddPatientForm() {

        setTitle("Add Patient");
        setSize(500,500);
        setLayout(null);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(50,50,100,30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(180,50,200,30);
        add(nameField);

        ageLabel = new JLabel("Age");
        ageLabel.setBounds(50,100,100,30);
        add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(180,100,200,30);
        add(ageField);

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(50,150,100,30);
        add(genderLabel);

        genderField = new JTextField();
        genderField.setBounds(180,150,200,30);
        add(genderField);

        diseaseLabel = new JLabel("Disease");
        diseaseLabel.setBounds(50,200,100,30);
        add(diseaseLabel);
        diseaseField = new JTextField();
        diseaseField.setBounds(180,200,200,30);
        add(diseaseField);

        saveBtn = new JButton("Save");
        saveBtn.setBounds(180,300,120,40);
        add(saveBtn);

        saveBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO patients(name,age,gender,disease) VALUES(?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nameField.getText());
            pst.setInt(2, Integer.parseInt(ageField.getText()));
            pst.setString(3, genderField.getText());
            pst.setString(4, diseaseField.getText());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this,"Patient Added Successfully");

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}