package Sprint2;

public interface score {
	public double setStandar(double score);//1.เรียกการรับเกณฑ์คะแนน
	public boolean saveScore(boolean save);//2.บันทึกเกณฑ์คะแนน
	public double editScore(int number,double score);//3.แก้ไขเกณฑ์คะแนน
	public void calculateMean(boolean calculate);//4.คำนวณค่าเฉลี่ยตามสถิติ
	public char studentGrade(double score);//5.ตัดเกรดนักศึกษา
	public double sd(double sd);//6.แบ่งคะแนนเป็นช่วงๆตามmean +-sd
	public double getMean();
	public int getStudent();
}
