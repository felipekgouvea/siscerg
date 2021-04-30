package br.com.cerg.siscerg.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {

	private Integer status;
	private String msg;
	private Long timeStamp;
}
