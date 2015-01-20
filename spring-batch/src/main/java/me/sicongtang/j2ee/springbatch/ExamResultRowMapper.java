package me.sicongtang.j2ee.springbatch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

public class ExamResultRowMapper implements RowMapper<ExamResult> {
	private static Logger logger = Logger.getLogger(ExamResultRowMapper.class);
	
	@Override
	public ExamResult mapRow(ResultSet rs, int paramInt) throws SQLException {
		ExamResult examResult = new ExamResult();
		
		examResult.setId(rs.getInt("id"));
		examResult.setStudentName(rs.getString("studentName"));
		examResult.setPercentage(rs.getDouble("percentage"));
		examResult.setExamName(rs.getString("examName"));

		logger.info("print in mapper, examResult = " + examResult);
        return examResult;
	}

}
