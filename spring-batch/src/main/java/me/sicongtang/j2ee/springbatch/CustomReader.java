package me.sicongtang.j2ee.springbatch;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class CustomReader<T> implements ItemReader<T> {
	private static Logger logger = Logger.getLogger(CustomReader.class);
	private List<T> items;

	public CustomReader(List<T> items) {
		this.items = items;
	}

	public T read() throws Exception, UnexpectedInputException, ParseException {
		if (!items.isEmpty()) {
			logger.info("items[0] = " + items.get(0));
			return items.remove(0);
		}
		return null;
	}
}
