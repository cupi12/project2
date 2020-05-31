package co.yedam.project2.member;

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
	private final String insert = "insert into member(id,pwd,name,age,gender,phone,regdt) values(?, ?, ?, ?, ?, ?, sysdate)";
	private final String MEMBER_INSERT = "INSERT INTO MEMBER(id,pwd,name,age,gender,phone,regdt) "
											+ "VALUES(?,?,?,?,?,?,SYSDATE)";
	private final String MEMBER_UPDATE = "UPDATE MEMBER SET(ID=?, PWD=?, NAME=?, AGE=?, GENDER=?,PHONE=?)";
	private final String MEMBER_DELETE = "DELETE FROM MEMBER WHERE ID=?";

	public MemberDAO() {
		super();
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
				membervo.setGender(rs.getString("gender"));
				membervo.setPhone(rs.getString("phone"));
				membervo.setRegdt(rs.getString("regdt"));

				list.add(membervo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public MemberVO getSelect(String id) {
		MemberVO membervo = new MemberVO();
		
		


	public MemberVO getMember(String id) {
		MemberVO membervo = new MemberVO();

		try {

			psmt = conn.prepareStatement(MEMBER_SELECT);
			psmt.setString(1,id);

			psmt = conn.prepareStatement(getMember);
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			if (rs.next()) {
				membervo.setId(rs.getString("id"));
				membervo.setPwd(rs.getString("pwd"));
				membervo.setName(rs.getString("name"));
				membervo.setAge(rs.getString("age"));
				membervo.setGender(rs.getString("gender"));
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
	public void memberInsert(MemberVO membervo) throws SQLException {
		try {
			psmt = conn.prepareStatement(MEMBER_INSERT);

			psmt.setString(1, membervo.getId());
			psmt.setString(2, membervo.getPwd());
			psmt.setString(3, membervo.getName());
			psmt.setString(4, membervo.getAge());
			psmt.setString(5, membervo.getGender());
			psmt.setString(6, membervo.getPhone());

			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void memberDelete(String id) {
		try {
			psmt = conn.prepareStatement(MEMBER_DELETE);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public MemberVO memberUpdate(MemberVO membervo) {
		try {
			psmt = conn.prepareStatement(MEMBER_UPDATE);
			psmt.setString(1, membervo.getId());
			psmt.executeUpdate();
			if (rs.next()) {
				membervo.setId(rs.getString("id"));
				membervo.setPwd(rs.getString("pwd"));
				membervo.setName(rs.getString("name"));
				membervo.setAge(rs.getString("age"));
				membervo.setGender(rs.getString("gender"));
				membervo.setPhone(rs.getString("phone"));
				membervo.setRegdt(rs.getString("regdt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return membervo;

	}
}
