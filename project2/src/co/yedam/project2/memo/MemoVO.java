package co.yedam.project2.memo;

import java.util.Date;

public class MemoVO {
	
	private int seq;
	private String regdt;
	private String memo;
	
	
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "MemoVO [seq=" + seq + ", regdt=" + regdt + ", memo=" + memo + "]";
	}
	
	
	
	
	


}
