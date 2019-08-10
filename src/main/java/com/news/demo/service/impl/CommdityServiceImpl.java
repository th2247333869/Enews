package com.news.demo.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.news.demo.Utils.MongoDB.MongodbUtils;
import com.news.demo.Utils.commonUtils;
import com.news.demo.model.Commdity;
import com.news.demo.mapper.CommdityMapper;
import com.news.demo.model.MongoDbModel.CommdityDb;
import com.news.demo.model.MongoDbModel.col;
import com.news.demo.service.BaseManager.BaseCommdityManager;
import com.news.demo.service.CommdityService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GEBILAOHU
 * @since 2019-07-07
 */
@Service
public class CommdityServiceImpl extends ServiceImpl<CommdityMapper, Commdity> implements CommdityService {

    @Autowired
    private CommdityMapper commdityMapper;

    @Override
    public List<Map<String,String>>  getCommmdityPageNotic(Page page) {

        return commdityMapper.selectCommdityPageNotic(page,commonUtils.getStrNow()+"00:00:00","1");
    }


    /***
     * 分页查询默认第一次查询 查询缓存数据库中推荐的数据 数据分类采用日期过滤 查询当前推荐数据按照日期推送时间查询排序
     * 如果当mysql推送任何数据则查询mysql数据库中日期类型一致查询到最近日期的数据为止。
     * 如果缓存数据库数据以及缓存完成今天的数据则按照普通查询查询mysql中所有数据。
     * （缓存数据默认每天推送，只有刷新才会查询之前的缓存数据，分页查询大量数据默认不走缓存数据）
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<CommdityDb>  getCommmdityPageNoticV2() throws Exception{
        //分页查询 mongodb
        Criteria criteria1 = Criteria.where("date")
                                    .gte(commonUtils.getStrNow());
        Criteria criteria2 = Criteria.where("state").is("1");
        Criteria[] criterias = new Criteria[]{criteria1,criteria2};
        List<CommdityDb> colList = (List<CommdityDb>) MongodbUtils.find(criterias,new CommdityDb());
        return colList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveCommmditysPageNotics(List<Commdity> commdities) throws Exception{
        Integer result = 1;
        try {
            for(Commdity com : commdities){
                commdityMapper.insert(com);
            }
        }catch (Exception e){
            result = 0;
            e.printStackTrace();
            throw new Exception("批量插入错误：saveCommmditysPageNotics");
        }
        return result;
    }
}
