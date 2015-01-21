package me.sicongtang.j2ee.springbatch;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;

public class ExamResultItemProcessor implements ItemProcessor<ExamResult, ExamAggregrate> {
	private Logger logger = Logger.getLogger(ExamResultItemProcessor.class);

	@Override
	public ExamAggregrate process(ExamResult result) throws Exception {
		logger.info("Processing result :" + result);
		
		//Thread.sleep(Long.MAX_VALUE);

		/*
		 * Only return results which are more than 75%
		 */
		if (result.getPercentage() < 75) {
			return null;
		}

		ExamAggregrate aggregrate = new ExamAggregrate();
		aggregrate.setExamName(result.getExamName());
		aggregrate.setStudentName(result.getStudentName());

		logger.info("Processing aggregrate :" + aggregrate);

		return aggregrate;
	}

}
