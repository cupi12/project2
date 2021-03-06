package co.yedam.project2.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import co.yedam.project2.common.DAO;

public class MemberDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	private final String MEMBER_SELECT_LIST = "SELECT * FROM MEMBER ORDER BY ID DESC";
	private final String getMember = "SELECT * FROM MEMBER WHERE id=?";
	private final String MEMBER_INSERT = "INSERT INTO MEMBER(id ,pwd ,name ,age ,phone ,regdt) VALUES(? ,? ,? ,? ,? ,SYSDATE)";
	private final String MEMBER_UPDATE = "UPDATE MEMBER SET PWD=?, NAME=?, AGE=?, PHONE=? WHERE ID=?";
	private final String MEMBER_DELETE = "DELETE FROM MEMBER WHERE ID=?";

	public MemberDAO() {
		super();
	}
	
	public int getCount(String title, String contents) {
		String strWhere = " where 1 = 1";
		if (title != null && !title.isEmpty()) {
			strWhere += " and title = ?";
		}
		if (contents != null && !contents.isEmpty()) {
			strWhere += " and contents like '%' || ? || '%'";
		}
		int cnt = 0;

		
		try {
			String sql = "select count(*) AS cnt from member" + strWhere ;
			psmt = conn.prepareStatement(sql);
			int position = 1;
			if (title != null && !title.isEmpty()) {
				psmt.setString(position++, title);
			}
			if (contents != null && !contents.isEmpty()) {
				psmt.setString(position++, contents);
			}
			rs = psmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	public List<MemberVO> getMemberList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			psmt = conn.prepareStatement(MEMBER_SELECT_LIST);
			rs = psmt.executeQuery();
			while (rs.next()) {
				MemberVO membervo = new MemberVO();
				membervo.setId(rs.getString("id"));
				membervo.setPwd(rs.getString("pwd"));
				membervo.setName(rs.getString("name"));
				membervo.setAge(rs.getString("age"));
				membervo.setPhone(rs.getString("phone"));
				membervo.setRegdt(rs.getString("regdt"));

				list.add(membervo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public MemberVO getMember(String id) {
		MemberVO membervo = new MemberVO();

		try {

			psmt = conn.prepareStatement(getMember);
			psmt.setString(1,id);

			rs = psmt.executeQuery();
			if (rs.next()) {
				
				membervo.setId(rs.getString("id"));
				membervo.setPwd(rs.getString("pwd"));
				membervo.setName(rs.getString("name"));
				membervo.setAge(rs.getString("age"));
				membervo.setPhone(rs.getString("phone"));
				membervo.setRegdt(rs.getString("regdt"));
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
		return membervo;
	}

	// 등록
	public void memberInsert(MemberVO vo) throws SQLException {
	
		try {
			psmt = conn.prepareStatement(MEMBER_INSERT);

			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPwd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getAge());
			psmt.setString(5, vo.getPhone());

			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void memberDelete(String id) {
		try {
			psmt = conn.prepareStatement(MEMBER_DELETE);
			psmt.setString(1, id);
			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public MemberVO memberUpdate(MemberVO membervo) {
		try {
			psmt = conn.prepareStatement(MEMBER_UPDATE);
			
			psmt.setString(1, membervo.getPwd());
			psmt.setString(2, membervo.getName());
			psmt.setString(3, membervo.getAge());
			psmt.setString(4, membervo.getPhone());
			psmt.setString(5, membervo.getId());
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return membervo;

	}
}
