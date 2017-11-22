package Sprint2;

import java.io.File;
import java.util.ArrayList;

public interface email {
	public boolean readEmail(File email);
	public char Gradesent(studentGrade name);
	public int studentSize();
	public studentGrade get(int index);
}
