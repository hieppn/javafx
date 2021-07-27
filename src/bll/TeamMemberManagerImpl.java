package bll;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.TeamMemberDao;
import dao.TeamMemberDaoImpl;
import dto.LeaderDto;
import dto.ProjectDto;
import dto.TeamMemberDto;
import model.Leader;
import model.TeamMember;

public class TeamMemberManagerImpl implements ITeamMemberManagement {

	private TeamMemberDao teamMemberDao = new TeamMemberDaoImpl();

	@Override
	public void DeleteTeamMember(int teamMemberID) {
		// TODO Auto-generated method stub
		if (teamMemberID != 0) {
			teamMemberDao.deleteTeamMember(teamMemberID);
		}
	}

	@Override
	public List<TeamMember> getAllTeamMembers() {
		// TODO Auto-generated method stub
		List<TeamMemberDto> teamMembers = teamMemberDao.getAllTeamMembers();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		List<TeamMember> list = new ArrayList<>();

		for (TeamMemberDto member : teamMembers) {
			TeamMember teamMember = new TeamMember();

			teamMember.setId(member.getId());
			teamMember.setLastName(member.getLastName());
			teamMember.setFirstName(member.getFirstName());
			teamMember.setDateOfBirth(dateFormat.format(member.getDateOfBirth()));
			teamMember.setEmail(member.getEmail());
			teamMember.setAddress(member.getAddress());
			teamMember.setPhone(member.getPhone());
			teamMember.setGender(member.getGender());
			teamMember.setPosition(member.getPosition());

			list.add(teamMember);
		}
		return list;
	}

	@Override
	public void insertTeamMember(TeamMember teamMember) {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date date = null;

		try {
			date = dateFormat.parse(teamMember.getDateOfBirth());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		TeamMemberDto dto = new TeamMemberDto();
		if (teamMember != null) {

			dto.setId(teamMember.getId());
			dto.setLastName(teamMember.getLastName());
			dto.setFirstName(teamMember.getFirstName());
			dto.setAddress(teamMember.getAddress());
			dto.setPhone(teamMember.getPhone());
			dto.setDateOfBirth(new Date(date.getTime()));
			dto.setGender(teamMember.getGender());
			dto.setEmail(teamMember.getEmail());
			dto.setPosition(teamMember.getPosition());

			teamMemberDao.insertTeamMember(dto);
		}

	}
	@Override
	public void updateMember(TeamMember leader) {
		SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = null;
		try {
			date = dateFormater.parse(leader.getDateOfBirth());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		TeamMemberDto dto = new TeamMemberDto();
		if (leader != null) {

			dto.setId(leader.getId());
			dto.setFirstName(leader.getFirstName());
			dto.setLastName(leader.getLastName());
			dto.setEmail(leader.getEmail());
			dto.setDateOfBirth(new Date(date.getTime()));
			dto.setPhone(leader.getPhone());
			dto.setAddress(leader.getAddress());

			teamMemberDao.updateTeamMember(dto);;
		}
		
	}
	@Override
	public List<TeamMember> getAllTeamMembersDoProject(int projectId) {
		// TODO Auto-generated method stub
		List<TeamMemberDto> teamMembers = teamMemberDao.getAllTeamMembersDoProject(projectId);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		List<TeamMember> list = new ArrayList<>();

		for (TeamMemberDto member : teamMembers) {
			TeamMember teamMember = new TeamMember();

			teamMember.setId(member.getId());
			teamMember.setLastName(member.getLastName());
			teamMember.setFirstName(member.getFirstName());
			teamMember.setDateOfBirth(dateFormat.format(member.getDateOfBirth()));
			teamMember.setEmail(member.getEmail());
			teamMember.setAddress(member.getAddress());
			teamMember.setPhone(member.getPhone());
			teamMember.setGender(member.getGender());
			teamMember.setPosition(member.getPosition());

			list.add(teamMember);
		}
		return list;
	}
	

}
