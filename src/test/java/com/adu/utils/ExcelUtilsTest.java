package com.adu.utils;

import com.adu.model.Person;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Map;


public class ExcelUtilsTest {
    private Map<String, Object> dataElementMap;
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void exportExcel() {
        String templateFilePath = this.getClass().getClassLoader().getResource("template.xls").getPath();
        String resultFilePath = "D:/result.xls";
        boolean res = ExcelUtils.exportExcel(dataElementMap, templateFilePath, resultFilePath);
        logger.debug("res={}", res);
    }

    @Before
    public void init() {
        this.dataElementMap = Maps.newHashMap();
        List<Person> personList = Lists.newArrayList();
        for (int i = 1; i <= 100; i++) {
            personList.add(new Person("name" + i, i));
        }
        dataElementMap.put("personList", personList);
    }

}
