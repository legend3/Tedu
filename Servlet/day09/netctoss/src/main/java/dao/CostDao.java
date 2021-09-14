package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Cost;
import util.DBUtil;

public class CostDao {
	
	public List<Cost> findAll() {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from cost "
				+ "order by cost_id";
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			List<Cost> list = new ArrayList<Cost>();
			while(rs.next()) {
				Cost c = createCost(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询资费失败", e);
		} finally {
			DBUtil.close(con);
		}
	}

	private Cost createCost(ResultSet rs) throws SQLException {
		Cost c = new Cost();
		c.setCostId(rs.getInt("cost_id"));
		c.setName(rs.getString("name"));
		c.setBaseDuration(rs.getInt("base_duration"));
		c.setBaseCost(rs.getDouble("base_cost"));
		c.setUnitCost(rs.getDouble("unit_cost"));
		c.setStatus(rs.getString("status"));
		c.setDescr(rs.getString("descr"));
		c.setCreatime(rs.getTimestamp("creatime"));
		c.setStartime(rs.getTimestamp("startime"));
		c.setCostType(rs.getString("cost_type"));
		return c;
	}
	
	public void save(Cost cost) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"insert into cost_lhh "
				+ "values(cost_seq_lhh.nextval,"
				+ "?,?,?,?,'1',?,sysdate,null,?)";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, cost.getName());
			//setInt、setDouble不允许传入null，
			//但当前业务中，这些值的确可能为null，
			//且该字段也确实可以为null。此时，可以
			//将这些字段当做对象(setObject)处理。
			ps.setObject(2, cost.getBaseDuration());
			ps.setObject(3, cost.getBaseCost());
			ps.setObject(4, cost.getUnitCost());
			ps.setString(5, cost.getDescr());
			ps.setString(6, cost.getCostType());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"新增资费失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	public Cost findById(int id) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from cost_lhh "
				+ "where cost_id=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return createCost(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询资费失败", e);
		} finally {
			DBUtil.close(con);
		}
		return null;
	}
	
	public static void main(String[] args) {
		CostDao dao = new CostDao();
		Cost c = dao.findById(1);
		System.out.println(
			c.getCostId() + "," +
				c.getName());
	}

}







