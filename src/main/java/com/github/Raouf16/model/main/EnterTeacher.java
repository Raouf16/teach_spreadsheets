package com.github.Raouf16.model.main;

import java.io.File;
import java.io.IOException;

import com.github.Raouf16.controller.TeacherInformationController;
import com.github.Raouf16.controller.TeacherPreferencesController;
import com.github.Raouf16.model.csv.write.CsvFile;
import com.github.Raouf16.model.spreadsheet.write.WriteInformations;
import com.github.Raouf16.model.spreadsheet.write.WritePreferences;
import com.github.Raouf16.model.utils.teacher.Teacher;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.log4j;

public class EnterTeacher
{
	private final static Logger logger = Logger.getLogger(EnterTeacher.class);
	
	private static Stage primaryStage;
	private static TeacherInformationController teacherControler;
	private static TeacherPreferencesController prefControler;
	private static Teacher teacher;
	private static Stage dialogStage = new Stage();

	
	public static void enterInfo() throws Exception
	{
		 logger.info("Entering the enterInfo method");
		primaryStage = Main.primaryStage ;
		dialogStage.initModality(Modality.WINDOW_MODAL);
		showTeacherDialog();
		if (!teacherControler.isOkClicked())
		{
			dialogStage.close();
			return;
		}
		Main.teacher = teacher = teacherControler.getTeacher();
		CsvFile.writeTeacher(Main.teachersFilePath, teacher);
		showPreferencesDialog();
		if (!prefControler.isOkClicked()) 
		{
			dialogStage.close();
			return;
		}
		CsvFile.writePreference(Main.preferencesFilePath, teacher);
		File teacherFile = WriteInformations.write(teacher);
		WritePreferences.write(teacher, teacherFile, teacher.getPreferences());
	}
	
	/**
     * Opens a dialog to edit details for the specified teacher. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * @param teacher the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
	private static void showTeacherDialog()
	{
		 logger.info("Entering the showTeacherDialog method");
		try
        {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(Main.teacherControlerPath));
            AnchorPane page = (AnchorPane) loader.load();
            logger.info("FXML file for teacher loaded");
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
	
	private static void showPreferencesDialog()
	{
		 logger.info("Entering the showPreferenceDialog method");
		try
        {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(Main.prefControlerPath));
            AnchorPane page = (AnchorPane) loader.load();
            logger.info("FXML file for preferences loaded");
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
