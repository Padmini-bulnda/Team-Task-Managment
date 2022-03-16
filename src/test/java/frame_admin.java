
    import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

    public class frame_admin {

        public static Connection c;
        public static Statement s;
        public static PreparedStatement p;
        public static ResultSet r;
        public static Scanner sc;
        public static JFrame jr, jc, jd ,jk,je,jq,jp;
        public static String url = "jdbc:mysql://localhost:3306", user = "root", pass = "Padmini@23";

        public static void emp() {
            JFrame jd = new JFrame();
            jd.setSize(400, 400);
            jd.setLayout(null);

            JLabel l1 = new JLabel("New Team Member");
            JLabel l2 = new JLabel("Username");
            JLabel l3 = new JLabel("Password");
            JLabel l4 = new JLabel("Task Name");
            JLabel l5 = new JLabel("Status");

            final JTextField t1 = new JTextField();
            final JTextField t2 = new JTextField();
            final JTextField t3 = new JTextField();
            final JTextField t4 = new JTextField();

            JButton btn = new JButton("Enter");

            l1.setBounds(120, 20, 250, 30);
            l1.setFont(new Font("Serif", Font.BOLD, 20));
            l2.setBounds(110, 80, 150, 20);
            l3.setBounds(110, 130, 150, 20);
            l4.setBounds(110, 180, 150, 20);
            l5.setBounds(120, 230, 150, 20);

            t1.setBounds(190, 80, 100, 25);
            t2.setBounds(190, 130, 100, 25);
            t3.setBounds(190, 180, 100, 25);
            t4.setBounds(190, 230, 100, 25);

            btn.setBounds(150, 290, 100, 35);
            btn.setBackground(Color.BLUE);
            btn.setForeground(Color.WHITE);

            jd.add(l1);
            jd.add(l2);
            jd.add(l3);
            jd.add(l4);
            jd.add(l5);

            jd.add(t1);
            jd.add(t2);
            jd.add(t3);
            jd.add(t4);

            jd.add(btn);

            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String u = t1.getText(), pa = t2.getText(), t = t3.getText(), sz = t4.getText();
                        String in_emp = "insert into emp(username,password,task_desc,status) values(?,?,?,?)";
                        p = c.prepareStatement(in_emp);
                        p.setString(1, u);
                        p.setString(2, pa);
                        p.setString(3, t);
                        p.setString(4, sz);

                        int o = p.executeUpdate();
                        System.out.println(o + " row(s) inserted .");

                        r = s.executeQuery("select * from emp");
                        while (r.next()) {
                            System.out.println(r.getInt("id") + " " + r.getString("username") + " "
                                    + r.getString("task_desc") + " " + r.getString("status"));
                        }
                    } catch (Throwable w) {
                        w.printStackTrace();
                    }
                }
            });
            jd.setVisible(true);
        }

        public static void login_emp() {
            final JFrame jm = new JFrame();

            jm.setSize(400, 290);
            jm.setLayout(null);

            JLabel l1 = new JLabel("Team Portal");
            JLabel l2 = new JLabel("Username");
            JLabel l3 = new JLabel("Password");

            final JTextField t1 = new JTextField();
            final JTextField t2 = new JTextField();

            JButton btn = new JButton("Login");

            l1.setBounds(140, 20, 250, 30);
            l1.setFont(new Font("Serif", Font.BOLD, 20));
            l2.setBounds(110, 80, 150, 20);
            l3.setBounds(110, 130, 150, 20);

            t1.setBounds(190, 80, 100, 25);
            t2.setBounds(190, 130, 100, 25);

            btn.setBounds(150, 180, 100, 35);
            btn.setBackground(Color.BLUE);
            btn.setForeground(Color.WHITE);

            jm.add(l1);
            jm.add(l2);
            jm.add(l3);
            jm.add(t1);
            jm.add(t2);

            jm.add(btn);

            jm.setVisible(true);
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {



                    String nameuser = t1.getText();
                        String passWord = t2.getText();
                        ALL_task.user_Login(nameuser,passWord);

//

                }
            });
        }

        public static void emp_up() {
            final JFrame jk = new JFrame();

            jk.setSize(400, 290);
            jk.setLayout(null);

            JLabel l1 = new JLabel("Update Status");
            JLabel l2 = new JLabel("Username");
            JLabel l3 = new JLabel("Status");

            final JTextField t1 = new JTextField();
            final JTextField t2 = new JTextField();

            JButton btn = new JButton("Add");

            l1.setBounds(140, 20, 250, 30);
            l1.setFont(new Font("Serif", Font.BOLD, 20));
            l2.setBounds(110, 80, 150, 20);
            l3.setBounds(110, 130, 150, 20);

            t1.setBounds(190, 80, 100, 25);
            t2.setBounds(190, 130, 100, 25);

            btn.setBounds(150, 180, 100, 35);
            btn.setBackground(Color.BLUE);
            btn.setForeground(Color.WHITE);

            jk.add(l1);
            jk.add(l2);
            jk.add(l3);
            jk.add(t1);
            jk.add(t2);

            jk.add(btn);

            jk.setVisible(true);
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String url = "jdbc:mysql://localhost:1024", user = "root", pass = "102456";
                    try {
                        System.out.println("Team Found \n Enter the status of task");
                        String nam = t1.getText(), stats = t2.getText();
                        String stat = "update emp set status = " + "'" + stats + "'" + "where username = " + "'" + nam
                                + "'";
                        s.execute(stat);

                        r = s.executeQuery("select * from emp");
                        while (r.next()) {
                            System.out.println(r.getInt("id") + " " + r.getString("username") + " "
                                    + r.getString("task_desc") + " " + r.getString("status"));
                        }
                    } catch (Throwable t) {
                        System.out.println("Connection Terminated");
                        t.printStackTrace();
                    }
                }
            });
        }

        public static void task() {
            JFrame je = new JFrame();
            je.setSize(400, 350);
            je.setLayout(null);

            JLabel l1 = new JLabel("Task Assignning");
            JLabel l2 = new JLabel("Id");
            JLabel l3 = new JLabel("Description");
            JLabel l4 = new JLabel("Status");

            final JTextField t1 = new JTextField();
            final JTextField t2 = new JTextField();
            final JTextField t3 = new JTextField();

            JButton btn = new JButton("Enter");

            l1.setBounds(120, 20, 250, 30);
            l1.setFont(new Font("Serif", Font.BOLD, 20));
            l2.setBounds(110, 80, 150, 20);
            l3.setBounds(110, 130, 150, 20);
            l4.setBounds(110, 180, 150, 20);

            t1.setBounds(190, 80, 100, 25);
            t2.setBounds(190, 130, 100, 25);
            t3.setBounds(190, 180, 100, 25);

            btn.setBounds(150, 240, 100, 35);
            btn.setBackground(Color.BLUE);
            btn.setForeground(Color.WHITE);

            je.add(l1);
            je.add(l2);
            je.add(l3);
            je.add(l4);
            je.add(t1);
            je.add(t2);
            je.add(t3);

            je.add(btn);

            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String id = t1.getText();
                        int ids = Integer.parseInt(id);
                        String task = t2.getText(), stst = t3.getText();
                        String in_task = "insert into task values(?,?,?)";
                        p = c.prepareStatement(in_task);
                        p.setInt(1, ids);
                        p.setString(2, task);
                        p.setString(3, stst);

                        int o = p.executeUpdate();
                        System.out.println(o + " row(s) inserted .");

                        r = s.executeQuery("select * from task");
                        while (r.next()) {
                            System.out
                                    .println(r.getInt("id") + " " + r.getString("task_desc") + " " + r.getString("status"));
                        }
                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
            });
            je.setVisible(true);
        }

        public static void update_emp() {
            final JFrame jq = new JFrame();

            jq.setSize(400, 340);
            jq.setLayout(null);

            JLabel l1 = new JLabel("Update Status and point");
            JLabel l2 = new JLabel("Username");
            JLabel l3 = new JLabel("Status");
            JLabel l4 = new JLabel("Point");

            final JTextField t1 = new JTextField();
            final JTextField t2 = new JTextField();
            final JTextField t3 = new JTextField();

            JButton btn = new JButton("Update");

            l1.setBounds(90, 20, 250, 30);
            l1.setFont(new Font("Serif", Font.BOLD, 20));
            l2.setBounds(110, 80, 150, 20);
            l3.setBounds(110, 130, 150, 20);
            l4.setBounds(110, 180, 150, 20);

            t1.setBounds(190, 80, 100, 25);
            t2.setBounds(190, 130, 100, 25);
            t3.setBounds(190, 180, 100, 25);

            btn.setBounds(150, 240, 100, 35);
            btn.setBackground(Color.BLUE);
            btn.setForeground(Color.WHITE);

            jq.add(l1);
            jq.add(l2);
            jq.add(l3);
            jq.add(l4);
            jq.add(t1);
            jq.add(t2);
            jq.add(t3);

            jq.add(btn);

            jq.setVisible(true);
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String nam = t1.getText(), stats = t2.getText() , pnt = t3.getText();
                        String stat = "update emp set status = " + "'"+stats+"'"+" , point = "+"'"+pnt+"'"+"where username = " + "'" + nam
                                + "'";
                        s.execute(stat);

                        r = s.executeQuery("select * from emp");
                        while (r.next()) {
                            System.out.println(r.getInt("id") + " " + r.getString("username") + " "
                                    + r.getString("task_desc") + " " + r.getString("status")+" "+r.getString("point"));
                        }
                    } catch (Throwable t) {
                        System.out.println("Connection Terminated");
                        t.printStackTrace();
                    }
                }
            });
        }

        public static void admin_2() {
            final JFrame jp = new JFrame();

            jp.setSize(400, 290);
            jp.setLayout(null);

            JLabel l1 = new JLabel("Admin Panel");
            JLabel l2 = new JLabel("Enter the value to");
            JLabel l3 = new JLabel("pass to Team members or tasks editing");

            final JTextField t1 = new JTextField();

            JButton btn = new JButton("Enter");

            l1.setBounds(140, 20, 250, 30);
            l1.setFont(new Font("Serif", Font.BOLD, 20));
            l2.setBounds(145, 70, 150, 20);
            l3.setBounds(92, 90, 300, 20);

            t1.setBounds(140, 130, 100, 25);

            btn.setBounds(140, 180, 100, 35);
            btn.setBackground(Color.BLUE);
            btn.setForeground(Color.WHITE);

            jp.add(l1);
            jp.add(l2);
            jp.add(l3);
            jp.add(t1);

            jp.add(btn);

            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String val = t1.getText();
                        int x = Integer.parseInt(val);
                        if(x == 1) {
                            task();
                            jp.setVisible(false);
                        }
                        else if(x == 2) {
                            emp();
                            jp.setVisible(false);
                        }
                        else if(x==3) {
                            update_emp();
                            jp.setVisible(false);
                        }
                    } catch (Throwable t) {
                        System.out.println("Connection Terminated");
                        t.printStackTrace();
                    }
                }
            });
            jp.setVisible(true);
        }

        public static void ad_frm() {
            final JFrame jr = new JFrame();

            jr.setSize(400, 290);
            jr.setLayout(null);

            JLabel l1 = new JLabel("Task Managment System");
            JLabel l2 = new JLabel("Username");
            JLabel l3 = new JLabel("Password");

            final JTextField t1 = new JTextField();
            final JTextField t2 = new JTextField();

            JButton btn = new JButton("Login");

            l1.setBounds(85, 20, 250, 30);
            l1.setFont(new Font("Serif", Font.BOLD, 20));
            l2.setBounds(110, 80, 150, 20);
            l3.setBounds(110, 130, 150, 20);

            t1.setBounds(190, 80, 100, 25);
            t2.setBounds(190, 130, 100, 25);

            btn.setBounds(150, 180, 100, 35);
            btn.setBackground(Color.BLUE);
            btn.setForeground(Color.WHITE);

            jr.add(l1);
            jr.add(l2);
            jr.add(l3);
            jr.add(t1);
            jr.add(t2);

            jr.add(btn);

            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String url = "jdbc:mysql://localhost:3306/", user = "root", pass = "Padmini@23";
                    try {
                        c = DriverManager.getConnection(url, user, pass);
                        System.out.println("Connection Established");

                        s = c.createStatement();

                        System.out.println("DataBase is being utilized...");
                        s.execute("use managment");

                        String name = t1.getText();
                        String passW = t2.getText();

                        Boolean p = s.execute("select * from admin where firstname = " + "'" + name + "'"
                                + "and password =" + "'" + passW + "'");
                        if (p) {
                            System.out.println("Admin Found");
                            admin_2();
                            jr.setVisible(false);
                        } else {
                            System.out.println("Credentials invalid");
                        }
                    } catch (Throwable t) {
                        System.out.println("Connection Terminated");
                        t.printStackTrace();
                    }
                }
            });
            jr.setVisible(true);
        }

        public static void main(String args[]) {
            ad_frm();
//            login_emp();
        }
    }

