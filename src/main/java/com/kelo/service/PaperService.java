package com.kelo.service;

import com.kelo.bean.Paper;

import java.util.List;

/**
 * @author KELO
 * @date 2019/5/24 - 14:49
 */
public interface PaperService {
    public int savePaper(Paper paper);

    public int deleteById(Integer id);

    public int updatePaper(Paper paper);

    public Paper queryById(Integer id);

    public List<Paper> queryAll();
}
