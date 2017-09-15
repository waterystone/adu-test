package com.adu.org.apache.hadoop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

public class HadoopTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void readHDFSFile() throws Exception {
		String filename = "/user/adrd-dev/yunjiedu/README.txt";
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);

		// check if the io exists
		Path path = new Path(filename);
		if (fs.exists(path)) {
			FSDataInputStream is = fs.open(path);
			// get the io info to create the buffer
			FileStatus stat = fs.getFileStatus(path);

			// create the buffer
			byte[] buffer = new byte[Integer.parseInt(String.valueOf(stat
					.getLen()))];
			is.readFully(0, buffer);

			is.close();
			fs.close();
			logger.debug(new String(buffer));

		} else {
			throw new Exception("the io is not found .");
		}
	}
}
