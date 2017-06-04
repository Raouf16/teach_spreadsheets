package com.github.Raouf16.model.main;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import com.github.Raouf16.model.utils.teacher.*;
import com.github.Raouf16.controller.TeacherInformationController;
import com.github.Raouf16.controller.TeacherPreferencesController;
import com.github.Raouf16.controller.HomeController;
import com.github.Raouf16.model.csv.write.*;
import com.github.Raouf16.model.spreadsheet.write.*;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Main extends Application
{

	public static String canevasFolderPath = "src/main/resources/com/github/Raouf16/canevas/";
	public static File fileReadingData = new File("src/main/resources/com/github/Raouf16/Lire_saisie_voeux.ods");
	public static String teachersFilePath = "src/main/resources/com/github/Raouf16/csv/teachers";
	public static String preferencesFilePath = "src/main/resources/com/github/Raouf16/csv/preferences";
	public static String prefControlerPath = "/com/github/Raouf16/view/TeacherPreferences.fxml" ;
	public static String homePath = "/com/github/Raouf16/view/Home.fxml" ;
	public static String teacherControlerPath = "/com/github/Raouf16/view/TeacherInformation.fxml" ;
	private Stage primaryStage;
    private static TeacherInformationController teacherController ;
    private static TeacherPreferencesController prefController;
    private static HomeController homeControl;
    
    

    public static Dataset<Row> teachers = SparkSession
            .builder()
            .appName("Java Spark SQL basic example")
            .config("spark.master", "local")
            .getOrCreate()
            .read()
            .option("header", true)
            .csv(teachersFilePath);

   public static Teacher teacher ;


   public void showHome()
   {
       try
       {
           // Load the fxml file and create a new stage for the popup dialog.
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(Main.class.getResource(homePath));
           AnchorPane page = (AnchorPane) loader.load();
           // Create the dialog Stage
           Stage dialogStage = new Stage();
           dialogStage.setTitle("Menu Principal");
           dialogStage.initModality(Modality.WINDOW_MODAL);
           dialogStage.initOwner(primaryStage);
           Scene scene = new Scene(page);
           dialogStage.setScene(scene);

           // Set the person into the controller.
           homeControl = loader.getController();
           homeControl.setDialogStage(dialogStage);

           // Show the dialog and wait until the user closes it
           dialogStage.showAndWait();

       } catch (IOException e)
       {
           e.printStackTrace();
           return ;
       }
   }
   
    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * @param teacher the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public void showTeacherEditDialog()
    {
        try
        {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(teacherControlerPath));
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

        } catch (IOException e)
        {
            e.printStackTrace();
            return ;
        }
    }
    
    public void showTeacherPreference() throws IOException
    {

            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(prefControlerPath));
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
    }

	@Override
	public void start(Stage primaryStage) throws IOException
	{
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Teach SpreadSheets");
        showHome();
        if (!homeControl.isInfoClicked()) System.exit(0);
        showTeacherEditDialog();
        if (!teacherController.isOkClicked()) System.exit(0);
        teacher = teacherController.getTeacher();
        showTeacherPreference();
        if (!prefController.isOkClicked()) System.exit(0);;
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
		CsvFile.WriteTeacher("src/main/resources/com/github/Raouf16/teachers", teacher);
		CsvFile.WritePreference("src/main/resources/com/github/Raouf16/preferences", teacher);
		File teacherFile = WriteInformations.write(teacher);
		WritePreferences.write(teacher, teacherFile, teacher.getPreferences());
		//SpreadSheetFill s= new SpreadSheetFill();
    	//s.GenerateFS(teacher);
	}
}