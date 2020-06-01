package co.yedam.project2.menu;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.project2.common.DAO;

public class MenuDAO extends DAO{
	
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private final String menuList ="select * from menu order by seq asc";  //메뉴 보여주는 쿼리
	private final String menuInsert = "insert into menu(seq,mname, mprice,filename) values(seq.nextval, ?, ?, ?)";
	private final String menuSelect = "SELECT * FROM menu WHERE mName=?";
	private final String menuUpdate = "Update menu set MNAME=?, MPRICE=? where mName=?";
	private final String menuDelete = "DELETE FROM MENU  WHERE MNAME =?";
	
	public MenuDAO() {
		super();
	}
	

	//메뉴 수정
	public void menuUpdate(MenuVO menu) {
		try {			
			psmt = conn.prepareStatement(menuUpdate);
			psmt.setString(1, menu.getmName());
			psmt.setInt(2, menu.getmPrice());
			psmt.setString(3, menu.getmName());
			
			psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}//end of getList
	
	
	
	
	
	
	public void menuInsert(MenuVO vo) throws SQLException {//메뉴 넣기
		try {
			psmt = conn.prepareStatement(menuInsert);
			
			psmt.setString(1, vo.getmName());
			psmt.setInt(2, vo.getmPrice());
			psmt.setString(3, vo.getFileName());
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
	}//end of menuInsert
	
	
	
	public void menuDelete(String mName) throws SQLException {//메뉴 넣기
		try {
			psmt = conn.prepareStatement(menuDelete);
			
			psmt.setString(1, mName);

			
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
	}//end of menuDelete
	
	
	
	public List<MenuVO> getList() {//메뉴 전체조회
		List<MenuVO> list = new ArrayList<MenuVO>();
		try {			
			psmt = conn.prepareStatement(menuList);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MenuVO vo = new MenuVO();
				vo.setmName(rs.getString("mname"));
				vo.setmPrice(rs.getInt("mprice"));
				vo.setFileName(rs.getString("filename"));
				
				list.add(vo);
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}//end of getList
	
	
	public MenuVO getMenu(String mName) throws SQLException {//메뉴 단건조회
		MenuVO vo = new MenuVO();
		try {
			psmt = conn.prepareStatement(menuSelect);
			psmt.setString(1, mName);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setmName(rs.getString("mName"));
				vo.setmPrice(rs.getInt("mPrice"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return vo;
		
	}

}
