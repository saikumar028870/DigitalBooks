package com.digitalbooks.demo.dto;

public class ReaderDto {
	
	private String readerMailId;
	
	private String readerName;
	
	private boolean isPurchased;
	
	private int bookId;
	
	private int paymentId;
	
	private boolean isRefunded;

	public String getReaderMailId() {
		return readerMailId;
	}

	public void setReaderMailId(String readerMailId) {
		this.readerMailId = readerMailId;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public boolean isPurchased() {
		return isPurchased;
	}

	public void setPurchased(boolean isPurchased) {
		this.isPurchased = isPurchased;
	}




	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public boolean isRefunded() {
		return isRefunded;
	}

	public void setRefunded(boolean isRefunded) {
		this.isRefunded = isRefunded;
	}  
	
	
	

}
