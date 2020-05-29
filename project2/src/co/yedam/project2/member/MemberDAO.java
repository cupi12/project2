package co.yedam.project2.member;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import co.yedam.project2.common.DAO;

public class MemberDAO extends DAO {
	private	PreparedStatement psmt;
	private	ResultSet rs;
	
	private final String MEMBER_SELECT_LIST = "SELECT * FROM MEMBER ORDER BY ID DESC";
	private final String MEMBER_SELECT ="SELECT * FROM MEMBER WHERE id=?";
	private final String MEMBER_INSERT = "INSERT INTO MEMBER(id,pwd,name,age,gender,phone,regdt) VALUES(?,?,?,?,?,?,SYSDATE)";
	private final String MEMBER_UPDATE = "UPDATE MEMBER SET(ID=?, PWD=?, NAME=?, AGE=?, GENDER=?,PHONE=?)";
	private final String MEMBER_DELETE = "DELETE FROM MEMBER WHERE ID=?";
	
	public MemberDAO() {
		super();
	}
	public List<MemberVO> getSelectList(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			psmt = conn.prepareStatement(MEMBER_SELECT_LIST);
			rs = psmt.executeQuery();
			while(rs.next()) {
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
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public MemberVO getSelect(MemberVO membervo) {
		try {
			psmt = conn.prepareStatement(MEMBER_SELECT);
			psmt.setString(1, membervo.getId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				membervo.setId(rs.getString("id"));
				membervo.setPwd(rs.getString("pwd"));
				membervo.setName(rs.getString("name"));
				membervo.setAge(rs.getString("age"));
				membervo.setGender(rs.getString("gender"));
				membervo.setPhone(rs.getString("phone"));
				membervo.setRegdt(rs.getString("regdt"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return membervo;
	}
	
	//등록
	public MemberVO memberInsert(MemberVO membervo) {
		MemberVO vo = new MemberVO();
		try {
			psmt = conn.prepareStatement(MEMBER_INSERT);
			
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPwd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getAge());
			psmt.setString(5, vo.getGender());
			psmt.setString(6, vo.getPhone());
			
			psmt.executeUpdate();
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getString("age"));
				vo.setGender(rs.getString("gender"));
				vo.setPhone(rs.getString("phone"));
				vo.setRegdt(rs.getString("regdt"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return membervo;
		
	}
	
	
	
	public void getDelete(String id) {
		try {
			psmt = conn.prepareStatement(MEMBER_DELETE);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public MemberVO getSelectUpdate(MemberVO membervo) {
		try {
			psmt = conn.prepareStatement(MEMBER_UPDATE);
			psmt.setString(1, membervo.getId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				membervo.setId(rs.getString("id"));
				membervo.setPwd(rs.getString("pwd"));
				membervo.setName(rs.getString("name"));
				membervo.setAge(rs.getString("age"));
				membervo.setGender(rs.getString("gender"));
				membervo.setPhone(rs.getString("phone"));
				membervo.setRegdt(rs.getString("regdt"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return membervo;
		
	}
}
