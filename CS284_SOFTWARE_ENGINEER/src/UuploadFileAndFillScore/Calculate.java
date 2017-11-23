package UuploadFileAndFillScore;

import javax.swing.JOptionPane;

public class Calculate implements calculateScore {

	private double score;
	private double standard=0;
	private double maxScore=0;
	public double getScore() {
		return score;
	}
	public void setStandard(double standard){
		if (standard >= 0&&standard<=100) {
			this.standard = standard;
		}else{
			this.standard = 0;
		}
	}
	public double getStandard(){
		return standard;
	}
	public void setMaxScore(double maxScore){
		if (maxScore >= 0) {
			this.maxScore = maxScore;
		}else{
			this.maxScore = 0;
		}
	}
	public double getMaxScore(){
		return maxScore;
	}
	public boolean setScore(double score) {
		boolean check = false;
		if (score < 0) {
			check = false;
			// JOptionPane.showMessageDialog(null, "This version min score is
			// 0");
			this.score = 0;
		} else if (score > maxScore) {
			check = false;
			// JOptionPane.showMessageDialog(null, "This version max score is
			// 50");
			this.score = maxScore;
		} else {
			check = true;
			this.score = score;
		}
		return check;
	}

	public double calculateScore() {

		return ((this.score / maxScore) * standard);
	}

}
