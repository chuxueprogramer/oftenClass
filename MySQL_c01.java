package dao;

public class MySQL_c01 {
	//ͨ��ĳ����¼��ĳ�����Բ�ѯĳ����¼
	public *Bean get����(���� ����) {
		String sql = "select * from ����  where ����='" + ���� + "'";
		*Bean *Bean = null;
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;
		try {
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			if (rs.next()) {
				���� ����1 = rs.get����("���Ե�����");
				���� ����2 = rs.get����("���Ե�����");
				���� ����3 = rs.get����("���Ե�����");
				*Bean = new *Bean(����1������2������3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, state, conn);
		}
		return *Bean;
	}

}
