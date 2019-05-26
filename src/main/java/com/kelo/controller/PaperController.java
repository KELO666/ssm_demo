package com.kelo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kelo.bean.Paper;
import com.kelo.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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
        System.out.println("controller执行删除...");
        paperService.deleteById(paperId);
        return "redirect:/paper/findAll";
    }

    /**
     * 更新
     * @param paper
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@Validated Paper paper, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getField()+" * "+error.getDefaultMessage());
                model.addAttribute("ERR_"+error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("paper", paper);
            Integer id = paper.getPaperId();
            return "redirect:/paper/toUpdate/"+id;
        }
        paperService.updatePaper(paper);
        return "redirect:/paper/findAll";
    }

    /**
     * 保存
     * @param paper
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@Validated Paper paper, BindingResult bindingResult, Model model, HttpServletRequest request){
        if (bindingResult.hasErrors()){
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getField()+" * "+error.getDefaultMessage());
                model.addAttribute("ERR_"+error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("paper", paper);
            return "redirect:/"+request.getContextPath()+"/add.jsp";
        }
        System.out.println(paper);
        paperService.savePaper(paper);

        return "redirect:/paper/findAll";
    }

    @RequestMapping(value = "/toUpdate/{id}")
    public String toUpdatePage(@PathVariable("id")Integer id,Model model){
//        System.out.println("controller执行更新...");
        Paper paper = paperService.queryById(id);
        model.addAttribute("paper", paper);
        return "update";
    }

}
