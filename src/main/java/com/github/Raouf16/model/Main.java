package com.github.Raouf16.model;


import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.github.Raouf16.model.teacherUtils.Teacher;
import com.github.Raouf16.controller.TeacherInformationController;
import com.github.Raouf16.controller.TeacherPreferencesController;
import com.github.Raouf16.model.writeCsv.*;
import com.github.Raouf16.model.excelWrite.*;

public class Main extends Application 
{
	
	
	public static File fileReadingData = new File("src/main/resources/com/github/Raouf16/Lire_saisie_voeux.ods");
	
	private Stage primaryStage;
    private static TeacherInformationController teacherController ;
    private static TeacherPreferencesController prefController;
    
    public static Teacher teacher ;
    
    
    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * @param teacher the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showTeacherEditDialog()
    {
        try
        {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/TeacherInformation.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Informations personnelles");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            teacherController = loader.getController();
            teacherController.setDialogStage(dialogStage);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return teacherController.isOkClicked();
        } catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public boolean showTeacherPreference() throws IOException
    {
       
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/TeacherPreferences.fxml"));
            
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Preferences");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            prefController = loader.getController();
            prefController.setDialogStage(dialogStage);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            return prefController.isOkClicked();
    }
   
   
    
	@Override
	public void start(Stage primaryStage) throws IOException 
	{
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Teach spreadsheets");
        showTeacherEditDialog();
        teacher = teacherController.getTeacher();
        System.out.println(showTeacherPreference())                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    ;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	

	public static void main(String[] args) throws Exception
	{
		launch();
		CsvFile.WriteTeacher("src/main/resources/com/github/Raouf16/test", teacher);
		File teacherFile = WriteInformations.write(teacher);
		WritePreferences.write(teacher, teacherFile, teacher.getPreferences());
	}
}