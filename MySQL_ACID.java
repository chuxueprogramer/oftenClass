package dao;

public class MySQL_ACID {
	//�����ݿ������һ����¼
	public boolean add(*Bean *Bean) {
		// TODO Auto-generated method stub
		
		boolean f = false;

		String sql = "insert into ***/*(Ҫ�����ı������)*/(���ԣ����ԡ�����) values('"
				+ *Bean.get*()  //�Ѳ����е�ֵ����������¼
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
	
	//��������ɾ�����ݿ����ĳ����Ϣ
	public boolean delete(����  ���������룩){
		boolean f = false ;
		String sql = "delete from ����  where ���� = '"+����+"'";
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
	
	//��ѯĳ������м�¼
	public List<*Bean> check(){
		List<*Bean> *Beans = new ArrayList<*Bean>();
		String sql = "select * from ����  ";
		Connection conn = DBUtil.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		*Bean *Bean = null;
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				���� ����1 = rs.get����("���Ե�����");
				����  ����2 = rs.get����("���Ե�����");
				���� ����3= rs.get����("���Ե�����");
				*Bean = new *Bean(����1������2������3);
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
	
	//�޸�ĳ����¼
	public boolean update(*Bean *Bean) {
		String sql = "update ���� set ���� = "+*Bean.get����()+" where ���� = "+*Bean.get����()+"";
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
