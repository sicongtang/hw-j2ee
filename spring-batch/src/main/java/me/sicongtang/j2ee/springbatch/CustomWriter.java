package me.sicongtang.j2ee.springbatch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.support.transaction.TransactionAwareProxyFactory;

public class CustomWriter<T> implements ItemWriter<T> {
	List<T> output = TransactionAwareProxyFactory.createTransactionalList();

    public void write(List<? extends T> items) throws Exception {
    	System.out.println("CustomWriter.write(), items = " + items);
        output.addAll(items);
        System.out.println("CustomWriter.write() output = " + output);
    }

    public List<T> getOutput() {
        return output;
    }
}
