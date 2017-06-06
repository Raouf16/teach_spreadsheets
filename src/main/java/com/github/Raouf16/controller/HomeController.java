package com.github.Raouf16.controller;
import com.github.Raouf16.model.spreadsheet.write.*;
import com.github.Raouf16.model.utils.io.TeacherReader;
import com.github.Raouf16.model.utils.teacher.Teacher;

import java.util.ArrayList;
import java.util.Optional;

import com.github.Raouf16.model.main.EnterTeacher;
import com.github.Raouf16.model.main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;


/**
 * This class is the Home Controller 
 * @author Raouf HADDAD
 */

public class HomeController 
{
	
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
		dialog.setHeaderText("Nom et prénom de l'enseignant");
		dialog.setContentText("Entrez le nom ET prénom du professeur");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		Teacher wantedTeacher = null;
		if (result.isPresent()) 
		{
			String [] tmpStr = result.get().replace(" ",",").split(",");
			String firstName = tmpStr[1], lastName = tmpStr[0];
			ArrayList<Teacher> teachers = TeacherReader.readTeachersData(Main.teachersFilePath);
			for (Teacher t : teachers)
			{
				if (t!=null && t.firstName.equals(firstName) && t.lastName.equals(lastName)) 
				{
					wantedTeacher = t;
					break;
				}
			}
			
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

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		Teacher wantedTeacher = null;
		if (result.isPresent()) 
		{
			String [] tmpStr = result.get().replace(" ",",").split(",");
			String firstName = tmpStr[1], lastName = tmpStr[0];
			ArrayList<Teacher> teachers = TeacherReader.readTeachersData(Main.teachersFilePath);
			for (Teacher t : teachers)
			{
				if (t!=null && t.firstName.equals(firstName) && t.lastName.equals(lastName)) 
				{
					wantedTeacher = t;
					break;
				}
			}
			
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
		EnterTeacher.enterInfo();
	}
	
	public boolean isInfoClicked(){
		return infoClicked;
	}
}