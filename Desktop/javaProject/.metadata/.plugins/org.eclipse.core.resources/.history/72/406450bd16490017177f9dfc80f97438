package com.github.Raouf16.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.apache.spark.sql.Column;

import com.github.Raouf16.model.Main;
import com.github.Raouf16.model.utils.teacher.*;

/**
 * Dialog to set personal information
 *
 * @author Sonia ASSAM
 */
public class TeacherInformationController
{
	

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField numEnField;
    @FXML
    private TextField adressField;
    @FXML
    private TextField personalEmailField;
    @FXML
    private TextField mobilePhoneField;
    @FXML
    private TextField officeField;
    @FXML
    private TextField  dauphinePhoneField;
    @FXML
    private TextField  dauphineEmailField;
    
   


    private Stage dialogStage;
    private boolean okClicked = false;
	private Teacher teacher = new Teacher();

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() 
    {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) 
    {
        this.dialogStage = dialogStage;
    }


    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() 
    {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() 
    {
        if (isInputValid()) 
        {
            teacher.setFirstName(firstNameField.getText());
            teacher.setLastName(lastNameField.getText());
            teacher.setNumEn(numEnField.getText());
            teacher.setAdress(adressField.getText());
            teacher.setDauphineEmail(dauphineEmailField.getText());
            teacher.setOffice(officeField.getText());
            teacher.setDauphinePhone(dauphinePhoneField.getText());
            teacher.setMobilePhone(mobilePhoneField.getText());
            teacher.setPersonalEmail(personalEmailField.getText());
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() 
    {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() 
    {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) 
        {
        	errorMessage += "Prenom invalide!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) 
        {
            errorMessage += "Nom invalide\n";
        }
        if (numEnField.getText() == null || numEnField.getText().length() == 0) 
        {
            errorMessage += "NUMEN invalide\n";
        }
        
        //TODO check if the numen isnt registred yet 


        if (errorMessage.length() == 0) return true;
        else 
        {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Corrigez les champs incorrectes");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }

	public Teacher getTeacher() 
	{
		return teacher;
	}
    
}