package bll;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.LeaderDao;
import dao.LeaderDaoImpl;
import dto.LeaderDto;
import model.Leader;

public class LeaderManagerImpl implements ILeaderManagement{
	
		private LeaderDao leaderDao = new LeaderDaoImpl();

		@Override
		public List<Leader> getAllLeaders() {
			// TODO Auto-generated method stub
			List<LeaderDto> leaders = leaderDao.getAllLeaders();
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			List<Leader> list = new ArrayList<>();

			for (LeaderDto lea : leaders) {
				Leader leader = new Leader();
				
				leader.setId(lea.getId());
				leader.setLastName(lea.getLastName());
				leader.setFirstName(lea.getFirstName());
				leader.setDateOfBirth(dateFormat.format(lea.getDateOfBirth()));   
				leader.setEmail(lea.getEmail());
				leader.setAddress(lea.getAddress());
				leader.setPhone(lea.getPhone());
				leader.setGender(lea.getGender());
				leader.setPosition(lea.getPosition());

				list.add(leader);
			}
			return list;
		}

		@Override
		public void insertLeader(Leader leader) {

			LeaderDto dto = new LeaderDto();
			if (leader != null) {
				// dto.setId(employee.getId());
				// dto.setProjectID(project.getProjectID());
				dto.setFirstName(leader.getFirstName());
				dto.setLastName(leader.getLastName());
				dto.setEmail(leader.getEmail());
				dto.setLastName(leader.getLastName());
				//dto.setGender(leader.getGender());
				dto.setPhone(leader.getPhone());

				leaderDao.insertLeader(dto);
			}			
		}

		@Override
		public void DeleteLeader(int leaderID) {
			if(leaderID !=0) {
			leaderDao.deleteLeader(leaderID);
	
			}
							
		}

		@Override
		public void updateLeader(Leader leader) {
			SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date date = null;
			try {
				date = dateFormater.parse(leader.getDateOfBirth());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			LeaderDto dto = new LeaderDto();
			if (leader != null) {

				dto.setId(leader.getId());
				dto.setFirstName(leader.getFirstName());
				dto.setLastName(leader.getLastName());
				dto.setEmail(leader.getEmail());
				dto.setDateOfBirth(new Date(date.getTime()));
				dto.setPhone(leader.getPhone());
				dto.setAddress(leader.getAddress());

				leaderDao.updateLeader(dto);;
			}
			
		}
}

	


