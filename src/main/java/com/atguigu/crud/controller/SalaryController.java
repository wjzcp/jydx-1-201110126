package com.atguigu.crud.controller;

import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.Salary;
import com.atguigu.crud.bean.dto.SalaryDto;
import com.atguigu.crud.service.SalaryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: TalentoHR
 * @description: н�ʹ���
 * @author: record
 * @create: 2023-07-03 15:27
 **/
@Controller
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    /**
     * ��ѯн��
     * @param pn
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/salarys")
    public Msg getSalarys(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 5);
        List<SalaryDto> salaryDtos = salaryService.getAll();
        PageInfo page = new PageInfo(salaryDtos, 5);
        return Msg.success().add("pageInfo", page);
    }

    /**
     * ����н��
     * @param salary
     * @return
     */
    @RequestMapping(value = "/salary",method = RequestMethod.POST)
    @ResponseBody
    public Msg saveSalary(@RequestBody Salary salary) {
        salaryService.saveSalary(salary);
        return Msg.success();
    }

    /**
     * ����id�޸�н��
     * @param
     * @return
     */
    @RequestMapping(value = "/salary/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Msg updateSalary(@PathVariable Integer id) {
        salaryService.updateSalary(id);
        return Msg.success();
    }

    /**
     * ����id��ѯн��
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/salary/{id}", method = RequestMethod.GET)
    public Msg getSalary(@PathVariable("id")Integer id) {
        SalaryDto salaryDto = salaryService.getSalaryDto(id);
        return Msg.success().add("salary", salaryDto);
    }

    /**
     * ɾ��н��
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/salary/{ids}",method = RequestMethod.DELETE)
    public Msg deleteSalary(@PathVariable("ids")String ids) {
        //����ɾ��
        if (ids.contains("-")){
            ArrayList<Integer> del_ids = new ArrayList<>();
            String[] str_ids = ids.split("-");
            //���id�ļ���
            for (String string : str_ids) {
                del_ids.add(Integer.parseInt(string));
            }
            salaryService.deleteBatch(del_ids);
        } else {
            Integer id = Integer.parseInt(ids);
            salaryService.deleteSalary(id);
        }
        return Msg.success();
    }
}
