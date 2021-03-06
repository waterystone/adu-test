package com.adu.jdk.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.adu.BaseTest;

public class RegexTest extends BaseTest {

    @Test
    public void matches() {
        String regex = "^m\\.sohu\\.com/n/(\\d+)/\\?.*wscrid=1137_(\\d+).*";
        String str = "m.sohu.com/n/407821518/?c=39&wscrid=1137_4";
        boolean isMatch = Pattern.matches(regex, str);// 等价于Pattern.compile(regex).matcher(input).matches()
        logger.info("isMatch=" + isMatch);
    }

    @Test
    public void matches2() {
        String regex = ".*";
        String str = "m.sohu.com/n/407821518/?c=39&wscrid=1137_4";
        boolean isMatch = Pattern.matches(regex, str);// 等价于Pattern.compile(regex).matcher(input).matches()
        logger.info("isMatch=" + isMatch);
    }

    @Test
    public void pattern() {
        String regex = "a.*b\\?";
        Pattern pattern = Pattern.compile(regex);
        logger.debug(pattern.pattern());
    }

    @Test
    public void split() {
        String str = "abcedefhijklmn";
        String regex = "(ce|ij)";
        Pattern pattern = Pattern.compile(regex);
        String[] ret = pattern.split(str);
        for (String s : ret) {
            logger.debug(s);
        }
    }

    @Test
    public void flags() {
        String regex = "(ce|ij)";
        Pattern pattern = Pattern.compile(regex);
        int ret = pattern.flags();
        logger.debug("ret=" + ret);
    }

    @Test
    public void lookingAt() {
        String str = "abcedefhijklmn";
        String regex = "a.{3}d";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        boolean isLookingAt = matcher.lookingAt();
        logger.debug("isLookingAt=" + isLookingAt);
    }

    @Test
    public void appendReplacement() {
        String str = "abxxabyyab";
        String regex = "ab";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        StringBuffer buffer = new StringBuffer();

        // 对于匹配到的逐个替换
        while (matcher.find()) {
            matcher.appendReplacement(buffer, "ba");
        }
        logger.debug("buffer=" + buffer);
    }

    @Test
    public void appendTail() {
        String str = "abcdea";
        String regex = "a";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        StringBuffer buffer = new StringBuffer();

        // 对于匹配到的逐个替换
        while (matcher.find()) {
            matcher.appendTail(buffer);
        }
        logger.debug("buffer=" + buffer);
    }

    @Test
    public void end() {
        String str = "aaabbbcccde";
        String regex = "(a+)(b+)(c+)\\w*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        int ret = 0;
        if (matcher.matches()) {
            ret = matcher.end();
        }
        logger.debug("ret=" + ret);
    }

    @Test
    public void replaceFirst() {
        String str = "aaabbbcccde";
        String regex = "(a+)(b+)(c+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        String ret = matcher.replaceFirst("adu");
        logger.debug("ret=" + ret);
    }

    @Test
    public void groupName() {
        String str = "a1b2c3d";
        String regex = "(?<id>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            String id = matcher.group("id");
            logger.debug("id=" + id);
            matcher.find();
        }

    }

    @Test
    public void compile() {
        String contentRegex = "<content>(.*)</content>";
        Pattern contentPattern = Pattern.compile(contentRegex, Pattern.DOTALL);

        String content = "<content>这是内容\n结束</content>";
        Matcher matcher = contentPattern.matcher(content);
        while (matcher.find()) {
            String group = matcher.group();
            String newContent = matcher.group(1);
            logger.debug("group=" + group + ",newContent=" + newContent);
        }

    }

    @Test
    public void group() {
        String url = "m.sohu.com/n/1999760/?v=3&_once_=000113_click&fp=0";
        String regex = "^(3g|m)\\.sohu\\.com/[np]/(\\d{1,7})/\\?.*_once_=000113_(\\w+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        while (matcher.find()) {
            String group = matcher.group();
            String id = matcher.group(2);
            String flag = matcher.group(3);
            logger.debug("group=" + group + ",id=" + id + ",flag=" + flag);
        }

    }

    @Test
    public void group1() {
        String content = "<a href=\"http://tv.sohu.com/20141020/n405296564.shtml\" target=\"_blank\">";
        String regex = "a href=\"(.+)\" target";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            String group = matcher.group();
            String url = matcher.group(1);
            logger.debug("group=" + group + ",url=" + url);
        }

    }

    @Test
    public void group2() {
        String content = "DZS-6045_multi_dump";
        String regex = "DZS-(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            String group = matcher.group();
            String url = matcher.group(1);
            logger.info("group=" + group + ",url=" + url);
        }
    }

    @Test
    public void group3() {
        String content = "[0].mainOrderInfo.trackData.SUBMIT_TRACE[1]";
        String regex = "(.+)\\[\\d+\\]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        if (matcher.matches()) {
            String group = matcher.group();
            String url = matcher.group(1);
            logger.info("group=" + group + ",url=" + url);
        }
    }

    @Test
    public void group4() {
        String content = "[06-21 12:00:46 594 INFO ] [zzarch-pThread-SCFServerWorkerThread_GroupDEFAULT_Index29-2] search.filter.ResponseFilter - (52) uid=46788274043157 token=039A493CB07E487E1D9A33D6A8FB6810 logid=4187364052125720557 cmd=dingyueinfos t=15 v=6.9.0 lon=114.269577 lat=33.272804 ip=223.89.186.156 channelid=market_908  InfoSearchService::appSearch exectime=5ms globalTotalExecTime=-25117075899ms globalMethodExecTime=5ms globalMethodWaitTime=0ms totalStratTime=25117075899427251 waitStartTime=25117075899428297 methodStartTime=25117075899673485 fromIP=10.136.219.15 sessionID=0 callerKey=oLzy2cozKcLMEqFxxXa7XWO3RKFHYPaz desc=end";
        String regex = ".+sessionID=(\\d+).+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            String sessionId = matcher.group(1);
            logger.debug("sessionId={}", sessionId);
        }
    }
}
