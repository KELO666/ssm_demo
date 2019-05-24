package com.kelo.service.impl;

import com.kelo.bean.Paper;
import com.kelo.mapper.PaperMapper;
import com.kelo.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author KELO
 * @date 2019/5/24 - 14:55
 */
@Service("paperService")
public class PaperServiceImpl implements PaperService {
    @Autowired
    PaperMapper paperMapper;

    @Override
    public int savePaper(Paper paper) {
        return paperMapper.insertSelective(paper);
    }

    @Override
    public int deleteById(Integer id) {
        return paperMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updatePaper(Paper paper) {
        return paperMapper.updateByPrimaryKeySelective(paper);
    }

    @Override
    public Paper queryById(Integer id) {
        Paper paper = paperMapper.selectByPrimaryKey(id);
        return paper;
    }

    @Override
    public List<Paper> queryAll() {
        List<Paper> list = paperMapper.selectByExample(null);
        return list;
    }
}
