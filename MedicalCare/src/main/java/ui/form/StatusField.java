package ui.form;

public class StatusField {
	private StatusFieldEnum status;
	private String reason;
	
	public StatusField() {
		this(StatusFieldEnum.correct, "");
	}
	
	public StatusField(StatusFieldEnum status, String reason) {
		this.status = status;
		this.reason = reason;
	}
	
	public String getReason() {
		return reason;
	}
	
	public StatusFieldEnum getStatus() {
		return status;
	}
}
