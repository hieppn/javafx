package bll;

import java.util.ArrayList;
import java.util.List;

import dao.ProjectDao;
import dao.ProjectDaoImpl;
import dto.ProjectDto;
import model.Project;

public class ProjectManagerImpl implements IProjectManagement {

	private ProjectDao projectDao = new ProjectDaoImpl();

	@Override
	public List<Project> getAllProjects() {
		List<ProjectDto> projects = projectDao.getAllProjects();

		List<Project> list = new ArrayList<>();

		for (ProjectDto pro : projects) {
			Project project = new Project();

			project.setProjectID(pro.getProjectID());
			project.setProjectName(pro.getProjectName());
			project.setProjectLocation(pro.getProjectLocation());

			list.add(project);
		}
		return list;
	}

	@Override
	public void insertProject(Project project) {
		// TODO Auto-generated method stub

		ProjectDto dto = new ProjectDto();
		if (project != null) {
			// dto.setId(employee.getId());
			// dto.setProjectID(project.getProjectID());
			dto.setProjectName(project.getProjectName());
			dto.setProjectLocation(project.getProjectLocation());

			projectDao.insertProject(dto);
		}
	}

	public void UpdateEmployee(Project project) {

		ProjectDto dto = new ProjectDto();
		if (project != null) {
			// dto.setId(employee.getId());
			dto.setProjectID(project.getProjectID());
			dto.setProjectName(project.getProjectName());
			dto.setProjectLocation(project.getProjectLocation());

			projectDao.updateProject(dto);

		}

	}

	@Override
	public void DeleteProject(int projectID) {
		// TODO Auto-generated method stub
		if (projectID != 0) {
			projectDao.deleteProject(projectID);
		}
	}

	@Override
	public void updateProject(Project project) {

		ProjectDto dto = new ProjectDto();
		if (project != null) {

			dto.setProjectName(project.getProjectName());
			dto.setProjectLocation(project.getProjectLocation());
			dto.setProjectID(project.getProjectID());

			projectDao.updateProject(dto);
		}
	}

}
