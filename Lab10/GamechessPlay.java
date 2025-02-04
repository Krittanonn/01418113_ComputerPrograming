import java.awt.*;
import javax.swing.*;

public class GamechessPlay extends JFrame {
    private JButton[][] boardButtons = new JButton[8][8];
    private boolean isPieceSelected = false;
    private int selectedRow = -1;
    private int selectedCol = -1;
    private int blackScore = 0;
    private int whiteScore = 0;
    private JLabel blackScoreLabel;
    private JLabel whiteScoreLabel;
    private JLabel timerLabel;
    private JLabel currentPlayerLabel;
    private Timer timer;
    private int timeElapsed = 0;
    private boolean isBlackTurn = true;
    private int blackTimeElapsed = 0;  // เวลาเล่นของผู้เล่นดำ
    private int whiteTimeElapsed = 0;  // เวลาเล่นของผู้เล่นขาว

    public GamechessPlay() {
        super("Checkers");
        setLayout(new BorderLayout());

        add(createBoard(), BorderLayout.CENTER);
        add(createGamePanel(), BorderLayout.EAST);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createBoard() {
        JPanel panel = new JPanel(new GridLayout(8, 8));
        Color lightSquare = new Color(238, 238, 210);
        Color darkSquare = new Color(118, 150, 86);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                boardButtons[row][col] = new JButton();
                boardButtons[row][col].setOpaque(true);
                boardButtons[row][col].setBorderPainted(false);
                boardButtons[row][col].setBackground((row + col) % 2 == 0 ? lightSquare : darkSquare);
                
                if ((row + col) % 2 != 0) {
                    if (row < 2) boardButtons[row][col].setText("⚫");
                    else if (row > 5) boardButtons[row][col].setText("⚪");
                }
                
                int finalRow = row, finalCol = col;
                boardButtons[row][col].addActionListener(e -> handleMove(finalRow, finalCol));
                panel.add(boardButtons[row][col]);
            }
        }
        return panel;
    }

    private JPanel createGamePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(200, 0));
        panel.setBackground(new Color(200, 200, 200));

        timerLabel = new JLabel("Time: 00:00");
        blackScoreLabel = new JLabel("Black Score: 0");
        whiteScoreLabel = new JLabel("White Score: 0");
        currentPlayerLabel = new JLabel("Current Player: Black");
        JButton startButton = new JButton("START");
        JButton resetButton = new JButton("RESET");

        startButton.addActionListener(e -> startGame());
        resetButton.addActionListener(e -> resetGame());

        panel.add(Box.createVerticalGlue());
        panel.add(new JLabel("Game Panel", SwingConstants.CENTER));
        panel.add(timerLabel);
        panel.add(blackScoreLabel);
        panel.add(whiteScoreLabel);
        panel.add(currentPlayerLabel);
        panel.add(startButton);
        panel.add(resetButton);
        panel.add(Box.createVerticalGlue());

        return panel;
    }

    private void handleMove(int row, int col) {
        if (!isPieceSelected) {
            String piece = boardButtons[row][col].getText();
            if ((isBlackTurn && piece.equals("⚫")) || (!isBlackTurn && piece.equals("⚪"))) {
                isPieceSelected = true;
                selectedRow = row;
                selectedCol = col;
                boardButtons[row][col].setBackground(Color.YELLOW);
            }
        } else {
            if (isValidMove(row, col)) {
                movePiece(row, col);
                isBlackTurn = !isBlackTurn;
                currentPlayerLabel.setText("Current Player: " + (isBlackTurn ? "Black" : "White"));
            }
            isPieceSelected = false;
            resetHighlights();
        }
    }
    

    private boolean isValidMove(int row, int col) {
        // 1. ตรวจสอบว่าเป็นช่องว่าง
        if (!boardButtons[row][col].getText().isEmpty()) return false;
    
        // 2. คำนวณความแตกต่างแถวและคอลัมน์
        int rowDiff = row - selectedRow;  // ความต่างแถว
        int colDiff = Math.abs(col - selectedCol);  // ความต่างคอลัมน์ (ต้องคำนวณเป็นบวก)
    
        String piece = boardButtons[selectedRow][selectedCol].getText(); // หมาที่ถูกเลือก
    
        // 3. ตรวจสอบการเดินทแยง (เดินไปข้างหน้า 1 ช่อง)
        if (piece.equals("⚪") && rowDiff != -1) return false;  // หมากขาวต้องเดินลง 1 ช่อง
        if (piece.equals("⚫") && rowDiff != 1) return false;   // หมากดำต้องเดินขึ้น 1 ช่อง
    
        // 4. ตรวจสอบการเดินในแนวทแยง (ช่องข้างหน้า-ข้างหลัง)
        if (colDiff != 1 && Math.abs(rowDiff) != 2) return false; // ถ้าหมาช่องปลายไม่ตรงกับการเดิน
        if (Math.abs(rowDiff) == 2) {  // ถ้าหมากระโดด
            int midRow = (selectedRow + row) / 2;  // คำนวณแถวของหมากที่ถูกกระโดด
            int midCol = (selectedCol + col) / 2;  // คำนวณคอลัมน์ของหมากที่ถูกกระโดด
    
            String capturedPiece = boardButtons[midRow][midCol].getText(); // หมาฝ่ายตรงข้ามที่อยู่ในช่องกลาง
            if (capturedPiece.isEmpty()) return false; // ไม่มีหมาในช่องกลาง
            if (capturedPiece.equals(piece)) return false; // หมาต้องเป็นของฝ่ายตรงข้าม
        }
    
        return true;  // ถ้าผ่านการตรวจสอบทั้งหมดก็ถือว่าเดินได้
    }
    
    

    private void movePiece(int row, int col) {
        String piece = boardButtons[selectedRow][selectedCol].getText();
    
        if (Math.abs(row - selectedRow) == 2) {
            int capturedRow = (selectedRow + row) / 2;
            int capturedCol = (selectedCol + col) / 2;
            boardButtons[capturedRow][capturedCol].setText("");  // ลบหมาที่ถูกกระโดด
            if (piece.equals("⚪")) blackScore++;  // หมาขาวทำคะแนน
            else whiteScore++;  // หมาดำทำคะแนน
            blackScoreLabel.setText("Black Score: " + blackScore);
            whiteScoreLabel.setText("White Score: " + whiteScore);
        }
    
        boardButtons[selectedRow][selectedCol].setText("");  // ลบหมาจากตำแหน่งเดิม
        boardButtons[row][col].setText(piece);  // ย้ายหมาไปตำแหน่งใหม่
    
        // เช็คการเปลี่ยนเป็นหมากป้อม (King)
        if ((piece.equals("⚪") && row == 0) || (piece.equals("⚫") && row == 7)) {
            boardButtons[row][col].setText("👑");  // เปลี่ยนเป็นหมากป้อม
        }
    
        // ตรวจสอบการชนะ
        if (blackScore >= 8 || whiteScore >= 8) {
            JOptionPane.showMessageDialog(this, (blackScore >= 8 ? "Black" : "White") + " Wins!");
            resetGame();  // รีเซ็ตเกมเมื่อมีผู้ชนะ
        }
    }
    
    

    private void resetHighlights() {
        Color lightSquare = new Color(238, 238, 210);
        Color darkSquare = new Color(118, 150, 86);
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                boardButtons[row][col].setBackground((row + col) % 2 == 0 ? lightSquare : darkSquare);
            }
        }
    }

    private void startGame() {
        blackScore = 0;
        whiteScore = 0;
        blackScoreLabel.setText("Black Score: 0");
        whiteScoreLabel.setText("White Score: 0");

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                boardButtons[row][col].setText("");
                if ((row + col) % 2 != 0 && row < 2) {
                    boardButtons[row][col].setText("⚫");
                }
                else if ((row + col) % 2 != 0 && row > 5) {
                    boardButtons[row][col].setText("⚪");
                }
            }
        }
    
        isBlackTurn = true;
        currentPlayerLabel.setText("Current Player: Black");
    
        timeElapsed = 0;
        blackTimeElapsed = 0;
        whiteTimeElapsed = 0;
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        timer = new Timer(1000, e -> {
            timeElapsed++;
            if (isBlackTurn) blackTimeElapsed++;
            else whiteTimeElapsed++;

            int minutes = timeElapsed / 60;
            int seconds = timeElapsed % 60;
            timerLabel.setText(String.format("Time: %02d:%02d", minutes, seconds));
        });
        timer.start();
    }

    private void resetGame() {
        blackScore = 0;
        whiteScore = 0;
        blackScoreLabel.setText("Black Score: 0");
        whiteScoreLabel.setText("White Score: 0");
        
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                boardButtons[row][col].setText("");  
                if ((row + col) % 2 != 0 && row < 2) {
                    boardButtons[row][col].setText("⚫");
                }
                else if ((row + col) % 2 != 0 && row > 5) {
                    boardButtons[row][col].setText("⚪");
                }
            }
        }
    
        isBlackTurn = true;  
        currentPlayerLabel.setText("Current Player: Black");
    
        timeElapsed = 0;
        blackTimeElapsed = 0;
        whiteTimeElapsed = 0;
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        timerLabel.setText("Time: 00:00");
    
        timer = new Timer(1000, e -> {
            timeElapsed++;
            if (isBlackTurn) blackTimeElapsed++;
            else whiteTimeElapsed++;

            int minutes = timeElapsed / 60;
            int seconds = timeElapsed % 60;
            timerLabel.setText(String.format("Time: %02d:%02d", minutes, seconds));
        });
        timer.start();
    }
}
