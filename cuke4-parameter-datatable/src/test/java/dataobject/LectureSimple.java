package dataobject;

import java.util.Map;

public class LectureSimple {

	private Professor profName;
	
	private int size;
		
	private ProfLevels profLevel;

	public Professor getProfName() {
		return profName;
	}
	public void setProfName(Professor profName) {
		this.profName = profName;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public ProfLevels getProfLevel() {
		return profLevel;
	}
	public void setProfLevel(ProfLevels profLevel) {
		this.profLevel = profLevel;
	}
	
	public static LectureSimple createLecture(Map<String, String> entry) {
		LectureSimple lecture = new LectureSimple();
		lecture.setProfName(new Professor(entry.get("profName")));
		lecture.setSize(Integer.parseInt(entry.get("size")));
		lecture.setProfLevel(ProfLevels.valueOf(entry.get("profLevel").toUpperCase()));
		return lecture;
	}
	@Override
	public String toString() {
		return "LectureSimple [profName=" + profName + ", size=" + size + ", profLevel=" + profLevel + "]";
	}	
}
