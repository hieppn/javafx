package dao;

import java.util.List;

import dto.LeaderDto;
import dto.ProjectDto;
import dto.TeamMemberDto;

public interface TeamMemberDao {

		public TeamMemberDto getTeamMemberById(Integer teamMemberID);
		
		public List<TeamMemberDto> getAllTeamMembers();
		
		public void insertTeamMember(TeamMemberDto teamMember);
	
		
		public void deleteTeamMember(Integer teamMemberID);
		
		public void updateTeamMember(TeamMemberDto teamMember);

		TeamMemberDto getTeamMemberByPosition(String teamMemberPosition);
		public List<TeamMemberDto> getAllTeamMembersDoProject(int projectId);
		

	}



