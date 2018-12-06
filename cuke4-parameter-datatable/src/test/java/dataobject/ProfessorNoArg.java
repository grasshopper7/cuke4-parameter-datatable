package dataobject;

public class ProfessorNoArg {

	private String profName;
	
	public ProfessorNoArg() {}
	
	/*public ProfessorNoArg(String profName) {
		this.profName = profName;
	}*/

	public String getProfName() {
		return profName;
	}

	public void setProfName(String profName) {
		this.profName = profName;
	}
	
	public static ProfessorNoArg parseProfessor(String name) {
		ProfessorNoArg prof = new ProfessorNoArg();
		prof.setProfName(name);
		return prof;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((profName == null) ? 0 : profName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfessorNoArg other = (ProfessorNoArg) obj;
		if (profName == null) {
			if (other.profName != null)
				return false;
		} else if (!profName.equals(other.profName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Professor [profName=" + profName + "]";
	}
	
}
