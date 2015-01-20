package me.sicongtang.j2ee.springbatch;

import org.apache.log4j.Logger;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBatchJob {
	private static Logger logger = Logger.getLogger(SpringBatchJob.class);
	private String jobName;

	private JobLocator jobLocator;

	private JobLauncher jobLauncher;

	public void performJob() {
		logger.info("Starting ExamResult Job");

		try {

			JobExecution result = jobLauncher.run(jobLocator.getJob(jobName), new JobParameters());
			logger.info("ExamResult Job completetion details : " + result.toString());
			
		} catch (JobExecutionException ex) {
			logger.error("ExamResult Job halted with following excpetion :" + ex);
		}

	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public void setJobLocator(JobLocator jobLocator) {
		this.jobLocator = jobLocator;
	}

	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String batchJob = "springBatchJob";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("batch-context.xml");
		SpringBatchJob job = applicationContext.getBean(batchJob, SpringBatchJob.class);

		logger.info("Quartz job started: " + job);

		try {
			job.performJob();
		} catch (Exception e) {
			logger.error("Job " + batchJob + " could not be executed : " + e.getMessage());
		}
		
		logger.info("Quartz job end");
	}

}
