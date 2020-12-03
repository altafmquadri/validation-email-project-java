package validationemailproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

	private String emailAddress;
	
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public Email(String emailAddress) {
		super();
		this.emailAddress = emailAddress;
	}
	

	@Override
	public String toString() {
		return emailAddress;
	}
	
	public static final String regex = "^([A-Za-z0-9\\-_.]+)@(.+)$";

	public static void main(String[] args) {
		List<Email> emailList = new ArrayList<Email>();		
		emailList.add(new Email("altafmquadri@gmail.com"));
		emailList.add(new Email("ozhorov@gmail.com"));
		emailList.add(new Email("ozhorov@gmail.com"));
		
		Pattern pattern = Pattern.compile(regex);
		Scanner scanner = new Scanner(System.in);
		
		int counter = 0;
		
		while (counter != 1) {
			System.out.println("Please enter an email address: ");
			
			String emailAddress = scanner.nextLine().toLowerCase();
			Matcher matcher = pattern.matcher(emailAddress);
			String valid = (matcher.matches() ? "valid" : "invalid");
			
			System.out.println("\nThe email is " + emailAddress + " is "+ valid + "\n");
			
			if (valid == "valid")
				System.out.println(emailList.toString().contains(emailAddress) ? "The email address exists." : "Email address is not found!");	
			
			System.out.println("\nWould you like to search again? y/n");
			String continued = scanner.nextLine();
			if (continued.equals("n")) counter++;
		}
	}
}
