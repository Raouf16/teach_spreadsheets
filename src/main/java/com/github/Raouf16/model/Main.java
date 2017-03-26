package com.github.Raouf16.model;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.github.Raouf16.model.teacherUtils.Teacher;
import com.github.Raouf16.controller.TeacherInformationController;
import com.github.Raouf16.model.writeCsv.*;
import com.github.Raouf16.model.excelWrite.*;
public class Main extends Application 
{
	
	private Stage primaryStage;
    private BorderPane rootLayout;
    private static TeacherInformationController controller ;
    
    
    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * @param teacher the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showPersonEditDialog(Teacher teacher)
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
            controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setTeacher(teacher);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
   
    
	@Override
	public void start(Stage primaryStage) 
	{
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Teach spreadsheets");
        showPersonEditDialog(new Teacher());
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
		Teacher t = controller.getTeacher();
		CsvFile.WriteTeacher("src/main/resources/com/github/Raouf16/test", t);
		TestWrite.writeInformations(t);
	}
}
