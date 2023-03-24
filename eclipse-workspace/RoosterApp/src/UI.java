import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;

public class UI {

	private JFrame frame;
	private School school;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					School my_school = new School();
					UI window = new UI(my_school);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setVisible(boolean parameter1)
	{
		this.frame.setVisible(parameter1);
	}
	
	

	/**
	 * Create the application.
	 */
	public UI(School my_school) {
		this.school = my_school;
		
		initialize();
	}
	
	public void showContent()
	{
		//frame.removeAll();
		System.out.println("test");
		frame.repaint();
		//initialize();
		//frame.setVisible(true);
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		
////////////////////// SET FRAME /////////////////////////////
		
		frame = new JFrame();
		frame.setName("frame_classrooms_rooster");
		frame.setBounds(100, 100, 500, 980);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
//////////////////////SET APP TITLE /////////////////////////////	
		
		JLabel label_title = new JLabel("Classroom rooster - BS De Bochuil, Eindhoven");
		label_title.setFont(new Font("Akrobat", Font.BOLD, 20));
		label_title.setBounds(30, 15, 420, 29);
		frame.getContentPane().add(label_title);
		
		
////////////////////// Dynamically LOAD drop-down list TEACHERS /////////////////////////////
		
		// Create drop-down list element
		JComboBox<String> comboBox_teacher = new JComboBox<String>();
		ArrayList<Teacher> my_teachers = this.school.getAllTeachers();
		String teacher_name = "";
		
		// Generate list items
		for ( int i =0; i < my_teachers.size(); i++)
		{
			teacher_name = my_teachers.get(i).name + " " + my_teachers.get(i).surname + " (" + my_teachers.get(i).specialty + ")";
			comboBox_teacher.addItem(teacher_name);
		}

		// Positioning on the screen
		comboBox_teacher.setBounds(30, 68, 420, 20);
		frame.getContentPane().add(comboBox_teacher);
		
		
////////////////////// Dynamically LOAD drop-down list STUDENTS /////////////////////////////
		
		// Create drop-down list element
		JComboBox<String> comboBox_student = new JComboBox<String>();
		ArrayList<Student> my_students = this.school.getAllStudents();
		String student_name = "";
		
		// Generate list items
		for ( int i =0; i < my_students.size(); i++)
		{
			student_name = my_students.get(i).name + " " + my_students.get(i).surname;
			comboBox_student.addItem(student_name);
		}
		
		// Positioning on the screen
		comboBox_student.setBounds(30, 99, 420, 20);
		frame.getContentPane().add(comboBox_student);


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		

		
		
		int x_Position = 30;
		int y_Position = 200;
		final JLabel label_num_students = null;
		for (int i=0; i<this.school.allClassroomArray.size(); i++ ) {
			Classroom classroom = this.school.allClassroomArray.get(i);
			//System.out.println(classroom.name);
			
			y_Position = 200;
			JLabel label_classroom = new JLabel(classroom.name);
			label_classroom.setFont(new Font("Akrobat", Font.BOLD, 20));
			label_classroom.setBounds(x_Position, 150, 110, 29);
			frame.getContentPane().add(label_classroom);
			
			JLabel label_value_booked = new JLabel("42");
			label_value_booked.setForeground(Color.BLACK);
			label_value_booked.setFont(new Font("Akrobat", Font.PLAIN, 16));
			label_value_booked.setBounds(x_Position, 185, 16, 29);
			frame.getContentPane().add(label_value_booked);
			
			JLabel label_string_procent = new JLabel("% booked");
			label_string_procent.setForeground(Color.BLACK);
			label_string_procent.setFont(new Font("Akrobat", Font.PLAIN, 16));
			label_string_procent.setBounds(x_Position+20, 185, 89, 29);
			frame.getContentPane().add(label_string_procent);
			
			JProgressBar progressBar_classrom = new JProgressBar();
			progressBar_classrom.setBackground(Color.LIGHT_GRAY);
			progressBar_classrom.setForeground(Color.RED);
			progressBar_classrom.setValue(80);
			progressBar_classrom.setBounds(x_Position, 215, 168, 9);
			frame.getContentPane().add(progressBar_classrom);
			
			for (String day : this.school.openDays ) {
				y_Position += 40;
				JLabel label_day = new JLabel(day);
				label_day.setForeground(Color.BLACK);
				label_day.setFont(new Font("Akrobat", Font.BOLD, 14));
				label_day.setBounds(x_Position, y_Position, 89, 29);
				frame.getContentPane().add(label_day);
				
				JLabel label_students = new JLabel("Students");
				label_students.setForeground(Color.BLACK);
				label_students.setFont(new Font("Akrobat", Font.BOLD, 14));
				label_students.setBounds(x_Position+120, y_Position, 49, 29);
				frame.getContentPane().add(label_students);
				y_Position += 10;
				//System.out.println(classroom.allAvailableHoursArray.size());
				for (int j=0; j<classroom.allAvailableHoursArray.size(); j++ ) {
					
					AvailableHour available = classroom.allAvailableHoursArray.get(j);
					if (day.equals(available.day)==false) continue;
					
					String hour = available.hour;
					y_Position += 20;
					JRadioButton rdbtn_hour = new JRadioButton(hour);
					buttonGroup.add(rdbtn_hour);
					rdbtn_hour.setBounds(x_Position, y_Position , 111, 23);
					rdbtn_hour.setActionCommand(i+"_"+j);
					frame.getContentPane().add(rdbtn_hour);
					
					
					label_num_students = new JLabel(Integer.toString(available.nr_booked));
					label_num_students.setForeground(Color.BLACK);
					label_num_students.setFont(new Font("Akrobat", Font.PLAIN, 14));
					label_num_students.setBounds(x_Position+120, y_Position, 16, 23);
					frame.getContentPane().add(label_num_students);
					
					if (available.nr_booked >= classroom.max_people )
						rdbtn_hour.setEnabled(false);
				}
			}
			x_Position += 230 ;
		}
			
		
		
/////////////////////////////////////////////// Element BUTTON "Reserve classroom" /////////////////////////////////////////////
		
		// Create button
		JButton btn_reserve = new JButton("Reserve classroom");
		btn_reserve.setFont(new Font("Akrobat", Font.BOLD, 16));
		btn_reserve.setBackground(new Color(153, 204, 0));
		btn_reserve.setActionCommand("UpdateClassroomRooster");
		
		// Positioning on the screen
		btn_reserve.setBounds(30, 810, 422, 40);
		frame.getContentPane().add(btn_reserve);		
		
		// Info labels under the button "Reserve classroom"  
		JLabel label_attention = new JLabel("NO SELECTION!");
		label_attention.setVisible(false);
		label_attention.setForeground(Color.RED);
		label_attention.setBounds(30, 880, 420, 15); 
		frame.getContentPane().add(label_attention);
		
		JLabel label_status_reservation = new JLabel("RESERVATION DONE!");
		label_status_reservation.setVisible(false);
		label_status_reservation.setForeground(new Color(0, 128, 0));
		label_status_reservation.setBounds(30, 880, 420, 15); 
		frame.getContentPane().add(label_status_reservation);
		
		JLabel label_reservation_data1 = new JLabel("Student subscribed for subject (teacher)");
		label_reservation_data1.setVisible(false);
		label_reservation_data1.setForeground(new Color(0, 128, 0));
		label_reservation_data1.setBounds(30, 900, 420, 15);
		frame.getContentPane().add(label_reservation_data1);
		
		JLabel label_reservation_data2 = new JLabel("on DAY at TIME in CR.");
		label_reservation_data2.setVisible(false);
		label_reservation_data2.setForeground(new Color(0, 128, 0));
		label_reservation_data2.setBounds(30, 915, 420, 15); 
		frame.getContentPane().add(label_reservation_data2);
				
	
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////// BUTTON FUNCTIONALLITY////////////////////////////////////////////////////////////////////////
		
		System.out.println(" ");
		
		btn_reserve.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//System.out.println("Selected values:");
				label_status_reservation.setVisible(true);
				int classroom_nr = 0;
				int available_nr = 0;
				for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) 
				{
			        AbstractButton button = buttons.nextElement();
			        if (button.isSelected()) 
			        {
			        	//System.out.println("Selected RadioButton: " + button.getActionCommand()); 
			        	classroom_nr = Integer.parseInt(button.getActionCommand().split("_")[0]);
			        	available_nr = Integer.parseInt(button.getActionCommand().split("_")[1]);
			        	
			        	//school.allClassroomArray.get(classroom_nr).addBooking(available_nr);
			        	if (school.allClassroomArray.get(classroom_nr).allAvailableHoursArray.get(available_nr).nr_booked < school.allClassroomArray.get(classroom_nr).max_people)		
			        	{
			        		school.allClassroomArray.get(classroom_nr).allAvailableHoursArray.get(available_nr).nr_booked += 1; // getal in de geheugen
			        		label_num_students.setText("" + school.allClassroomArray.get(classroom_nr).allAvailableHoursArray.get(available_nr).nr_booked); // label met de getal waarde. die label moet repaint worden
			        		if (school.allClassroomArray.get(classroom_nr).allAvailableHoursArray.get(available_nr).nr_booked == school.allClassroomArray.get(classroom_nr).max_people)
			        		{
			        			button.setEnabled(false);
			        		}
			        	}
			        	
			        	System.out.println("Subscribed students: " + school.allClassroomArray.get(classroom_nr).allAvailableHoursArray.get(available_nr).nr_booked);
			        		
			        }
			    }
								
				System.out.println("Teacher: " + comboBox_teacher.getSelectedItem().toString());
				System.out.println("Student: " + comboBox_student.getSelectedItem().toString());
				System.out.println("class room: " + school.allClassroomArray.get(classroom_nr).name);
				System.out.println("day: " + school.allClassroomArray.get(classroom_nr).allAvailableHoursArray.get(available_nr).day );
				System.out.println("hour: " +  school.allClassroomArray.get(classroom_nr).allAvailableHoursArray.get(available_nr).hour);
				System.out.println(" ");
				
				label_status_reservation.setVisible(true);
				//showContent();  // Reloads the frame and updates the number of students, subscribed for the selected CR, day and hour
				frame.repaint();
				frame.setVisible(true);
				
			} // End of actionPerformed(ActionEvent e)

		}); // End of btn_reserve.addActionListener

		frame.repaint();
		frame.setVisible(true);
	} // End of initialize() 
	
} // End of class UI
