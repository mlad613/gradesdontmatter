import java.util.ArrayList;
import java.util.Scanner;

public class Organize {
	
	public static void main(String[] args){
		takeInGiven();
		findDesiredGrades();
	}
	public static ArrayList<String> classList = new ArrayList<String>(); 
	public static ArrayList<String> gradeList = new ArrayList<String>(); 
	public static ArrayList<String> wantedGrades = new ArrayList<String>(); 
	public int timeSpent; 
	private static void takeInGiven() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you need help in any class?");
		String givenClass = sc.next(); 
		String response = "yes"; 
		while(!(response.equalsIgnoreCase("no"))){
			System.out.println("What class?");
			givenClass = sc.next(); 
			classList.add(givenClass); 
			System.out.println("What grade did you recieve in this class");
			String grade = sc.next(); 
			gradeList.add(grade);
			System.out.println("Are there any other classes?");
			response = sc.next();
		}
		System.out.println(classList);
		System.out.println(gradeList);
	}
	
	public static void findDesiredGrades(){
		Scanner sc1 = new Scanner(System.in);
		for(int i = 0; i < classList.size(); i++){
			System.out.println("What grade would u like in " + classList.get(i));
			wantedGrades.add(sc1.next());
		}
		System.out.println(wantedGrades);
	}
	
}


