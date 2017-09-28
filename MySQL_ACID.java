package dao;

public class MySQL_ACID {
	//向数据库里添加一条记录
	public boolean add(*Bean *Bean) {
		// TODO Auto-generated method stub
		
		boolean f = false;

		String sql = "insert into ***/*(要操作的表的名称)*/(属性，属性。。。) values('"
				+ *Bean.get*()  //把参数中的值赋给这条记录
				+ "','"
				+ *Bean.get*()
				+ "')";
		
		Connection conn = DBUtil.getConn();
		Statement state = null;
		try {
			state = conn.createStatement();
			int a = state.executeUpdate(sql);
			if(a==1){
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(state, conn);
		}
		return f;
	}
	
	//根据主码删除数据库里的某条信息
	public boolean delete(类型  参数（主码）){
		boolean f = false ;
		String sql = "delete from 表名  where 主码 = '"+参数+"'";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		try{
			state = conn.createStatement();
			int a = state.executeUpdate(sql);
			if(a==1){
				f = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(state, conn);
		}
		return f;
	}
	
	//查询某表的所有记录
	public List<*Bean> check(){
		List<*Bean> *Beans = new ArrayList<*Bean>();
		String sql = "select * from 表名  ";
		Connection conn = DBUtil.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		*Bean *Bean = null;
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				类型 属性1 = rs.get类型("属性的名称");
				类型  属性2 = rs.get类型("属性的名称");
				类型 属性3= rs.get类型("属性的名称");
				*Bean = new *Bean(属性1，属性2，属性3);
				list.add(*Bean);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, stmt, conn);
		}
		return list;
	}
	
	//修改某条记录
	public boolean update(*Bean *Bean) {
		String sql = "update 表名 set 属性 = "+*Bean.get属性()+" where 属性 = "+*Bean.get属性()+"";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		boolean f = false;
		int a = 0;
		try {
			state = conn.createStatement();
			a = state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(state, conn);
		}
		if (a > 0) {
			f = true;
		}
		return f;
	}
}
