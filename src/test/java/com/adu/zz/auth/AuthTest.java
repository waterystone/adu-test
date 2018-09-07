package com.adu.zz.auth;

import java.util.List;

import org.junit.Test;

import com.adu.BaseTest;
import com.adu.utils.FileUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author duyunjie
 * @date 2018/9/6 下午8:56
 */
public class AuthTest extends BaseTest {
    private static final Joiner joiner = Joiner.on(" | ").useForNull("null");

    @Test
    public void test() {
        String content = FileUtil.read("zz.txt");
        JSONArray jsonArray = JSONArray.parseArray(content);
        StringBuffer buffer = new StringBuffer();

        List<String> headerList = Lists.newArrayList("姓名", "用户ID", "职位", "手机", "入职时间", "领导");
        buffer.append(joiner.join(headerList) + "\n");

        List<String> splitList = Lists.newArrayList("---", "---", "---", "---", "---", "---");
        buffer.append(joiner.join(splitList) + "\n");

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject info = jsonArray.getJSONObject(i);
            List<String> list = Lists.newArrayList();
            list.add(info.getString("realname"));
            list.add(info.getString("userid"));
            list.add(info.getString("positionName"));
            list.add(info.getString("mobile"));
            list.add(info.getString("onboardTime"));
            list.add(info.getString("leaders"));

            buffer.append(joiner.join(list) + "\n");
        }

        System.out.println(buffer.toString());
    }
}
