import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.SwingConstants;

class User extends JFrame {

	private JPanel contentPane;
	public JTextField classesText;
	public JTextField gradesText;
	public String classesAndGrades = "";
	private JTextField locationText;
	public JButton btnRun;
	public JTextField freeTimeText;
	public JLabel lblEnterFreeTime;
	public int timeSpent;
	public int numAp = 0;
	public int numH = 0;
	public int numClasses = 0;
	private JTextField class1Text;
	private JTextField class2Text;
	private JTextField class3Text;
	private JTextField tutorText;
	private JTextField class4Text;
	private JTextField class5Text;
	private JTextField class6Text;
	private JTextField class7Text;
	public JLabel class1Label;
	public JLabel class2Label;
	public JLabel class3Label;
	public JLabel class4Label;
	public JLabel class5Label;
	public JLabel class6Label;
	public JLabel class7Label;
	private JLabel extraTimeLabel;
	private JTextField extraTimeText;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
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
	public User() {
		setBackground(new Color(0, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 539);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		contentPane.add(panel, null);
		panel.setLayout(null);
		

		gradesText = new JTextField();
		gradesText.setBounds(155, 62, 331, 26);
		panel.add(gradesText);
		gradesText.setColumns(10);
		gradesText.addActionListener(new customListener());

		classesText = new JTextField();
		classesText.setForeground(new Color(0, 0, 0));
		classesText.setBackground(new Color(255, 255, 255));
		classesText.setBounds(46, 115, 440, 39);
		panel.add(classesText);
		classesText.setColumns(10);
		classesText.addActionListener(new customListener());

		JLabel lblEnterGrades = new JLabel("Enter Grades:");
		lblEnterGrades.setFont(new Font("Yuppy SC", Font.PLAIN, 13));
		lblEnterGrades.setBounds(46, 65, 97, 21);
		panel.add(lblEnterGrades);

		JLabel lblEnterClasses = new JLabel("Enter Classes(Please enter AP and H in uppercase):");
		lblEnterClasses.setFont(new Font("Yuanti SC", Font.PLAIN, 13));
		lblEnterClasses.setBounds(46, 98, 296, 16);
		panel.add(lblEnterClasses);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(155, 36, 1, 1);
		panel.add(desktopPane);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(92, 17, 1, 1);
		panel.add(layeredPane);

		locationText = new JTextField();
		locationText.setBounds(155, 36, 331, 26);
		panel.add(locationText);
		locationText.setColumns(10);

		JLabel lblNewLabel = new JLabel("Enter Location:");
		lblNewLabel.setFont(new Font("Yuanti SC", Font.PLAIN, 13));
		lblNewLabel.setBounds(46, 36, 97, 16);
		panel.add(lblNewLabel);

		btnRun = new JButton("RUN");
		btnRun.setBounds(177, 148, 117, 29);
		panel.add(btnRun);
		btnRun.addActionListener(new customListener());

		freeTimeText = new JTextField();
		freeTimeText.setBounds(252, 12, 234, 26);
		panel.add(freeTimeText);
		freeTimeText.setColumns(10);

		lblEnterFreeTime = new JLabel("Enter Free Time (Hours In A Week): ");
		lblEnterFreeTime.setFont(new Font("Yuanti SC", Font.PLAIN, 13));
		lblEnterFreeTime.setBounds(46, 17, 208, 16);
		panel.add(lblEnterFreeTime);

		class1Label = new JLabel("Class 1 Time:");
		class1Label.setFont(new Font("Yuanti SC", Font.PLAIN, 13));
		class1Label.setBounds(46, 175, 97, 16);
		panel.add(class1Label);

		class1Text = new JTextField();
		class1Text.setBounds(125, 170, 361, 26);
		panel.add(class1Text);
		class1Text.setColumns(10);

		class2Label = new JLabel("Class 2 Time:");
		class2Label.setFont(new Font("Yuanti SC", Font.PLAIN, 13));
		class2Label.setBounds(46, 194, 97, 16);
		panel.add(class2Label);

		class2Text = new JTextField();
		class2Text.setBackground(new Color(255, 255, 255));
		class2Text.setBounds(125, 189, 361, 26);
		panel.add(class2Text);
		class2Text.setColumns(10);

		class4Label = new JLabel("Class 4 Time:");
		class4Label.setFont(new Font("Yuanti SC", Font.PLAIN, 13));
		class4Label.setBounds(46, 232, 97, 16);
		panel.add(class4Label);

		class3Text = new JTextField();
		class3Text.setBackground(new Color(255, 255, 255));
		class3Text.setBounds(125, 208, 361, 26);
		panel.add(class3Text);
		class3Text.setColumns(10);

		JLabel lblGetATutor = new JLabel("Get a Tutor From: ");
		lblGetATutor.setFont(new Font("Yuanti SC", Font.PLAIN, 14));
		lblGetATutor.setBounds(13, 337, 130, 16);
		panel.add(lblGetATutor);

		tutorText = new JTextField();
		tutorText.setHorizontalAlignment(SwingConstants.LEFT);
		tutorText.setBounds(6, 357, 505, 93);
		panel.add(tutorText);
		tutorText.setColumns(10);

		class3Label = new JLabel("Class 3 Time:");
		class3Label.setFont(new Font("Yuanti SC", Font.PLAIN, 13));
		class3Label.setBounds(46, 213, 85, 16);
		panel.add(class3Label);

		class4Text = new JTextField();
		class4Text.setBounds(125, 227, 361, 26);
		panel.add(class4Text);
		class4Text.setColumns(10);

		class5Label = new JLabel("Class 5 Time: ");
		class5Label.setFont(new Font("Yuanti SC", Font.PLAIN, 13));
		class5Label.setBounds(46, 252, 97, 16);
		panel.add(class5Label);

		class5Text = new JTextField();
		class5Text.setBounds(125, 246, 361, 26);
		panel.add(class5Text);
		class5Text.setColumns(10);

		class6Text = new JTextField();
		class6Text.setBounds(125, 283, 361, 26);
		panel.add(class6Text);
		class6Text.setColumns(10);

		class6Label = new JLabel("Class 6 Time:");
		class6Label.setFont(new Font("Yuanti SC", Font.PLAIN, 13));
		class6Label.setBounds(46, 269, 85, 16);
		panel.add(class6Label);

		class7Label = new JLabel("Class 7 Time: ");
		class7Label.setFont(new Font("Yuanti SC", Font.PLAIN, 13));
		class7Label.setBounds(46, 288, 97, 16);
		panel.add(class7Label);

		class7Text = new JTextField();
		class7Text.setBounds(125, 264, 361, 26);
		panel.add(class7Text);
		class7Text.setColumns(10);
		
		extraTimeLabel = new JLabel("Extra Time: ");
		extraTimeLabel.setBounds(46, 307, 75, 16);
		panel.add(extraTimeLabel);
		
		extraTimeText = new JTextField();
		extraTimeText.setBounds(125, 302, 361, 26);
		panel.add(extraTimeText);
		extraTimeText.setColumns(10);

		JLabel lblGradesdontmatter = new JLabel("Grades Dont Matter");
		lblGradesdontmatter.setBackground(new Color(255, 0, 255));
		lblGradesdontmatter.setForeground(Color.BLACK);
		lblGradesdontmatter.setFont(new Font("Yuanti SC", Font.PLAIN, 27));
		contentPane.add(lblGradesdontmatter, BorderLayout.NORTH);
	}

	public class customListener implements ActionListener {
		  
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == gradesText) {
				classesAndGrades = gradesText.getText();
				getClasses();
				System.out.println(classList);
			} else if (e.getSource() == classesText) {
				classesAndGrades = gradesText.getText();
				getClasses();
				System.out.println(classList);
			} else if (e.getSource() == btnRun) {
				System.out.println("num" + numClasses);
				getClasses();
				//getPriority();
				changeText();
				
				System.out.println("Class List " + classList);
			}

		}

		public ArrayList<Double> classTime = new ArrayList<Double>();
		
		public void changeText() {
			YelpAPICLI yelpApiCli = new YelpAPICLI("tutor", locationText.getText());
		    new JCommander(yelpApiCli);

		    YelpAPI yelpApi = new YelpAPI();
		    String[] results = YelpAPI.queryAPI(yelpApi, yelpApiCli);
			
			tutorText.setText("Name: " + results[0] + " " + " Phone#"+":  " + results[1] );
			
			setLabels();
			setTimes();

		}
		
		public void setTime() {
			
			setToken();
			System.out.println("token" +tokenList.length);
			int totalTokens = 0;
			for(int i = 0; i < tokenList.length; i++){
				totalTokens+= tokenList[i];
			}
			double percent = ((double)(100/(totalTokens)));
			System.out.println("cent " +percent);
			for(int i = 0; i < tokenList.length; i++){
				System.out.println("list num = " + percent + " * " + tokenList[i]);
				tokenList[i] = (percent * (double)(tokenList[i]));
				System.out.println("brain" + tokenList[i]);
			}
			for (int i = 0; i < classList.size(); i++) {
				classTime.add(((tokenList[i] * (Double.parseDouble((freeTimeText.getText().replaceAll("\\s+", ""))))))/100);
			}
			int difference = (Integer.parseInt(freeTimeText.getText().replaceAll("\\s+", "")));
			for(int i = 0; i< classList.size();i++){
				difference -= classTime.get(i);
			}
			extraTimeText.setText("" + difference + " hours");
			System.out.println("Times " + classTime);
		}

		private void setTimes() {
			setTime();
			if (classList.size() > 6) {
				class7Text.setText("" + classTime.get(6) + " hours");
				class6Text.setText("" + classTime.get(5) + " hours");
				class5Text.setText("" + classTime.get(4) + " hours");
				class4Text.setText("" + classTime.get(3) + " hours");
				class3Text.setText("" + classTime.get(2) + " hours");
				class2Text.setText("" + classTime.get(1) + " hours");
				class1Text.setText("" + classTime.get(0) + " hours");
			} else if (classList.size() > 5) {
				class6Text.setText("" + classTime.get(5) + " hours");
				class5Text.setText("" + classTime.get(4) + " hours");
				class4Text.setText("" + classTime.get(3) + " hours");
				class3Text.setText("" + classTime.get(2) + " hours");
				class2Text.setText("" + classTime.get(1) + " hours");
				class1Text.setText("" + classTime.get(0) + " hours");
			} else if (classList.size() > 4) {
				class5Text.setText("" + classTime.get(4) + " hours");
				class4Text.setText("" + classTime.get(3) + " hours");
				class3Text.setText("" + classTime.get(2) + " hours");
				class2Text.setText("" + classTime.get(1) + " hours");
				class1Text.setText("" + classTime.get(0) + " hours");
			} else if (classList.size() > 3) {
			class4Text.setText("" + classTime.get(3) + " hours");
			class3Text.setText("" + classTime.get(2) + " hours");
			class2Text.setText("" + classTime.get(1) + " hours");
			class1Text.setText("" + classTime.get(0) + " hours");
			} else if (classList.size() > 2) {
				class3Text.setText("" + classTime.get(2) + " hours");
				class2Text.setText("" + classTime.get(1) + " hours");
				class1Text.setText("" + classTime.get(0) + " hours");
			} else if (classList.size() > 1) {
				class2Text.setText("" + classTime.get(1) + " hours");
				class1Text.setText("" + classTime.get(0) + " hours");
			} else if (classList.size() > 0) {
				class1Text.setText("" + classTime.get(0) + " hours");
			}

		}

		private void setLabels() {
			if (classList.size() > 6) {
				class7Label.setText(classList.get(6));
				class6Label.setText(classList.get(5));
				class5Label.setText(classList.get(4));
				class4Label.setText(classList.get(3));
				class3Label.setText(classList.get(2));
				class2Label.setText(classList.get(1));
				class1Label.setText(classList.get(0));
			} else if (classList.size() > 5) {
				class6Label.setText(classList.get(5));
				class5Label.setText(classList.get(4));
				class4Label.setText(classList.get(3));
				class3Label.setText(classList.get(2));
				class2Label.setText(classList.get(1));
				class1Label.setText(classList.get(0));
			} else if (classList.size() > 4) {
				class5Label.setText(classList.get(4));
				class4Label.setText(classList.get(3));
				class3Label.setText(classList.get(2));
				class2Label.setText(classList.get(1));
				class1Label.setText(classList.get(0));
			} else if (classList.size() > 3) {
				class4Label.setText(classList.get(3));
				class3Label.setText(classList.get(2));
				class2Label.setText(classList.get(1));
				class1Label.setText(classList.get(0));
			} else if (classList.size() > 2) {
				class3Label.setText(classList.get(2));
				class2Label.setText(classList.get(1));
				class1Label.setText(classList.get(0));
			} else if (classList.size() > 1) {
				class2Label.setText(classList.get(1));
				class1Label.setText(classList.get(0));
			} else if (classList.size() > 0) {
				class1Label.setText(classList.get(0));
			}
		}

		private String getAnswer2() {
			return getTimeForApClass() + "\n" + getTimePerHClass() + "\n" + getTimePerClass();
		}

		private String getAnswer1() {
			return getTutors();
		}

		public ArrayList<String> classList = new ArrayList<String>();
		public ArrayList<String> newClassList = new ArrayList<String>();
		public ArrayList<String> locations = new ArrayList<String>(
				Arrays.asList("San Jose", "San Fransisco", "Palo Alto", "Los Altos", "Fremont"));
		public ArrayList<String> people = new ArrayList<String>(Arrays.asList("Elite Tutoring",
				"Russian School Of Math", "Kumon", "TutorSync", "C2 Education of Fremont"));
		public ArrayList<String> gradeList = new ArrayList<String>();
		public ArrayList<String> wantedGrades = new ArrayList<String>();

		public void getClasses() {
			String classesAndGrades = classesText.getText();
			String classes = "";
			System.out.println(classesText.getText());
			for (int i = 0; i < classesAndGrades.length(); i++) {
				if (classesAndGrades.charAt(i) != ' ' && classesAndGrades.charAt(i) != ',') {
					classes += classesAndGrades.charAt(i);
				}
				if (classesAndGrades.charAt(i) == ',' || i == classesAndGrades.length() - 1) {
					classList.add(classes);
					numClasses++;
					classes = "";
				}

				if (classesAndGrades.charAt(i) == ('H')) {
					numH++;
					System.out.println("found");
				}
				if (i != classesAndGrades.length() - 2 && classesAndGrades.charAt(i) == 'A'
						&& classesAndGrades.charAt(i + 1) == 'P') {
					numAp++;
				}

			}
			System.out.println("AP" + numAp + "H" + numH);
		}

		public String getTutors() {
			for (int i = 0; i < locations.size(); i++) {
				if (locationText.getText().equals(locations.get(i))) {
					return people.get(i);
				}
			}
			return null;
		}

		public String getTimeForApClass() {
			System.out.println("time " + freeTimeText.getText() + "classes " + numClasses);

			int time = Integer.parseInt(freeTimeText.getText());
			int averageTime = (int) (((time / numClasses) * 3) / numAp);
			return averageTime + " hours";

		}

		public String getTimePerHClass() {
			int time = Integer.parseInt(freeTimeText.getText());
			int averageTime = (int) (((time / numClasses) * 2) / numH);
			return averageTime + " hours";

		}

		public String getTimePerClass() {
			int time = Integer.parseInt(freeTimeText.getText().replaceAll("\\s+", ""));
			int averageTime = (time - (int) (((time / numClasses) * 2)) - (int) (((time / numClasses))))
					/ (numClasses - numAp - numH);
			return averageTime + " hours";
		}

		public String getGradesList() {
			String grade = "";
			for (int i = 0; i < gradesText.getText().length(); i++) {
				if (gradesText.getText().charAt(i) != ',' && gradesText.getText().charAt(i) != ' ') {
					grade += gradesText.getText().charAt(i);
				}
			}
			return grade;
		}

		

		private int getApOrH(String string) {
			for (int i = 0; i < string.length(); i++) {
				if (string.charAt(i) == 'H' && (i == 0 || i == string.length() - 1)) {
					return 1;
				}
				if (string.charAt(i) == 'A' && string.charAt(i + 1) == 'P' && (i == 0 || i == string.length() - 2)) {
					return 2;
				}
			}
			return 0;
		}

		private int assignNum(char grade) {
			if (grade == 'A' || grade == 'a') {
				return 4;
			} else if (grade == 'B' || grade == 'b') {
				return 3;
			} else if (grade == 'C' || grade == 'c') {
				return 2;
			} else if (grade == 'D' || grade == 'd') {
				return 1;
			} else {
				return 0;
			}
		}
		public double[] tokenList;
		
		public void setToken(){
			 tokenList = new double[classList.size()];
			for(int i =0; i < classList.size(); i++){
				if(getApOrH(classList.get(i)) == 2){
					tokenList[i] = tokenList[i]+ 2;
				}else if(getApOrH(classList.get(i)) == 1){
					tokenList[i] += 1;
 				}
				if(assignNum(getGradesList().charAt(i)) == 3){
					tokenList[i] += 1;
				}else if(assignNum(getGradesList().charAt(i)) == 2){
					tokenList[i] += 2;
				}else if(assignNum(getGradesList().charAt(i)) == 1){
					tokenList[i] += 3;
				}else if(assignNum(getGradesList().charAt(i)) == 0){
					tokenList[i] += 4;
				}
				
				
			}
			for(int i =0; i < classList.size(); i++){
				if(tokenList[i] == 0){
					tokenList[i] = 1;
				}
			}
			
		}
		
	}
}



