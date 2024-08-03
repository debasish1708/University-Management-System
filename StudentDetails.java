import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.*;

public class StudentDetails extends JFrame implements ActionListener {

    JTable table;
    JButton search, print, add, delete, cancel;
    JTextField searchText;

    StudentDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        searchText = new JTextField();
        searchText.setBounds(180, 20, 150, 20);
        add(searchText);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 100, 860, 400);
        add(scrollPane);

        search = new JButton("Search");
        search.setBounds(350, 20, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(450, 20, 80, 20);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(550, 20, 80, 20);
        add.addActionListener(this);
        add(add);

        delete = new JButton("Delete");
        delete.setBounds(650, 20, 80, 20);
        delete.addActionListener(this);
        add(delete);

        cancel = new JButton("Cancel");
        cancel.setBounds(750, 20, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        try {
            Conn c=new Conn();
            Resultset rs=(Resultset) c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(900, 600);
        setLocation(200, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String rollNumber = searchText.getText();
            String query = "SELECT * FROM student WHERE rollno = '" + rollNumber + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == add) {
            setVisible(false);
            new AddStudent();
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        } else if (ae.getSource() == delete) {
            setVisible(false);
             new DeleteStudent();
        }
    }

    public static void main(String[] args) {
        new StudentDetails();
    }
}