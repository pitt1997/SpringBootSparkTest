package com.cn.springboot04web.controller;

import com.cn.springboot04web.dao.DepartmentDao;
import com.cn.springboot04web.dao.EmployeeDao;
import com.cn.springboot04web.entities.Department;
import com.cn.springboot04web.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
@Controller
public class EmployeeCtroller {
    //注入EmployeeDao
    //注解就是spring可以自动帮你把bean里面引用的对象的setter/getter方法省略，它会自动帮你set/get
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    //查询所有员工，返回员工列表页面
    //@RequestMapping("/emps")
    //@ResponseBody
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        //取得所有员工后，放在请求域中进行共享（Model,Map,ModelMap）
        model.addAttribute("emps",all);
        //thymeleaf默认拼串，会拼到类路径下classpath:/templates/下去找emp/list
        //classpath:/templates/xxx.html   emp文件夹下的
        return "emp/list";
    }
    //来到员工添加页面，映射emp请求
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面
        //1.先查询所有的部门编号，并且放到容器中，回传（用model）注意！！！！！查一下model用法
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    //员工添加，添加完成后来到员工列表页面
    //springmvc自动将请求参数和入参对象的属性进行一一绑定；要求：请求参数的名字要和Javabean入参的对象里面的属性名相同
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("保存信息："+employee);
        //redirect:表示重定向   /表示当前项目的路径
        //forward:表示转发到一个地址
        employeeDao.save(employee);
        return "redirect:/emps";    //重定向到列表页面
    }

    //来到修改页面，获取员工id，查出当前员工信息，在页面回显
   @RequestMapping("/emp/{id}")
   //@ResponseBody
    public String toEditPage(@PathVariable("id") Integer id,Model model){//
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";   //emp/add
    }
    //员工修改
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        System.out.println("----"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";//删除完成后，重定向到列表页面
    }


}
