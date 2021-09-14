package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Emp;

public class EmpDao {

	public List<Emp> findAll() {
		List<Emp> list = new ArrayList<Emp>();
		
		Emp e1 = new Emp();
		e1.setEmpno(1);
		e1.setEname("唐僧");
		e1.setJob("领导");
		e1.setSal(8000.0);
		list.add(e1);
		
		Emp e2 = new Emp();
		e2.setEmpno(2);
		e2.setEname("悟空");
		e2.setJob("徒弟");
		e2.setSal(6000.0);
		list.add(e2);
		
		Emp e3 = new Emp();
		e3.setEmpno(3);
		e3.setEname("八戒");
		e3.setJob("徒弟");
		e3.setSal(5000.0);
		list.add(e3);
		
		return list;
	}
	
	public void save(Emp emp) {
		System.out.println("新增保存员工:" + emp);
	}
	
}







