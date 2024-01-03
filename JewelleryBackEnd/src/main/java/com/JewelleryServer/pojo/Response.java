package com.JewelleryServer.pojo;




import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class Response<T> {
	private String status;
	private String error;
	private T data;
	public Response(String status, String error, T data) {
		this.status = status;
		this.error = error;
		this.data = data;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
 
	public static <T> Response<T> success(T data) {
		Response<T> resp = new Response<>("success", null, data);
		return resp;
	}
	public static <T> Response<T> error(String message) {
		Response<T> resp = new Response<>("error", message, null);
		return resp;
	}
}






