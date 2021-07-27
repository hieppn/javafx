package dao;

import java.util.List;

import dto.ProjectDto;
import model.Project;

public interface ProjectDao {

		public ProjectDto getProjectById(Integer projectID);
		
		public List<ProjectDto> getAllProjects();
		
		public void insertProject(ProjectDto project);
		
		public void deleteProject(Integer projectID);
		
	public void updateProject(ProjectDto project);
		
		//public ProjectDto getProjectByCode(String code);

	}


