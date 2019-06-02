package com.news.demo.Module.Enews;

import com.news.demo.Utils.OrderCodeFactoryUtils;

import java.util.HashMap;
import java.util.Map;
/**
* @Description:    自动爬虫 抓取新闻事件
* @Author:         GEBILAOHU
* @CreateDate:     2019/6/2 20:09
* @UpdateUser:     GEBILAOHU
* @UpdateDate:     2019/6/2 20:09
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class EnewsAiSystem {


    /**
    * @Description:    创建爬虫所需数据
    * @UpdateUser:     GEBILAOHU
    * @UpdateDate:     19.6.2
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public Map<String,Enews> create(){
        //模拟数据
        Enews enews = new Enews();
        enews.seteHead("喜马拉雅山又现攀峰意外:登山团失踪 8人生死未卜");
        enews.seteData("<p><strong>海外网6月2日电&nbsp;</strong>继十余人在攀登珠穆朗玛峰期间死亡后，" +
                "印度境内喜马拉雅山山脉楠达德维山东峰也发生登山者失踪事件，8人生死未卜。</p>" +
                "<p>近期，喜马拉雅山脉频繁发生登山者死亡或失踪的事件。珠峰的“登山潮”导致大规模" +
                "拥堵，很多登山者要在海拔8000米左右的地方排几小时的长队。此外，绝大多数人在没有" +
                "额外氧气供给的情况下，登顶后只能坚持几分钟的时间，但由于拥挤下山的时间被推迟，" +
                "加上等候时间过长、体力消耗太大等因素，不少人将生命留在了珠峰。目前，“大堵车”已致" +
                "十余人死亡。</p>");
        enews.seteCode(OrderCodeFactoryUtils.getCommonCode(1,"C"));
        enews.seteAuthor("Tian");
        enews.seteOrigin("中华新闻网");

        Map<String,Enews> enewsMap = new HashMap<>();
        enewsMap.put("eNews",enews);
        return  enewsMap;
    }

}
