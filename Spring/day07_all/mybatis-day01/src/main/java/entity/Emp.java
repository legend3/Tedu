package entity;
/**
 * 实体类
 *	注意：属性名要与表的字段名一致(大小写无所谓)。
 *	原因：
 *		mybatis将查询出来的一条记录存放到一个
 *	Map对象里面,key是字段名，value是字段值。
 *		接下来，mybatis会依据字段名，调用
 *	emp对象对应的set方法，完成赋值。
 *	注：
 *		如果属性名与字段名不一致，可以在写
 *	sql时，为字段名指定别名。
 */
public class Emp {
	private Integer id;
	private String name;
	private Integer age;
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", "
				+ "name=" + name + ", age=" + age + "]";
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
