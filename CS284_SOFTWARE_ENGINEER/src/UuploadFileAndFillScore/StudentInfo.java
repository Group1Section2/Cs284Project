package UuploadFileAndFillScore;

import java.util.ArrayList;

public class StudentInfo {
	private String name;

	private long id;
	private int index;


	public StudentInfo(int index, long id, String name) {
		this.name = name;

		this.id = id;
		this.index = index;

	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public int getIndex() {
		return index;
	}

	@Override
	public String toString() {
		return "StudentInfo [name=" + name + ", id=" + id + ", index=" + index +"]";
	}
}
