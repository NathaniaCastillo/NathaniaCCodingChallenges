package application;

/*Nathania Castillo
 * UCID 30152619
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class GradeCalculatorController {

    @FXML
    private ChoiceBox<Integer> optCodingChallengesChoiceBox;

    @FXML
    private ChoiceBox<Integer> codingChallengesChoiceBox;

    @FXML
    private Slider averageQuizGradeSlider;

    @FXML
    private TextField projectGradeTextfield;
    
    @FXML
    private Label courseGradeLabel;
    
    @FXML
    private Label projectGradeErrorLabel;
    /**
     * Checks if the value provided is a valid project grade. A project grade must be numeric and
     * a percentage (between 0 and 100). If valid, the equivalent double is returned, if not, this method returns zero.
     * 
     * @param valueEntered the value entered as the project grade
     * @return the double value of valueEntered if it is numeric and a percentage and 0 otherwise.
     */
    double getProjectGrade(String valueEntered) {
    	
    	//check that the user entered a numeric value
    	boolean validProjectGrade = true;
    	int count = 0;
   
    	for (char c : valueEntered.toCharArray()){
    		//if any character is not a digit or a decimal point
    		if (!Character.isDigit(c) || c == '.') {
    			validProjectGrade = false;//will this still keep on running through the rest of the code? into the other for loop even if it went to invalid
    			
    			projectGradeErrorLabel.setText(" Don't include the character: " + c +" Project grade should be "
    					+ "percentage.");
    			/*if character is a decimal point change to true and add no text also counting how many
    			 * decimal points there are.
    			 */
    			
    			if (c == '.') {
    				validProjectGrade = true;
    				projectGradeErrorLabel.setText("");
    				count++;
    			}
    			/* when decimal point is more than one will change boolean to false and 
    			 * give an appropriate error message
    			 */
    			if (count > 1){
    				validProjectGrade = false;
    				projectGradeErrorLabel.setText(" Don't include more than one decimal point. Invalid value: " + valueEntered);
    		
    			
    			}
    		}
    		
    	}
    	/*Default project grade to 0. If valid number entered, convert user input to
    	*floating number
    	*/
    	double projectGrade = 0;
    	if(validProjectGrade) {
    		projectGrade =  Double.parseDouble (valueEntered);
    	}
    	//Check if projectGrade is a valid percentage grade. If not, reset to default grade of 0.
    	if (projectGrade < 0 || projectGrade > 100) {
    		projectGradeErrorLabel.setText("Project Grade should be between 0% and 100%. Invalid project grade: " 
    				+ projectGrade);
    		projectGrade = 0;
    	}
    
    	
    	return projectGrade;
    }
    @FXML
    /**
     * 
     * @param event triggers the calculation of the course grade as a whole
     */
    void calculateGrade(ActionEvent event) {
    	projectGradeErrorLabel.setText("");

    	double courseGrade = 0.0;
    	
    	//assuming the project is worth 50% of course
    	String projectValueEntered = projectGradeTextfield.getText();
    	
    	//check if user entered a percentage grade. If not, display error message and don't
    	double projectGrade = getProjectGrade(projectValueEntered);
    	//include project grade in course grade
    	courseGrade = courseGrade + (projectGrade)* 50/100;
    	System.out.println("Project grade entered: " +projectGrade +
    			" Course grade so far: " + courseGrade);
    	
    	//assuming the quizzes are worth 30% towards course grade
    	//assuming that quizzes are marked out of 10****
    	double quizGrade = averageQuizGradeSlider.getValue();
    	courseGrade += quizGrade * (100/10) * .25;
    	System.out.println("Quiz grade entered: " + quizGrade 
    			+ " Course grade so far: " + courseGrade);
    	
    	//assuming that coding challenges are worth 20% towards course grade**has to be changed i believe 
    	//assuming 15 coding challenges
    	int codingChallengesPassed = codingChallengesChoiceBox.getValue();
    	courseGrade += codingChallengesPassed  * 1.25;
    	System.out.println("Coding challenge passed: " + codingChallengesPassed 
    			+ " Course grade so far: " + courseGrade);
    	//have to add this one
    	int optCodingChallengesPassed = optCodingChallengesChoiceBox.getValue();
    	courseGrade += optCodingChallengesPassed * 1.25; 
    	System.out.println("Optional coding challenges passed: " 
    			+ optCodingChallengesPassed + " Course Grade so far: " + courseGrade);
    	
    	// Display result of calculation to the user in the window
    	//Display result to two digits after the decimal point
    	courseGradeLabel.setText(String.format("Your overall course grade is: %.2f", courseGrade)); 
    }

}
