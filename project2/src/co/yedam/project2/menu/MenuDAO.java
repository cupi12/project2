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
	
	private final String Menu_Select_MName ="select * from menu";  //메뉴이름 보여주는 쿼리
	
	public MenuDAO() {
		super();
	}
	
	public List<MenuVO> getList() {
		List<MenuVO> list = new ArrayList<MenuVO>();
		try {
			PreparedStatement psmt = null;
			Connection conn = null;		
			psmt = conn.prepareStatement(Menu_Select_MName);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MenuVO vo = new MenuVO();
				vo.setmName(rs.getString("mName"));
				vo.setmPrice(rs.getInt("mPrice"));
				
				list.add(vo);
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return list;
	}

}
