import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;;

public class AddStudent extends JFrame implements ActionListener{

    JTextField tfname,tfathername;
    JLabel labelrollno;
    JDateChooser dcdob;
    @SuppressWarnings("rawtypes")
    JComboBox cbcourse;

    Random ran=new Random();
    long first4=Math.abs((ran.nextLong()%9000L)+1000L);

    JButton submit,cancel;

    @SuppressWarnings({ "rawtypes", "unchecked" })


    AddStudent(){
        setSize(900,600);
        setLocation(200,50);
        setLayout(null);

        JLabel heading=new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel lblname=new JLabel("Name");
        lblname.setBounds(50,100,100,20);
        lblname.setFont(new Font("serif", Font.BOLD, 22));
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(180,104,150,20);
        add(tfname);

        JLabel lblfname=new JLabel("Father Name");
        lblfname.setBounds(400,104,150,20);
        lblfname.setFont(new Font("serif", Font.BOLD, 22));
        add(lblfname);

        tfathername=new JTextField();
        tfathername.setBounds(600,104,150,20);
        add(tfathername);

        JLabel lblrollno=new JLabel("Roll Number");
        lblrollno.setBounds(50,150,170,18);
        lblrollno.setFont(new Font("serif", Font.BOLD, 22));
        add(lblrollno);

        labelrollno=new JLabel("210111"+first4);
        labelrollno.setBounds(200,150,170,18);
        labelrollno.setFont(new Font("serif", Font.BOLD, 22));
        add(labelrollno);

        JLabel lbldb=new JLabel("Date of Birth");
        lbldb.setBounds(400,150,170,18);
        lbldb.setFont(new Font("serif", Font.BOLD, 22));
        add(lbldb);

        dcdob = new JDateChooser();
        dcdob.setBounds(600,150,170,18);
        add(dcdob);

        JLabel lblcourse=new JLabel("Course");
        lblcourse.setBounds(50,200,170,18);
        lblcourse.setFont(new Font("serif", Font.BOLD, 22));
        add(lblcourse);

        String course[]={"B.Tech","MBA","BCA","Bsc","Msc","McA","Bcom","BA","MA","M.Tech","Phd"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,205,170,18);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        submit=new JButton("submit");
        submit.setBounds(250,350,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif", Font.BOLD, 15));
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(400,350,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String name=tfname.getText();
            String Father_Name=tfathername.getText();
            String rollno=labelrollno.getText();
            String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String course=(String)cbcourse.getSelectedItem();

            try {
                String query="insert into student values('"+name+"',  '"+Father_Name+"', '"+rollno+"', '"+dob+"', '"+course+"')";

                Conn con=new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Information Inserted Successfully");
                setVisible(false);

//                new StudentDetails();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddStudent();
    }
}
