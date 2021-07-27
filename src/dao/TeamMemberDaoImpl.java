package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.TeamMemberDto;

public class TeamMemberDaoImpl implements TeamMemberDao{

	@Override
	public List<TeamMemberDto> getAllTeamMembersDoProject(int projectId) {
			// TODO Auto-generated method stub
			Connection connection = ConnectionPerson.getConnection();
			try {
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT U.ID, U.FIRSTNAME, U.LASTNAME, U.EMAIL, U.POSITION, U.GENDER, "
						+ "U.BIRTHDAY, U.PHONE_NUMBER ,U.ADDRESS, A.PROJECTID\r\n" + 
						
						"FROM USERS U, PROJECT1 P, ASSIGNMENT A\r\n" + 
						"WHERE U.ID = A.EMPID AND P.PROJECTID = A.PROJECTID AND P.PROJECTID = " + projectId + "");
				
				List<TeamMemberDto> teamMembers = new ArrayList<>();
				while (rs.next()) {
					TeamMemberDto teamMember = new TeamMemberDto();
					teamMember.setId(rs.getInt("ID"));
					teamMember.setLastName(rs.getString("LASTNAME"));
					teamMember.setFirstName(rs.getString("FIRSTNAME"));
					teamMember.setDateOfBirth(rs.getDate("BIRTHDAY"));
					teamMember.setEmail(rs.getString("EMAIL"));
					teamMember.setAddress(rs.getString("ADDRESS"));
					teamMember.setPhone(rs.getString("PHONE_NUMBER"));
					teamMember.setGender(rs.getString("GENDER"));
					teamMember.setPosition(rs.getString("POSITION"));
					
					
					teamMembers.add(teamMember);
				}

				return teamMembers;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			return null;
		}

	@Override
	public TeamMemberDto getTeamMemberById(Integer teamMemberID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeamMemberDto> getAllTeamMembers() {
		// TODO Auto-generated method stub
		Connection connection = ConnectionPerson.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE POSITION = 'Team member'");
			
			List<TeamMemberDto> teamMembers = new ArrayList<>();
			while (rs.next()) {
				TeamMemberDto teamMember = new TeamMemberDto();
				teamMember.setId(rs.getInt("ID"));
				teamMember.setLastName(rs.getString("LASTNAME"));
				teamMember.setFirstName(rs.getString("FIRSTNAME"));
				teamMember.setDateOfBirth(rs.getDate("BIRTHDAY"));
				teamMember.setEmail(rs.getString("EMAIL"));
				teamMember.setAddress(rs.getString("ADDRESS"));
				teamMember.setPhone(rs.getString("PHONE_NUMBER"));
				teamMember.setGender(rs.getString("GENDER"));
				teamMember.setPosition(rs.getString("POSITION"));
				
				
				teamMembers.add(teamMember);
			}

			return teamMembers;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertTeamMember(TeamMemberDto teamMember) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionPerson.getConnection();
		try {
			String queryString = "INSERT INTO USERS VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(queryString);
			//ps.setInt(1, project.getProjectID());
			
			
			ps.setString(1, teamMember.getLastName());
			ps.setString(2, teamMember.getFirstName());
			ps.setString(3, teamMember.getAddress());
			ps.setString(4, teamMember.getPhone());
			ps.setDate(  5, teamMember.getDateOfBirth());
			ps.setString(6, teamMember.getGender());
			ps.setString(7, teamMember.getEmail());
			ps.setString(8, teamMember.getPosition());

			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}


	@Override
	public void deleteTeamMember(Integer teamMemberID) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionPerson.getConnection();
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("DELETE FROM USERS WHERE ID = '" + teamMemberID + "'");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	

	@Override
	public void updateTeamMember(TeamMemberDto member) {
		Connection connection = ConnectionPerson.getConnection();
		try {
			String queryString = "UPDATE USERS SET FIRSTNAME =?,LASTNAME=?,BIRTHDAY = ?, EMAIL=?, PHONE_NUMBER = ?, ADDRESS = ? WHERE ID = ?";
			PreparedStatement ps = connection.prepareStatement(queryString);
			ps.setString(1, member.getFirstName());
			ps.setString(2, member.getLastName());
			ps.setDate(3, member.getDateOfBirth());
			ps.setString(4,member.getEmail());
			ps.setString(5, member.getPhone());
			ps.setString(6,member.getAddress());
			ps.setInt(7, member.getId());
			 
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	
	@Override
	public TeamMemberDto getTeamMemberByPosition(String teamMemberPosition) {
		// TODO Auto-generated method stub
		return null;
	}

		
}
