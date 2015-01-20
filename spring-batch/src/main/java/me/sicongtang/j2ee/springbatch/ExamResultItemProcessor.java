package me.sicongtang.j2ee.springbatch;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;

public class ExamResultItemProcessor implements ItemProcessor<ExamResult, ExamResult>{
	private Logger logger = Logger.getLogger(ExamResultItemProcessor.class);
	
	@Override
	public ExamResult process(ExamResult result) throws Exception {
		logger.info("Processing result :"+result);
		
		/*
		 * Only return results which are more than 75%
		 * 
		 */
		if(result.getPercentage() < 75){
			return null;
		}
		
		return result;
	}

}
