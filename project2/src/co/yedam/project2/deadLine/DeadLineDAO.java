package co.yedam.project2.deadLine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.yedam.project2.common.DAO;

public class DeadLineDAO extends DAO{
	
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private final String DEADLINE_LIST = "SELECT * FROM DEADLINE ORDER BY SEQ DESC";
	private final String DEADLINE_CHART = "SELECT TO_Char(regdt, 'DD') AS regdt, sum FROM deadline ORDER BY regdt ASC";
	
	//싱글톤  : static 필드
	static DeadLineDAO instance;	
	public static DeadLineDAO getInstance() {
		if (instance == null)
			instance = new DeadLineDAO();
		return instance;
	}
	
	
	
	public DeadLineDAO() {
		super();
	}
	
	
	public List<DeadLineVO> deadLineList(){
		List<DeadLineVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(DEADLINE_LIST);
			rs = psmt. executeQuery();
			while(rs.next()){
				DeadLineVO vo = new DeadLineVO();
				vo.setRegdt(rs.getString("regdt"));
				vo.setSum(rs.getInt("sum"));
				list.add(vo);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	
		
	
			//차트(날짜,일일 합계) List<Map>
			public List<Map<String,Object>> DeadLine(){
				List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
				
				try {
					psmt = conn.prepareStatement(DEADLINE_CHART);
					rs = psmt.executeQuery();
					while(rs.next()) {
						Map<String,Object> map = new HashMap<String,Object>();
						map.put("regdt",rs.getString("regdt"));
						map.put("sum",rs.getInt("sum"));
						list.add(map);
					}
				}catch(Exception e) {
					e.printStackTrace();
				} 
				return list;
			}
			
}
