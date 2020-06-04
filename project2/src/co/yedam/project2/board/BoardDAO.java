package co.yedam.project2.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.project2.common.DAO;
import co.yedam.project2.member.MemberVO;

public class BoardDAO extends DAO {
	private PreparedStatement psmt = null;
	private ResultSet rs = null;


	private final String BOARD_SELECT_LIST = "SELECT * FROM BOARD ORDER BY SEQ DESC";
	private final String BOARD_SELECT = "SELECT * FROM BOARD WHERE SEQ=?";
	private final String BOARD_INSERT = "INSERT INTO BOARD(seq, title, contents, star, recommand,filename, id, regdt) "
			+ "VALUES((select nvl(max(seq),0)+1 from board),?,?,?,0,?,?,sysdate)";
	private final String BOARD_UPDATE = "update board set title = ?, contents= ? where seq=? ";
	private final String BOARD_DELETE = "delete FROM BOARD WHERE SEQ=?";
	private final String recommand = "update board set recommand=(select nvl(max(recommand),0)+1 from board where seq=?) where seq=?";

	public BoardDAO() {
		super();
	}

	public void recommand(int seq) {

		try {
			psmt = conn.prepareStatement(recommand);
			psmt.setInt(1, seq);
			psmt.setInt(2, seq);
			rs = psmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<BoardVO> getBoardList() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO boardvo;
		try {
			psmt = conn.prepareStatement(BOARD_SELECT_LIST);
			rs = psmt.executeQuery();
			while (rs.next()) {
				boardvo = new BoardVO();
				boardvo.setSeq(rs.getInt("seq"));
				boardvo.setTitle(rs.getString("title"));
				boardvo.setContents(rs.getString("contents"));
				boardvo.setId(rs.getString("id"));
				boardvo.setRegdt(rs.getString("regdt"));
				boardvo.setStar(rs.getInt("star"));
				boardvo.setRecommand(rs.getInt("recommand"));

				list.add(boardvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public BoardVO getBoard(int seq) {
		BoardVO boardvo = new BoardVO();
		try {
			psmt = conn.prepareStatement(BOARD_SELECT);
			psmt.setInt(1, seq);
			rs = psmt.executeQuery();
			if (rs.next()) {
				boardvo.setSeq(rs.getInt("seq"));
				boardvo.setTitle(rs.getString("title"));
				boardvo.setContents(rs.getString("contents"));
				boardvo.setRegdt(rs.getString("regdt"));
				boardvo.setId(rs.getString("id"));
				boardvo.setFileName(rs.getString("fileName"));
				boardvo.setStar(rs.getInt("star"));
				boardvo.setRecommand(rs.getInt("recommand"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return boardvo;
	}

	public void boardInsert(BoardVO vo) {
		try {
			psmt = conn.prepareStatement(BOARD_INSERT);

			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContents());
			psmt.setInt(3, vo.getStar());
			psmt.setString(4, vo.getFileName());
			psmt.setString(5, vo.getId());

			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public BoardVO boardUpdate(BoardVO vo) {
		try {
		psmt = conn.prepareStatement(BOARD_UPDATE);
		
		psmt.setString(1, vo.getTitle());
		psmt.setString(2, vo.getContents());
		psmt.setInt(3, vo.getSeq());
			
		psmt.executeUpdate();
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return vo;	
}

	public void boardDelete(int seq) {
		try {
			psmt = conn.prepareStatement(BOARD_DELETE);
			psmt.setInt(1, seq);
			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
