package com.adu.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.*;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.utils.StringUtil;
import com.alibaba.fastjson.JSONObject;

public class HighLevelProducerTest {
    private String topic = "custom_h_dynamic_pricing_producer";
    private Producer producer;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before
    public void init() {
        Properties props = new Properties();

        props.put("bootstrap.servers", "l-pgstats4.h.dev.cn0.qunar.com:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("acks", "all");
        props.put("retries", "10");

        producer = new KafkaProducer<String, String>(props);
    }

    @Test
    public void produce() {
        try {
            String message = getMessage();
            for (int i = 0; i < 3; i++) {
                logger.info("[start_send]message={}", message);
                producer.send(new ProducerRecord(topic, message), new MyCallBack());
                Thread.sleep(100);
            }
        } catch (Exception e) {
            logger.error("[ERROR-start]", e);
        }
    }

    private String getMessage() {
        JSONObject res = new JSONObject();
        res.put("key", "135123");
        res.put("environment", "A");
        res.put("type", "salePrice");
        res.put("hotelSeq", "beijing_city_123");
        res.put("productId", "1739236308");
        res.put("productValue", "120.3");
        res.put("checkInDate", "2016-12-15");

        return res.toJSONString();
    }

}

class MyCallBack implements Callback {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        logger.info("[start-onCompletion]recordMetadata={},e={}", StringUtil.toString(recordMetadata), e);
    }
}
