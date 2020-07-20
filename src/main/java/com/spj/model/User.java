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
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String uid;
	private String pwd;
}
