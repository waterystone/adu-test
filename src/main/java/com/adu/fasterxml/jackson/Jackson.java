package com.adu.fasterxml.jackson;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson {
	private static final Log logger = LogFactory.getLog(Jackson.class);

	private static ObjectMapper m = new ObjectMapper();

	public static JsonNode parseFull(String input) {
		if (input == null) {
			return null;
		}
		try {
			return m.readTree(input);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			logger.error("Can't parse json string: " + input, e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Parse json string: " + input + " with IOexception ",
					e);
		}
		return null;
	}

	public static JsonNode parseFull(byte[] input) {
		if (input == null) {
			return null;
		}
		try {
			return m.readTree(input);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			try {
				logger.error("Can't parse json byte[]: "
						+ (new String(input, "UTF-8")));
			} catch (UnsupportedEncodingException e1) {

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Parse json byte[]: " + input + " with IOexception ",
					e);
		}
		return null;
	}

	public static String encode(Object obj) {
		try {
			return m.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			logger.error("Can't parse json obj: " + obj.toString(), e);
		}
		return null;
	}
}
