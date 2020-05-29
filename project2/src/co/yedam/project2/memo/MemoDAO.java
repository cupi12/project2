package co.yedam.project2.wmemo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.project2.common.DAO;


	public class MemoDAO extends DAO {
		private PreparedStatement psmt;
		private ResultSet rs;

		private final String MEMO_SELSECT_LIST = "SELECT * FROM MEMO ORDER BY SEQ DESC";
		private final String MEMO_SELECT = "SELECT * FROM MEMO WHERE SEQ=?";
		private final String MEMO_INSERT = "INSERT INTO MEMO " + "VALUES(memo_seq.nextval,?,?)";
		private final String MEMO_UPDATE = "UPDATE MEMO SET REGDT=?, MEMO=?, WHERE=SEQ=?";
		private final String MEMO_DELETE = "ALTER TABLE MEMO DROP COLUMN SEQ=?"; 
		

		public MemoDAO() {
			super();
		}

		public List<MemoVO> getMemoList() {
			MemoVO memovo = new MemoVO();
			List<MemoVO> list = new ArrayList<MemoVO>();
			try {
				psmt = conn.prepareStatement(MEMO_SELSECT_LIST);
				rs = psmt.executeQuery();

				while (rs.next()) {
					memovo.setSeq(rs.getInt("seq"));
					memovo.setRegdt(rs.getString("regdt"));
					memovo.setMemo(rs.getString("memo"));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}

		public MemoVO getInsert(MemoVO memovo) {
			MemoVO vo = new MemoVO();

			try {
				psmt = conn.prepareStatement(MEMO_INSERT);
				rs = psmt.executeQuery();

				if (rs.next()) {
					vo.setSeq(rs.getInt("seq"));
					vo.setRegdt(rs.getString("regdt"));
					vo.setMemo(rs.getString("memo"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return vo;
		}

		public MemoVO getUpdate(MemoVO memovo) {
			try {
				psmt = conn.prepareStatement(MEMO_UPDATE);
			
			psmt.setInt(1, getSeq());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				memovo.setSeq(rs.getInt("seq"));
				memovo.setRegdt(rs.getString("regdt"));
				memovo.setMemo(rs.getString("memo"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}return memovo;
	}


		private int getSeq() {
			// TODO Auto-generated method stub
			return 0;
		}

		public MemoVO memoDelete(MemoVO memovo) {
			MemoVO memodel = new MemoVO();
			try {
				psmt = conn.prepareStatement(MEMO_DELETE);
				psmt.setInt(1, memodel.getSeq());
				rs = psmt.executeQuery();
				if (rs.next()) {
					memodel.setSeq(rs.getInt("seq"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return memodel;

		

	} // public class MemoDAO extends DAO
}// public class MemoDAO
