package UuploadFileAndFillScore;
import java.io.File;

public class StudentControl {
	StudentFileMgr stm;
	
	public StudentControl() {
		stm = new StudentFileMgr();
	}
	public void readFile(File file) {
		stm.readFile(file);
	}
	public StudentFileMgr getData() {
		return stm;
	}
	
	
	
}
