package dataobject;

import java.util.Map;

public class LecturePrimitive {

	private String profName;
	
	private int size;
		
	private String profLevel;

	public String getProfName() {
		return profName;
	}
	public void setProfName(String profName) {
		this.profName = profName;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getProfLevel() {
		return profLevel;
	}
	public void setProfLevel(String profLevel) {
		this.profLevel = profLevel;
	}

	public static LecturePrimitive createLecture(Map<String, String> entry) {
		LecturePrimitive lecture = new LecturePrimitive();
		lecture.setProfName(entry.get("profName"));
		lecture.setSize(Integer.parseInt(entry.get("size")));
		lecture.setProfLevel(entry.get("profLevel"));
		return lecture;
	}
	@Override
	public String toString() {
		return "LecturePrimitive [profName=" + profName + ", size=" + size + ", profLevel=" + profLevel + "]";
	}
	
}
