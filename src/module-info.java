module NathaniaCastilloGradeCalculator1 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires junit;
	
	opens application to javafx.graphics, javafx.fxml;
}
