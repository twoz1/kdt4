package com.example.demo.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuestBookDTO {
	private Long gno;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate, modDate;
}
