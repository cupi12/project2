package co.yedam.project2.order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.yedam.project2.common.DAO;

public class OrderDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	private final String setOrder = "insert into forder(regdt, id, seq, amount, price) "
			+ " values(sysdate, ?, (select nvl(max(seq),0)+1 from forder), ?, ?  )";
	private final String getOrder = "select * from forder where id=?";

	public OrderVO getorder(String id) {
		OrderVO vo = new OrderVO();
		try {
			psmt = conn.prepareStatement(getOrder);
			psmt.setString(1, vo.getId());
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setAmount(rs.getInt("amount"));
				vo.setPrice(rs.getInt("price"));
				vo.setSeq(rs.getInt("seq"));
				vo.setRegdt(rs.getString("regdt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
		
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
