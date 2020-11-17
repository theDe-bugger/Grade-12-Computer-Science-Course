/**
 * Starts a simple application that takes input of only whole numbers, stores them in a list and outputs that list
 * Allows for one to print a sum of all the numbers in the list, all even numbers in the list, or all odd numbers in the list
 * If an error occurs, the whole input text field is reset and the program continues running after displaying an error message.
 * Allows user to remove all occurrences of an input within the list as well.
 * unit 2 examples for computer science, 12 used as basic setup
 * 
 * integer sums - starter GUI project 
 * 
 * modified     20201007
 * date         20200920
 * @filename	SumElement.java
 * @author 		jdalwadi and vmso
 * @version     1.1
 * @see			assignment 2.2 
 */


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;


import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;


public class SumElement {

	private JFrame frame;
	private JTextField txtInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SumElement window = new SumElement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}


	/**
	 * Create the application.
	 */
	public SumElement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// sets up new frame
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(238, 238, 238));
		frame.setBounds(100, 100, 450, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// declares and initializes output text area
		JTextArea txtOutput = new JTextArea();
		txtOutput.setEditable(false);
		txtOutput.setBounds(48, 92, 241, 118);
		frame.getContentPane().add(txtOutput);
		txtOutput.setText("");
		
		// declares and initializes sum output text area
		JTextArea txtSumOutput = new JTextArea();
		txtSumOutput.setColumns(15);
		txtSumOutput.setRows(2);
		txtSumOutput.setText("");
		txtSumOutput.setEditable(false);
		txtSumOutput.setBounds(48, 256, 359, 47);
		frame.getContentPane().add(txtSumOutput);
		

		// declares reset button
		JButton btnReset = new JButton("Reset");
		frame.getContentPane().add(btnReset);
		btnReset.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		btnReset.setBounds(290, 114, 117, 29);
		//looks for button clicks on reset button, if so, resets all fields to empty
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOutput.setText(null);
				txtSumOutput.setText(null);
				txtInput.setText(null);
			}
		});

		// declares remove button
		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		btnRemove.setBounds(290, 87, 117, 29);
		frame.getContentPane().add(btnRemove);
		//looks for button clicks on remove button, if so, removes the last input if possible
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        // tries to remove the input if possible from the list
					String[] txtoutput = (txtOutput.getText().split("\n"));
					int input = Integer.parseInt(txtInput.getText());
					for(int i = 0;i < txtoutput.length;i++)
					{
					   if (input == Integer.parseInt(txtoutput[i])) {
						   txtoutput[i] = "0";
					   }
					}
					txtOutput.setText(String.join("\n", txtoutput )+"\n");
					
					} catch (Exception a) {
						// if error is found, it corrects list of values and input text
						String[] txtoutput = (txtOutput.getText()).split("\n");
						String input = (txtInput.getText());
						// for loop goes through output field and if wrong input was accidentally added, it removes it
						for(int i = 0;i < txtoutput.length;i++)
						{
						   if (input.equals(txtoutput[i])) {
							   txtoutput[i] = "0";
						   }
						}
						// checks if output field is empty, if so, it allows user to add directly to the field the next time
						if (txtOutput.getText()=="") {
							txtOutput.setText(String.join("\n", txtoutput));
						}
						// else, if output field had previous text, it allows user to add on to the next line
						else if (txtoutput.length > 1) {
							txtOutput.setText(String.join("\n", txtoutput)+"\n");
						}
						
						// resets input text
				    	txtInput.setText("");
				    	
				    	// displays error message
				    	JOptionPane.showMessageDialog(null, "Please enter only a number.");
			    }
				
			}
		});


		JLabel lblTitle = new JLabel("Integer Sum");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.ORANGE);
		lblTitle.setFont(new Font("Helvetica Neue", Font.PLAIN, 28));
		lblTitle.setBounds(6, 6, 438, 40);
		frame.getContentPane().add(lblTitle);
		
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // tries to add the input if possible to the list
				try {
				String txtoutput = txtOutput.getText();
				
				txtoutput = txtoutput + String.valueOf(Integer.parseInt(txtInput.getText())) + "\n";
				txtOutput.setText(txtoutput);
				} catch (Exception a) {
					// if error is found, it corrects list of values and input text
					String[] txtoutput = (txtOutput.getText()).split("\n");
					String input = (txtInput.getText());
					// for loop goes through output field and if wrong input was accidentally added, it removes it
					for(int i = 0;i < txtoutput.length;i++)
					{
					   if (input.equals(txtoutput[i])) {
						   txtoutput[i] = "0";
					   }
					}
					// checks if output field is empty, if so, it allows user to add directly to the field the next time
					if (txtOutput.getText()=="") {
						txtOutput.setText(String.join("\n", txtoutput));
					}
					// else, if output field had previous text, it allows user to add on to the next line
					else if (txtoutput.length != 1) {
						txtOutput.setText(String.join("\n", txtoutput)+"\n");
					}
					// resets input text
			    	txtInput.setText("");
			    	
			    	// displays error message
			    	JOptionPane.showMessageDialog(null, "Please enter only a number.");
				}
			}
				
		});
		btnAdd.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		btnAdd.setBounds(290, 58, 117, 29);
		frame.getContentPane().add(btnAdd);
		

		// declares exit button and if clicked, exits the system
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		btnExit.setBounds(290, 142, 117, 29);
		frame.getContentPane().add(btnExit);
		
		JLabel lblInput = new JLabel("Enter an Integer:");
		lblInput.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblInput.setBounds(48, 63, 110, 16);
		frame.getContentPane().add(lblInput);
		
		txtInput = new JTextField();
		txtInput.setBounds(159, 58, 130, 26);
		frame.getContentPane().add(txtInput);
		txtInput.setColumns(10);
		
		// declares sum odd button and checks if button is clicked
		JButton btnSumOdd = new JButton("Sum Odd");
		btnSumOdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				// takes in the list, converts each odd number to an integer, adds it to the odd sum variable, and outputs new array with only odd numbers
				String[] txtoutput = (txtOutput.getText()).split("\n");
				ArrayList <Integer> oddtxtoutput = new ArrayList<Integer>();
				String finaloutput = "The odd numbers in the list are: ";
				int oddSum = 0;
				for(int i = 0;i < txtoutput.length;i++)
				{
					if ((Integer.parseInt(txtoutput[i]))%2 != 0) {
						oddSum = oddSum + Integer.parseInt(txtoutput[i]);
						// adds the integer to the new list
						oddtxtoutput.add(Integer.parseInt(txtoutput[i]));
					}
				}
				// sorts the list from lowest to greatest
				Collections.sort(oddtxtoutput);
				
				//loops through list and adds each element to the final output string
				for (int i = 0; i < oddtxtoutput.size();i++) {
					if (i == oddtxtoutput.size()-1) {
					finaloutput += String.valueOf(oddtxtoutput.get(i));
				} else {
					finaloutput += String.valueOf(oddtxtoutput.get(i)) + ", ";
				}
				}
				// sets odd sum output
				txtSumOutput.setText(finaloutput + ".\nThe sum of all the odd numbers in the list is: " + String.valueOf(oddSum));
				// if no odd numbers
				if (finaloutput.equals("The odd numbers in the list are: ")) {
					txtSumOutput.setText("There are no odd numbers in this list.");

				}
				} catch(Exception a) {
				// resets input text
		    	txtInput.setText("");
		    	
		    	// displays error message
		    	JOptionPane.showMessageDialog(null, "Please add integers to the list.");
			}
			}
		});
		btnSumOdd.setHorizontalAlignment(SwingConstants.LEFT);
		btnSumOdd.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		btnSumOdd.setBounds(213, 222, 89, 29);
		frame.getContentPane().add(btnSumOdd);
		
		// declares sum even button and checks if button is clicked
		JButton btnSumEven = new JButton("Sum Even");
		btnSumEven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//simple try catch to ensure no errors occur
				try {
					// takes in the list, converts each even number to an integer, adds it to the even sum variable, and outputs new array with only even numbers
					String[] txtoutput = (txtOutput.getText()).split("\n");
					ArrayList <Integer> eventxtoutput = new ArrayList<Integer>();
					String finaloutput = "The even numbers in this list are: ";
					int evenSum = 0;
					for(int i = 0;i < txtoutput.length;i++)
					{
						if ((Integer.parseInt(txtoutput[i]))%2 == 0) {
							evenSum = evenSum + Integer.parseInt(txtoutput[i]);
							// adds the integer to the new list
							eventxtoutput.add(Integer.parseInt(txtoutput[i]));
						}
					}
					// sorts the list from lowest to greatest
					Collections.sort(eventxtoutput);
					
					//loops through list and adds each element to the final output string
					for (int i = 0; i < eventxtoutput.size();i++) {
						if (i == eventxtoutput.size()-1) {
						finaloutput += String.valueOf(eventxtoutput.get(i));
					} else {
						finaloutput += String.valueOf(eventxtoutput.get(i)) + ", ";
					}
					}
					
					// sets even sum output
					txtSumOutput.setText(finaloutput + ".\nThe sum of all the even numbers in the list is: " + String.valueOf(evenSum));
					
					// if no even numbers
					if (finaloutput.equals("The even numbers in the list are: ")) {
						txtSumOutput.setText("There are no even numbers in this list.");

					}
				} catch (Exception a){
					// resets input text
			    	txtInput.setText("");
			    	
			    	// displays error message
			    	JOptionPane.showMessageDialog(null, "Please add integers to the list.");
				}
				
			}
		});
		btnSumEven.setHorizontalAlignment(SwingConstants.LEFT);
		btnSumEven.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		btnSumEven.setBounds(112, 222, 89, 29);
		frame.getContentPane().add(btnSumEven);
		
		// declares sum all button and checks if button is clicked
		JButton btnSumAll = new JButton("Sum All");
		btnSumAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//simple try catch to ensure no errors occur
				try {
					// takes in the list, converts each number to an integer and adds it to the sum variable
					String[] txtoutput = (txtOutput.getText()).split("\n");
					int sum = 0;
					ArrayList <Integer> alltxtoutput = new ArrayList<Integer>();
					String finaloutput = "";
					for(int i = 0;i < txtoutput.length;i++)
					{
					   sum = sum + Integer.parseInt(txtoutput[i]);
					   // adds the integer to the new list
					   alltxtoutput.add(Integer.parseInt(txtoutput[i]));
					}
					// sorts the list from lowest to greatest
					Collections.sort(alltxtoutput);
					
					//loops through list and adds each element to the final output string
					for (int i = 0; i < alltxtoutput.size();i++) {
						finaloutput += String.valueOf(alltxtoutput.get(i)) + "\n";
					}
					
					// sets sum output
					txtSumOutput.setText("The sum of all the numbers in the list is: " + String.valueOf(sum));
					txtOutput.setText(finaloutput);
				} catch (Exception a){
					// resets input text
			    	txtInput.setText("");
			    	
			    	// displays error message
			    	JOptionPane.showMessageDialog(null, "Please add integers to the list.");
				}
				
			}
		});
		btnSumAll.setHorizontalAlignment(SwingConstants.LEFT);
		btnSumAll.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		btnSumAll.setBounds(34, 222, 76, 29);
		frame.getContentPane().add(btnSumAll);
		
		

	}
}