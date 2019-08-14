package com.bjsxt.sorm.core;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

//import com.bjsxt.po.Emp;
import com.bjsxt.sorm.bean.ColumnInfo;
import com.bjsxt.sorm.bean.TableInfo;
import com.bjsxt.sorm.utils.JDBCUtils;
import com.bjsxt.sorm.utils.ReflectUtils;
//import com.bjsxt.vo.EmpVO;

/**
 * 负责针对MySQL数据库的查询
 * @author gaoqi
 *
 */
@SuppressWarnings("all")
public class MySqlQuery extends Query {
	
//	/**
//	 * 用于测试的主函数
//	 * @param args
//	 */
//	public static void main(String[] args) {
////		Number obj = (Number)new MySqlQuery().queryValue("select count(*) from emp where salary>?",new Object[]{1000});
//		
////		testDML();
//		
////		Number obj = new MySqlQuery().queryNumber("select count(*) from emp where salary>?", new Object[] { 1000 });
////		System.out.println(obj);
//
//		testQueryRows();
//	}
	
//	/**
//	 * 测试增删改查
//	 */
//	public static void testDML(){
//		Emp e = new Emp();
//		e.setId(5);
//		e.setEmpname("测试用户名");
//		e.setBirthday(new java.sql.Date(System.currentTimeMillis()));
//		e.setAge(30);
////		new MySqlQuery().delete(e);	//删
////		new MySqlQuery().insert(e);	//增
////		new MySqlQuery().update(e,new String[]{"empname"});	//改
////		new MySqlQuery().update(e,new String[]{"empname","age","salary"});	//改
//		List<Emp>emp=new MySqlQuery().queryRows("select * from sorm.emp where salary>? and age>?",e.getClass(),new String[] {"10000","30"});//查
//		for(Emp ep:emp) {
//			System.out.println(ep.toString());
//		}
//	}
	
//	/**
//	 * 测试复杂查询 查询多行
//	 */
//	public static void testQueryRows() {
////		List<Emp> list = new MySqlQuery().queryRows("select id,empname,age from emp where age>? and salary<?",	Emp.class, new Object[] { 30, 5000 });
////
////		for (Emp e : list) {
////			System.out.println(e.getEmpname());
////		}
//
//		String sql2 = "select e.id,e.empname,salary,bonus,salary+bonus 'money',age,d.dname 'deptName',d.address 'deptAddr' from emp e join dept d on e.deptId=d.id";
//		List<EmpVO> list2 = new MySqlQuery().queryRows(sql2, EmpVO.class, null);
//
//		for (EmpVO e : list2) {
//			System.out.println(e.toString());
//		}
//	}
	
	/**
	 * 分页查询
	 */
	public Object queryPagenate(int pageNum,int size) {
		return null;
	}
}
