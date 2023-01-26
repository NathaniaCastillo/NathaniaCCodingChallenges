package application;

//Nathania Castillo
//UCID 30152619
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
    Label projectErrorLabel;

    @FXML
    void calculateGrade(ActionEvent event) {
    	double courseGrade = 0.0;
    	//assuming the project is worth 50% of course
    	String projectGrade =  projectGradeTextfield.getText();
    	courseGrade = courseGrade + Double.parseDouble(projectGrade)* 40/100;
    	System.out.println("Project grad entered: " +projectGrade +
    			" Course grade so far: " + courseGrade);
    	//assuming the quizzes are worth 30% towards course grade
    	//assuming that quizzes are marked out of 10****
    	double quizGrade = averageQuizGradeSlider.getValue();
    	courseGrade += quizGrade * (100/10) * .3;
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
