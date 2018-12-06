package dataobject;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FullName {

	private String firstName = "";

	private String title = "";

	private String middleName = "";

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public static FullName parseNameDetails(String name) {
		String[] names = name.split(" ");
		FullName fullName = new FullName();

		if (names.length >= 1)
			fullName.setTitle(names[names.length - 1]);
		if (names.length >= 2)
			fullName.setFirstName(names[0]);
		if (names.length > 2)
			fullName.setMiddleName(Arrays.stream(names, 1, names.length - 1).collect(Collectors.joining(" ")));

		return fullName;
	}

	@Override
	public String toString() {
		return "FullName [firstName=" + firstName + ", title=" + title + ", middleName=" + middleName + "]";
	}

}
