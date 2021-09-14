package dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import entity.Emp;
import entity.Emp2;

/**
 * 使用MyBatis提供的SqlSessionTempate
 * 来访问数据库。
 */
@Repository("empDAO")
public class EmpDAOMybatisImpl 
	implements EmpDAO{
	
	@Resource(name="sst")
	//Resource注解来自于javaee(javax.annotation)
	private SqlSessionTemplate sst;
	
	public void save(Emp emp) {
		sst.insert("save", emp);
	}

	public List<Emp> findAll() {
		return sst.selectList("findAll");
	}

	public Emp findById(int id) {
		return sst.selectOne(
				"findById", id);
	}

	public void update(Emp emp) {
		sst.update("update", emp);
	}

	public void delete(int id) {
		sst.delete("delete", id);
	}

	public Emp2 findById3(int id) {
		return sst.selectOne("findById3",
				id);
	}
	
}
