package co.yedam.project2.deadLine;

public class DeadLineVO {
	String regdt;
	int sum;
	
	
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
	
	@Override
	public String toString() {
		return "ForderVO [regdt=" + regdt + ", sum=" + sum + "]";
	}
	
	
	
	
}
