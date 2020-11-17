/**
 * This program runs the GUI for Tic Tac Toe
 *
 * date         20201016
 * @filename    TicTacEvent.java
 * @author      jdalwadi
 * @version     1.0
 * @see         assignment 2.5
 */

import javax.swing.*;
import java.awt.event.*;



public class TicTacEvent implements ItemListener, ActionListener, Runnable {
    TicTac gui;
    Thread playing;
    String path = "./";
    ImageIcon a = new ImageIcon(path + "X.jpg"); // https://i.pinimg.com/originals/de/ed/90/deed90b3002de42a3c8f2e1114f90734.jpg
    ImageIcon b = new ImageIcon(path + "O.jpg"); // https://static.wikia.nocookie.net/naruto-bleach/images/c/c0/Rasengan.jpg/revision/latest/scale-to-width-down/340?cb=20101031232829
    ImageIcon back = new ImageIcon(path + "cardback.jpg"); // https://images-na.ssl-images-amazon.com/images/I/51xSmRDEH4L._AC_SL1500_.jpg
    int clicks = 0;
    int win = 0;
    int xcount = 0;
    int ocount = 0;
    int ties = 0;
    int[][] check = new int[4][4];

    public TicTacEvent (TicTac in){
        gui = in;
        for (int row=0; row<=3; row++){
           for (int col=0; col<=3; col++){
               check[row][col]=0;
           }
       }
    }

    public void actionPerformed (ActionEvent event) {
       String command = event.getActionCommand();

       if (command.equals("Reset")) {
           startPlaying();
       }
       if (command.equals("1")) {
           b1();
       }
       if (command.equals("2")) {
           b2();
       }
       if (command.equals("3")) {
           b3();
       }
       if (command.equals("4")) {
           b4();
       }
       if (command.equals("5")) {
           b5();
       }
       if (command.equals("6")) {
           b6();
       }
       if (command.equals("7")) {
           b7();
       }
       if (command.equals("8")) {
           b8();
       }
       if (command.equals("9")) {
           b9();
       }
       if (command.equals("10")) {
           b10();
       }
       if (command.equals("11")) {
           b11();
       }
       if (command.equals("12")) {
           b12();
       }
       if (command.equals("13")) {
           b13();
       }
       if (command.equals("14")) {
           b14();
       }
       if (command.equals("15")) {
           b15();
       }
       if (command.equals("16")) {
           b16();
       }
       
       if (command.equals("Exit")){
           System.exit(0);
       }
    }

    void b1() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            gui.boxes[0][0].setIcon(a);
            // disables so it can't be clicked again until game is over
            gui.boxes[0][0].setEnabled(false);
            gui.boxes[0][0].setDisabledIcon(a);
            check[0][0] = 1;
        } else {
            gui.boxes[0][0].setIcon(b);
            // disables so it can't be clicked again until game is over
            gui.boxes[0][0].setEnabled(false);
            gui.boxes[0][0].setDisabledIcon(b);
            check[0][0] = 2;
        }
        winner();

    }
    void b2() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            gui.boxes[0][1].setIcon(a);
            // disables so it can't be clicked again until game is over
            gui.boxes[0][1].setEnabled(false);
            gui.boxes[0][1].setDisabledIcon(a);
            check[0][1] = 1;
        } else {
            gui.boxes[0][1].setIcon(b);
            // disables so it can't be clicked again until game is over
            gui.boxes[0][1].setEnabled(false);
            gui.boxes[0][1].setDisabledIcon(b);
            check[0][1] = 2;
        }
        winner();
    }
    void b3() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            gui.boxes[0][2].setIcon(a);
            // disables so it can't be clicked again until game is over
            gui.boxes[0][2].setEnabled(false);
            gui.boxes[0][2].setDisabledIcon(a);
            check[0][2] = 1;
        } else {
            gui.boxes[0][2].setIcon(b);
            // disables so it can't be clicked again until game is over
            gui.boxes[0][2].setEnabled(false);
            gui.boxes[0][2].setDisabledIcon(b);
            check[0][2] = 2;
        }
        winner();
    }
    void b4() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            gui.boxes[0][3].setIcon(a);
            // disables so it can't be clicked again until game is over
            gui.boxes[0][3].setEnabled(false);
            gui.boxes[0][3].setDisabledIcon(a);
            check[0][3] = 1;
        } else {
            gui.boxes[0][3].setIcon(b);
            // disables so it can't be clicked again until game is over
            gui.boxes[0][3].setEnabled(false);
            gui.boxes[0][3].setDisabledIcon(b);
            check[0][3] = 2;
        }
        winner();
    }
    void b5() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            gui.boxes[1][0].setIcon(a);
            // disables so it can't be clicked again until game is over
            gui.boxes[1][0].setEnabled(false);
            gui.boxes[1][0].setDisabledIcon(a);
            check[1][0] = 1;
        } else {
            gui.boxes[1][0].setIcon(b);
            // disables so it can't be clicked again until game is over
            gui.boxes[1][0].setEnabled(false);
            gui.boxes[1][0].setDisabledIcon(b);
            check[1][0] = 2;
        }
        winner();
    }
    void b6() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            gui.boxes[1][1].setIcon(a);
            // disables so it can't be clicked again until game is over
            gui.boxes[1][1].setEnabled(false);
            gui.boxes[1][1].setDisabledIcon(a);
            check[1][1] = 1;
        } else {
            gui.boxes[1][1].setIcon(b);
            // disables so it can't be clicked again until game is over
            gui.boxes[1][1].setEnabled(false);
            gui.boxes[1][1].setDisabledIcon(b);
            check[1][1] = 2;
        }
        winner();
    }
    void b7() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            gui.boxes[1][2].setIcon(a);
            // disables so it can't be clicked again until game is over
            gui.boxes[1][2].setEnabled(false);
            gui.boxes[1][2].setDisabledIcon(a);
            check[1][2] = 1;
        } else {
            gui.boxes[1][2].setIcon(b);
            // disables so it can't be clicked again until game is over
            gui.boxes[1][2].setEnabled(false);
            gui.boxes[1][2].setDisabledIcon(b);
            check[1][2] = 2;
        }
        winner();
    }
    void b8() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            gui.boxes[1][3].setIcon(a);
            // disables so it can't be clicked again until game is over
            gui.boxes[1][3].setEnabled(false);
            gui.boxes[1][3].setDisabledIcon(a);
            check[1][3] = 1;
        } else {
            gui.boxes[1][3].setIcon(b);
            // disables so it can't be clicked again until game is over
            gui.boxes[1][3].setEnabled(false);
            gui.boxes[1][3].setDisabledIcon(b);
            check[1][3] = 2;
        }
        winner();
    }
    void b9() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            gui.boxes[2][0].setIcon(a);
            // disables so it can't be clicked again until game is over
            gui.boxes[2][0].setEnabled(false);
            gui.boxes[2][0].setDisabledIcon(a);
            check[2][0] = 1;
        } else {
            gui.boxes[2][0].setIcon(b);
            // disables so it can't be clicked again until game is over
            gui.boxes[2][0].setEnabled(false);
            gui.boxes[2][0].setDisabledIcon(b);
            check[2][0] = 2;
        }
        winner();
    }
    void b10() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            gui.boxes[2][1].setIcon(a);
            // disables so it can't be clicked again until game is over
            gui.boxes[2][1].setEnabled(false);
            gui.boxes[2][1].setDisabledIcon(a);
            check[2][1] = 1;
        } else {
            gui.boxes[2][1].setIcon(b);
            // disables so it can't be clicked again until game is over
            gui.boxes[2][1].setEnabled(false);
            gui.boxes[2][1].setDisabledIcon(b);
            check[2][1] = 2;
        }
        winner();

    }
    void b11() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            gui.boxes[2][2].setIcon(a);
            // disables so it can't be clicked again until game is over
            gui.boxes[2][2].setEnabled(false);
            gui.boxes[2][2].setDisabledIcon(a);
            check[2][2] = 1;
        } else {
            gui.boxes[2][2].setIcon(b);
            // disables so it can't be clicked again until game is over
            gui.boxes[2][2].setEnabled(false);
            gui.boxes[2][2].setDisabledIcon(b);
            check[2][2] = 2;
        }
        winner();

    }
    void b12() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            gui.boxes[2][3].setIcon(a);
            // disables so it can't be clicked again until game is over
            gui.boxes[2][3].setEnabled(false);
            gui.boxes[2][3].setDisabledIcon(a);
            check[2][3] = 1;
        } else {
            gui.boxes[2][3].setIcon(b);
            // disables so it can't be clicked again until game is over
            gui.boxes[2][3].setEnabled(false);
            gui.boxes[2][3].setDisabledIcon(b);
            check[2][3] = 2;
        }
        winner();

    }
    void b13() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            gui.boxes[3][0].setIcon(a);
            // disables so it can't be clicked again until game is over
            gui.boxes[3][0].setEnabled(false);
            gui.boxes[3][0].setDisabledIcon(a);
            check[3][0] = 1;
        } else {
            gui.boxes[3][0].setIcon(b);
            // disables so it can't be clicked again until game is over
            gui.boxes[3][0].setEnabled(false);
            gui.boxes[3][0].setDisabledIcon(b);
            check[3][0] = 2;
        }
        winner();

    }
    void b14() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            gui.boxes[3][1].setIcon(a);
            // disables so it can't be clicked again until game is over
            gui.boxes[3][1].setEnabled(false);
            gui.boxes[3][1].setDisabledIcon(a);
            check[3][1] = 1;
        } else {
            gui.boxes[3][1].setIcon(b);
            // disables so it can't be clicked again until game is over
            gui.boxes[3][1].setEnabled(false);
            gui.boxes[3][1].setDisabledIcon(b);
            check[3][1] = 2;
        }
        winner();

    }
    void b15() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            gui.boxes[3][2].setIcon(a);
            // disables so it can't be clicked again until game is over
            gui.boxes[3][2].setEnabled(false);
            gui.boxes[3][2].setDisabledIcon(a);
            check[3][2] = 1;
        } else {
            gui.boxes[3][2].setIcon(b);
            // disables so it can't be clicked again until game is over
            gui.boxes[3][2].setEnabled(false);
            gui.boxes[3][2].setDisabledIcon(b);
            check[2][2] = 2;
        }
        winner();

    }
    void b16() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            gui.boxes[3][3].setIcon(a);
            // disables so it can't be clicked again until game is over
            gui.boxes[3][3].setEnabled(false);
            gui.boxes[3][3].setDisabledIcon(a);
            check[3][3] = 1;
        } else {
            gui.boxes[3][3].setIcon(b);
            // disables so it can't be clicked again until game is over
            gui.boxes[3][3].setEnabled(false);
            gui.boxes[3][3].setDisabledIcon(b);
            check[3][3] = 2;
        }
        winner();

    }
    
    void winner() {
        /** Check rows for winner */
        
        for (int x=0; x<=3; x++){
            if ((check[x][0]==check[x][1])&&(check[x][0]==check[x][2])&&(check[x][0]==check[x][3])) {
                if (check[x][0]==1) {
                    JOptionPane.showMessageDialog(null, "X is the winner");
                    xcount ++;
                    win = 1;
                    // sets text for scores
                    gui.x.setText("X Wins: " + String.valueOf(xcount)+ "\nTies: " + String.valueOf(ties));
                    gui.o.setText("O Wins: " + String.valueOf(ocount) + "\nTies: " + String.valueOf(ties));
                    
                    // disables all buttons until game is reset
                    for (int row=0; row<=3; row++){
                        for (int col=0; col<=3; col++){
                            gui.boxes[row][col].setEnabled(false);
                    }
       }

                } else if (check[x][0]==2){
                    JOptionPane.showMessageDialog(null, "O is the winner");
                    win = 1;
                    ocount ++;
                    // sets text for scores
                    gui.x.setText("X Wins: " + String.valueOf(xcount)+ "\nTies: " + String.valueOf(ties));
                    gui.o.setText("O Wins: " + String.valueOf(ocount) + "\nTies: " + String.valueOf(ties));
                    
                    // disables all buttons until game is reset
                    for (int row=0; row<=3; row++){
                        for (int col=0; col<=3; col++){
                            gui.boxes[row][col].setEnabled(false);
                    }
                    }
                }
            }
        }

        /** Check columns for winner */
        for (int x=0; x<=3; x++){
            if ((check[0][x]==check[1][x])&&(check[0][x]==check[2][x])&&(check[0][x]==check[3][x])) {
                if (check[0][x]==1) {
                    JOptionPane.showMessageDialog(null, "X is the winner");
                    win = 1;
                    xcount++;
                    // sets text for scores
                    gui.x.setText("X Wins: " + String.valueOf(xcount)+ "\nTies: " + String.valueOf(ties));
                    gui.o.setText("O Wins: " + String.valueOf(ocount) + "\nTies: " + String.valueOf(ties));
                    
                    // disables all buttons until game is reset
                    for (int row=0; row<=3; row++){
                        for (int col=0; col<=3; col++){
                            gui.boxes[row][col].setEnabled(false);
                    }
                    }
                } else if (check[0][x]==2) {
                    JOptionPane.showMessageDialog(null, "O is the winner");
                    win = 1;
                    ocount++;
                    // sets text for scores
                    gui.x.setText("X Wins: " + String.valueOf(xcount)+ "\nTies: " + String.valueOf(ties));
                    gui.o.setText("O Wins: " + String.valueOf(ocount) + "\nTies: " + String.valueOf(ties));
                    
                    // disables all buttons until game is reset
                    for (int row=0; row<=3; row++){
                        for (int col=0; col<=3; col++){
                            gui.boxes[row][col].setEnabled(false);
                    }
                    }
                }
            }
        }

        /** Check diagonals for winner */
        if (((check[0][0]==check[1][1])&&(check[0][0]==check[2][2])&&(check[0][0]==check[3][3]))){
            if (check[2][2]==1) {
                JOptionPane.showMessageDialog(null, "X is the winner");
                win = 1;
                xcount++;
                // sets text for scores
                gui.x.setText("X Wins: " + String.valueOf(xcount)+ "\nTies: " + String.valueOf(ties));
                gui.o.setText("O Wins: " + String.valueOf(ocount) + "\nTies: " + String.valueOf(ties));
                
                // disables all buttons until game is reset
                for (int row=0; row<=3; row++){
                        for (int col=0; col<=3; col++){
                            gui.boxes[row][col].setEnabled(false);
                    }
                    }


            } else if (check[2][2]==2) {
                JOptionPane.showMessageDialog(null, "O is the winner");
                win = 1;
                ocount++;
                // sets text for scores
                gui.x.setText("X Wins: " + String.valueOf(xcount)+ "\nTies: " + String.valueOf(ties));
                gui.o.setText("O Wins: " + String.valueOf(ocount) + "\nTies: " + String.valueOf(ties));
                
                // disables all buttons until game is reset
                for (int row=0; row<=3; row++){
                        for (int col=0; col<=3; col++){
                            gui.boxes[row][col].setEnabled(false);
                    }
                    }

            }
        }
            else if((check[0][3]==check[1][2])&&(check[0][3]==check[2][1])&&(check[0][3]==check[3][0])){
                if (check[2][1]==1) {
                JOptionPane.showMessageDialog(null, "X is the winner");
                win = 1;
                xcount++;
                // sets text for scores
                gui.x.setText("X Wins: " + String.valueOf(xcount)+ "\nTies: " + String.valueOf(ties));
                gui.o.setText("O Wins: " + String.valueOf(ocount) + "\nTies: " + String.valueOf(ties));
                
                // disables all buttons until game is reset
                for (int row=0; row<=3; row++){
                        for (int col=0; col<=3; col++){
                            gui.boxes[row][col].setEnabled(false);
                    }
                    }


            } else if (check[2][1]==2) {
                JOptionPane.showMessageDialog(null, "O is the winner");
                win = 1;
                ocount++;
                // sets text for scores
                gui.x.setText("X Wins: " + String.valueOf(xcount)+ "\nTies: " + String.valueOf(ties));
                gui.o.setText("O Wins: " + String.valueOf(ocount) + "\nTies: " + String.valueOf(ties));
                
                // disables all buttons until game is reset
                for (int row=0; row<=3; row++){
                        for (int col=0; col<=3; col++){
                            gui.boxes[row][col].setEnabled(false);
                    }
                    }

            }

        }

        /** Checks if the game is a tie */
        if ((clicks==16) && (win==0)) {
            JOptionPane.showMessageDialog(null, "The game is a tie");
            ties ++;
            // sets text for scores
            gui.x.setText("X Wins: " + String.valueOf(xcount)+ "\nTies: " + String.valueOf(ties));
            gui.o.setText("O Wins: " + String.valueOf(ocount) + "\nTies: " + String.valueOf(ties));
            
            // disables all buttons until game is reset
            for (int row=0; row<=3; row++){
                        for (int col=0; col<=3; col++){
                            // disables all buttons
                            gui.boxes[row][col].setEnabled(false);
                    }
                    }
        }
        
    }
    

     
    void startPlaying() {
        playing = new Thread(this);
        playing.start();
    }

    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void run() {
        int name = 0;
        String newname;
        for (int x=0; x<=3; x++){
            for (int y=0; y<=3; y++){
                // resets game, but not scores
                gui.boxes[x][y].setIcon(back);
                gui.boxes[x][y].setDisabledIcon(back);
                gui.boxes[x][y].setEnabled(true);
                clicks = 0;
                win = 0;
                check[x][y] = 0;
            }
        }
    }


}

