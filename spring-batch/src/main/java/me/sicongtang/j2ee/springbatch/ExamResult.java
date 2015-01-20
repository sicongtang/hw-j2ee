package me.sicongtang.j2ee.springbatch;


public class ExamResult {
	

	private String studentName;
	private double percentage;
	

	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
	public double getPercentage() {
		return percentage;
	}
	
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "ExamResult [studentName=" + studentName + ", percentage=" + percentage + "]";
	}
	
	
}
