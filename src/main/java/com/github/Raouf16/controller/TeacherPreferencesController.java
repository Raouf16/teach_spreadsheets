package com.github.Raouf16.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.odftoolkit.simple.SpreadsheetDocument;

import com.github.Raouf16.model.main.Main;
import com.github.Raouf16.model.utils.io.spreadsheet.read.ReadBorder;
import com.github.Raouf16.model.utils.io.spreadsheet.read.ReadData;
import com.github.Raouf16.model.utils.preference.*;
import com.github.Raouf16.model.utils.teacher.*;

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
	private SpreadsheetDocument spreadSheetReadingData;	
	private List<Preference> tmpPref = new ArrayList<> ();
	private boolean addedPref = false;

	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
	 * @throws Exception 
     */
	
	public TeacherPreferencesController() throws Exception
	{
		System.out.println(Main.fileReadingData.getAbsolutePath());
		spreadSheetReadingData = SpreadsheetDocument.loadDocument(Main.fileReadingData);
	}
	
    @FXML
    private void initialize() 
    {
    	
    	ReadData rd = new ReadData();
        // Initialize the teacher's information
    	teacher = Main.teacher;
    	firstNameField.setText(teacher.firstName);
    	lastNameField.setText(teacher.lastName);
    	numEnField.setText(teacher.numEn);
    	formationsData.addAll(rd.getFilieres(spreadSheetReadingData));
    	formations.setItems(formationsData);
    	formations.setOnAction((event) -> {
    	    String formation = formations.getSelectionModel().getSelectedItem();
    	    if (formation != null) loadSemesters(formation);
    	});
    	
    	semester.setItems(semesterData);
    	semester.setOnAction((event) -> {
    	    loadCourses();
    	});
    	
    	courses.setOnAction((event) -> {
    	    String course = courses.getSelectionModel().getSelectedItem();
    	    String sem = semester.getSelectionModel().getSelectedItem();
    	    String formation = formations.getSelectionModel().getSelectedItem();
    	    loadChoices(formation, sem, course);
    	});
    
    }

    
    private void loadCourses() 
    {
    	ReadData rd = new ReadData();
    	courses.getItems().clear();
		courses.getItems().addAll(rd.getCourses(spreadSheetReadingData, 
								  formations.getSelectionModel().getSelectedItem(),
								  semester.getSelectionModel().getSelectedItem()));
	}
    
    
	private void loadSemesters(String formation)
    {
		ReadData rd = new ReadData();
		semester.getItems().clear();
    	semester.getItems().addAll(rd.getSemesters(spreadSheetReadingData, formation));
    	courses.getItems().clear();
    }
	
	
	private void loadChoices(String formation, String semester1, String course)
    {
		
		String [] choices = new String[3];
    	choices[0] = "A";
    	choices[1] = "B";
    	choices[2] = "C";
    	
    	courseChoice.getItems().clear();
		cmTDChoice.getItems().clear();
		tpChoice.getItems().clear();
		
		ReadBorder rb = new ReadBorder();
    	if (rb.isCourseDiagonalBorder(spreadSheetReadingData, formation, semester1, course) == false)
    	{
    		courseChoice.setDisable(false);
    		courseChoice.getItems().setAll(choices);
    	}
    	else courseChoice.setDisable(true);
    	
    	if (rb.isTdDiagonalBorder(spreadSheetReadingData, formation, semester1, course) == false)
    	{
    		cmTDChoice.setDisable(false);
    		cmTDChoice.getItems().setAll(choices);
    	}
    	else cmTDChoice.setDisable(true);
    	
    	if (rb.isTpDiagonalBorder(spreadSheetReadingData, formation, semester1, course) == false)
    	{
    		tpChoice.setDisable(false);
    		tpChoice.getItems().setAll(choices);
    	}	
    	else tpChoice.setDisable(true);
    	
    	choices = new String[4];
    	for (int i=1; i<5; i++) choices[i-1] = ""+i;
    	groupNumber.getItems().setAll(choices);
    }
    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) 
    {
    	this.dialogStage = dialogStage;
    	this.dialogStage.setOnCloseRequest(event -> {
    	    handleCancel();
    	});
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
     * Called to check if all the fields are empty
     */
    
    public boolean areEmptyFields()
    {
    	boolean empty = false;
    	if (formations.getSelectionModel().getSelectedItem() == null || formations.getSelectionModel().getSelectedItem().length() == 0) 
	        empty = true;
    	else empty = false;
        if (semester.getSelectionModel().getSelectedItem() == null || semester.getSelectionModel().getSelectedItem().length() == 0) 
        	empty = true;
        else empty = false;
        if (courses.getSelectionModel().getSelectedItem() == null || courses.getSelectionModel().getSelectedItem().length() == 0) 
        	empty = true;
        else empty = false;
        if (groupNumber.getSelectionModel().getSelectedItem() == null || courses.getSelectionModel().getSelectedItem().length() == 0)
        	empty = true;
        else empty = false;
        if (experience.getText() == null || experience.getText().length() == 0)
        	empty = true;
        else empty = false;
   
        return empty;
    }

    /**
     * Called when the user clicks valid.
     */
    @FXML
    private void handleValid() 
    {
    	if (!areEmptyFields()) addPreference();
    	else
    	{
    		teacher.setPreferences(tmpPref);
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
    	if (!addedPref) dialogStage.close();
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.initOwner(dialogStage);
    	alert.setTitle("Vous êtes sur le point de quitter");
    	alert.setHeaderText("Vouliez vous vraiment quitter ?");
    	alert.setContentText("Les préférences que vous aviez ajouté seront perdus");
    	ButtonType buttonOK = new ButtonType("OK");
    	ButtonType buttonCancel = new ButtonType("Annuler", ButtonData.CANCEL_CLOSE);
    	alert.getButtonTypes().setAll(buttonOK, buttonCancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonOK) dialogStage.close();
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
			preference.setSubject(courses.getSelectionModel().getSelectedItem().replace("\n", ""));
			preference.setChoiceCourse(courseChoice.getSelectionModel().getSelectedItem());
			preference.setChoiceTD(cmTDChoice.getSelectionModel().getSelectedItem());
			preference.setChoiceTP(tpChoice.getSelectionModel().getSelectedItem());
			preference.setNbrTD(groupNumber.getSelectionModel().getSelectedItem());
			preference.setNbrYear(experience.getText());
			tmpPref.add(preference);
			if (!addedPref) addedPref = true;
			refresh();
			initialize();
		}		
	}
	
	private void refresh()
	{
		formations.getItems().clear();
		semester.getItems().clear();
		courses.getItems().clear();
		courseChoice.getItems().clear();
		cmTDChoice.getItems().clear();
		tpChoice.getItems().clear();
		groupNumber.getItems().clear();
		experience.clear();
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