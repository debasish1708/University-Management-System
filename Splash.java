import java.awt.*;

import javax.swing.*;

public class Splash extends JFrame implements Runnable{

    Thread t;
    Splash(){
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/University.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);

        t=new Thread(this);
        t.start();
        setLocation(198, 50);
        setSize(900,600);
        setVisible(true);
    }

    public void run(){
        try {
            Thread.sleep(4000);
            setVisible(false);

            //Next Frame
            new Login();
        } catch (Exception e) {
            
        }
    }
    public static void main(String[] args) {
        new Splash();
    }
}
