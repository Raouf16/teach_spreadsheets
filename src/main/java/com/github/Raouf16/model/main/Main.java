package com.github.Raouf16.model.main;

import java.io.File;
import java.io.IOException;

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
import org.apache.log4j;


public class Main extends Application
{
	private final static Logger logger = Logger.getLogger(Main.class);
	
	public static String canevasFolderPath = "src/main/resources/com/github/Raouf16/canevas/";
	public static File fileFicheService = new File("src/main/resources/com/github/Raouf16/canevas/Fiche_service.ods");
	public static File fileReadingData = new File("src/main/resources/com/github/Raouf16/canevas/Lire_saisie_voeux.ods");
	public static String teachersFilePath = "src/main/resources/com/github/Raouf16/csv/teachers";
	public static String preferencesFilePath = "src/main/resources/com/github/Raouf16/csv/preferences";
	public static String prefControlerPath = "/com/github/Raouf16/view/TeacherPreferences.fxml" ;
	public static String homePath = "/com/github/Raouf16/view/Home.fxml" ;
	public static String teacherControlerPath = "/com/github/Raouf16/view/TeacherInformation.fxml" ;
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
	   logger.info("Entering the showHome method");
       try
       {
           // Load the fxml file and create a new stage for the popup dialog.
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(Main.class.getResource(homePath));
           AnchorPane page = (AnchorPane) loader.load();
           logger.info("Load successful");
           
           // Create the dialog Stage
           Stage dialogStage = new Stage();
           dialogStage.setTitle("Menu Principal");
           dialogStage.initModality(Modality.WINDOW_MODAL);
           dialogStage.initOwner(primaryStage);
           Scene scene = new Scene(page);
           dialogStage.setScene(scene);
           logger.info("Creation successful");

           // Set the person into the controller.
           homeControl = loader.getController();
           homeControl.setDialogStage(dialogStage);

           // Show the dialog and wait until the user closes it
           dialogStage.showAndWait();
           

       } catch (IOException e)
       {
    	   logger.error("Error while loading file. Message:" + e.getMessage());
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
		logger.info("d�but de l'application");
		launch();
		logger.info("fin de l'application");
	}
}