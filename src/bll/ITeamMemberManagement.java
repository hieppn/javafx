package bll;

import java.util.List;

import model.TeamMember;

public interface ITeamMemberManagement {

			
			public List<TeamMember> getAllTeamMembers();

			public void insertTeamMember(TeamMember teamMember);

			public void DeleteTeamMember(int teamMemberID);
			public void updateMember(TeamMember member);
			public List<TeamMember> getAllTeamMembersDoProject(int projectId);

		}






