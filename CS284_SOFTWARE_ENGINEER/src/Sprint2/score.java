package Sprint2;

public interface score {
	public double setStandar(double score);//1.���¡����Ѻࡳ���ṹ
	public boolean saveScore(boolean save);//2.�ѹ�֡ࡳ���ṹ
	public double editScore(int number,double score);//3.���ࡳ���ṹ
	public void calculateMean(boolean calculate);//4.�ӹǳ�������µ��ʶԵ�
	public char studentGrade(double score);//5.�Ѵ�ô�ѡ�֡��
	public double sd(double sd);//6.�觤�ṹ�繪�ǧ���mean +-sd
	public double getMean();
	public int getStudent();
}
