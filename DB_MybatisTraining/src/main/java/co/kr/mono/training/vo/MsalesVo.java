package co.kr.mono.training.vo;

public class MsalesVo {

	private String prodId;
	private String prodNm;
	private int saleCnt;
	
	public MsalesVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MsalesVo(String prodId, String prodNm, int saleCnt) {
		super();
		this.prodId = prodId;
		this.prodNm = prodNm;
		this.saleCnt = saleCnt;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdNm() {
		return prodNm;
	}

	public void setProdNm(String prodNm) {
		this.prodNm = prodNm;
	}

	public int getSaleCnt() {
		return saleCnt;
	}

	public void setSaleCnt(int saleCnt) {
		this.saleCnt = saleCnt;
	}

	@Override
	public String toString() {
		return "MsalesVo [prodId=" + prodId + ", prodNm=" + prodNm + ", saleCnt=" + saleCnt + "]";
	}
	
	
}
