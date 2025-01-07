import javax.swing.*;
import java.awt.*;

public class Gamechess extends JFrame{
    
    public Gamechess(){
        super("Checkers");
        ImageIcon img = new ImageIcon("./Icon.png");
        this.setIconImage(img.getImage());
        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());

        JPanel panel = createGamePanel();
        cp.add(panel, BorderLayout.EAST);

        JPanel table = createGametable();
        cp.add(table, BorderLayout.WEST); 

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JPanel createGamePanel(){
        JPanel P = new JPanel();
        JLabel L1 = new JLabel("GamePanel");
        JLabel L2 = new JLabel("Time Passed: 00.00");
        JButton b = new JButton("START");
        

        P.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; c.gridy = 0; c.ipadx = 100; c.ipady = 50;
        // P.setLayout(new BoxLayout(P, BoxLayout.Y_AXIS));
        // P.add(L1);
        // P.add(L2);
        // P.add(b);
        P.add(L1, c);
        c.gridx =0; c.gridy = 1;
        P.add(L2, c);
        c.gridx =0; c.gridy = 2; c.ipadx = 30; c.ipady = 15;
        P.add(b, c);
        L1.setHorizontalAlignment(JLabel.CENTER);
        L1.setVerticalAlignment(JLabel.BOTTOM);
        L2.setHorizontalAlignment(JLabel.CENTER);
        return P;
        
    }

    public JPanel createGametable(){
        JPanel P = new JPanel();
        P.setLayout(new GridLayout(8, 8));
        
        // JButton a = new JButton();
        // P.add(a);

        Color lightSquare = new Color(238, 238, 210);
        Color darkSquare = new Color(118, 150, 86);

        JButton bt[][] = new JButton[8][8];
        for (int i=0;i<8;i++) {
            for (int j=0;j<8;j++) {
                bt[i][j] = new JButton();
                P.add(bt[i][j]);
                bt[i][j].setBackground((i + j) % 2 == 0 ? lightSquare : darkSquare);
                bt[i][j].setPreferredSize(new Dimension(80, 80));
                P.add(bt[i][j]);
            }
        }
        
        return P;
    }
}
