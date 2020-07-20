package com.spj.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String sid;
	private String studnt;
	private String address;
	private String phone;
	private int sex;
	private int authority;
}
