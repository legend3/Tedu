package dao;

import java.util.List;

import entity.Emp;

/**
 * 	Mapper接口。
 *
 */
public interface EmpDAO {
	
	public void save(Emp emp);
	public List<Emp> findAll();
	public Emp findById(int id);
	public void update(Emp emp);
	public void delete(int id);
	
	
	
}
