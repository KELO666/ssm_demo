package com.kelo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kelo.bean.Paper;
import com.kelo.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author KELO
 * @date 2019/5/24 - 19:14
 */
@Controller
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    private PaperService paperService;

    /**
     * 根据id查询书籍
     * @param paperId
     * @param model
     * @return
     */
    @RequestMapping(value = "/findOne/{id}")
    public String findOne(@PathVariable("id")Integer paperId, Model model){
        Paper paper = paperService.queryById(paperId);
        model.addAttribute("paper", paper);
        return null;
    }

    /**
     * 查询全部
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public String findAll(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model){
        PageHelper.startPage(pn, 5);
        List<Paper> list = paperService.queryAll();
        PageInfo pageInfo = new PageInfo(list,5);
        model.addAttribute("pageInfo", pageInfo);
        return "list";
    }

    /**
     * 根据id删除
     * @param paperId
     * @param model
     * @return
     */
    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id")Integer paperId,Model model){
        paperService.deleteById(paperId);
        return "";
    }

    /**
     * 更新
     * @param paper
     * @return
     */
    @RequestMapping(value = "/update")
    public String update(Paper paper){
        paperService.updatePaper(paper);
        return "";
    }

    /**
     * 保存
     * @param paper
     * @return
     */
    public String save(Paper paper){
        paperService.savePaper(paper);

        return "";
    }

}
