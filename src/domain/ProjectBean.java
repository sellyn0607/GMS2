package domain;

public class ProjectBean {
	
	protected String teamId,teamName;

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public String toString() {
		return "ProjectBean [teamId=" + teamId + ", teamName=" + teamName + "]";
	}
	
	
	
}
