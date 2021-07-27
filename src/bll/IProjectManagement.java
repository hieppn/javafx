package bll;

import java.util.List;

import model.Project;

public interface IProjectManagement {

	public List<Project> getAllProjects();

	public void insertProject(Project project);

	public void DeleteProject(int projectID);

	public void updateProject(Project project);
}
