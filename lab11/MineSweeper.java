import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MineSweeper extends JFrame implements MouseListener{

    private JButton[][] jbuttons;

    public MineSweeper(String title){
        super(title);
        
        setLayout(new GridLayout(20, 20));
        jbuttons = new JButton[20][20];
        for (int i = 0 ; i < 20 ; i++){
            for (int j = 0 ; j < 20 ; j++){
                jbuttons[i][j] = new JButton();
                jbuttons[i][j].setBackground(Color.GREEN);
                jbuttons[i][j].addMouseListener(this);
                add(jbuttons[i][j]);
                setResizable(false);

            }
        }
        setVisible(true);
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton changeColor = (JButton) e.getSource();
        changeColor.setBackground(Color.BLACK);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {
        new MineSweeper("MineSweeper");
    }
    
}
