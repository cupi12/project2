package co.yedam.project2.menu;

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
			MenuVO vo = new MenuVO();
			psmt = conn.prepareStatement(Menu_Select_MName);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo.setmName(rs.getString("mName"));
				vo.setmPrice(rs.getInt("mprice"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
