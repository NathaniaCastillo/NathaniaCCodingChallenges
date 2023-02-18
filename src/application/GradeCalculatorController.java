package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
	
	double reAverageQuizGrade = 0.0;
	
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
    
    @FXML
    private Label reQuizGradeErrorLabel;
    
    @FXML 
    private Label optQuizGradeErrorLabel;
 
//all for required quiz
    //notes: for the red text it has to be in the fxml file and it has the right values but is showing the wrong one in the scene.
    void calculateQuizGrade(Scene mainScene, ArrayList<TextField> quizGradeTextfields){
    	reQuizGradeErrorLabel.setText("");
    	reAverageQuizGrade = 0.0;
    	boolean noErrors = true;
    	double weightOfEachQuiz = 1.0/15;
    	
    	
    	for(TextField textfield: quizGradeTextfields) {//for each textfield in quiz textfield
    		Grade reQuizGrade = new Grade(0,10,weightOfEachQuiz);//double check the out of 10 hhere
    		String errorMessage = reQuizGrade.setValue(textfield.getText());
    		if (!errorMessage.equals("")) {
    			noErrors = false;
    			reQuizGradeErrorLabel.setText(errorMessage);
    		}
    		reAverageQuizGrade += ((reQuizGrade.getWeightedPercentageValue())/10); 
    		
    	}
    	if (noErrors) {
    		requiredQuizAverage.setText(""+ String.format("%.2f", reAverageQuizGrade,100) + "/10.0");//added string format from java2blog
    		applicationStage.setScene(mainScene);
    	}

    }
//required quiz
    @FXML
    void getQuizGrades(ActionEvent enterQuizGradeEvent) {
    	Scene mainScene = applicationStage.getScene();
    	numberOfQuizzes = quizzesChoiceBox.getValue();
    	int rowCounter = 0;
    	Label title = new Label("Required quiz grades");
    	VBox allRows = new VBox();
    	allRows.getChildren().add(title);
    	
    	ArrayList <TextField> quizTextFields = new ArrayList<TextField>();
    	while(rowCounter < numberOfQuizzes) {
    		rowCounter++;
        	HBox quizRow = new HBox();
        	Label quizLabel = new Label("Quiz " + rowCounter + " grade");
        	TextField quizGradeTextfield = new TextField();
        	quizTextFields.add(quizGradeTextfield);//may have to debug
        	
        	quizRow.getChildren().addAll(quizLabel,quizGradeTextfield);
        	allRows.getChildren().add(quizRow);
    	}
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> calculateQuizGrade(mainScene,quizTextFields));
    	allRows.getChildren().add(doneButton);
    	
    	reQuizGradeErrorLabel = new Label();
    	allRows.getChildren().add(reQuizGradeErrorLabel);
    	
    	Scene quizScene  = new Scene(allRows);
    	applicationStage.setScene(quizScene);
    }
//optional quizzes 
    void calculateOptQuizGrade(Scene optMainScene, ArrayList<TextField> optQuizGradeTextfield){
    	optQuizGradeErrorLabel.setText("");
    	optAverageQuizGrade = 0.0;
    	boolean noErrors = true;
    	double totalNumOptQuizzes = 0.0;
    	double weightOfEachOptQuiz = 1.0/5;//check difference between this and size
 
    	
    	ArrayList<Double> highestFiveQuizGrades = new ArrayList<Double>();
    	
    	for(TextField textfield: optQuizGradeTextfield) {
    		Grade optQuizGrade = new Grade(0,10,weightOfEachOptQuiz);
    		String optErrorMessage = optQuizGrade.setValue(textfield.getText());
    		if (!optErrorMessage.equals("")) {
    			noErrors = false;
    			optQuizGradeErrorLabel.setText(optErrorMessage);	
    		}
    		optAverageQuizGrade += optQuizGrade.getWeightedPercentageValue();
    		highestFiveQuizGrades.add(Double.parseDouble(textfield.getText()));// in this line it is putting all the numbers in an array individually
    	}
    	
    	Collections.sort(highestFiveQuizGrades);//this sorts from lowest to highest number
    	int numOfQuizzesComplete = highestFiveQuizGrades.size();
    	
    	if (numOfQuizzesComplete <= 5) {
    		for (double optQuizGrade : highestFiveQuizGrades) {
    			totalNumOptQuizzes += optQuizGrade;   			
    		}
    		optAverageQuizGrade = totalNumOptQuizzes/5;//optQuizGradeTextfield.size()
    	}
    	if(numOfQuizzesComplete == 6) {
    		highestFiveQuizGrades.remove(0);//this removes first number which is now the lowest number thanks to the sort function
    		for(double optQuizGrade : highestFiveQuizGrades) {
    			totalNumOptQuizzes += optQuizGrade;
    		}
    		optAverageQuizGrade = totalNumOptQuizzes/5;
    	}
    	if(numOfQuizzesComplete == 7){
    		highestFiveQuizGrades.remove(0);
    		highestFiveQuizGrades.remove(0);
    		for(double optQuizGrade : highestFiveQuizGrades) {
    			totalNumOptQuizzes += optQuizGrade;
    		}
    		optAverageQuizGrade = totalNumOptQuizzes/5;
    	}
    	if(noErrors) {
    	optionalQuizAverage.setText("" + String.format("%.2f",optAverageQuizGrade) + "/10.0");
    	OptApplicationStage.setScene(optMainScene);
    	}
    }
//optional quizzes
    @FXML
    void getOptQuizGrades(ActionEvent enterOptQuizGradeEvent) {
    
    	Scene optMainScene = OptApplicationStage.getScene();
    	optNumberOfQuizzes = optionalQuizChoiceBox.getValue();
    	int optRowCounter = 0;
    	Label optTitle = new Label("Optional quiz grades");
    	VBox optAllRows = new VBox();
    	optAllRows.getChildren().add(optTitle);
    	
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
    	
    	optQuizGradeErrorLabel = new Label();
    	optAllRows.getChildren().add(optQuizGradeErrorLabel);
    	
    	
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
    	Grade projectGrade = new Grade(0, 100, .5);
    	projectGradeErrorLabel.setText(projectGrade.setValue(projectGradeTextfield.getText()));//no error message for 101
    
    	
    	//require and optional quizzes//have to fix this part i think I do not kno what tho
    	System.out.println("5." +reAverageQuizGrade);
    	Grade reQuizGrade = new Grade(reAverageQuizGrade,10, 0.1875);//changed to 100
    	
    	System.out.println("5." +optAverageQuizGrade);
    	Grade optQuizGrade = new Grade(optAverageQuizGrade,10, 0.0625);//changed

    	
    	//all functions for required coding challenges including max value for the required which is 15
    	Grade codingChallengesPassed = new Grade(codingChallengesChoiceBox.getValue(),15,.1875);

    	
    	Grade optCodingChallengesPassed = new Grade(optCodingChallengesChoiceBox.getValue(),5,.0625);
   
    	
    	
    	//check if user entered a percentage grade. If not, display error message and don't
    	//include project grade in course grade
    	courseGrade = projectGrade.getWeightedPercentageValue() + reQuizGrade.getWeightedPercentageValue() 
    	+ optQuizGrade.getWeightedPercentageValue()+ codingChallengesPassed.getWeightedPercentageValue()
    	+ optCodingChallengesPassed.getWeightedPercentageValue();
    	
    	// Display result of calculation to the user in the window
    	//Display result to two digits after the decimal point
    	courseGradeLabel.setText(String.format("Your overall course grade is: %.2f", courseGrade)); 
    }
    
}
