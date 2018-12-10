package dataobject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lectures {


	private List<Lecture> lectures;
	
	public Lectures() {}

	public Lectures(List<Lecture> lectures) {
		this.lectures = lectures;
	}
	
	public List<Lecture> getLectures() {
		return Collections.unmodifiableList(lectures);
	}
	
	public boolean addLecture(Lecture lect) {
		return lectures.add(lect);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lectures == null) ? 0 : lectures.hashCode());
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
		Lectures other = (Lectures) obj;
		if (lectures == null) {
			if (other.lectures != null)
				return false;
		} else if (!lectures.equals(other.lectures))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lectures [lectures=" + lectures + "]";
	}
	
	
}
