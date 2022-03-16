import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class index {
    public static void main(String[] arguments) throws IOException {



        JPanel panel = new JPanel();

        BufferedImage image = ImageIO.read(new File("src/test/java/task.png"));
        JLabel label = new JLabel(new ImageIcon(image));
//        panel.setBounds(-300,300,90,85);
        panel.add(label);

        // main window
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("JPanel Example");

        JLabel lblNewUserRegister = new JLabel("TASK Managment Software");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(490, 52, 645, 50);
        frame.add(lblNewUserRegister);
        JLabel name = new JLabel("Created by PAdmini");
        name.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        name.setBounds(650, 152, 405, 40);
        frame.add(name);

        JLabel start= new JLabel("Let's Start With");
        start.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        start.setBounds(950, 280, 400, 50);
        frame.add(start);

        final JButton btnNewButton = new JButton("Register");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(950, 350, 200, 74);
        frame.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
Register.register();
            }
        });

        final JButton btnNewButton1 = new JButton("Login");
        btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton1.setBounds(950, 450, 200, 74);
        frame.add(btnNewButton1);
        btnNewButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Login.login();
            }
        });

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the Jpanel to the main window



        frame.pack();
        frame.setVisible(true);

    }
    }

