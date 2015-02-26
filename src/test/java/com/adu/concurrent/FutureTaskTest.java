package com.adu.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class FutureTaskTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void test() throws InterruptedException, ExecutionException {
		MyJob<Object> myjob = new MyJob<Object>();
		FutureTask<Object> futureTask = new FutureTask<Object>(myjob);
		new Thread(futureTask).start();
		logger.debug("do something else");
		Object res = (Object) futureTask.get();
		logger.debug("res=" + res);

	}

	class MyJob<Object> implements Callable<Object> {

		@Override
		public Object call() throws Exception {
			String res = "hello";
			logger.debug("start sleep~");
			Thread.sleep(1000);
			logger.debug("end sleep~");
			return (Object) res;
		}

	}
}
