package com.github.Raouf16.controller;
import com.github.Raouf16.model.spreadsheet.write.*;

import com.github.Raouf16.model.pdf.generate.*;
import javafx.fxml.FXML;
import javafx.stage.Stage;


/**
 * This class is the Home Controller 
 * @author Raouf HADDAD
 */

public class HomeController {
	
	private Stage dialogStage;
	private boolean infoClicked = false;
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
    
   
	public void generateODS() throws Exception{
		GenerateEmptyFile.generate();
	}


	public void generateFicheSecretary() throws Exception{
		ExemplePDF.generate();
	}
	
	public void generateFicheProfessor() throws Exception{
		ExemplePDF.generate();
	}
	
	public void generateFichierAgrege() throws Exception{
		ExemplePDF.generate();
	}
	
	public void enterInfo() throws Exception{
		infoClicked = true;
		dialogStage.close();
	}
	
	public boolean isInfoClicked(){
		return infoClicked;
	}
}