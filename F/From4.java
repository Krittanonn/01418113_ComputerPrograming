import java.awt.*;
import javax.swing.*;

public class From4 extends JFrame{
    JFrame f = new JFrame("Login");
    Container cp = f.getContentPane();

    public From4() {
    cp.setLayout(null);

    JLabel i = new JLabel("USER : ");
    JTextField t = new JTextField();
    JLabel j = new JLabel("PASSWORD :");
    JPasswordField p = new JPasswordField();
    JButton b1 = new JButton("Login");

    i.setBounds(50, 50, 100, 30);
    t.setBounds(150, 50, 200, 30);
    j.setBounds(50, 100, 100, 30);
    p.setBounds(150, 100, 200, 30);
    b1.setBounds(200, 150, 100, 30);
    
    cp.add(i);
    cp.add(t);
    cp.add(j);
    cp.add(p);
    cp.add(b1);



    
    }
}
    
