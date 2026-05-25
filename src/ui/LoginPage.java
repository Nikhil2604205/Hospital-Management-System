package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {

    JLabel userLabel, passLabel;
    JTextField userField;
    JPasswordField passField;
    JButton loginBtn;

    public LoginPage() {

        setTitle("Hospital Login");
        setSize(400,300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userLabel = new JLabel("Username");
        userLabel.setBounds(50,50,100,30);
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(150,50,150,30);
        add(userField);

        passLabel = new JLabel("Password");
        passLabel.setBounds(50,100,100,30);
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(150,100,150,30);
        add(passField);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(130,170,100,40);
        add(loginBtn);

        loginBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String username = userField.getText();
        String password = passField.getText();

        if(username.equals("admin") && password.equals("1234")) {
            JOptionPane.showMessageDialog(this,"Login Successful");

            new Dashboard();
            dispose();

        } else {
            JOptionPane.showMessageDialog(this,"Invalid Credentials");
        }
    }
}