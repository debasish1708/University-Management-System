import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

import java.awt.event.*;
public class Project extends JFrame implements ActionListener{

    Project(){
        setSize(1280, 700);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./images/CollegeSecond.png"));
        Image i2=i1.getImage().getScaledInstance(1300, 650, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);

        JMenuBar mb=new JMenuBar();
        // New Information
        JMenu newInformation=new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);

        JMenuItem facultyInfo=new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo=new JMenuItem("New Student Info");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        // Details
        JMenu details=new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);

        JMenuItem facultydetails=new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails=new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);

        // Exam
        JMenu exam=new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);

        JMenuItem examResult=new JMenuItem("Check Result");
        examResult.setBackground(Color.WHITE);
        examResult.addActionListener(this);
        exam.add(examResult);

        JMenuItem enterMarks=new JMenuItem("Enter Marks");
        enterMarks.setBackground(Color.WHITE);
        enterMarks.addActionListener(this);
        exam.add(enterMarks);

        // Fees
        JMenu fee=new JMenu("Fee Details");
        fee.setForeground(Color.GREEN);
        mb.add(fee);

        JMenuItem Feestructure=new JMenuItem("Fee Structure");
        Feestructure.setBackground(Color.WHITE);
        Feestructure.addActionListener(this);
        fee.add(Feestructure);

        JMenuItem feeForm=new JMenuItem("Student Fee form");
        feeForm.setBackground(Color.WHITE);
        fee.add(feeForm);

        // Exit
        JMenu exit=new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        mb.add(exit);

        JMenuItem ex=new JMenuItem("Exit");
        ex.setForeground(Color.BLACK);
        ex.addActionListener(this);
        exit.add(ex);

        setJMenuBar(mb);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String msg=ae.getActionCommand();

        if(msg.equals("Exit")){
            setVisible(false);
        } else if(msg.equals("New Faculty Information")){
            new AddFaculty();
        } else if(msg.equals("New Student Info")){
            new AddStudent();
        } else if(msg.equals("View Faculty Details")){
            new FacultyDetails();
        } else if(msg.equals("View Student Details")){
            new StudentDetails();
        } else if(msg.equals("Enter Marks")){
            new EnterMarks();
        } else if(msg.equals("Check Result")){
            new ExaminationDetails();
        } else if(msg.equals("Fee Structure")){
            new FeeStructure();
        }
    }
    public static void main(String[] args) {
        new Project();
    }
}
