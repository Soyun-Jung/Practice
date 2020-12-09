package dto;

public class MessageDTO {
	private String ms_bdmbid;
	private String ms_mbid;
	private String ms_text;
	private String ms_date;
	private int ms_bdnum;
	
	
	public int getMs_bdnum() {
		return ms_bdnum;
	}

	public void setMs_bdnum(int ms_bdnum) {
		this.ms_bdnum = ms_bdnum;
	}

	@Override
	public String toString() {
		return "MessageDTO [ms_bdmbid=" + ms_bdmbid + ", ms_mbid=" + ms_mbid + ", ms_text=" + ms_text + ", ms_date="
				+ ms_date + "]";
	}
	
	public String getMs_bdmbid() {
		return ms_bdmbid;
	}
	public void setMs_bdmbid(String ms_bdmbid) {
		this.ms_bdmbid = ms_bdmbid;
	}
	public String getMs_mbid() {
		return ms_mbid;
	}
	public void setMs_mbid(String ms_mbid) {
		this.ms_mbid = ms_mbid;
	}
	public String getMs_text() {
		return ms_text;
	}
	public void setMs_text(String ms_text) {
		this.ms_text = ms_text;
	}
	public String getMs_date() {
		return ms_date;
	}
	public void setMs_date(String ms_date) {
		this.ms_date = ms_date;
	}
	
	
}
