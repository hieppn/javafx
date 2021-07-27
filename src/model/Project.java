package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Project {
	private SimpleIntegerProperty projectID;
	private SimpleStringProperty projectName;
	private SimpleStringProperty projectLocation;
	
	public Project() {
		this.projectID = new SimpleIntegerProperty();
		this.projectName = new SimpleStringProperty();
		this.projectLocation = new SimpleStringProperty();
	}

	public Project(int projectID, String projectName, String projectLocation) {
		this.projectID = new SimpleIntegerProperty(projectID);
		this.projectName = new SimpleStringProperty(projectName);
		this.projectLocation = new SimpleStringProperty(projectLocation);

	}
	
	public Project( String projectName, String projectLocation) {
		this.projectID = new SimpleIntegerProperty();
		this.projectName = new SimpleStringProperty(projectName);
		this.projectLocation = new SimpleStringProperty(projectLocation);

	}

	public int getProjectID() {
		return projectID.get();
	}

	public void setProjectID (int projectID) {
		this.projectID.set(projectID);
	}

	public String getProjectName() {
		return projectName.get();
	}

	public void setProjectName(String projectName) {
		this.projectName.set(projectName);
		;
	}

	public String getProjectLocation() {
		return projectLocation.get();
	}

	public void setProjectLocation(String projectLocation) {
		this.projectLocation.set(projectLocation);
		;
	}

}
