package Sprint2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class emailManager implements email {
	private ArrayList<studentGrade> s ;
	@Override
	public boolean readEmail(File email) {
		File f = email;
		return false;
	}

	@Override
	public char Gradesent(studentGrade name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int studentSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public studentGrade get(int index) {
		// TODO Auto-generated method stub
		return s.get(index);
	}

}
