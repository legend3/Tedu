package dao;

import java.util.List;

import entity.Emp;

public interface EmpDAO {
	public void save(Emp emp);
	public List<Emp> findAll();
}
