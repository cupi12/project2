package co.yedam.project2.order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.project2.common.DAO;

public class OrderDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	private final String setOrder = "insert into forder(regdt, id, seq, amount, price) "
			+ " values(sysdate, ?, (select nvl(max(seq),0)+1 from forder), ?, ?  )";
	private final String getOrder = "select * from forder where id=?";

	public List<OrderVO> getorder(String id) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		OrderVO vo;
		try {
			psmt = conn.prepareStatement(getOrder);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				vo = new OrderVO();
				vo.setId(rs.getString("id"));
				vo.setAmount(rs.getInt("amount"));
				vo.setPrice(rs.getInt("price"));
				vo.setSeq(rs.getInt("seq"));
				vo.setRegdt(rs.getString("regdt"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}

	/* STRING(regdt id),  INT(seq amount price) */

	public void orderInsert(OrderVO vo) {
		try {
			psmt = conn.prepareStatement(setOrder);
			psmt.setString(1, vo.getId());
			psmt.setInt(2, vo.getAmount());
			psmt.setInt(3, vo.getPrice());

			psmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

}
