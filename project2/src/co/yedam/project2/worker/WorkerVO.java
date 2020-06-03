package co.yedam.project2.worker;

import java.sql.Date;

public class WorkerVO {
	
	private int seq;
	private String wname;
	private String wstart;
	private String wend;
	private String totalTime;
	private String money;
	
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getWstart() {
		return wstart;
	}
	public void setWstart(String date) {
		this.wstart = date;
	}
	public String getWend() {
		return wend;
	}
	public void setWend(String date) {
		this.wend = date;
	}
	public String getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(String date) {
		this.totalTime = date;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "WorkerVO [seq=" + seq + ", wname=" + wname + ", wstart=" + wstart + ", wend=" + wend + ", totalTime="
				+ totalTime + ", money=" + money + "]";
	}
	
	
	
	

}
