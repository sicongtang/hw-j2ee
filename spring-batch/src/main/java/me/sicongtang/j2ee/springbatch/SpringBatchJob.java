package me.sicongtang.j2ee.springbatch;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBatchJob {

	private String jobName;

	private JobLocator jobLocator;

	private JobLauncher jobLauncher;

	public void performJob() {
		System.out.println("Starting ExamResult Job");

		try {

			JobExecution result = jobLauncher.run(jobLocator.getJob(jobName), new JobParameters());
			System.out.println("ExamResult Job completetion details : " + result.toString());
		} catch (JobExecutionException ex) {
			System.out.println("ExamResult Job halted with following excpetion :" + ex);
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
		System.out.println("Quartz job started: " + job);

		try {
			job.performJob();

		} catch (Exception exception) {
			System.out.println("Job " + batchJob + " could not be executed : " + exception.getMessage());
		}
		System.out.println("Quartz job end");
	}

}
