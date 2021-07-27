package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.ProjectDto;

public class ProjectDaoImpl implements ProjectDao {

	@Override
	public ProjectDto getProjectById(Integer projectID) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionPerson.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PROJECT1 WHERE ID = '" + projectID + "'");

			if (rs.next()) {
				ProjectDto project = new ProjectDto();
				project.setProjectID(rs.getInt("PROJECTID"));
				project.setProjectName(rs.getString("PROJECTNAME"));
				project.setProjectLocation(rs.getString("LOCATION"));

				return project;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProjectDto> getAllProjects() {
		// TODO Auto-generated method stub
		Connection connection = ConnectionPerson.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PROJECT1");
			List<ProjectDto> projects = new ArrayList<>();
			while (rs.next()) {
				ProjectDto project = new ProjectDto();
				project.setProjectID(rs.getInt("PROJECTID"));
				project.setProjectName(rs.getString("PROJECTNAME"));
				project.setProjectLocation(rs.getString("LOCATION"));

				projects.add(project);
			}

			return projects;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertProject(ProjectDto project) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionPerson.getConnection();
		try {
			String queryString = "INSERT INTO PROJECT1 VALUES(null, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(queryString);
			// ps.setInt(1, project.getProjectID());
			ps.setString(1, project.getProjectName());
			ps.setString(2, project.getProjectLocation());

			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteProject(Integer projectID) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionPerson.getConnection();
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("DELETE FROM PROJECT1 WHERE PROJECTID = '" + projectID + "'");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updateProject(ProjectDto project) {
		Connection connection = ConnectionPerson.getConnection();
		try {
			String queryString = "UPDATE PROJECT1 SET PROJECTNAME = ?, LOCATION = ? WHERE PROJECTID = ?";
			PreparedStatement ps = connection.prepareStatement(queryString);
			ps.setString(1, project.getProjectName());
			ps.setString(2, project.getProjectLocation());
			ps.setInt(3, project.getProjectID());

			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
