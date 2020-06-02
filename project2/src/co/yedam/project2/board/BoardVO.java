package co.yedam.project2.board;

public class BoardVO {
	private int seq;
	private String title;
	private String contents;
	private int star;
	private int	recommand;
	private String id;
	private String regdt;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getRecommand() {
		return recommand;
	}
	public void setRecommand(int recommand) {
		this.recommand = recommand;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regDt) {
		this.regdt = regdt;
	}
	
	
	
}
