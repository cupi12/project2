package co.yedam.project2.forder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.project2.common.DAO;
import co.yedam.project2.forder.*;

public class ForderDAO extends DAO{
	
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private final String FORDER_LIST = "SELECT * FROM DEADLINE ORDER BY SEQ DESC";

	
	
	public ForderDAO() {
		super();
	}
	
	
	public List<ForderVO> getSelectList(){
		List<ForderVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(FORDER_LIST);
			rs = psmt. executeQuery();
			while(rs.next()){
				ForderVO vo = new ForderVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setId(rs.getString("id"));
				vo.setPrice(rs.getInt("price"));
				vo.setAmount(rs.getInt("amount"));
				vo.setRegdt(rs.getString("regdt"));
				list.add(vo);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
}
