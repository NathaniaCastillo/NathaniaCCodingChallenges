package application;
/*Nathania Castillo
 * UCID 30152619
 */
public class Grade {
	//attributes/data
	double value;
	double weight;
	int maxValue = 100;
	
	public Grade (String value1, Integer maxValue1, Double weight1) throws InvalidGradeException{
		try {
		double valueOne = Double.parseDouble(value1);
		value = valueOne;
		
		if(value > maxValue1) {
			throw new InvalidGradeException("Grade is too large. Grid is invalid" + maxValue1);
		}

		
		}catch (NumberFormatException nfe) {//using number format exception from Chat gpt that will be thrown from the change od string to double
			throw new InvalidGradeException("Can't change to a string to double",nfe);
		}
		maxValue = maxValue1;
		weight = weight1;
	}
		
	Grade(double gradeValue, int maxGradeValue, double weightTowardsCourseGrade){
		value = gradeValue;
		maxValue = maxGradeValue;
		weight = weightTowardsCourseGrade;
	}
	

	public double getWeightedPercentageGrade() {
		return value * 100 * (weight / maxValue);
	}

	
	//actions
	/*String setValue(String valueAsString) {
		String errorMessage = "";//assuming there is no error
    	//check that the user entered a numeric value
    	boolean validGrade = true;
    	int count = 0;
   
    	for (char c : valueAsString.toCharArray()){
    		//if any character is not a digit or a decimal point
    		if (!Character.isDigit(c) || c == '.') {
    			validGrade = false;//will this still keep on running through the rest of the code? into the other for loop even if it went to invalid
    			
    			errorMessage = (" Don't include the character: " + c +" Grade should be "
    					+ "number.");
    			/*if character is a decimal point change to true and add no text also counting how many
    			 * decimal points there are.
    			 */
    			/*
    			if (c == '.') {
    				validGrade = true;
    				errorMessage = ("");//projectGradeErrorLabel.setText("")
    				count++;
    			}
    			/* when decimal point is more than one will change boolean to false and 
    			 * give an appropriate error message
    			 */
	/*
    			if (count > 1){
    				validGrade = false;
    				errorMessage = (" Don't include more than one decimal point. Invalid value: " + value);
    		
    			
    			}
    		}
    		
    	}*/
    	/*Default project grade to 0. If valid number entered, convert user input to
    	*floating number
    	*/
    	/*
    	if(validGrade) {
    		value =  Double.parseDouble (valueAsString);
    	}
    	//Check if projectGrade is a valid percentage grade. If not, reset to default grade of 0.
    	if (value < 0 || value > maxValue) {
    		errorMessage = String.format("Grade should be between 0 and %d. Invalid grade: %.2f " 
    			 ,maxValue,value);
    		value = 0;
    	}
    
    	
    	return errorMessage;
    }*/
	}


