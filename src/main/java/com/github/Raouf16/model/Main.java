package com.github.Raouf16.model;


import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.github.Raouf16.model.teacherUtils.Teacher;
import com.github.Raouf16.model.preferenceUtils.Preference;
import com.github.Raouf16.controller.TeacherInformationController;
import com.github.Raouf16.controller.HomeController;
import com.github.Raouf16.model.writeCsv.*;
import com.github.Raouf16.model.excelWrite.*;

public class Main extends Application 
{
	
	private static Stage primaryStage;
    private BorderPane rootLayout;
    private static HomeController controller1;
    private static TeacherInformationController controller2;
    
    
    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * @param teacher the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     * @throws IOException 
     */
    public static boolean showPersonEditDialog(Teacher teacher)
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
            controller2 = loader.getController();
            controller2.setDialogStage(dialogStage);
            controller2.setTeacher(teacher);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller2.isOkClicked();
        } catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public void showHome() throws IOException
    {
        
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/Home.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Home title");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            controller1 = loader.getController();
            controller1.setDialogStage(dialogStage);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
          
    }     
   
    
	@Override
	public void start(Stage primaryStage) throws IOException 
	{
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Teach spreadsheets");
        showHome();
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	private void initRootLayout()
	{
		try
		{
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            //primaryStage.show();
        } catch (IOException e)
		{
            e.printStackTrace();
        }

	}

	public static void main(String[] args) throws Exception
	{
		launch(args);

	}
}
