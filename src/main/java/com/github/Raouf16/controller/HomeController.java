package com.github.Raouf16.controller;
import com.github.Raouf16.model.utils.io.csv.read.CsvReader;
import com.github.Raouf16.model.utils.io.spreadsheet.write.GenerateEmptyFile;
import com.github.Raouf16.model.utils.io.spreadsheet.write.GenerateFicheService;
import com.github.Raouf16.model.utils.teacher.EnterTeacher;
import com.github.Raouf16.model.utils.teacher.Teacher;

import java.util.Optional;


import com.github.Raouf16.model.main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This class is the Home Controller, here we manage what the home interface buttons do
 * @author Raouf HADDAD
 */

public class HomeController 
{
	static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	private Stage dialogStage;
	private boolean infoClicked = false;
   

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
		GenerateEmptyFile gef = new GenerateEmptyFile();
		gef.generate();
	}

	//Generate "FIche de service" filled with teacher informations
	public void generateFicheSecretary() throws Exception
	{
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Informations professeur");
		dialog.setHeaderText("Identifiant enseignant");
		dialog.setContentText("Entrez le numen de l'enseignant");
		LOGGER.info("Fiche secretary generated");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		Teacher wantedTeacher = null;
		if (result.isPresent()) 
		{
			CsvReader cr = new CsvReader();
			String numen = result.get();
			wantedTeacher = cr.getTeacherByNumEn(Main.teachersFilePath, numen) ;
			
			if (wantedTeacher == null)
			{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Look, an Error Dialog");
				alert.setContentText("L'enseignant est introuvable!");

				alert.showAndWait();
			}
			
			else{
				GenerateFicheService gfs = new GenerateFicheService();
				gfs.generateFullFS(wantedTeacher);
			}
				
		}
	}
	//Generate empty "FIche de service" without teacher informations
	public void generateFicheProfessor() throws Exception{
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Informations professeur");
		dialog.setHeaderText("Nom et prénom de l'enseignant");
		dialog.setContentText("Entrez le nom ET prénom du professeur");
		LOGGER.info("Fiche professor generated");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		Teacher wantedTeacher = null;
		if (result.isPresent()) 
		{
			CsvReader cr = new CsvReader();
			String numen = result.get();
			wantedTeacher = cr.getTeacherByNumEn(Main.teachersFilePath, numen) ;
			if (wantedTeacher == null)
			{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Look, an Error Dialog");
				alert.setContentText("L'enseignant est introuvable!");

				alert.showAndWait();
			}
			
			else{
				GenerateFicheService gfs = new GenerateFicheService();
				gfs.generateEmptyFS(wantedTeacher);
			}
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