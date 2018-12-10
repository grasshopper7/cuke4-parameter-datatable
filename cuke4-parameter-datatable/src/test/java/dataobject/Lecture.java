package dataobject;

import java.util.Map;

public class Lecture {

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

	public static Lecture createLecture(Map<String, String> entry) {
		Lecture lecture = new Lecture();
		lecture.setProfName(new Professor(entry.get("profName")));
		lecture.setSize(Integer.parseInt(entry.get("size")));
		lecture.setFrequency(Integer.parseInt(entry.get("frequency")));
		lecture.setRooms(Rooms.parseRooms(entry.get("rooms")));
		lecture.setTopic(Topic.parseTopic(entry.get("topic")));
		return lecture;
	}
	
	@Override
	public String toString() {
		return "Lecture [profName=" + profName + ", topic=" + topic + ", size=" + size + ", frequency=" + frequency
				+ ", rooms=" + rooms + "]";
	}

	
}
