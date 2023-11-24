import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class AddStudentGUI extends JFrame implements ActionListener {

    private  ArrayList<Student> list;

    public static void main(String[] args) {
    
    	new AddStudentGUI();
    }

    public AddStudentGUI() {
    	
    	list = new ArrayList<>();
    	
    	/** 1. The top-level container –Jframe is organized in a Borderlayout. */

        JFrame frame = new JFrame("Student Information System");
        //frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);
        frame.setLayout(new BorderLayout());

        /** 2. Two panels are added to the frame–panelNewStudent is added to the centre, and
        //panelButtonsis added to the bottom (south) */
        
        /** 3. PanelNewStudent has a TitledBorder with the title “New Student” and
        BevelBorderraised */
        
        JPanel panelNewStudent = new JPanel(); // create jpanel new student
        TitledBorder newStudent = BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "New Student");
        panelNewStudent.setBorder(newStudent);
        panelNewStudent.setLayout(new BorderLayout()); // set border layout

        frame.add(panelNewStudent, BorderLayout.CENTER); // add panelNewStudent to the frame
        
        // Panel for buttons in panelButtons
        JPanel panelButtons = new JPanel();
        frame.add(panelButtons, BorderLayout.SOUTH);
        
        JButton Finish = new JButton("Finish");
        panelButtons.add(Finish);
        
        JButton clearAll = new JButton("Clear All");
        panelButtons.add(clearAll);

        /** 4. PanelNewStudent layout is a BorderLayout. It holds three panels –panelAddStudent
        // in the north, panelShowStudent in the center, panelModules in the east. */
        
        // Create JPanel for Add Student
        JPanel panelAddStudent = new JPanel(); // create jpanel add student
        panelAddStudent.setLayout(new BoxLayout(panelAddStudent, BoxLayout.X_AXIS));

        panelNewStudent.add(panelAddStudent, BorderLayout.NORTH); // put panelAddStudent within panelNewStudnet

        /** 5. PanelAddStudent has a label saying “Name:”, a textField, with a default name “Peter
        Smith”. Another label saying “Address” and a textField with a default address “35 Liffey
        Street, Dublin 2”. Button “Submit” and button“Clear”. */
        
        // Labels and TextFields for panelAddstudents within panelNewStudent
        JLabel nameLabel = new JLabel("Name:");
        panelAddStudent.add(nameLabel);

        JTextField nameTextField = new JTextField("Peter Smith");
        nameTextField.setEditable(true);
        panelAddStudent.add(nameTextField);

        JLabel addressLabel = new JLabel("Address:");
        panelAddStudent.add(addressLabel);

        JTextField addressTextField = new JTextField("35 Liffey Street, Dublin 2");
        addressTextField.setEditable(true);
        panelAddStudent.add(addressTextField);

        // Buttons for panelAddStudents within panelNewStudent
        JButton btnSubmit = new JButton("Submit");
        panelAddStudent.add(btnSubmit);

        JButton clearButton = new JButton("Clear");
        panelAddStudent.add(clearButton);

        /** 6. PanelShowStudents has a borderLayout. It has a label StudentList in the north of the
        border, and textArea txtrShowStudents in the center. */
        
        // Panel for showing student details within panelNewStudent
        JPanel panelShowStudents = new JPanel(); // create
        panelNewStudent.add(panelShowStudents, BorderLayout.CENTER); // add panelShowStudent to center of panelNewStudent
        panelShowStudents.setLayout(new BorderLayout()); // set layout
        
        // Label the panel
        JLabel studentList = new JLabel("Student List:");
        panelShowStudents.add(studentList, BorderLayout.NORTH);
        
        // Textarea to display student details
       JTextArea txtrShowStudents = new JTextArea(); // create a text area
       panelShowStudents.add(txtrShowStudents, BorderLayout.CENTER); // put it in the center
       txtrShowStudents.setEditable(false);
       
       /** 7. PanelModules layout is GridLayout of one column and two rows. It holds a panel
       with thecheckboxes (panelCheckBoxes) and a textarea. */
       
       // PanelModules for checkboxes and textarea
       JPanel panelModules = new JPanel();
       panelNewStudent.add(panelModules, BorderLayout.EAST);
       panelModules.setLayout(new GridLayout(2, 1)); // set grid layout 2 rows and column
       panelModules.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 2));
       
       /** 7 a. PanelCheckBoxes layout is GridLayout with one column and zero row. It
       holds three checkboxes for different modules. Each check box should have a
       listener associated with it – whenever a state of the checkbox’s changes – the
       text area below should show the current selection */
       
       JPanel panelCheckBoxes = new JPanel(); // create panel for checkboxes
       panelCheckBoxes.setLayout(new GridLayout(0, 1)); // rows 1 collummn
       
       //Create 3 checkboxes
       JCheckBox databases = new JCheckBox("Databases");
       panelCheckBoxes.add(databases);
       
       JCheckBox java = new JCheckBox("Java");
       panelCheckBoxes.add(java);
       
       JCheckBox accountancy = new JCheckBox("Accountancy");
       panelCheckBoxes.add(accountancy);
       
       panelModules.add(panelCheckBoxes); // add panelCheckboxes within panelModules
       
       JTextArea txtrShowModules = new JTextArea(); // text area for modules
       panelModules.add(txtrShowModules); // add text area within panelModules
       txtrShowModules.setEditable(false);
             
      
       {
    	   /** 5 a. When Submit button (btnSubmit) is clicked a name written in the textField and
    	   an address written in the textField should be added to the list called
    	   “studentList” and then the list should be printed in the text area below
    	   (txtrShowStudents). */
    	   
    	   btnSubmit.addActionListener(new ActionListener() {
    		    public void actionPerformed(ActionEvent e) {
    		        String name = nameTextField.getText();
    		        String address = addressTextField.getText();

    		        // Create a new Student object
    		        Student student = new Student(name, address);

    		        // Add the Student object to the list
    		        list.add(student);

    		        // Clear the student list text area
    		        txtrShowStudents.setText("");

    		        // Update the text area with the updated student list
    		        for (Student s : list) {
    		            txtrShowStudents.append(s.toString());
    		        }
    		    }
    		});
       
    	  /** 5 b. When “Clear” button is clicked, it should clear the student’s name and student
    	   address fields */
    	   
       clearButton.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        nameTextField.setText(""); // Clear the name field
    	        addressTextField.setText(""); // Clear the address field
    	    }
    	});

      /** (Contnued) 7 a. PanelCheckBoxes layout is GridLayout with one column and zero row. It
       holds three checkboxes for different modules. Each check box should have a
       listener associated with it – whenever a state of the checkbox’s changes – the
       text area below should show the current selection */
       
       databases.addItemListener(new ItemListener() {
    	    public void itemStateChanged(ItemEvent e) {
    	        JCheckBox databases = (JCheckBox) e.getItem();
    	        if (e.getStateChange() == ItemEvent.SELECTED) {
    	            databases.setText("Databases");
    	            txtrShowModules.append("Databases\n");
    	        } else {
    	            // Remove "Databases" from the text area
    	            String currentText = txtrShowModules.getText();
    	            currentText = currentText.replace("Databases\n", "");
    	            txtrShowModules.setText(currentText);
    	        }
    	    }
    	});
       
       java.addItemListener(new ItemListener() {
   	    public void itemStateChanged(ItemEvent e) {
   	        JCheckBox java = (JCheckBox) e.getItem();
   	        if (e.getStateChange() == ItemEvent.SELECTED) {
   	            java.setText("Java");
   	            txtrShowModules.append("Java\n");
   	        } else {
   	            // Remove "Java" from the text area
   	            String currentText = txtrShowModules.getText();
   	            currentText = currentText.replace("Java\n", "");
   	            txtrShowModules.setText(currentText);
   	        }
   	    }
   	});
       
       accountancy.addItemListener(new ItemListener() {
   	    public void itemStateChanged(ItemEvent e) {
   	        JCheckBox accountancy = (JCheckBox) e.getItem();
   	        if (e.getStateChange() == ItemEvent.SELECTED) {
   	            accountancy.setText("Accountancy");
   	            txtrShowModules.append("Accountancy\n");
   	        } else {
   	            // Remove "Accountancy" from the text area
   	            String currentText = txtrShowModules.getText();
   	            currentText = currentText.replace("Accountancy\n", "");
   	            txtrShowModules.setText(currentText);
   	        }
   	    }
   	});
       
       /** 8. Finish button should close the window */
       
       Finish.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               frame.dispose(); // Close the window
           }
       });
       
      /** 9. Clear All button should clear all the selections (the text fields, the text area, and
    		   the check boxes). */
       
       clearAll.addActionListener(new ActionListener() {
   	    public void actionPerformed(ActionEvent e) {
   	        // Clear the name and address text fields
   	        nameTextField.setText("");
   	        addressTextField.setText("");

   	        // Clear the student list text area
   	        txtrShowStudents.setText("");

   	        // Unselect all checkboxes
   	        databases.setSelected(false);
   	        java.setSelected(false);
   	        accountancy.setSelected(false);

   	        // Clear the modules text area
   	        txtrShowModules.setText("");
   	    }
   	});
       
       frame.pack();
        frame.setVisible(true);
       };
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

