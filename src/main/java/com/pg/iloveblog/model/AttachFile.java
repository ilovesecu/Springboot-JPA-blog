package com.pg.iloveblog.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pg.iloveblog.model.converter.BooleanToYNConverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AttachFile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	@Column(nullable = false, length = 100)
	private String fileName; //원본파일 이름
	@Column(nullable = false, length = 50)
	private String uploadPath; //업로드 경로
	@Column(nullable = false, length = 40)
	private String uuid; //uuid
	
	@Column(nullable = false)
	private boolean image; //이미지인지 여부 (true:image(y))
	
	@ManyToOne
	@JoinColumn(name="boardId")
	private Board board;
}
