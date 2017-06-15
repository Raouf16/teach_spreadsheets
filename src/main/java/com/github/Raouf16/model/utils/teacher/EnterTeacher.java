package com.github.Raouf16.model.utils.teacher;

import java.io.File;
import java.io.IOException;

import com.github.Raouf16.controller.TeacherInformationController;
import com.github.Raouf16.controller.TeacherPreferencesController;
import com.github.Raouf16.model.utils.io.csv.read.CsvReader;
import com.github.Raouf16.model.utils.io.csv.write.CsvWriter;
import com.github.Raouf16.model.utils.io.spreadsheet.write.WriteInformations;
import com.github.Raouf16.model.utils.io.spreadsheet.write.WritePreferences;
import com.github.Raouf16.model.main.Main;
import com.github.Raouf16.model.utils.teacher.Teacher;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnterTeacher
{
	static final Logger LOGGER = LoggerFactory.getLogger(EnterTeacher.class);
	
	private static Stage primaryStage;
	private static TeacherInformationController teacherControler;
	private static TeacherPreferencesController prefControler;
	private static Teacher teacher;
	private static Stage dialogStage = new Stage();

	
	public void enterInfo() throws Exception
	{
		 LOGGER.info("Entering the enterInfo method");
		primaryStage = Main.primaryStage ;
		dialogStage.initModality(Modality.WINDOW_MODAL);
		showTeacherDialog();
		if (!teacherControler.isOkClicked())
		{
			dialogStage.close();
			return;
		}
		Main.teacher = teacher = teacherControler.getTeacher();
		
		CsvWriter cw = new CsvWriter();
		cw.writeTeacher(Main.teachersFilePath, teacher);
		showPreferencesDialog();
		if (!prefControler.isOkClicked()) 
		{
			dialogStage.close();
			return;
		}
		cw.writePreference(Main.preferencesFilePath, teacher);
		
		WriteInformations wi = new WriteInformations();
		File teacherFile = wi.write(teacher);
		
		WritePreferences wp = new WritePreferences();
		wp.write(teacher, teacherFile, teacher.getPreferences());
	}
	
	/**
     * Opens a dialog to edit details for the specified teacher. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * @param teacher the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
	private void showTeacherDialog()
	{
		 LOGGER.info("Entering the showTeacherDialog method");
		try
        {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.teacherControlerPath);
            AnchorPane page = (AnchorPane) loader.load();
            LOGGER.info("FXML file for teacher loaded");
            // Create the dialog Stage
            dialogStage.setTitle("Informations personnelles");
            
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            teacherControler = loader.getController();
            teacherControler.setDialogStage(dialogStage);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e)
        {
            e.printStackTrace();
            return ;
        }
		
	}
	
	private void showPreferencesDialog()
	{
		 LOGGER.info("Entering the showPreferenceDialog method");
		try
        {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.prefControlerPath);
            AnchorPane page = (AnchorPane) loader.load();
            LOGGER.info("FXML file for preferences loaded");
            // Create the dialog Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Informations personnelles");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            prefControler = loader.getController();
            prefControler.setDialogStage(dialogStage);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e)
        {
            e.printStackTrace();
            return ;
        }
	}

}
