package dataobject;

import java.util.List;
import java.util.Map;

public class LectureLite {

	private Professor profName;
	
	private Topic topic;
	
	private int size;
	
	private int frequency;
	
	private Rooms rooms;

	public Professor getProfName() {
		return profName;
	}

	public void setProfName(Professor profName) {
		this.profName = profName;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public Rooms getRooms() {
		return rooms;
	}

	public void setRooms(Rooms rooms) {
		this.rooms = rooms;
	}

	public static LectureLite createLectureLite(List<String> row) {
		LectureLite lecture = new LectureLite();
		lecture.setProfName(new Professor(row.get(0)));
		lecture.setTopic(Topic.parseTopic(row.get(1)));
		lecture.setSize(Integer.parseInt(row.get(2)));
		lecture.setFrequency(Integer.parseInt(row.get(3)));
		lecture.setRooms(Rooms.parseRooms(row.get(4)));
		return lecture;
	}
	
	@Override
	public String toString() {
		return "LectureLite [profName=" + profName + ", topic=" + topic + ", size=" + size + ", frequency=" + frequency
				+ ", rooms=" + rooms + "]";
	}

}
