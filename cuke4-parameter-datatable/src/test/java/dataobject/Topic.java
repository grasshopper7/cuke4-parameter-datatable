package dataobject;

import java.util.Objects;

public class Topic {

	public Topic() {
	}

	public Topic(String details) {
		String[] topicData = details.split(":");
		this.code = topicData[0];
		this.name = topicData[1];
	}

	public Topic(String code, String name) {
		this.code = code;
		this.name = name;
	}

	private String code;

	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Topic parseTopic(String top) {
		String[] topicData = top.split(":");
		Topic topic = new Topic(topicData[0], topicData[1]);
		return topic;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, name);
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(this, obj);
	}

	@Override
	public String toString() {
		return "Topic [code=" + code + ", name=" + name + "]";
	}

}
