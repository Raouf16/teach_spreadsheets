package com.github.Raouf16.controller;
import com.github.Raouf16.model.spreadsheet.write.*;
import com.github.Raouf16.model.pdf.generate.*;
import com.github.Raouf16.model.Main;
import javafx.fxml.FXML;
import com.github.Raouf16.model.utils.teacher.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HomeController {
	
	private Stage dialogStage;
	 /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) 
    {
        this.dialogStage = dialogStage;
    }
    
    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
   
	public void generateODS() throws Exception{
		GenerateEmptyFile.generate();
	}


	public void generateFiche() throws Exception{
		ExemplePDF.generate();
	}
	
	public void enterInfo() throws Exception{
		//Main.showPersonEditDialog(new Teacher());
	}
}