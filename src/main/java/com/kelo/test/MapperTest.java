package com.kelo.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kelo.bean.Paper;
import com.kelo.mapper.PaperMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author KELO
 * @date 2019/5/24 - 15:10
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    PaperMapper paperMapper;

    @Test
    public void testCRUD(){
        PageHelper.startPage(1, 10);
        List<Paper> list = paperMapper.selectByExample(null);
        PageInfo pageInfo = new PageInfo(list,5);
        List pageInfoList = pageInfo.getList();
        for (Object p : pageInfoList) {
            System.out.println(p);
        }

    }
}
