package com.atguigu.crud.service;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.Salary;
import com.atguigu.crud.bean.SalaryExample;
import com.atguigu.crud.bean.dto.SalaryDto;
import com.atguigu.crud.dao.DepartmentMapper;
import com.atguigu.crud.dao.EmployeeMapper;
import com.atguigu.crud.dao.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @program: TalentoHR
 * @description:
 * @author: record
 * @create: 2023-07-03 15:46
 **/
@Service
public class SalaryService {

    @Autowired
    private SalaryMapper salaryMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * ��ѯ����
     */
    public List<SalaryDto> getAll() {
        ArrayList<SalaryDto> salaryDtos = new ArrayList<>();
        List<Salary> salaries = salaryMapper.selectByExample(null);
        if (salaries != null) {
            for (Salary salary : salaries) {
                SalaryDto salaryDto = new SalaryDto();
                salaryDto.setId(salary.getId());
                salaryDto.setJsalary(salary.getJsalary());
                salaryDto.setJbonus(salary.getJbonus());
                salaryDto.setIsgrant(salary.getIsgrant());
                Employee employee = employeeMapper.selectByPrimaryKey(salary.getEmpId());
                salaryDto.setEmpName(employee.getEmpName());
                Department department = departmentMapper.selectByPrimaryKey(salary.getDeptId());
                salaryDto.setDeptName(department.getDeptName());
                Date grantdate = salary.getGrantdate();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                // ʹ��SimpleDateFormat��format()������Date����ת��Ϊ�ַ���
                String dateString = sdf.format(grantdate);
                salaryDto.setGrantdate(dateString);
                salaryDtos.add(salaryDto);
            }
            return salaryDtos;
        }
        return null;
    }

    /**
     * н�ʱ���
     */
    public void saveSalary(Salary salary) {
        salaryMapper.insertSelective(salary);
    }

    /**
     * ����id��ѯ
     */
    public SalaryDto getSalaryDto(Integer id) {
        Salary salary = salaryMapper.selectByPrimaryKey(id);
        SalaryDto salaryDto = new SalaryDto();
        salaryDto.setJsalary(salary.getJsalary());
        salaryDto.setJbonus(salary.getJbonus());
        salaryDto.setIsgrant(salary.getIsgrant());
        Employee employee = employeeMapper.selectByPrimaryKey(salary.getEmpId());
        salaryDto.setEmpName(employee.getEmpName());
        Department department = departmentMapper.selectByPrimaryKey(salary.getDeptId());
        salaryDto.setDeptName(department.getDeptName());
        return salaryDto;
    }

    /**
     * �޸�н��
     */
    public void updateSalary(Integer id) {
        Salary salary = salaryMapper.selectByPrimaryKey(id);
        salary.setIsgrant("��");
        // ��ȡ��ǰʱ��
        LocalDateTime currentTime = LocalDateTime.now();
        // ��LocalDateTime����ת��Ϊjava.util.Date����
        Date grantDate = Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant());
        // ��ת�����ʱ��ע�뵽salary�����grantdate������
        salary.setGrantdate(grantDate);
        salaryMapper.updateByPrimaryKeySelective(salary);
    }

    /**
     * ɾ��н��
     */
    public void deleteSalary(Integer id) {
        salaryMapper.deleteByPrimaryKey(id);
    }

    /**
     * ����ɾ��
     */
    public void deleteBatch(List<Integer> ids) {
        SalaryExample salaryExample = new SalaryExample();
        SalaryExample.Criteria criteria = salaryExample.createCriteria();
        criteria.andEmpIdIn(ids);
        salaryMapper.deleteByExample(salaryExample);
    }
}
