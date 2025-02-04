import java.awt.*;
import javax.swing.*;

public class Gamechess extends JFrame {
    
    public Gamechess() {
        super("Checkers");
        // ตั้งค่าไอคอน
        try {
            ImageIcon img = new ImageIcon("./icon.png");
            this.setIconImage(img.getImage());
        } catch (Exception e) {
            System.out.println("Icon not found!");
        }

        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());

        // สร้างส่วนตารางเกม
        JPanel table = createGametable();
        cp.add(table, BorderLayout.CENTER);

        // สร้าง Game Panel
        JPanel panel = createGamePanel();
        cp.add(panel, BorderLayout.EAST);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // สร้าง Game Panel ด้านขวา
    public JPanel createGamePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel title = new JLabel("Game Panel");
        JLabel timer = new JLabel("Time Passed: 00.00");
        JButton startButton = new JButton("START");

        // ตั้งค่า Layout
        c.gridx = 0; c.gridy = 0; c.insets = new Insets(10, 10, 10, 10);
        panel.add(title, c);

        c.gridy = 1;
        panel.add(timer, c);

        c.gridy = 2;
        startButton.setPreferredSize(new Dimension(100, 40));
        panel.add(startButton, c);

        return panel;
    }

    // สร้างตารางเกม
    public JPanel createGametable() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 8));

        // สีของช่องตาราง
        Color lightSquare = new Color(238, 238, 210);
        Color darkSquare = new Color(118, 150, 86);

        JButton[][] buttons = new JButton[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBackground((i + j) % 2 == 0 ? lightSquare : darkSquare);
                buttons[i][j].setPreferredSize(new Dimension(80, 80));
                panel.add(buttons[i][j]);
            }
        }
        return panel;
    }
}
