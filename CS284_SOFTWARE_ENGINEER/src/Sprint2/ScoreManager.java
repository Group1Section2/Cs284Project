package Sprint2;

import java.util.ArrayList;

import UuploadFileAndFillScore.Calculate;

public class ScoreManager implements score {
	private Calculate c;
	private ArrayList<Calculate> exam ;
	private double score;
	private double mean;
	public ScoreManager() {
		c = new Calculate();
		exam = new ArrayList<>();
		score = 0;
		mean=0;
	}
	@Override
	public double setStandar(double score) {
		this.score = score;
		return this.score;
	}

	@Override
	public boolean saveScore(boolean save) {
		if(save==true){
			c.setScore(score);
			exam.add(c);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public double editScore(int number, double score) {
		exam.get(number).setStandard(score);
		return exam.get(number).getStandard();
	}

	@Override
	public void calculateMean(boolean calculate) {
		if(calculate==true){
			mean = c.getStandard()/2;
		}
		
	}

	@Override
	public char studentGrade(double score) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double sd(double sd) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getMean() {
		return mean;
	}

	@Override
	public int getStudent() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void selectExam(int exam){
		
	}

	
}
