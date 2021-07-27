package dao;

import java.util.List;

import dto.LeaderDto;

public interface LeaderDao {

		public LeaderDto getLeaderById(Integer leaderID);
		
		public List<LeaderDto> getAllLeaders();
		
		public void insertLeader(LeaderDto leader);
		
		public void deleteLeader(Integer leaderID);
		
		public void updateLeader(LeaderDto leader);

		LeaderDto getLeaderByPosition(String leaderPosition);
		

	}


