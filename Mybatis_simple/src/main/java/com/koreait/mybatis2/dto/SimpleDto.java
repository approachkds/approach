package com.koreait.mybatis2.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor	// 디폴트 생성자
@AllArgsConstructor	// 필드를 이용한 생성자
@Data	// getter and setter
public class SimpleDto {

	// field
	private int no;
	private String writer;
	private String title;
	private String content;
	private Date regDate;
	
}
