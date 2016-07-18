package com.adu.google.common.collect;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

/**
 * Created by yunjie.du on 2015/7/9.
 */
public class SetsTest {
    private Set<Integer> setA = ImmutableSet.of(1, 2, 3);
    private Set<Integer> setB = ImmutableSet.of(2, 3, 4);
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void newHashSet() {
        Set<String> res = Sets.newHashSet();
        res.add("a");
        res.add("b");
        res.add("c");
        logger.debug("res={}", res);
    }

    @Test
    public void newConcurrentHashSet() {
        Set<String> res = Sets.newConcurrentHashSet();
        res.add("a");
        res.add("b");
        res.add("c");
        logger.debug("res={}", res);
    }

    @Test
    public void union() {
        SetView<Integer> res = Sets.union(setA, setB);
        logger.debug("res={}", res);
    }

    @Test
    public void intersection() {
        SetView<Integer> res = Sets.intersection(setA, setB);
        logger.debug("res={}", res);
    }

    @Test
    public void difference() {
        Set<String> setA = Sets.newHashSet("aba_2117", "anshan_2097", "anshan_2802", "anyang_2451", "anyang_2795", "baoding_3446", "baoting_2097", "baotou_2916", "beijing_city_441", "changchun_28", "changsha_10", "changsha_11642", "changsha_13094", "changsha_3349", "changsha_4708", "changzhou_4453", "changzhou_6239", "chengde_2972", "chengdu_2307", "chengdu_3029", "chengdu_3043", "chengdu_5287", "chengdu_5475", "chengdu_6025", "chengdu_7095", "chengdu_8384", "chenzhou_2029", "chenzhou_2816", "chenzhou_2952", "chongqing_city_2261", "dandong_2941", "dongfang_2040", "dongguan_2312", "fuzhou_fujian_10", "guangzhou_11587", "guangzhou_2082", "guilin_8406", "guilin_8908", "guilin_8976", "guilin_9138", "guilin_9192", "guiyang_11", "guiyang_2432", "guiyang_2976", "guiyang_2987", "guiyang_3003", "guiyang_3424", "guiyang_3668", "guiyang_5284", "haerbin_10485", "haerbin_4703", "haerbin_5007", "haerbin_5018", "haerbin_52", "haerbin_5768", "haerbin_6436", "haerbin_6740", "haikou_3650", "haikou_4190", "haikou_4421", "haikou_5316", "handan_2471", "handan_2495", "handan_2509", "handan_2748", "handan_2824", "handan_3500", "hangzhou_11829", "hangzhou_13286", "hangzhou_14643", "hangzhou_15470", "hangzhou_15740", "hangzhou_163", "hangzhou_16971", "hangzhou_17536", "hangzhou_17591", "hangzhou_8335", "hengshui_2629", "hengshui_2699", "hengyang_2003", "hengyang_2200", "hengyang_2757", "hengyang_2894", "huangshan_5464", "huangshan_5732", "huangshan_5757", "huangshi_2009", "huhehaote_3314", "huhehaote_4900", "huzhou_2019", "jiaozuo_2576", "jiaozuo_2582", "jiaozuo_2652", "jiaozuo_2720", "jiaozuo_2778", "jiaozuo_3317", "jiaxing_10426", "jiaxing_7231", "jilin_city_2342", "jilin_city_3282", "jilin_city_3286", "jilin_city_3292", "jinan_2017", "jinan_4152", "jingmen_2058", "jingmen_2167", "jingmen_2406", "jingmen_2604", "jingmen_2605", "jingmen_2671", "jingmen_3165", "jingmen_3509", "jingmen_3510", "jingzhou_3417", "jingzhou_3777", "jingzhou_3790", "jingzhou_3898", "jingzhou_4975", "jingzhou_4998", "jingzhou_5163", "jingzhou_5164", "jining_3344", "jinzhong_2310", "jinzhong_3273", "jinzhong_3377", "jinzhong_4666", "jinzhou_2390", "jinzhou_2641", "jiujiang_3146", "jiujiang_3677", "kaifeng_2176", "kaifeng_2253", "kaifeng_2536", "kaifeng_2984", "kaifeng_3182", "kaifeng_3273", "kunming_1004", "kunming_2499", "kunming_2542", "kunming_53", "langfang_2603", "langfang_2954", "lanzhou_3968", "lianyungang_4354", "liaoyang_2053", "linfen_2112", "linfen_4233", "linyi_5364", "liuzhou_2164", "liuzhou_2500", "liuzhou_2509", "liuzhou_2726", "liuzhou_2765", "liuzhou_3203", "loudi_11", "luoyang_2290", "luoyang_3782", "luoyang_4917", "luoyang_4996", "luoyang_5366", "mianyang_3710", "nanchang_3408", "nanchang_3489", "nanchang_4948", "nanchang_5392", "nanjing_7357", "nanning_2026", "nanning_3293", "nanping_3489", "nanyang_2813", "qingdao_10095", "qingdao_86", "qiqihaer_2552", "quanzhou_2060", "quanzhou_2330", "quanzhou_4085", "sanya_10144", "sanya_11926", "sanya_12065", "sanya_8659", "shanghai_city_22780", "shangrao_2028", "shangrao_3683", "shaoxing_2400", "shaoxing_2537", "shaoxing_4377", "shaoxing_5904", "shenyang_4637", "shenyang_5568", "shenyang_6498", "shenyang_7894", "shenyang_8540", "shenyang_9609", "shenzhen_4547", "shijiazhuang_3482", "shijiazhuang_3502", "shiyan_2073", "shiyan_2853", "shiyan_2979", "suzhou_jiangsu_6994", "taiyuan_3567", "taiyuan_3625", "taiyuan_3645", "taiyuan_4066", "taiyuan_4496", "taiyuan_5311", "taiyuan_5312", "taiyuan_5388", "taiyuan_6894", "taizhou_zhejiang_3759", "tianjin_city_7549", "tieling_2127", "wuhan_11314", "wuhan_13131", "wuhan_13390", "wuhan_13481", "wuhan_3657", "wuhan_3705", "wuhan_4575", "wuhan_5774", "wuhan_7428", "wuhan_9741", "wuhan_9798", "wuhu_2223", "wuhu_2270", "wuhu_2681", "wuhu_3068", "wuxi_4113", "xiamen_10433", "xiamen_44", "xiamen_4554", "xian_15777", "xianyang_7730", "xianyang_7791", "xianyang_7815", "xianyang_7820", "xianyang_7832", "xianyang_7833", "xianyang_7834", "xingtai_2365", "xingtai_2387", "xingtai_3205", "xinxiang_2034", "xinxiang_2293", "xinxiang_2295", "xinxiang_2321", "xinxiang_2453", "xinxiang_2494", "xinxiang_2497", "xinxiang_2535", "xinxiang_2543", "xinxiang_2566", "xinxiang_3006", "xinxiang_3357", "xinzhou_3092", "xinzhou_3872", "xishuangbanna_3115", "xuchang_2102", "yangzhou_4667", "yantai_2078", "yantai_8010", "yichang_2838", "yichang_2955", "yichang_3221", "yichang_3381", "yichang_4537", "yichun_jiangxi_2129", "yingkou_2403", "yuncheng_2324", "zaozhuang_2148", "zaozhuang_2153", "zaozhuang_2196", "zaozhuang_2249", "zhengzhou_10042", "zhengzhou_10382", "zhengzhou_2005", "zhengzhou_2971", "zhengzhou_3479", "zhengzhou_4746", "zhengzhou_5130", "zhengzhou_5166", "zhengzhou_5176", "zhengzhou_5263", "zhengzhou_5470", "zhengzhou_5733", "zhengzhou_5940", "zhengzhou_6726", "zhengzhou_6984", "zhengzhou_8737", "zhengzhou_8892", "zhengzhou_9020", "zhengzhou_9257", "zhengzhou_9288", "zhengzhou_9296", "zhengzhou_9317", "zhengzhou_9331", "zhengzhou_9578", "zhengzhou_9610", "zhenjiang_2954", "zibo_2013", "zunyi_2002", "zunyi_2300", "zunyi_2389", "zunyi_2465", "zunyi_2502", "zunyi_2877", "zunyi_3677", "zunyi_4007");
        Set<String> setB = Sets.newHashSet("aba_2117", "anshan_2097", "anshan_2802", "anyang_2451", "anyang_2795", "baoding_3446", "baoting_2097", "baotou_2916", "beijing_city_441", "changchun_28", "changsha_10", "changsha_11642", "changsha_13094", "changsha_3349", "changsha_4708", "changzhou_4453", "changzhou_6239", "chengde_2972", "chengdu_2307", "chengdu_3029", "chengdu_3043", "chengdu_5287", "chengdu_5475", "chengdu_6025", "chengdu_7095", "chengdu_8384", "chenzhou_2029", "chenzhou_2816", "chenzhou_2952", "chongqing_city_2261", "dandong_2941", "dongfang_2040", "dongguan_2312", "fuzhou_fujian_10", "guangzhou_11587", "guangzhou_2082", "guilin_8406", "guilin_8908", "guilin_8976", "guilin_9138", "guilin_9192", "guiyang_11", "guiyang_2432", "guiyang_2976", "guiyang_2987", "guiyang_3003", "guiyang_3424", "guiyang_3668", "guiyang_5284", "haerbin_10485", "haerbin_4703", "haerbin_5007", "haerbin_5018", "haerbin_52", "haerbin_5768", "haerbin_6436", "haerbin_6740", "haikou_3650", "haikou_4190", "haikou_4421", "haikou_5316", "handan_2471", "handan_2495", "handan_2509", "handan_2748", "handan_2824", "handan_3500", "hangzhou_11829", "hangzhou_13286", "hangzhou_14643", "hangzhou_15470", "hangzhou_15740", "hangzhou_163", "hangzhou_16971", "hangzhou_17536", "hangzhou_17591", "hangzhou_8335", "hengshui_2629", "hengshui_2699", "hengyang_2003", "hengyang_2200", "hengyang_2757", "hengyang_2894", "huangshan_5464", "huangshan_5732", "huangshan_5757", "huangshi_2009", "huhehaote_3314", "huhehaote_4900", "huzhou_2019", "jiaozuo_2576", "jiaozuo_2582", "jiaozuo_2652", "jiaozuo_2720", "jiaozuo_2778", "jiaozuo_3317", "jiaxing_10426", "jiaxing_7231", "jilin_city_2342", "jilin_city_3282", "jilin_city_3286", "jilin_city_3292", "jinan_2017", "jinan_4152", "jingmen_2058", "jingmen_2167", "jingmen_2406", "jingmen_2604", "jingmen_2605", "jingmen_2671", "jingmen_3165", "jingmen_3509", "jingmen_3510", "jingzhou_3417", "jingzhou_3777", "jingzhou_3790", "jingzhou_3898", "jingzhou_4975", "jingzhou_4998", "jingzhou_5163", "jingzhou_5164", "jining_3344", "jinzhong_2310", "jinzhong_3273", "jinzhong_3377", "jinzhong_4666", "jinzhou_2390", "jinzhou_2641", "jiujiang_3146", "jiujiang_3677", "kaifeng_2176", "kaifeng_2253", "kaifeng_2536", "kaifeng_2984", "kaifeng_3182", "kaifeng_3273", "kunming_1004", "kunming_2499", "kunming_2542", "kunming_53", "langfang_2603", "langfang_2954", "lanzhou_3968", "lianyungang_4354", "liaoyang_2053", "linfen_2112", "linfen_4233", "linyi_5364", "liuzhou_2164", "liuzhou_2500", "liuzhou_2509", "liuzhou_2726", "liuzhou_2765", "liuzhou_3203", "loudi_11", "luoyang_2290", "luoyang_3782", "luoyang_4917", "luoyang_4996", "luoyang_5366", "mianyang_3710", "nanchang_3408", "nanchang_3489", "nanchang_4948", "nanchang_5392", "nanjing_7357", "nanning_2026", "nanning_3293", "nanping_3489", "nanyang_2813", "qingdao_10095", "qingdao_86", "qiqihaer_2552", "quanzhou_2060", "quanzhou_2330", "quanzhou_4085", "sanya_10144", "sanya_11926", "sanya_12065", "sanya_8659", "shanghai_city_22780", "shangrao_2028", "shangrao_3683", "shaoxing_2400", "shaoxing_2537", "shaoxing_4377", "shenyang_4637", "shenyang_5568", "shenyang_6498", "shenyang_7894", "shenyang_8540", "shenyang_9609", "shenzhen_4547", "shijiazhuang_3482", "shijiazhuang_3502", "shiyan_2073", "shiyan_2853", "shiyan_2979", "suzhou_jiangsu_6994", "taiyuan_3567", "taiyuan_3625", "taiyuan_3645", "taiyuan_4066", "taiyuan_4496", "taiyuan_5311", "taiyuan_5312", "taiyuan_5388", "taiyuan_6894", "taizhou_zhejiang_3759", "tianjin_city_7549", "tieling_2127", "wuhan_11314", "wuhan_13131", "wuhan_13390", "wuhan_13481", "wuhan_3657", "wuhan_3705", "wuhan_4575", "wuhan_5774", "wuhan_7428", "wuhan_9741", "wuhan_9798", "wuhu_2223", "wuhu_2270", "wuhu_2681", "wuhu_3068", "wuxi_4113", "xiamen_10433", "xiamen_44", "xiamen_4554", "xian_15777", "xianyang_7730", "xianyang_7791", "xianyang_7815", "xianyang_7820", "xianyang_7832", "xianyang_7833", "xianyang_7834", "xingtai_2365", "xingtai_2387", "xingtai_3205", "xinxiang_2034", "xinxiang_2293", "xinxiang_2295", "xinxiang_2321", "xinxiang_2453", "xinxiang_2494", "xinxiang_2497", "xinxiang_2535", "xinxiang_2543", "xinxiang_2566", "xinxiang_3006", "xinxiang_3357", "xinzhou_3092", "xinzhou_3872", "xishuangbanna_3115", "xuchang_2102", "yangzhou_4667", "yantai_2078", "yantai_8010", "yichang_2838", "yichang_2955", "yichang_3221", "yichang_3381", "yichang_4537", "yichun_jiangxi_2129", "yingkou_2403", "yuncheng_2324", "zaozhuang_2148", "zaozhuang_2153", "zaozhuang_2196", "zaozhuang_2249", "zhengzhou_10042", "zhengzhou_10382", "zhengzhou_2005", "zhengzhou_2971", "zhengzhou_3479", "zhengzhou_4746", "zhengzhou_5130", "zhengzhou_5166", "zhengzhou_5176", "zhengzhou_5263", "zhengzhou_5470", "zhengzhou_5733", "zhengzhou_5940", "zhengzhou_6726", "zhengzhou_6984", "zhengzhou_8737", "zhengzhou_8892", "zhengzhou_9020", "zhengzhou_9257", "zhengzhou_9288", "zhengzhou_9296", "zhengzhou_9317", "zhengzhou_9331", "zhengzhou_9578", "zhengzhou_9610", "zhenjiang_2954", "zibo_2013", "zunyi_2002", "zunyi_2300", "zunyi_2389", "zunyi_2465", "zunyi_2502", "zunyi_2877", "zunyi_3677", "zunyi_4007");
        SetView<String> res = Sets.difference(setA, setB);
        logger.debug("res={}", res);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void cartesianProduct() {
        Set<List<Integer>> res = Sets.cartesianProduct(setA, setB);
        logger.debug("res={}", res);
    }

    @Test
    public void powerSet() {
        Set<Set<Integer>> res = Sets.powerSet(setA);
        logger.debug("res={}", res);
    }

}
