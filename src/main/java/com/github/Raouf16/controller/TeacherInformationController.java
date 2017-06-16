package com.github.Raouf16.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import com.github.Raouf16.model.main.Main;
import com.github.Raouf16.model.utils.io.csv.read.CsvReader;
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
    @FXML 
    private TextField disciplineField;
    @FXML 
    private TextField postalCodeField;
    @FXML 
    private ComboBox<String> civility ;
    
   


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
    	String [] civ = {"Mr", "Mme", "Mlle"}; 
    	ObservableList<String> tmp = FXCollections.observableArrayList();
    	for (String c : civ) tmp.add(c);
    	civility.setItems(tmp);
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
     * @throws IOException 
     * @throws IllegalArgumentException 
     */
    @FXML
    private void handleOk() throws IllegalArgumentException, IOException 
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
            teacher.setCivility(civility.getSelectionModel().getSelectedItem());
            teacher.setDiscipline(disciplineField.getText());
            teacher.setPostalCode(postalCodeField.getText());
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
     * @throws IOException 
     * @throws IllegalArgumentException 
     */
    private boolean isInputValid() throws IllegalArgumentException, IOException 
    {
        String errorMessage = "";
        
        if (civility== null || civility.getSelectionModel().getSelectedItem().equals("Selection"))
        {
        	errorMessage += "Civilité invalide!\n";
        }
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
        if (disciplineField.getText() == null || disciplineField.getText().length() == 0)
        {
        	 errorMessage += "Discipline invalide\n";
        }
        
    
        	
        //check if the numen is not already in the csv teachers file
        if (errorMessage.length() == 0)
        {
        	CsvReader cr = new CsvReader();
        	Teacher t = cr.getTeacherByNumEn(Main.teachersFilePath, numEnField.getText());
        	if (t != null) errorMessage += "Numen existant!";
        }
        
        if (errorMessage.length() == 0) return true;
		// Show the error message.
		Alert alert = new Alert(AlertType.ERROR);
		alert.initOwner(dialogStage);
		alert.setTitle("Invalid Fields");
		alert.setHeaderText("Corrigez les champs incorrectes");
		alert.setContentText(errorMessage);
		alert.showAndWait();
		return false;
    }

	public Teacher getTeacher() 
	{
		return teacher;
	}
    
}