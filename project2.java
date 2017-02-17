import javax.swing.JOptionPane;

public class project2{

	public static void main(String [] args){
		String[][] userPassArray=readUserPassFile();
		String username;
		String password;
		int tries  = 0;
		boolean success=false;
		while(tries<3 && success=false){
			username = JOptionPane.showInputDialog(null, "Enter your username");
			password = JOptionPane.showInputDialog(null, "Enter your password");
			if(checkValidation(username, password)==true) success=true;
			JOptionPane.showMessageDialog(null, " Invalid username or password" );
			tries++;
		}




	}
	public static String[][] readUserPassFile(){

		//intake txt file
		//lets see if we can do this multidimesional guys


	}
	public static boolean checkValidation(String username, String password, String[][] userPassArray){
		boolean isMatch=false;
		//sift through array to find a match, find username first, if not found end search

		return isMatch;


	}
	public static void questions(){
		String[][] questions=readQuestionFile();




	}
	public static String[][] readQuestionFile(){



	}
}
