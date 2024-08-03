import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteStudent extends JFrame implements ActionListener{

    JButton delete, cancel;
    JTextField tfDelete;

    DeleteStudent(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(600, 300);
        setLocation(350, 80);

        JLabel lblDelete = new JLabel("Enter Roll Number to Delete:");
        lblDelete.setBounds(30, 40, 160, 20);
        add(lblDelete);

        tfDelete = new JTextField();
        tfDelete.setBounds(200, 40, 130, 20);
        add(tfDelete);

        delete = new JButton("Delete");
        delete.setBounds(30, 70, 80, 20);
        delete.addActionListener(this);
        add(delete);

        cancel = new JButton("Cancel");
        cancel.setBounds(120, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == delete){
            String rollNo = tfDelete.getText();
            String query = "DELETE FROM student WHERE rollno='" + rollNo + "'";
            try {
                Conn connect = new Conn();
                connect.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Deleted successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error occurred while deleting");
            }
        } else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new DeleteStudent();
    }
}
