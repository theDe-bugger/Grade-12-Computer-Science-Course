/**
 * Simple Tic Tac Toe game, 4 by 4 play board, custom Naruto theme, stores scores and ties, allows for reset.
 * 
 * date         20201016
 * @filename	TicTac.java
 * @author 		jdalwadi
 * @version     1.0
 * @see			assignment 2.5
 */
import java.awt.*;
import javax.swing.*;

public class TicTac extends JFrame {

    // declares and initializes gui + components
    TicTacEvent tictac = new TicTacEvent(this);
    JPanel row1 = new JPanel();
    JButton[][] boxes = new JButton[4][4];
    JButton reset = new JButton("Reset");
    JButton exit = new JButton("Exit");
    JTextArea x = new JTextArea("X Wins: 0\nTies: 0");
    JTextArea o = new JTextArea("O Wins: 0\nTies: 0");
    
    JOptionPane win = new JOptionPane("Winner");
    String path = "./"; 
    ImageIcon back = new ImageIcon(path + "cardback.jpg"); // https://images-na.ssl-images-amazon.com/images/I/51xSmRDEH4L._AC_SL1500_.jpg


    public TicTac() {
        super ("Tic Tac Toe");
        setSize (650,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        int name = 0;
        String newname;

        // creates grid that has 5 rows, 4 columns (last row for scores, reset, and exit)
        GridLayout layout1 = new GridLayout(5, 4, 10, 10);

        // creates game buttons for each row and column, sets image to back.
        row1.setLayout(layout1);
        for (int x=0; x<=3; x++){
            for (int y=0; y<=3; y++){
                name = name + 1;
                newname = Integer.toString(name);
                boxes[x][y] = new JButton(newname);
                boxes[x][y].setIcon(back);
                boxes[x][y].setDisabledIcon(back);
                row1.add(boxes[x][y]);
            }
        }

        // adds final row with scores, reset, and exit
        row1.add(x);
        row1.add(reset);
        row1.add(exit);
        row1.add(o);
        add (row1);

        // sets output to uneditable
        x.setEditable(false);
        o.setEditable(false);
        reset.addActionListener(tictac);
        exit.addActionListener(tictac);
        for (int x=0; x<=3; x++){
            for (int y=0; y<=3; y++){
                boxes[x][y].addActionListener(tictac);
            }
        }
        setVisible(true);
    }

    public static void main(String[] arguments){
        TicTac frame = new TicTac();
    }
}