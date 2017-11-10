package MainProgram;


import ULogin.LoginFrame;
import UuploadFileAndFillScore.FillPointFrame;



/// โปรแกรม ทั้งหมดถูกเปิดที่นี้ /////
public class MainProgram {
	private static LoginFrame loginFrame;
	private static FillPointFrame fillPointFrame;

	public static void main(String[] args) {
		loginFrame = new LoginFrame();
		loginFrame.setVisible(true);
		fillPointFrame = new FillPointFrame();
	}
  //// get ค่าไปใช้ ใน login Panel เพื่อจะปิดเปิด หน้าต้่าง////
	public static FillPointFrame getFillPointFrame() {
		return fillPointFrame;
	}

	public static LoginFrame getLoginFrame() {
		return loginFrame;
	}

}
