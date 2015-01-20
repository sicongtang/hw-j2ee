package me.sicongtang.j2ee.springbatch;

public class ExamResult {

	private int id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ExamResult [id=" + id + "studentName=" + studentName + ", percentage=" + percentage + "]";
	}

}
