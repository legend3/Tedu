package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entity.Emp;

@Repository("empDAO")
public class EmpDAOJdbcImpl implements EmpDAO{
	
	@Resource(name="jdbcTemplate")
	//注入jdbcTempate对象。
	private JdbcTemplate jt;
	
	/**
	 * jdbcTempate会将底层的异常统一转换成
	 * RuntimeException，然后抛出。
	 */
	public void save(Emp emp) {
		jt.update(
		"INSERT INTO emp "
		+ "VALUES(emp_seq.nextval,?,?)", 
		new Object[]{emp.getName(),emp.getAge()});
	}
	
	public List<Emp> findAll() {
		List<Emp> emps = 
				new ArrayList<Emp>();
		String sql = "SELECT * FROM emp";
		emps = jt.query(sql, new EmpRowMapper());
		return emps;
	}
	
	/*
	 * 写一个内部类，该类的作用是将ResultSet转
	 * 换成相应的实体对象。
	 */
	class EmpRowMapper implements RowMapper<Emp>{
		/*
		 * rs:要遍历的ResultSet。
		 * index:第几条记录。
		 */
		public Emp mapRow(ResultSet rs,
				int index) throws SQLException {
			Emp emp = new Emp();
			emp.setName(rs.getString("name"));
			emp.setAge(rs.getInt("age"));
			emp.setId(rs.getInt("id"));
			return emp;
		}
		
	}

//	public Emp findById(int id) {
//		Emp emp = null;
//		String sql = 
//				"SELECT * FROM emp WHERE id=?";
//		Object[] params = new Object[]{id};
//		emp = jt.queryForObject(
//				sql, params,new EmpRowMapper());
//		return emp;
//	}
	
	/**
	 * queryForObject方法：
	 * 如果找不到记录，会抛出异常。
	 */
	public Emp findById(int id){
		Emp emp = null;
		String sql = 
				"SELECT * FROM emp WHERE id=?";
		Object[] params = new Object[]{id};
		List<Emp> emps = 
				jt.query(sql, params, 
						new EmpRowMapper());
		if(emps != null && emps.size() > 0){
			emp = emps.get(0);
		}
		return emp;
	}

	public void update(Emp emp) {
		String sql = "UPDATE emp "
				+ "SET name=?,age=? "
				+ "WHERE id=?";
		Object[] params = 
				new Object[]{emp.getName(),
						emp.getAge(),
						emp.getId()};
		jt.update(sql, params);
	}

	public void delete(int id) {
		String sql = 
				"DELETE FROM emp WHERE id=?";
		Object[] params = 
				new Object[]{id};
		jt.update(sql,params);
	}

	//获得总的记录数
	public int getTotal() {
		String sql =
				"SELECT count(*) FROM emp";
		return jt.queryForObject(sql, 
				Integer.class);
	}

}
