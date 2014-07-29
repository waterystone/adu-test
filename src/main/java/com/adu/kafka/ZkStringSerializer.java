package com.adu.kafka;

import java.io.UnsupportedEncodingException;

import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZkStringSerializer implements ZkSerializer {
	private static final String FORMAT = "UTF-8";

	private static final Logger LOG = LoggerFactory
			.getLogger(ZkStringSerializer.class);

	public byte[] serialize(Object data) throws ZkMarshallingError {
		if (data instanceof String) {
			try {
				return ((String) data).getBytes(FORMAT);
			} catch (UnsupportedEncodingException e) {
				LOG.error("[ERROR-serialize]data=" + data, e);
				throw new ZkMarshallingError("[ERROR-serialize]data=" + data, e);
			}
		} else {
			LOG.error("[ERROR-unsupported-type]data=" + data + ",type="
					+ data.getClass());
		}
		return null;
	}

	public Object deserialize(byte[] bytes) throws ZkMarshallingError {
		if (bytes == null) {
			return null;
		} else {
			try {
				return new String(bytes, FORMAT);
			} catch (UnsupportedEncodingException e) {
				LOG.error("[ERROR-deserialize]bytes=" + bytes, e);
				throw new ZkMarshallingError("[ERROR-deserialize]bytes="
						+ bytes, e);
			}
		}
	}

}
