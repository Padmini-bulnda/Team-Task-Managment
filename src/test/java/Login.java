 import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 import javax.swing.*;


 public class Login {
     public static JFrame contentPane;
     public static JButton btnNewButton;

        public static void login() {

             contentPane=new JFrame();

            JLabel lblNewLabel = new JLabel("Login");
            lblNewLabel.setForeground(Color.BLACK);
            lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
            lblNewLabel.setBounds(423, 13, 273, 93);
            contentPane.add(lblNewLabel);

            final JTextField textField = new JTextField();
            textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
            textField.setBounds(481, 170, 281, 68);
            contentPane.add(textField);
            textField.setColumns(10);

            final JTextField passwordField = new JPasswordField();
            passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
            passwordField.setBounds(481, 286, 281, 68);
            contentPane.add(passwordField);

            JLabel lblUsername = new JLabel("UserID");
            lblUsername.setBackground(Color.BLACK);
            lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
            lblUsername.setBounds(250, 166, 193, 52);
            contentPane.add(lblUsername);

            JLabel lblPassword = new JLabel("Password");
            lblPassword.setForeground(Color.BLACK);
            lblPassword.setBackground(Color.CYAN);
            lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
            lblPassword.setBounds(250, 286, 193, 52);
            contentPane.add(lblPassword);

            // Create the label
           JLabel choice = new JLabel("Login as", JLabel.CENTER);
           choice.setForeground(Color.BLACK);
            choice.setBackground(Color.CYAN);
            choice.setFont(new Font("Tahoma", Font.PLAIN, 31));
            choice .setBounds(200,400,193,52);
            contentPane.add(choice);
            JRadioButton btn1 = new JRadioButton("USER");
            btn1.setActionCommand("User");
            JRadioButton btn2 = new JRadioButton("ADMIN");
            btn2.setActionCommand("Admin");


            // Set the position of the radio buttons
            btn1.setBounds(500,400,200,50);
            btn2.setBounds(500,500,200,50);
            ButtonGroup bg = new ButtonGroup();
            bg.add(btn1);
            bg.add(btn2);


            // Add buttons to frame
            contentPane.add(btn1);
            contentPane.add(btn2);


          btnNewButton = new JButton("Login");
            btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
            btnNewButton.setBounds(545, 530, 162, 73);
            ButtonGroup group = new ButtonGroup();
            btnNewButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    String value=bg.getSelection().getActionCommand();


                        System.out.println("The selected radio button is: " +
                               value);

                    int userName = Integer.parseInt(textField.getText());
                    String password = passwordField.getText();
                    if(value=="User")
                    {
                        ALL_task.user_Login(String.valueOf(userName),password);
                    }
                    else
                    {
                       ALL_task.admin_login(userName,password);
                    }
//
                }
            });

            contentPane.add(btnNewButton);

           JLabel label = new JLabel("");
            label.setBounds(0, 0, 1008, 562);
            contentPane.add(label);
            contentPane.setSize(1000, 1000);
            contentPane.setLayout(null);
            contentPane.setVisible(true);
        }
    }

