package co.yedam.project2.worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.yedam.project2.worker.WorkerVO;

public class WorkerDAO {
	public Connection conn;

	private String Driver = "oracle:jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "project";
	private String pwd = "project";

	public WorkerDAO() {

	public int WorkerInsert(WorkerVO worker) {   //직원등록
			int r = 0;
			Connection conn = null;
			PreparedStatement pamt = null;
			
						
//		try {
//			Class.forName(Driver);
//			conn = DriverManager.getConnection(url,user,pwd);
//		}catch (Exception e){
//			e.printStackTrace();
			
			try {
			
			//1.db연결
			conn = ConnectionManager.getConnnection();
			
			//2. sql 구문준비
			String sql = "INSERT INTO WORKER(SEQ, WNAME, WSTART, WEND, TOTALTIME, MONEY) VALUES(?,?,?,?,?,?)";
			
			psmt = conn.prepareStatement(sql);
			
			
			//3. 실행
			psmt.setInt(1, worker.getSeq());
			psmt.setString(2, worker.getWname());
			psmt.setString(3, worker.getWstart());
			psmt.setString(4, worker.getWend());
			psmt.setString(5, worker.getTotalTime());
			psmt.setString(6, worker.getMoney());
			
			r = psmt.executeUpdate();
			
			//4. 결과처리
			System.out.println(r+"건이 등록되었습니다.");
			
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
			
			//5.연결해제
				ConnectionManager.close(conn);
			//6.반환
			
				return r;
		}
	// end of insert

	public ArrayList<WorkerVO> getWorkerList() {
		ArrayList<WorkerVO> list = new ArrayList<WorkerVO>();

		try {
			// 1.연결
			Connection conn = null;
			PrepareStatement psmt = null;

			// 2.쿼리 준비
			conn = ConnectionManager.getConnnection();
			String sql = "SELECT*FROM PROJECT2 ORDER BY SEQ";
			psmt = conn.prepareStatement(sql);

			// 3.statement 실행
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				WorkerVO vo = new WorkerVO();

				vo.setSeq(rs.getInt("seq"));
				vo.setWname(rs.getString("wname"));
				vo.setWstart(rs.getString("wstart"));
				vo.setWend(rs.getString("wend"));
				vo.setTotalTime(rs.getString("totaltime"));
				vo.setMoney(rs.getString("money"));

				list.add(vo);
			}

			// 4.결과저장
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.연결해제
		}
		return list; // 6.반환

	}

	public WorkerVO getWorker(String wname) { // 단건 조회
		WorkerVO vo = new WorkerVO();

		try {
			// 1. db연결
			Connection conn = null;
			PreparedStatement psmt = null;

			// 2. 쿼리준비
			conn = ConnectionManager.getConnnection();
			String sql = "select * form worker where wname = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);

			// 3.statement 실행
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {

				vo.setSeq(rs.getInt("seq"));
				vo.setWname(rs.getString("wname"));
				vo.setWstart(rs.getString("wstart"));p
				vo.setWend(rs.getString("wend"));
				vo.setTotalTime(rs.getString("totalTime"));
				vo.setMoney(rs.getString("money"));
			} else {

			}
			// 4. 결과저장
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제

		}
		return vo; // 6. 리턴
	}

	private void setWend(String string) {
		// TODO Auto-generated method stub
		
	}

	public int workerUpdate(WorkerVO worker) {
				int r = 0;
				Connection conn = null;
				PrepareStatement psmt = null;
				try {
					//1.연결
					conn =ConnectionManager.getConnnection();
					
					//2.sql 쿼리준비
					String sql = "update worker set seq=?, wname=?, wstart=?, wend=?, totalTime=?, money=?";
					
					psmt = conn.prepareStatement(sql);
					
					//3.실행
					psmt.setInt(1, worker.getSeq());
					psmt.setString(2, worker.getWname());
					psmt.setString(3, worker.getWstart());
					psmt.setString(4, worker.getWend());
					psmt.setString(5, worker.getTotalTime());
					psmt.setString(6, worker.getMoney());
					
					r = psmt.executeUpdate();
					
					//4.결과처리
					System.out.println(r+ "건이 등록되었습니다.");
					
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					//5.연결해제 or  List로 넘어감
					ConnectionManager.close(conn);
				}
					//6.리턴
				return r;	
					
				}//end of class

} //end of workerDAO