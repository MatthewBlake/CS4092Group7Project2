import javax.swing.*;
import java.io.*;
import java.util.*;

public class Project2
{
	public static void main(String[] args) throws IOException
	{
		boolean validDetails = false;
		int tries = 0;
		String username, password;
		
		//loop to get username and password, if correct username and password is supplied, program is launched.
		while (!validDetails && tries < 3)
		{	
			//Takes in username and password from user, if the user presses cancel then the program will exit
			username = JOptionPane.showInputDialog(null, "Please insert a username " + "(attempt " + (tries + 1) + ")");	
			
			if(username != null)
			{
				//put the username to lowercase because usernames should not be case sensitive
				username = username.toLowerCase();
				
				password = JOptionPane.showInputDialog(null, "Please insert a password " + "(attempt " + (tries + 1) + ")");
				
				if(password!= null)
				{
					//checks if the user and password supplied is correct
					if(checkValidation(username, password))
					{
						//if it is correct then it launches the program
						validDetails = true;
						programLauncher(username);
				
					}
					//if it isn't correct then it tells the user and then starts again with the tries counter incremented.
					else
					{
						if(tries == 2)		JOptionPane.showMessageDialog(null, "You have entered an incorrect username and password 3 times, the program will now exit.");
						else							JOptionPane.showMessageDialog(null, "Invalid username or password, please try again.");
					}
				}		//if the user presses cancel, tries should go to 3 so it won't reloop
						else						tries = 3;
			}
						else						tries = 3;
				//increment tries everytime it goes into the loop
				tries++;
		}
	}

	//checks validation of input
	public static boolean checkValidation(String username, String password) throws IOException
	{
		boolean isValid = false;
		
		//Takes in input from a file
		FileReader file = new FileReader("users.txt");
		Scanner in = new Scanner(file);
		
		String[] data;
		
		while(in.hasNext())
		{
			//splits the data, subset 0 is username, subset 1 is 
			data = in.nextLine().split(",");
			
			//checks if the username and password supplied matches what's on file
			if(username.matches(data[0]) && password.matches(data[1]))	isValid = true;
		}
		in.close();
		file.close();
		return isValid;
	}
	//gets a choice from the user and calls the getQuestions method if input is correct
	public static void programLauncher(String username) throws IOException
	{
		String choice = JOptionPane.showInputDialog(null, "Hi " + username + ", welcome to the Multiple Choice Practice Test!\nPlease choose a topic below!\n1... Arrays\n2... Syntax\n3... String Manipulation\n4... <no idea yet>");
		String pattern = "[1-4]{1}";
		while(choice != null)
		{
			if(choice.matches(pattern))
			{
				getQuestions(Integer.parseInt(choice));
			}
			else
				JOptionPane.showMessageDialog(null, "Error, please input a number between 1 and 4");
		}
		
	}
	
	//Gets questions for the topic selected by the user
	public static void getQuestions(int topic) throws IOException
	{
		FileReader file = new FileReader("questions.txt");
		Scanner in = new Scanner(file);
		
		String[] data;
		
		//splits the data so we can check if the topic corresponds with subscript 0 etc.
		while(in.hasNext())
		{
			//TODO
			//Splits the data, subset 0 = topic, subset 1 = question number, subset 2 = question, subset 4 = correct answer, subset 5 = possible answer 1, subset 6 = possible answer 2, subset 7 = possible answer 3, subset 8 = explanation
		}
		
	
		//TODO
		//a method to choose and randomise the questions and answers.
		//track score in the users.txt file
		//output current and overall score to the user
	}

}
