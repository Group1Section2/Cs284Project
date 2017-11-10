package UuploadFileAndFillScore;

import javax.swing.JOptionPane;

public class Calculate implements calculateScore{
	
 	  private double score;
	

	public double getScore(){
		return score;
	}
	public boolean setScore(double score) {
		boolean check = false;
		if(score < 0){
			check = false;
			//JOptionPane.showMessageDialog(null, "This version min score is 0");
			this.score = 0;
		}
		else if(score>50){
			check = false;
			//JOptionPane.showMessageDialog(null, "This version max score is 50");
			this.score = 50;
		}else{
			check = true;
			this.score = score;
		}
		return check;
	}
	
	
	
	public double calculateScore(){
		
	   
		return ((this.score/ 50) * 100);
	}
	
}
