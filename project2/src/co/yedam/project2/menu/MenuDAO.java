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
	
	private final String menuList ="select * from menu order by mname desc";  //메뉴 보여주는 쿼리
	private final String insertMenu = "insert into menu(seq, mname, mprice) values((select nvl(max(seq),0)+1, ?, ?)";
	
	public MenuDAO() {
		super();
	}
	
	public void menuInsert(MenuVO vo) throws SQLException {//메뉴 넣기
		try {
			psmt = conn.prepareStatement(insertMenu);
			
			psmt.setString(1, vo.getmName());
			psmt.setInt(2, vo.getmPrice());
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
	}//end of menuInsert
	
	public List<MenuVO> getList() {//메뉴 전체조회
		List<MenuVO> list = new ArrayList<MenuVO>();
		try {			
			psmt = conn.prepareStatement(menuList);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MenuVO vo = new MenuVO();
				vo.setmName(rs.getString("mname"));
				vo.setmPrice(rs.getInt("mprice"));
				
				list.add(vo);
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}//end of getList

}
