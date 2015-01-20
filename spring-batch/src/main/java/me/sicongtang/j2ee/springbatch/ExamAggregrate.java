package me.sicongtang.j2ee.springbatch;

public class ExamAggregrate {
	private String studentName;
	private String examName;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	@Override
	public String toString() {
		return "ExamAggregrate [studentName=" + studentName + ", examName=" + examName + "]";
	}

}
