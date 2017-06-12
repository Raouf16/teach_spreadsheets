package com.github.Raouf16.model.main;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import com.github.Raouf16.model.utils.teacher.*;
import com.github.Raouf16.controller.HomeController;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Main extends Application
{

	public static String canevasFolderPath = Main.class.getResource("canevas/").getPath();
	public static URL outputsFolderPath = Main.class.getResource("sorties/");
	public static File fileFicheService = new File(Main.class.getResource("Fiche_service.ods").getPath());
	public static File fileReadingData = new File(Main.class.getResource("Lire_saisie_voeux.ods").getPath());
	public static File emptyFileChoice = new File(Main.class.getResource("canevas/Fichier_voeux_vide.ods").getPath());
	public static String teachersFilePath = Main.class.getResource("csv/teachers").getPath();
	public static String preferencesFilePath = Main.class.getResource("csv/preferences").getPath();
	public static URL prefControlerPath = Main.class.getResource("view/TeacherPreferences.fxml") ;
	public static URL homePath = Main.class.getResource("view/Home.fxml") ;
	public static URL teacherControlerPath = Main.class.getResource("view/TeacherInformation.fxml");
	public static Stage primaryStage;
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
           loader.setLocation(Main.homePath);

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
   

	@Override
	public void start(Stage primaryStage) throws IOException
	{
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Teach SpreadSheets");
        showHome();
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
	}
}