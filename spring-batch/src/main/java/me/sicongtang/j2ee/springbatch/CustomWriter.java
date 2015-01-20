package me.sicongtang.j2ee.springbatch;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.support.transaction.TransactionAwareProxyFactory;

public class CustomWriter<T> implements ItemWriter<T> {
	private static Logger logger = Logger.getLogger(CustomWriter.class);
	List<T> output = TransactionAwareProxyFactory.createTransactionalList();

    public void write(List<? extends T> items) throws Exception {
    	logger.info("items = " + items);
        output.addAll(items);
        logger.info("output = " + output);
    }

    public List<T> getOutput() {
        return output;
    }
}
