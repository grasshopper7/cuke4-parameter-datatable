package dataobject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Rooms {

	private List<Room> rooms;
	
	public Rooms(String details) {
		this.setRooms(Arrays.stream(details.split(",")).map(Room::new).collect(Collectors.toList()));
	}

	public Rooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	public static Rooms parseRooms(String rooms) {
		return new Rooms( Arrays.stream(rooms.split(",")).map(Room::new).collect(Collectors.toList()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rooms == null) ? 0 : rooms.hashCode());
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
		Rooms other = (Rooms) obj;
		if (rooms == null) {
			if (other.rooms != null)
				return false;
		} else if (!rooms.equals(other.rooms))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rooms [rooms=" + rooms + "]";
	}
	
	
}
