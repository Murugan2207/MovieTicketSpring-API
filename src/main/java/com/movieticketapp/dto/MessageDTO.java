package com.movieticketapp.dto;


	import lombok.Data;
	@Data
	public class MessageDTO {
		private String message;
		public MessageDTO(String message) {
			super();
			this.message = message;
		}
		
		
	}


