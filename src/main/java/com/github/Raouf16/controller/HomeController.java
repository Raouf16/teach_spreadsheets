package com.github.Raouf16.controller;
import com.github.Raouf16.model.spreadsheet.write.*;
import com.github.Raouf16.model.utils.io.csv.read.CsvReader;
import com.github.Raouf16.model.utils.teacher.EnterTeacher;
import com.github.Raouf16.model.utils.teacher.Teacher;

import java.util.Optional;


import com.github.Raouf16.model.main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import org.apache.log4j.Logger;


/**
 * This class is the Home Controller 
 * @author Raouf HADDAD
 */

public class HomeController 
{
	private final static Logger logger = Logger.getLogger(HomeController.class);
	
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


	public void generateFicheSecretary() throws Exception
	{
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Informations professeur");
		dialog.setHeaderText("Identifiant enseignant");
		dialog.setContentText("Entrez le numen de l'enseignant");
		logger.info("Fiche secretary generated");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		Teacher wantedTeacher = null;
		if (result.isPresent()) 
		{
			String numen = result.get();
			wantedTeacher = CsvReader.getTeacherByNumEn(Main.teachersFilePath, numen) ;
			
			if (wantedTeacher == null)
			{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Look, an Error Dialog");
				alert.setContentText("L'enseignant est introuvable!");

				alert.showAndWait();
			}
			
			else GenerateFicheService.generateFullFS(wantedTeacher);
				
		}
	}
	
	public void generateFicheProfessor() throws Exception{
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Informations professeur");
		dialog.setHeaderText("Nom et prénom de l'enseignant");
		dialog.setContentText("Entrez le nom ET prénom du professeur");
		logger.info("Fiche professor generated");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		Teacher wantedTeacher = null;
		if (result.isPresent()) 
		{
			String numen = result.get();
			wantedTeacher = CsvReader.getTeacherByNumEn(Main.teachersFilePath, numen) ;
			if (wantedTeacher == null)
			{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Look, an Error Dialog");
				alert.setContentText("L'enseignant est introuvable!");

				alert.showAndWait();
			}
			
			else GenerateFicheService.generateEmptyFS(wantedTeacher);
		}
	}
	
	public void generateFichierAgrege() throws Exception{
		//ExemplePDF.generate();
	}
	
	public void enterInfo() throws Exception
	{
		
		(new EnterTeacher()).enterInfo();
	}
	
	public boolean isInfoClicked(){
		return infoClicked;
	}
}