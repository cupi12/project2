package co.yedam.project2.worker;

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
	public void setWstart(String wstart) {
		this.wstart = wstart;
	}
	public String getWend() {
		return wend;
	}
	public void setWend(String wend) {
		this.wend = wend;
	}
	public String getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
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
