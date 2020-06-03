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
	private final String WORKER_INSERT = "INSERT INTO WORKER(seq,wname,wstart, wend, totaltime, money) VALUES((select nvl(max(seq),0)+1 from worker) , ?,sysdate,sysdate,sysdate,0)";
	private final String WORKER_UPDATE = "UPDATE WORKER SET WNAME=?";
	private final String WORKER_DELETE = "ALTER TABLE WORKER DEOP COLUME SEQ=?";
	
	private final String WORKER_WSTART = "INSERT INTO WORKER(WSTART) VALUES(TO_DATE(SYSDATE,'YYYY.MM.DD HH24:MI')) + COMMIT ";				
	private final String WORKER_WEND = "INSERT INTO WORKER(WSTART) VALUES(TO_DATE(SYSDATE,'YYYY.MM.DD HH24:MI')) + COMMIT ";
	private final String WORKER_TOTALTIME = "SELECT (TO_DATE(WEND) - TO_DATE(WSTART)) AS HOUR FROM WORKER WHERE SEQ=?"; 
	private final String WORKER_MONEY = "SELECT (TOTALTIME * 10000) FROM WORKER WHERE SEQ=?";
	/*
	 * private final String WORKER_STARTTIME =
	 * "INSERT INTO WORKER_WSTART VALUES(to_char(sysdata, 'yyyy.mm.dd hh24:mi'));"
	 * private final String WORKER_ENDTIME = "INSERT INTO WORKER_WEND
	 * VALUES(to_char(sysdata, 'yyyy.mm.dd hh24:mi')); private final String
	 * worker_totaltime = DATE_SUB()
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
}
