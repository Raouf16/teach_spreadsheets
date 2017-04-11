package com.github.Raouf16.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.github.Raouf16.model.teacherUtils.Teacher;

/**
 * Dialog to set personal information
 *
 * @author Sonia ASSAM
 */
public class TeacherPreferencesController
{
	
    @FXML
    private Label firstNameField;
    @FXML
    private Label lastNameField;
    @FXML
    private Label numEnField;
    
    
   


    private Stage dialogStage;
    private boolean okClicked = false;
	private Teacher teacher;

	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() 
    {
        // Initialize the person table with the two columns.
        numEnField.setText("12364");
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
     * Sets the person to be edited in the dialog.
     *
     * @param person
     */
    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;

        firstNameField.setText(teacher.getFirstName());
        lastNameField.setText(teacher.getFirstName());
        numEnField.setText(teacher.getNumEn());
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
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }



	public Teacher getTeacher() {
		return teacher;
	}
    
}