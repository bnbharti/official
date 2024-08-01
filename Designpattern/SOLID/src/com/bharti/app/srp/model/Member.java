package com.bharti.app.srp.model;

import java.util.UUID;

public class Member {
private UUID memberId;
private String name;

public UUID getMemberId() {
	return memberId;
}
public void setMemberId(UUID memberId) {
	this.memberId = memberId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
