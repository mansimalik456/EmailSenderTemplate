package com.emailSenderTemplate.model;

import java.util.Map;

import lombok.Data;

@Data
public class Email {
	
	 private String from;
	 private String to;
	 private String subject;
	 private String content;
	 public Map<String, Object> model;
	

}
