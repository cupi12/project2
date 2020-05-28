package co.yedam.project2.forder;

public class ForderVO {

	String regdt;
	String id;
	int seq;
	int amount;
	int price;
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	@Override
	public String toString() {
		return "ForderVO [regdt=" + regdt + ", id=" + id + ", seq=" + seq + ", amount=" + amount + ", price=" + price
				+ "]";
	}
	

	
}
