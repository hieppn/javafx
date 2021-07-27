package dto;

public class ProjectDto {
	

		private int projectID;
		private String projectName;
		private String projectLocation;
		
		public ProjectDto() {

		}

		public ProjectDto(int projectID, String projectName, String projectLocation ) {
			this.projectID = projectID;
			this.projectName = projectName;
			this.projectLocation = projectLocation;
			
		}
		
		public ProjectDto(String projectName, String projectLocation) {
			this.projectName = projectName;
			this.projectLocation = projectLocation;
		}

		public int getProjectID() {
			return projectID;
		}

		public void setProjectID(int projectID) {
			this.projectID = projectID;
		}
		
		public String getProjectName() {
			return projectName;
		}
		
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public String getProjectLocation() {
			return projectLocation;
		}

		public void setProjectLocation(String projectLocation) {
			this.projectLocation = projectLocation;
		}



}
