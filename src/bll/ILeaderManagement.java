package bll;

import java.util.List;

import javafx.util.Callback;
import model.Leader;

public interface ILeaderManagement {

			
			public List<Leader> getAllLeaders();

			public void insertLeader(Leader leader);

			public void DeleteLeader(int leaderID);
			public void updateLeader(Leader leader);




		}






