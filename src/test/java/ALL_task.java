import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

//import Connectivity;
public class ALL_task {
    public static String url = "jdbc:mysql://localhost:3306/managment";
    public static String user = "root";
    public static String pass = "Padmini@23";

    public static void user_Login(String ID, String password) {
        try {

            Connection cn = DriverManager.getConnection(url, user, pass);
            PreparedStatement st = cn.prepareStatement("Select id, password from team where id=? and password=?");

            st.setString(1, ID);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                Login.contentPane.setTitle("Welcome");
                Login.contentPane.setVisible(true);
                JOptionPane.showMessageDialog(Login.btnNewButton, "You have successfully logged in");
                ALL_task.view_user(ID);


            } else {
                JOptionPane.showMessageDialog(Login.btnNewButton, "Wrong Username & Password");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public static void admin_login(int Id, String password) {
        try {

            Connection cn = DriverManager.getConnection(url, user, pass);
            PreparedStatement st = cn.prepareStatement("Select userid, password from admin where userid=? and password=?");

            st.setInt(1, Id);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                Login.contentPane.setTitle("Welcome");
                Login.contentPane.setVisible(true);
                JOptionPane.showMessageDialog(Login.btnNewButton, "You have successfully logged in");
                AdminPanel.admin();
            } else {
                JOptionPane.showMessageDialog(Login.btnNewButton, "Wrong Username & Password");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    //    Functio for creating Teams
    public static void CreateTeam() {
        JFrame Team = new JFrame();

        JLabel lblNewLabel = new JLabel("Create NEW Team");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(423, 13, 273, 93);
        Team.add(lblNewLabel);

        final JTextField textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(481, 170, 273, 58);
        Team.add(textField);
        textField.setColumns(10);
        final JTextField Teamld = new JTextField();
        Teamld.setFont(new Font("Tahoma", Font.PLAIN, 32));
        Teamld.setBounds(481, 256, 273, 58);
        Team.add(Teamld);
        final JTextField passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(481, 346, 273, 58);
        Team.add(passwordField);


        JLabel lblTeam = new JLabel("Tead Id");
        lblTeam.setBackground(Color.BLACK);
        lblTeam.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblTeam.setBounds(250, 166, 193, 52);
        Team.add(lblTeam);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUsername.setBounds(250, 256, 193, 52);
        Team.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(250, 346, 193, 52);
        Team.add(lblPassword);
        final JButton btnNewButton = new JButton("Create Team");
        btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                String Teamid = Teamld.getText();
                String password = passwordField.getText();
                String task = "";


                String msg = "" + username;
                msg += " \n";


                try {
                    String Url = "jdbc:mysql://localhost:3306/managment";
                    String User = "root";
                    String pass = "Padmini@23";
                    Connection connection = DriverManager.getConnection(Url, User, pass);

                    String query = "INSERT INTO team values('" + username + "','" + Teamid + "','" +
                            password + "',' " + task + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                                "Welcome, " + msg + "Your account is sucessfully created");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }


            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 447, 259, 74);
        Team.add(btnNewButton);
        Team.setSize(1000, 1000);
        Team.setLayout(null);
        Team.setVisible(true);

    }

    //Assigning Tasks
    public static void Tasks() {
        JFrame Team = new JFrame();

        JLabel lblNewLabel = new JLabel("Assigning Tasks");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(423, 13, 300, 93);
        Team.add(lblNewLabel);

        final JTextField textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(481, 256, 273, 93);
        Team.add(textField);
        textField.setColumns(30);
        final JTextField Teamld = new JTextField();
        Teamld.setFont(new Font("Tahoma", Font.PLAIN, 32));
        Teamld.setBounds(481, 170, 273, 58);
        Team.add(Teamld);


        JLabel lblTeam = new JLabel("Tead Id");
        lblTeam.setBackground(Color.BLACK);
        lblTeam.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblTeam.setBounds(250, 166, 193, 52);
        Team.add(lblTeam);

        JLabel Desc = new JLabel("Task");
        Desc.setBackground(Color.BLACK);
        Desc.setFont(new Font("Tahoma", Font.PLAIN, 31));
        Desc.setBounds(250, 256, 193, 52);
        Team.add(Desc);
        final JButton btnNewButton = new JButton("submit");
        btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String Desc = textField.getText();
                String Teamid = Teamld.getText();
                try {
                    String Url = "jdbc:mysql://localhost:3306/managment";
                    String User = "root";
                    String pass = "Padmini@23";
                    Connection connection = DriverManager.getConnection(Url, User, pass);
                    String msg = "" + Teamid;
                    msg += " \n";

                    String query = "update team set task = " + "'" + Desc + "'" + "where id= " + "'" + Teamid
                            + "'";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                                "Welcome, " + msg + "Succasfully Assigning");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }


        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 447, 259, 74);
        Team.add(btnNewButton);
        Team.setSize(1000, 1000);
        Team.setLayout(null);
        Team.setVisible(true);

    }

    public static void view() {
        String[] columnNames = {"UID", "USER NAME", "TASK"};
        JTable table;
        String from;
        JComboBox c1;
        JFrame frame1 = new JFrame("Database Search Result");

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame1.setLayout(new BorderLayout());

//TableModel tm = new TableModel();

        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columnNames);

//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());

        table = new JTable(model);

        table = new JTable();

        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.setFillsViewportHeight(true);
        table.setRowSelectionAllowed(true);
        table.addRowSelectionInterval(1, 1);
        table.addRowSelectionInterval(3, 3);


        JScrollPane scroll = new JScrollPane(table);

        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        c1 = new JComboBox(v);
//
//        c1.setBounds(150, 110, 150, 20);


        String id = "";

        String username = "";

        String task = "";


        try {
            String Url = "jdbc:mysql://localhost:3306/managment";
            String User = "root";
            String pass1 = "Padmini@23";
            Connection connection = DriverManager.getConnection(Url, User, pass1);
            PreparedStatement pst = connection.prepareStatement("select id ,username,task from team  ");

            ResultSet rs = pst.executeQuery();

            int i = 0;

            if (rs.next()) {
                System.out.println("id" + rs.getString("id"));
                id = rs.getString("id");

                username = rs.getString("username");

                task = rs.getString("task");


                model.addRow(new Object[]{id, username, task});

                i++;

            }

            if (i < 1) {

                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

            }

            if (i == 1) {

                System.out.println(i + " Record Found");

            } else {

                System.out.println(i + " Records Found");

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

        frame1.add(scroll);

        frame1.setVisible(true);

        frame1.setSize(400, 300);

    }

    public static void view_user(String Id) {
        String[] columnNames = {"UID", "USER NAME", "TASK"};
        JTable table;
        String from;
        JComboBox c1;
        JFrame frame1 = new JFrame("VIEW TASK TEAM NUMBER=" + Id);

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame1.setLayout(new BorderLayout());


        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columnNames);


        table = new JTable(model);

        table = new JTable();

        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table);

        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


        try {
            String Url = "jdbc:mysql://localhost:3306/managment";
            String User = "root";
            String pass1 = "Padmini@23";
            Connection connection = DriverManager.getConnection(Url, User, pass1);
            PreparedStatement pst = connection.prepareStatement("select id,username,task from team  where id = " + Id);
            ResultSet rs = pst.executeQuery();
            String id = "";

            String username = "";

            String task = "";
            int i = 0;

            if (rs.next()) {
//            System.out.println("id" + rs.getString("id"));
//            System.out.println(rs.getString("username"));
                id = rs.getString("id");

                username = rs.getString("username");

                task = rs.getString("task");


                model.addRow(new Object[]{id, username, task});

                i++;

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
        final JButton btnNewButton = new JButton("Submit TASK");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked 1");
                ALL_task.Submit(Id);
            }
        });
        btnNewButton.setBounds(50, 200, 195, 50);
        frame1.add(btnNewButton);
        frame1.add(scroll);

        frame1.setVisible(true);

        frame1.setSize(400, 300);
    }

    public static void view1() {
        final Vector columnNames = new Vector();
        final Vector data = new Vector();


        JFrame f = new JFrame();

        f.pack();
        f.setVisible(true);


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/managment", "root", "Padmini@23");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select id ,username,task from team ");
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(md.getColumnName(i));
            }
            while (rs.next()) {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++) {
                    row.addElement(rs.getObject(i));
                }
                data.addElement(row);
            }
            JFrame frame = new JFrame();
            JTable table = new JTable(data, columnNames);

            JScrollPane pane = new JScrollPane(table);

            frame.add(pane);
            frame.setVisible(true);
            frame.pack();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void Submit(String Id) {
        JFrame contentPane = new JFrame();

        JLabel lblNewLabel = new JLabel("SUBMIT TASK");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(423, 13, 373, 93);
        contentPane.add(lblNewLabel);
        JLabel choice = new JLabel("Login as", JLabel.CENTER);
        choice.setForeground(Color.BLACK);
        choice.setBackground(Color.CYAN);
        choice.setFont(new Font("Tahoma", Font.PLAIN, 31));
        choice.setBounds(200, 400, 193, 52);
        contentPane.add(choice);
        JRadioButton btn1 = new JRadioButton("Complete");
        btn1.setActionCommand("Complete");
        JRadioButton btn2 = new JRadioButton("Uncomplete");
        btn2.setActionCommand("Uncomplete");


        // Set the position of the radio buttons
        btn1.setBounds(500, 400, 200, 50);
        btn2.setBounds(500, 500, 200, 50);
        ButtonGroup bg = new ButtonGroup();
        bg.add(btn1);
        bg.add(btn2);


        // Add buttons to frame
        contentPane.add(btn1);
        contentPane.add(btn2);

        JLabel Desc = new JLabel("STEPS to SOLVE ");
        Desc.setBackground(Color.BLACK);
        Desc.setFont(new Font("Tahoma", Font.PLAIN, 31));
        Desc.setBounds(250, 256, 200, 52);
        contentPane.add(Desc);
        final JTextField textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(481, 256, 273, 110);
        contentPane.add(textField);
        textField.setColumns(30);


        JButton btnNewButton = new JButton("submit Task");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(545, 530, 162, 73);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String step = textField.getText();

                String value = bg.getSelection().getActionCommand();


                System.out.println("The selected radio button is: " +
                        value);
                try {
                    String Url = "jdbc:mysql://localhost:3306/managment";
                    String User = "root";
                    String pass = "Padmini@23";
                    String points=" ";
                    Connection connection = DriverManager.getConnection(Url, User, pass);

                    String query = "INSERT INTO status values('" + Id + "','" + step + "','" +
                            value + "',' " + points + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);

                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });
        contentPane.add(btnNewButton);
        contentPane.setSize(500, 500);
        contentPane.setLayout(null);
        contentPane.setVisible(true);
    }

    public static void Points() {

        final Vector columnNames = new Vector();
        final Vector data = new Vector();


        JFrame frame = new JFrame();
        ;


        JButton btnNewButton = new JButton("Give Marks");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(545, 450, 200, 53);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("give");
                ALL_task.give();
            }

        });


        frame.pack();
        frame.setVisible(true);


        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/managment", "root", "Padmini@23");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select id ,status,Des from status ");
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(md.getColumnName(i));
            }
            while (rs.next()) {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++) {
                    row.addElement(rs.getObject(i));
                }
                data.addElement(row);
            }

            JTable table = new JTable(data, columnNames);

            JScrollPane pane = new JScrollPane(table);
            frame.add(btnNewButton);
            frame.add(pane);

            frame.setVisible(true);
            frame.pack();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }


public static void give()
{

    JFrame f = new JFrame();

    JLabel lblName = new JLabel("TeamID");
    lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblName.setBounds(58, 152, 99, 43);
    f.add(lblName);
    final JTextField firstname = new JTextField();
    firstname.setFont(new Font("Tahoma", Font.PLAIN, 25));
    firstname.setBounds(214, 151, 228, 50);
    f.add(firstname);
    firstname.setColumns(10);
    JLabel lblNewLabel = new JLabel("Marks");
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblNewLabel.setBounds(58, 243, 110, 29);
    f.add(lblNewLabel);
    final JTextField lastname = new JTextField();
    lastname.setFont(new Font("Tahoma", Font.PLAIN, 25));
    lastname.setBounds(214, 235, 228, 50);
    f.add(lastname);
    lastname.setColumns(10);

    final JButton btnNewButton = new JButton("submit");
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
    btnNewButton.setBounds(950, 350, 200, 74);
    f.add(btnNewButton);
    btnNewButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = firstname.getText();
            String point = lastname.getText();
            try {
                String Url = "jdbc:mysql://localhost:3306/managment";
                String User = "root";
                String pass = "Padmini@23";
                Connection connection = DriverManager.getConnection(Url, User, pass);
                String msg = "" + id;
                msg += " \n";

                String query = "update status set points = " + "'" + point + "'" + "where id= " + "'" + id
                        + "'";

                Statement sta = connection.createStatement();
                int x = sta.executeUpdate(query);
                if (x == 0) {
                    JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                } else {
                    JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Submit TASK SUccessFully");
                }
                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
        });

    f.setSize(400, 500);
    f.setLayout(null);
    f.setVisible(true);
}
}
