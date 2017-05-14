package com.github.Raouf16.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import org.jopendocument.dom.spreadsheet.SpreadSheet;

import com.github.Raouf16.model.Main;
import com.github.Raouf16.model.excelRead.ReadData;
import com.github.Raouf16.model.preferenceUtils.Preference;
import com.github.Raouf16.model.teacherUtils.Teacher;

/**
 * Dialog to set personal information
 *
 * @author Sonia ASSAM & Raouf HADDAD
 */
public class TeacherPreferencesController
{
	
    @FXML
    private Label firstNameField = new Label();
    @FXML
    private Label lastNameField = new Label();
    @FXML
    private Label numEnField = new Label();
    @FXML 
    private ComboBox<String> formations ;
    private ObservableList<String> formationsData = FXCollections.observableArrayList();
    @FXML 
    private ComboBox <String> courses ;
    @FXML
    private ComboBox <String> semester;
    private ObservableList<String> semesterData = FXCollections.observableArrayList();
    @FXML 
    private ComboBox<String> courseChoice;
    @FXML 
    private ComboBox<String> cmTDChoice;
    @FXML
    private ComboBox<String> tpChoice;
    @FXML 
    private ComboBox<String> groupNumber ;
    @FXML 
    private TextField experience;
    
    
    
    private Stage dialogStage;
    private boolean okClicked = false;
	private Teacher teacher = Main.teacher;
	private SpreadSheet spreadSheetReadingData;	

	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
	 * @throws IOException 
     */
	
	public TeacherPreferencesController() throws IOException
	{
		spreadSheetReadingData = SpreadSheet.createFromFile(Main.fileReadingData);
	}
    @FXML
    private void initialize() throws IOException 
    {
        // Initialize the teacher's information
    	teacher = Main.teacher;
    	firstNameField.setText(teacher.firstName);
    	lastNameField.setText(teacher.lastName);
    	numEnField.setText(teacher.numEn);
    	formationsData.addAll(ReadData.getFilieres(spreadSheetReadingData));
    	formations.setItems(formationsData);
    	formations.setOnAction((event) -> {
    	    String formation = formations.getSelectionModel().getSelectedItem();
    	    try {loadSemesters(formation);}
    	    catch (IOException e) {}
    	});
    	
    	semester.setItems(semesterData);
    	semester.setOnAction((event) -> {
    	    String sem = semester.getSelectionModel().getSelectedItem();
    	    loadCourses(sem);
    	});
    	
    	String [] choices = new String[3];
    	choices[0] = "A";
    	choices[1] = "B";
    	choices[2] = "C";
    	
    	courseChoice.getItems().setAll(choices);
    	cmTDChoice.getItems().setAll(choices);
    	tpChoice.getItems().setAll(choices);
    	
    	choices = new String[4];
    	for (int i=1; i<5; i++) choices[i-1] = ""+i;
    	
    	groupNumber.getItems().setAll(choices);
    }

    
    private void loadCourses(String sem) 
    {
    	courses.getItems().clear();
		courses.getItems().addAll(ReadData.getCourses(spreadSheetReadingData, 
								  formations.getSelectionModel().getSelectedItem(),
								  semester.getSelectionModel().getSelectedItem()));
	}
    
    
	private void loadSemesters(String formation) throws IOException
    {
		semester.getItems().clear();
    	semester.getItems().addAll(ReadData.getSemesters(spreadSheetReadingData, formation));
    	courses.getItems().clear();
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
    	System.out.println("OK");
    	okClicked = true;
    }
   

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

	public Teacher getTeacher() 
	{
		return teacher;
	}
	
	@FXML 
	private void addPreference()
	{
		if (isInputValid())
		{
			Preference preference = new Preference();
			preference.setYear(formations.getSelectionModel().getSelectedItem());
			preference.setSemester(semester.getSelectionModel().getSelectedItem());
			preference.setSubject(courses.getSelectionModel().getSelectedItem());
			preference.setChoiceCourse(courseChoice.getSelectionModel().getSelectedItem());
			preference.setChoiceTD(cmTDChoice.getSelectionModel().getSelectedItem());
			preference.setChoiceTP(tpChoice.getSelectionModel().getSelectedItem());
			preference.setNbrTD(groupNumber.getSelectionModel().getSelectedItem());
			preference.setNbrYear(experience.getText());
			teacher.addPreference(preference);
			refresh();
			//addToListChoice
			System.out.println("The preference was added");
		}		
	}
	
	private void refresh()
	{
		semester.getItems().clear();
		courses.getItems().clear();
		courseChoice.getItems().clear();
		cmTDChoice.getItems().clear();
		tpChoice.getItems().clear();
		groupNumber.getItems().clear();
	}
	
	
	private boolean isInputValid() 
    {
        String errorMessage = "";

        if (formations.getSelectionModel().getSelectedItem() == null || formations.getSelectionModel().getSelectedItem().length() == 0) 
        {
        	errorMessage += "Formation indéfinie!\n";
        }
        if (semester.getSelectionModel().getSelectedItem() == null || semester.getSelectionModel().getSelectedItem().length() == 0) 
        {
            errorMessage += "Semestre indéfini!\n";
        }
        if (courses.getSelectionModel().getSelectedItem() == null || courses.getSelectionModel().getSelectedItem().length() == 0) 
        {
            errorMessage += "Cours indéfini!\n";
        }


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
	
}