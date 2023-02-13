package application;

import java.util.ArrayList;

/*Nathania Castillo
 * UCID 30152619
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GradeCalculatorController {
	Stage applicationStage;
	
	Stage OptApplicationStage;
	
	double averageQuizGrade = 0.0;
	
	double optAverageQuizGrade = 0.0;
	
	int optNumberOfQuizzes;
	
	int numberOfQuizzes;
	
    @FXML
    private ChoiceBox<Integer> optCodingChallengesChoiceBox;

    @FXML
    private ChoiceBox<Integer> codingChallengesChoiceBox;

    @FXML
    private ChoiceBox<Integer> quizzesChoiceBox;
    
    @FXML
    private ChoiceBox<Integer> optionalQuizChoiceBox;
    @FXML
    private TextField projectGradeTextfield;
    
    @FXML
    private Label courseGradeLabel;
    
    @FXML
    private Label projectGradeErrorLabel;
    
    @FXML
    private Label requiredQuizAverage;
    
    @FXML
    private Label optionalQuizAverage;
    
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
//all for required quiz
    void calculateQuizGrade(Scene mainScene, ArrayList<TextField> quizGradeTextfield){
    	averageQuizGrade = 0.0;
    	
    	for(TextField textfield: quizGradeTextfield) {//for each textfield in quiz textfield
    		averageQuizGrade += Double.parseDouble(textfield.getText()); 
    	}
    	averageQuizGrade = averageQuizGrade /quizGradeTextfield.size();
    	requiredQuizAverage.setText("" + averageQuizGrade);//new line added
    	
    	applicationStage.setScene(mainScene);
    }
//required quiz
    @FXML
    void getQuizGrades(ActionEvent enterQuizGradeEvent) {
    	System.out.println("hello");
    	Scene mainScene = applicationStage.getScene();
    	numberOfQuizzes = quizzesChoiceBox.getValue();
    	System.out.println(numberOfQuizzes);
    	int rowCounter = 0;
    	
    	VBox allRows = new VBox();
    	ArrayList <TextField> quizTextFields = new ArrayList<TextField>();
    	
    	while(rowCounter < numberOfQuizzes) {
    		rowCounter++;
        	HBox quizRow = new HBox();
        	Label quizLabel = new Label("Quiz " + rowCounter + " grade");
        	TextField quizGradeTextfield = new TextField();
        	quizTextFields.add(quizGradeTextfield);
        	
        	quizRow.getChildren().addAll(quizLabel,quizGradeTextfield);
        	allRows.getChildren().add(quizRow);
    	}
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> calculateQuizGrade(mainScene,quizTextFields));
    	allRows.getChildren().add(doneButton);
    	
    	
    	Scene quizScene  = new Scene(allRows);
    	applicationStage.setScene(quizScene);
    }
//optional quizzes 
    void calculateOptQuizGrade(Scene optMainScene, ArrayList<TextField> optQuizGradeTextfield){
    	optAverageQuizGrade = 0.0;
    	
    	for(TextField textfield: optQuizGradeTextfield) {
    		optAverageQuizGrade += Double.parseDouble(textfield.getText()); 
    	}
    	optAverageQuizGrade = optAverageQuizGrade /optQuizGradeTextfield.size();
    	optionalQuizAverage.setText("" + optAverageQuizGrade);//new line added
    	
    	OptApplicationStage.setScene(optMainScene);
    }
//optional quizzes
    @FXML
    void getOptQuizGrades(ActionEvent enterOptQuizGradeEvent) {
    	System.out.println("hi");
    	Scene optMainScene = OptApplicationStage.getScene();
    	
    	optNumberOfQuizzes = optionalQuizChoiceBox.getValue();
    	System.out.println(optNumberOfQuizzes);
    	
    	int optRowCounter = 0;
    	
    	VBox optAllRows = new VBox();
    	ArrayList <TextField> optQuizTextFields = new ArrayList<TextField>();
    	
    	
    	while(optRowCounter < optNumberOfQuizzes) {
    		optRowCounter++;
        	HBox optQuizRow = new HBox();
        	Label optQuizLabel = new Label("Quiz " + optRowCounter + " grade");
        	TextField optQuizGradeTextfield = new TextField();
        	optQuizTextFields.add(optQuizGradeTextfield);
        	
        	optQuizRow.getChildren().addAll(optQuizLabel,optQuizGradeTextfield);
        	optAllRows.getChildren().add(optQuizRow);
        	
      
        	
     
        	
  
    	}
    	Button optDoneButton = new Button("Done");
    	optDoneButton.setOnAction(optDoneEvent -> calculateOptQuizGrade(optMainScene,optQuizTextFields));//changed opt event name
    	optAllRows.getChildren().add(optDoneButton);
    	
    	
    	Scene optQuizScene  = new Scene(optAllRows);
    	OptApplicationStage.setScene(optQuizScene);
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
    	double requiredQuizGrade = averageQuizGrade;//have to divide this into required and optional
    	courseGrade += requiredQuizGrade * 1.25;
    	System.out.println("Quiz grade entered: " + requiredQuizGrade 
    			+ " Course grade so far: " + courseGrade);
    	//the optional ones
    	double optQuizGrade = optAverageQuizGrade;
    	courseGrade += optQuizGrade * 1.25;//not right numbers rn
    	System.out.println("Optional quiz grade entered: " + optQuizGrade
    			+ "Course grade so far");
    	
    	//assuming that coding challenges are worth 25% towards course grade* 
    	//assuming 15 coding challenges required
    	int codingChallengesPassed = codingChallengesChoiceBox.getValue();
    	courseGrade += codingChallengesPassed  * 1.25;
    	System.out.println("Coding challenge passed: " + codingChallengesPassed 
    			+ " Course grade so far: " + courseGrade);
    	//have to add this one
    	//optional quizzes have to be 5 out of 7
    	int optCodingChallengesPassed = optCodingChallengesChoiceBox.getValue();
    	courseGrade += optCodingChallengesPassed * 1.25; 
    	System.out.println("Optional coding challenges passed: " 
    			+ optCodingChallengesPassed + " Course Grade so far: " + courseGrade);
    	
    	// Display result of calculation to the user in the window
    	//Display result to two digits after the decimal point
    	courseGradeLabel.setText(String.format("Your overall course grade is: %.2f", courseGrade)); 
    }
    
}
