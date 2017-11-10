package UuploadFileAndFillScore;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class StudentFileMgr {
	private ArrayList<StudentInfo> students;

	public StudentFileMgr() {
		students = new ArrayList<>();
	}

	public boolean readFile(File file) {
		boolean isFile = false;
		try {
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			StringTokenizer stk = null, stk2 = new StringTokenizer(file.getName(), ".");

			String line, fileType = "";
			int cnt = 0;

			while (stk2.hasMoreTokens()) {
				fileType = stk2.nextToken();
				
			}
			
		
			if (fileType.equals("csv")) {
				isFile = true;
				while ((line = br.readLine()) != null) {
					cnt++;
					if (cnt > 7) {
						stk = new StringTokenizer(line, ",");
						if (stk.hasMoreTokens()) {
							students.add(new StudentInfo(Integer.parseInt(stk.nextToken()),
									Long.parseLong(stk.nextToken()), stk.nextToken()));

						}
					}
				}
				br.close();
			}else {
				JOptionPane.showMessageDialog(null, "File must be the csv type");
			}


		} catch (FileNotFoundException e) {
			System.err.println("Cannot find " + file.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isFile;

	}

	public ArrayList<StudentInfo> getStudent() {
		return students;
	}

	public int size() {
		return students.size();
	}

	public StudentInfo get(int index) {
		return students.get(index);
	}

	
}
