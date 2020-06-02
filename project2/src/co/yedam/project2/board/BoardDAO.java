package co.yedam.project2.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.project2.common.DAO;
import co.yedam.project2.member.MemberVO;



public class BoardDAO extends DAO {
	private	PreparedStatement psmt = null;
	private	ResultSet rs = null;
	
	private final String BOARD_SELECT_LIST = "SELECT * FROM BOARD ORDER BY SEQ asc";
	private final String BOARD_SELECT = "SELECT * FROM BOARD WHERE SEQ=?";
	private final String BOARD_INSERT = "INSERT INTO BOARD(seq, title, contents, star, recommand, id, regdt) "
							+ "VALUES((select nvl(max(seq),0)+1 from board),?,?,?,0,?,sysdate)";
	private final String BOARD_UPDATE = "UPDATE BOARD SET TITLE=?,CONTENTS=?,"
			+"REGDT=?, ID=?, FILENAME=? WHERE SEQ=?";
	private final String BOARD_DELETE = "DELECT FROM BOARD WHERE SEQ=?";
	private final String recommand = "update board set (select nvl(max(seq),0)+1 from board)";
	
	public BoardDAO() {
		super();
	}
	
	public void recommand() {
		
		try {
			psmt = conn.prepareStatement(BOARD_SELECT_LIST);
			rs = psmt.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public List<BoardVO> getBoardList() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			psmt = conn.prepareStatement(BOARD_SELECT_LIST);
			psmt.executeQuery();
			while(rs.next()){
				BoardVO boardvo = new BoardVO();
				boardvo.setSeq(rs.getInt("seq"));
				boardvo.setTitle(rs.getString("title"));
				boardvo.setContents(rs.getString("contents"));
				boardvo.setRegdt(rs.getString("regdt"));
				boardvo.setId(rs.getString("id"));
				boardvo.setStar(rs.getInt("star"));
				boardvo.setRecommand(rs.getInt("recommand"));
				
				list.add(boardvo);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public BoardVO getBoard(int seq){
		BoardVO boardvo = new BoardVO();
		try {
			psmt = conn.prepareStatement(BOARD_SELECT);
			psmt.setInt(1, seq);
			psmt.executeQuery();
			if(rs.next()) {			
				boardvo.setSeq(rs.getInt("seq"));
				boardvo.setTitle(rs.getString("title"));
				boardvo.setContents(rs.getString("contents"));
				boardvo.setRegdt(rs.getString("regdt"));
				boardvo.setId(rs.getString("id"));
				boardvo.setStar(rs.getInt("star"));
				boardvo.setRecommand(rs.getInt("recommand"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return boardvo;
	}
	
	
		public void boardInsert(BoardVO boardvo) {
			BoardVO vo = new BoardVO();
			try {
				psmt = conn.prepareStatement(BOARD_INSERT);
				
				psmt.setString(1, vo.getTitle());
				psmt.setString(2, vo.getContents());
				psmt.setInt(3, vo.getStar());
				psmt.setString(4, vo.getId());
				
				psmt.executeUpdate();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		
	}

		public BoardVO boardUpdate(BoardVO boardvo) {
			try {
			psmt = conn.prepareStatement(BOARD_UPDATE);
			psmt.setInt(1, boardvo.getSeq());
			rs = psmt.executeQuery();
			if(rs.next()) {
				boardvo.setSeq(rs.getInt("seq"));
				boardvo.setTitle(rs.getString("title"));
				boardvo.setContents(rs.getString("contents"));
				boardvo.setRegdt(rs.getString("regdt"));
				boardvo.setId(rs.getString("id"));
				boardvo.setStar(rs.getInt("star"));
				boardvo.setRecommand(rs.getInt("recommand"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return boardvo;	
	}

	public BoardVO boardDelete(int seq) {
		BoardVO vo = new BoardVO();
		try {
			psmt = conn.prepareStatement(BOARD_DELETE);
			psmt.setInt(1,seq);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setSeq(rs.getInt("seq"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

}
