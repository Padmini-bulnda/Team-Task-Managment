import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel {
   public static void admin()
   {
       JFrame f=new JFrame("Admin Panel");
       JButton b1=new JButton("Creating Teams");
       b1.setBounds(50,100,195,50);
       f.add(b1);

       JButton b2=new JButton("Assigning Task");
       b2.setBounds(50,200,195,50);
       f.add(b2);

       JButton b3=new JButton("View All Assigning Task");
       b3.setBounds(250,100,195,50);
       f.add(b3);

       JButton b4=new JButton("Give Points ");
       b4.setBounds(250,200,195,50);
       f.add(b4);


       b1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               System.out.println("clicked");
               ALL_task.CreateTeam();
           }
       });

       b2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               System.out.println("clicked");
               ALL_task.Tasks();
           }
       });

       b3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               System.out.println("clicked");
             ALL_task.view1();
           }
       });

       b4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               System.out.println("clicked");
               ALL_task.Points();
           }
       });

       f.setSize(400,400);
       f.setLayout(null);
       f.setVisible(true);
   }

}
