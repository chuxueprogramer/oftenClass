package dao;

public class MySQL_c01 {
	//通过某条记录的某个属性查询某条记录
	public *Bean get表名(类型 属性) {
		String sql = "select * from 表名  where 属性='" + 参数 + "'";
		*Bean *Bean = null;
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;
		try {
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			if (rs.next()) {
				类型 属性1 = rs.get类型("属性的名称");
				类型 属性2 = rs.get类型("属性的名称");
				类型 属性3 = rs.get类型("属性的名称");
				*Bean = new *Bean(属性1，属性2，属性3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, state, conn);
		}
		return *Bean;
	}

}
