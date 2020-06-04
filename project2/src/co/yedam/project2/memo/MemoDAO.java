package co.yedam.project2.memo;

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
	private final String MEMO_INSERT = "INSERT INTO MEMO(seq,regdt,memo) VALUES((select nvl(max(seq),0)+1 from memo),sysdate,?)";
	private final String MEMO_UPDATE = "UPDATE MEMO SET REGDT=?, MEMO=?, WHERE=SEQ=?";
	private final String MEMO_DELETE = "delete from memo where SEQ=?";

	public MemoDAO() {
		super();
	}

	public MemoVO getMemo(int seq) {
		MemoVO vo = new MemoVO();
		try {
			psmt = conn.prepareStatement(MEMO_SELECT);
			psmt.setInt(1, seq);
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setSeq(rs.getInt("seq"));
				vo.setRegdt(rs.getString("regdd"));
				vo.setMemo(rs.getString("memo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vo;
	}

	public List<MemoVO> getMemoList() {
		MemoVO vo;
		List<MemoVO> list = new ArrayList<MemoVO>();
		try {
			psmt = conn.prepareStatement(MEMO_SELSECT_LIST);
			rs = psmt.executeQuery();

			while (rs.next()) {
				vo = new MemoVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setMemo(rs.getString("memo"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void getInsert(String memo) {

		try {
			psmt = conn.prepareStatement(MEMO_INSERT);
			psmt.setString(1, memo);

			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public MemoVO getUpdate(MemoVO memoUpdate) {
		try {
			psmt = conn.prepareStatement(MEMO_UPDATE);

			psmt.setInt(1, memoUpdate.getSeq());
			psmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memoUpdate;
	}

	public void memoDelete(int seq) {
		try {
			psmt = conn.prepareStatement(MEMO_DELETE);
			psmt.setInt(1, seq);
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // public class MemoDAO extends DAO
}// public class MemoDAO
