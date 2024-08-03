import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class AddFaculty extends JFrame implements ActionListener{

    JTextField tfname;

    JComboBox cbbranch,cbcat;

    JDateChooser dcdoj;

    JLabel labelfacultyID;

    JButton submit,cancel;

    Random ran = new Random();
    long first5 = Math.abs((ran.nextLong() % 90000L) + 10000L);
    AddFaculty(){
        setSize(900,600);
        setLocation(200,50);
        setLayout(null);

        JLabel heading=new JLabel("New Faculty Details");
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

        JLabel lblbranchname=new JLabel("Qualification");
        lblbranchname.setBounds(400,104,150,25);
        lblbranchname.setFont(new Font("serif", Font.BOLD, 22));
        add(lblbranchname);

        String branch[]={"B.Tech","MBA","BCA","Bsc","Msc","McA","Bcom","BA","MA","M.Tech","Phd"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(550,104,190,25);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        JLabel lblfacultyno=new JLabel("Faculty ID");
        lblfacultyno.setBounds(50,145,170,28);
        lblfacultyno.setFont(new Font("serif", Font.BOLD, 22));
        add(lblfacultyno);

        labelfacultyID=new JLabel("BPUT"+first5);
        labelfacultyID.setBounds(180,150,170,18);
        labelfacultyID.setFont(new Font("serif", Font.BOLD, 22));
        add(labelfacultyID);

        JLabel lbljd=new JLabel("Joining Date");
        lbljd.setBounds(400,150,170,30);
        lbljd.setFont(new Font("serif", Font.BOLD, 22));
        add(lbljd);

        dcdoj = new JDateChooser();
        dcdoj.setBounds(570,160,170,18);
        add(dcdoj);


        JLabel lblspecial=new JLabel("Specialized");
        lblspecial.setBounds(50,200,170,30);
        lblspecial.setFont(new Font("serif", Font.BOLD, 22));
        add(lblspecial);

        String catagory[]={
                "Computer Science Engineering",
                "Civil Engineering",
                "Mechanical Engineering",
                "Electrical Engineering",
                "Electronics and Communication Engineering",
                "Information Technology",
                "Chemical Engineering",
                "Aerospace Engineering",
                "Biomedical Engineering",
                "Environmental Engineering",
                "Industrial Engineering",
                "Materials Science and Engineering",
                "Nuclear Engineering",
                "Petroleum Engineering",
                "Software Engineering",
                "Agricultural Engineering",
                "Architecture",
                "Urban Planning",
                "Business Administration",
                "Economics",
                "Psychology",
                "Sociology",
                "Political Science",
                "History",
                "Philosophy",
                "Literature",
                "Linguistics",
                "Anthropology",
                "Education",
                "Law",
                "Fine Arts",
                "Music",
                "Theater",
                "Journalism",
                "Media Studies"};
        cbcat = new JComboBox(catagory);
        cbcat.setBounds(200,205,170,20);
        cbcat.setBackground(Color.WHITE);
        add(cbcat);

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
            String qualf=(String)cbbranch.getSelectedItem();
            String facid=labelfacultyID.getText();
            String jd=((JTextField)dcdoj.getDateEditor().getUiComponent()).getText();
            String special=(String)cbcat.getSelectedItem();

            try{
                String query1="insert into faculty values('"+name+"',  '"+qualf+"', '"+facid+"', '"+jd+"', '"+special+"')";

                Conn con=new Conn();
                con.s.executeUpdate(query1);

                JOptionPane.showMessageDialog(null, "Faculty Information Inserted Successfully");
                setVisible(false);
            } catch (Exception e){
                e.printStackTrace();
            }
       } else{
           setVisible(false);
       }
    }
    public static void main(String[] args) {
        new AddFaculty();
    }
}