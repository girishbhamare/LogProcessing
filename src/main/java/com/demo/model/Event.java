package com.demo.model;

//For object Mapping

public class Event {
	private String id;
	private State state;
	private String type;
	private String host;
	private Long timestamp;
	private Boolean alert = false;

	public Boolean getAlert() {
		return alert;
	}

	public void setAlert(Boolean alert) {
		this.alert = alert;
	}

	public String getId() {
		return id;
	}

	public State getState() {
		return state;
	}

	public String getType() {
		return type;
	}

	public String getHost() {
		return host;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public enum State {
		STARTED, FINISHED
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", state=" + state + ", type=" + type + ", host=" + host + ", timestamp=" + timestamp
				+ ", alert=" + alert + "]";
	}

}
