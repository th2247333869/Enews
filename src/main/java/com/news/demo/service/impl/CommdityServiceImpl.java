package com.news.demo.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.news.demo.Utils.MongoDB.MongodbUtils;
import com.news.demo.Utils.commonUtils;
import com.news.demo.model.Commdity;
import com.news.demo.mapper.CommdityMapper;
import com.news.demo.model.MongoDbModel.col;
import com.news.demo.service.CommdityService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

        return commdityMapper.selectCommdityPageNotic(page,"1");
    }

    @Override
    public List<col>  getCommmdityPageNoticV2(Page page) {

        //查询缓存数据库是否缓存了当天第一批需要加载的数据
        //String[] keys = new String[]{"date","state"};
        //String[] values = new String[]{"$gt:"+ commonUtils.getStrNow()+" 00:00:00,$lt:"+commonUtils.getStrNow()+" 23:59:59",
                                           // "1"};

        String[] keys = new String[]{"name"};
        String[] values = new String[]{"yzh"};
        List<col> colList = (List<col>) MongodbUtils.find(new col(),keys,values);

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
