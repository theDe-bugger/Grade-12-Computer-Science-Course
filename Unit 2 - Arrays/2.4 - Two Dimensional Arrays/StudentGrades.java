/*
 * 
 * This is a program which uses 2-dimensional arrays to store test marks, student names, and allows for calculation of student average and course average
 * To run the program, type first and last name of the student (no numbers allowed) and integer values between 0 and 100 for test marks. Press student 
 * average to find a studeent's average if they're already in the list, or calculate it directly. Click course average to get the average of the course. Max 15 students allowed.
 * Reset allows you to clear all values in the program.
 *
 * modified     20201016
 * date         20201015
 * @filename	StudentGrades.java
 * @author      jdalwadi
 * @version     1.0
 * @see         assignment 2.4
 * REFERENCE:
 * https://www.java67.com/2014/06/how-to-format-float-or-double-number-java-example.html#:~:text=format(%22%25.,float%20data%20type%20in%20Java. for decimal format
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class StudentGrades extends JFrame {
	DecimalFormat df = new DecimalFormat("#.##"); // used https://www.java67.com/2014/06/how-to-format-float-or-double-number-java-example.html#:~:text=format(%22%25.,float%20data%20type%20in%20Java. for decimal format
	Double test1, test2, test3, test4, studentAverage, courseAverage,total;
	String finalOutput = "";
	String [][] records = new String [15][7];
	int count = 0;
	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtTest1;
	private JTextField txtTest2;
	private JTextField txtTest3;
	private JTextField txtTest4;
	private JTextField txtCAverage;
	private JTextField txtSAverage;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentGrades frame = new StudentGrades();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public StudentGrades() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Student Grades");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(176, 6, 141, 16);
		contentPane.add(lblTitle);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(6, 39, 85, 16);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(6, 67, 85, 16);
		contentPane.add(lblLastName);
		
		JLabel lblTest1 = new JLabel("Test 1:");
		lblTest1.setBounds(16, 102, 61, 16);
		contentPane.add(lblTest1);
		
		JLabel lblTest2 = new JLabel("Test 2:");
		lblTest2.setBounds(16, 130, 61, 16);
		contentPane.add(lblTest2);
		
		JLabel lblTest3 = new JLabel("Test 3:");
		lblTest3.setBounds(16, 158, 61, 16);
		contentPane.add(lblTest3);
		
		JLabel lblTest4 = new JLabel("Test 4:");
		lblTest4.setBounds(16, 187, 61, 16);
		contentPane.add(lblTest4);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(87, 34, 130, 26);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(87, 62, 130, 26);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		txtTest1 = new JTextField();
		txtTest1.setBounds(87, 95, 130, 26);
		contentPane.add(txtTest1);
		txtTest1.setColumns(10);
		
		txtTest2 = new JTextField();
		txtTest2.setBounds(87, 125, 130, 26);
		contentPane.add(txtTest2);
		txtTest2.setColumns(10);
		
		txtTest3 = new JTextField();
		txtTest3.setBounds(87, 153, 130, 26);
		contentPane.add(txtTest3);
		txtTest3.setColumns(10);
		
		txtTest4 = new JTextField();
		txtTest4.setBounds(87, 182, 130, 26);
		contentPane.add(txtTest4);
		txtTest4.setColumns(10);
		
		JTextArea txtOutput = new JTextArea();
		txtOutput.setEditable(false);
		txtOutput.setRows(20);
		txtOutput.setColumns(10);
		txtOutput.setBounds(301, 34, 846, 287);
		contentPane.add(txtOutput);
		
		txtCAverage = new JTextField();
		txtCAverage.setEditable(false);
		txtCAverage.setColumns(10);
		txtCAverage.setBounds(16, 359, 261, 26);
		contentPane.add(txtCAverage);
		
		txtSAverage = new JTextField();
		txtSAverage.setEditable(false);
		txtSAverage.setColumns(10);
		txtSAverage.setBounds(16, 293, 251, 26);
		contentPane.add(txtSAverage);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(514, 359, 117, 29);
		contentPane.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOutput.setText(null);
				txtFirstName.setText(null);
				txtLastName.setText(null);
				txtTest1.setText(null);
				txtTest2.setText(null);
				txtTest3.setText(null);
				txtTest4.setText(null);
				txtCAverage.setText(null);
				txtSAverage.setText(null);
				count = 0;
				records = new String [15][7];
				finalOutput = "";
				
			}
		});
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(87, 220, 117, 29);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					records[count][0] = txtFirstName.getText();
					records[count][1] = txtLastName.getText();
					records[count][2] = txtTest1.getText();
					test1 = Double.parseDouble(records[count][2]);
					records[count][3] = txtTest2.getText();
					test2 = Double.parseDouble(records[count][3]);
					records[count][4] = txtTest3.getText();
					test3 = Double.parseDouble(records[count][4]);
					records[count][5] = txtTest4.getText();
					test4 = Double.parseDouble(records[count][5]);
					studentAverage = (test1 + test2 + test3 + test4)/4;

					// checks if there are integers in the names
					// used https://stackoverflow.com/questions/18590901/check-if-a-string-contains-numbers-java
					if(records[count][0].matches(".*\\d.*") || records[count][1].matches(".*\\d.*")) {
						JOptionPane.showMessageDialog(null, "Please enter VALID inputs. Test marks of at least 0 and maximum 100. Maximum 15 students. No numbers in names.");
						txtFirstName.setText(null);
						txtLastName.setText(null);
						txtTest1.setText(null);
						txtTest2.setText(null);
						txtTest3.setText(null);
						txtTest4.setText(null);
					}
					// checks if input is valid, if so, adds student information to the list
					else if (( test1 >= 0.0) &&(test2 >= 0.0) && (test3 >= 0.0) && (test4 >= 0.0) && ( test1 <= 100.0) &&(test2 <= 100.0) && (test3 <= 100.0) && (test4 <= 100.0) && count <15) {
						records[count][6] = String.valueOf(df.format(studentAverage));
						finalOutput += "First Name: " + records[count][0] + ", Last Name: " + records[count][1] + ". Test Marks: " + records[count][2] + ", " + records[count][3] + ", "+ records[count][4] + ", "+ records[count][5] + ". Average: " + records[count][6];
						finalOutput+= "\n";
						txtOutput.setText(finalOutput);
						count++;
						
					} else {
						JOptionPane.showMessageDialog(null, "Please enter VALID inputs. Test marks of at least 0 and maximum 100. Maximum 15 students. No numbers in names.");
						btnReset.doClick();
					}
				} catch (Exception e1){
					//displays error message
			    	JOptionPane.showMessageDialog(null, "Please enter VALID inputs. Test marks of at least 0 and maximum 100. Maximum 15 students. No numbers in names.");
					btnReset.doClick();
				}
			}
		});
		
		JButton btnStudentAverage = new JButton("Student Average");
		btnStudentAverage.setBounds(76, 261, 141, 29);
		contentPane.add(btnStudentAverage);
		btnStudentAverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = txtFirstName.getText() + " " + txtLastName.getText();
					// loops through records array and checks if student is already in there, retrieves their average
					for (int i = 0; i < records.length;i++) {
						if ((records[i][0]+" " +records[i][1]).toLowerCase().equals(name.toLowerCase())) {
							Double studentAverage = (Double.parseDouble(records[i][2])+Double.parseDouble(records[i][3])+Double.parseDouble(records[i][4])+Double.parseDouble(records[i][5]))/4;
							txtSAverage.setText(records[i][0] + " " + records[i][1] + "'s average is: " + String.valueOf(df.format(studentAverage)));
						}
					}

					// if the student average text field is still empty, calculate manually
					if (txtSAverage.getText().equals("")){
					records[count][0] = txtFirstName.getText();
					records[count][1] = txtLastName.getText();
					records[count][2] = txtTest1.getText();
					test1 = Double.parseDouble(records[count][2]);
					records[count][3] = txtTest2.getText();
					test2 = Double.parseDouble(records[count][3]);
					records[count][4] = txtTest3.getText();
					test3 = Double.parseDouble(records[count][4]);
					records[count][5] = txtTest4.getText();
					test4 = Double.parseDouble(records[count][5]);
					studentAverage = (test1 + test2 + test3 + test4)/4;

					// checks if there are integers in the names
					// used https://stackoverflow.com/questions/18590901/check-if-a-string-contains-numbers-java					
					if(records[count][0].matches(".*\\d.*") || records[count][1].matches(".*\\d.*")) {
						JOptionPane.showMessageDialog(null, "Please enter VALID inputs. Test marks of at least 0 and maximum 100. Maximum 15 students. No numbers in names.");
						txtFirstName.setText(null);
						txtLastName.setText(null);
						txtTest1.setText(null);
						txtTest2.setText(null);
						txtTest3.setText(null);
						txtTest4.setText(null);
					}
					else if (( test1 >= 0.0) &&(test2 >= 0.0) && (test3 >= 0.0) && (test4 >= 0.0) && ( test1 <= 100.0) &&(test2 <= 100.0) && (test3 <= 100.0) && (test4 <= 100.0) && count <15){						Double studentAverage = (test1 + test2 + test3 + test4)/4;
						records[count][6] = String.valueOf(df.format(studentAverage));
						txtSAverage.setText(records[count][0] + " " + records[count][1] + "'s average is: " + records[count][6]);
						count++;
					} 
					else {
						JOptionPane.showMessageDialog(null, "Please enter VALID inputs. Test marks of at least 0 and maximum 100. Maximum 15 students. No numbers in names.");
						txtFirstName.setText(null);
						txtLastName.setText(null);
						txtTest1.setText(null);
						txtTest2.setText(null);
						txtTest3.setText(null);
						txtTest4.setText(null);
					}
					} 
				}catch (Exception e1){
					// displays error message
			    		JOptionPane.showMessageDialog(null, "Please enter VALID inputs. Test marks of at least 0 and maximum 100. Maximum 15 students. No numbers in names.");
			    		btnReset.doClick();
			    	
				}
			
			}
		});
		
		JButton btnCourseAverage = new JButton("Course Average");
		btnCourseAverage.setBounds(76, 333, 141, 29);
		contentPane.add(btnCourseAverage);
		btnCourseAverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseOutput = "The course average is: ";
				total = 0.0;
				for (int i = 0; i < count; i++) {
					total += Double.valueOf(records[i][6]);
				}
				courseAverage = total/(Double.valueOf(count));
				//calculates course average and outputs in course average text field
				txtCAverage.setText(courseOutput + (df.format(courseAverage)));
				
				// checks if course array is empty. If so, sets course average text to empty
				if (txtOutput.getText().equals("")) {
					txtCAverage.setText("");

				}
			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(828, 359, 117, 29);
		contentPane.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		
	}
}
