package co.yedam.project2.worker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.project2.common.DAO;

public class WorkerDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	private final String WORKER_SELECT_LIST = "SELECT * FROM WORKER ORDER BY SEQ DESC";
	private final String WORKER_SELECT = "SELCET * FROM WORKER WHERE WNAME=?";
	/*
	 * private final String WORKER_INSERT =
	 * "INSERT INTO WORKER(seq,wname,wstart, wend, totaltime, money) VALUES((select nvl(max(seq),0)+1 from worker), ?,0,0,0,0)"
	 * ;
	 */
	  private final String WORKER_INSERT =
	  "INSERT INTO WORKER(seq,wname,wstart, wend, totaltime, money) VALUES((select nvl(max(seq),0)+1 from worker) ,?,null,null,null,0)"
	  ;
	 
	private final String WORKER_UPDATE = "UPDATE WORKER SET WSTART=SYSDATE WHERE wname=?";
	private final String WORKER_DELETE = "ALTER TABLE WORKER DEOP COLUME SEQ=?";
	
	private final String WORKER_WSTART = "UPDATE WORKER SET WSTART =(TO_DATE(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) WHERE SEQ = ? ";				
	private final String WORKER_WEND = "UPDATE WORKER SET WSTART = (TO_DATE(SYSDATE,'YYYY.MM.DD HH24:MI')) WHERE SEQ=?";
	private final String WORKER_TOTALTIME = "SELECT (TO_DATE(WEND) - TO_DATE(WSTART)) AS HOUR FROM WORKER WHERE SEQ=?"; 
	private final String WORKER_MONEY = "SELECT (SELECT (TO_DATE(WEND) - TO_DATE(WSTART)) AS HOUR FROM WORKER WHERE SEQ=22 ) * 10000 AS MONEY \r\n" + 
			"           FROM WORKER WHERE SEQ=?;     ";

	
	/*
	 * INSERT INTO 테이블명 VALUES (전체 COLUMN에 넣을 VALUE_LIST);
	 */

		
	
	public WorkerDAO() {
		super();
	}
	
	public List<WorkerVO> getWorkerList() {
		List<WorkerVO> list = new ArrayList<WorkerVO>();
		WorkerVO vo = null;
		try {
			psmt = conn.prepareStatement(WORKER_SELECT_LIST);
			rs = psmt.executeQuery();

			while (rs.next()) {
				vo = new WorkerVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setWname(rs.getString("wname"));
				vo.setWstart(rs.getString("wstart"));
				vo.setWend(rs.getString("wend"));
				vo.setTotalTime(rs.getString("totalTime"));
				vo.setMoney(rs.getString("money"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void getInsert(String id) {
		WorkerVO vo = new WorkerVO();
		try {
			psmt = conn.prepareStatement(WORKER_INSERT);
			
			psmt.setString(1, id);
			/*
			 * psmt.setString(2, workervo.getWname()); 
			 * psmt.setString(3, workervo.getWstart()); 
			 * psmt.setString(4, workervo.getWend());
			 * psmt.setString(5, workervo.getTotalTime()); 
			 * smt.setString(5, workervo.getMoney());
			 */
			
			psmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public WorkerVO getUpdate(WorkerVO workervo) {
		WorkerVO vo = new WorkerVO();
		try {
			psmt = conn.prepareStatement(WORKER_UPDATE);
			psmt.setString(1, workervo.getWname());
			psmt.executeUpdate();

			if (rs.next()) {
				vo.setSeq(rs.getInt("seq"));
				vo.setWname(rs.getString("wname"));
				vo.setWstart(rs.getString("wstart"));
				vo.setWend(rs.getString("wend"));
				vo.setTotalTime(rs.getString("totalTime"));
				vo.setMoney(rs.getString("money"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;

	}


	public WorkerVO getUpdate2(String id) {
		WorkerVO vo = new WorkerVO();
		try {
			psmt = conn.prepareStatement(WORKER_UPDATE);
			psmt.setString(1, id);
			psmt.executeUpdate();

			if (rs.next()) {
				vo.setSeq(rs.getInt("seq"));
				vo.setWname(rs.getString("wname"));
				vo.setWstart(rs.getString("wstart"));
				vo.setWend(rs.getString("wend"));
				vo.setTotalTime(rs.getString("totalTime"));
				vo.setMoney(rs.getString("money"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;

	}

	
	public WorkerVO getDelete(String wname) {
		WorkerVO vo = new WorkerVO();
		try {
			psmt = conn.prepareStatement(WORKER_DELETE);
			psmt.setString(1, wname);
			psmt.executeUpdate();

			if (rs.next()) {
				vo.setSeq(rs.getInt("seq"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return vo;
	}
	public WorkerVO getWstart(String wstart) {
		WorkerVO vo = new WorkerVO();
		try {
			psmt = conn.prepareStatement(WORKER_WSTART);
			psmt.setInt(1,  vo.getSeq());
			psmt.executeUpdate();
			
			if(rs.next()) {
				vo.setWstart(rs.getString("wstart"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return vo;
	}
	public WorkerVO getWend(String wend) {
		WorkerVO vo = new WorkerVO();
		try {
			psmt = conn.prepareStatement(WORKER_WEND);
			psmt.setInt(1,  vo.getSeq());
			psmt.executeUpdate();
			
			if(rs.next()) {
				vo.setWend(rs.getString("wend"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return vo;
	}
	
	public WorkerVO getTotalTime(String totalTime) {
		WorkerVO vo = new WorkerVO();
		try {
			psmt = conn.prepareStatement(WORKER_TOTALTIME);
			psmt.setInt(1,  vo.getSeq());
			psmt.executeUpdate();
			
			if(rs.next()) {
				vo.setTotalTime(rs.getString("totalTime"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return vo;
	}
	
	public WorkerVO getMoney(String money) {
		WorkerVO vo = new WorkerVO();
		try {
			psmt = conn.prepareStatement(WORKER_MONEY);
			psmt.setString(1,  money);
			psmt.executeUpdate();
			
			
			if(rs.next()) {
				vo.setMoney(rs.getString("money"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return vo;
	}
}
