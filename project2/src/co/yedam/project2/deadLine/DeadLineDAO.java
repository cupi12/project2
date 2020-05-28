package co.yedam.project2.deadLine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.project2.common.DAO;

public class DeadLineDAO extends DAO{
	
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private final String DEADLINE_LIST = "SELECT * FROM DEADLINE ORDER BY SEQ DESC";
	
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
	
}
