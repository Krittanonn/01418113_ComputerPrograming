import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Form {
    public Form(){
        JFrame j = new JFrame("Login");
        Container cp = j.getContentPane();
        cp.setLayout(null);

        JLabel L1 = new JLabel("User :");
        L1.setBounds(50, 50, 100, 30);
        cp.add(L1);

        JLabel L2 = new JLabel("password :");
        L2.setBounds(50, 100, 100, 30);
        cp.add(L2);

        JTextField tf = new JTextField();
        tf.setBounds(150, 50, 150, 30);
        cp.add(tf);
        
        JPasswordField pf = new JPasswordField();
        pf.setBounds(150, 100, 150, 30);
        cp.add(pf);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 30);
        cp.add(loginButton);

        // loginButton.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         System.out.println("Login button clicked");
        //     }
        // });
        
        j.setSize(350, 250);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);
        j.setVisible(true);
    }
}
