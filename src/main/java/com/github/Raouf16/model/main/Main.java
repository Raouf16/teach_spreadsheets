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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main extends Application
{
	static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	//public static String canevasFolderPath = "";
	public static String outputsFolderPath = "sorties/";
	public static File fileFicheService = new File("src/main/resources/com/github/Raouf16/model/main/canevas/Fiche_service.ods");
	public static File fileReadingData = new File("src/main/resources/com/github/Raouf16/model/main/canevas/Lire_saisie_voeux.ods");
	public static File emptyFileChoice = new File("src/main/resources/com/github/Raouf16/model/main/canevas/Fichier_voeux_vide.ods");
	public static String teachersFilePath = "sorties/csv/teachers";
	public static String preferencesFilePath = "sorties/csv/preferences" ;
	public static URL prefControlerPath = Main.class.getResource("view/TeacherPreferences.fxml") ;
	public static URL homePath = Main.class.getResource("view/Home.fxml") ;
	public static URL teacherControlerPath = Main.class.getResource("view/TeacherInformation.fxml");
	public static Stage primaryStage;
    private static HomeController homeControl;

  

   public static Teacher teacher ;


   public void showHome() throws IOException
   {
	   LOGGER.info("Entering the showHome method");
	   
      
           // Load the fxml file and create a new stage for the popup dialog.
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(Main.homePath);

           AnchorPane page = (AnchorPane) loader.load();
           LOGGER.info("Load successful");
           
           // Create the dialog Stage
           Stage dialogStage = new Stage();
           dialogStage.setTitle("Menu Principal");
           dialogStage.initModality(Modality.WINDOW_MODAL);
           dialogStage.initOwner(primaryStage);
           Scene scene = new Scene(page);
           dialogStage.setScene(scene);
           LOGGER.info("Creation successful");

           // Set the person into the controller.
           homeControl = loader.getController();
           homeControl.setDialogStage(dialogStage);

           // Show the dialog and wait until the user closes it
           dialogStage.showAndWait();

     
      
   }
   

	@Override
	public void start(Stage primaryStage1) throws IOException
	{
		Main.primaryStage = primaryStage1;
        Main.primaryStage.setTitle("Teach SpreadSheets");
        showHome();
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		Main.primaryStage = primaryStage;
	}
	
	

	public static void main(String[] args) throws Exception
	{
		try{
		LOGGER.info("Debut de l'application");
		launch();
		LOGGER.info("fin de l'application");
		}catch(Throwable e){
			LOGGER.error("ERREUR DU AU LANCEMENT DE L'APPLI");
			throw e;
			
		}
	}
}