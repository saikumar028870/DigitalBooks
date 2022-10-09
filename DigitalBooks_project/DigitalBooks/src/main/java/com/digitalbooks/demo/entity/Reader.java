package com.digitalbooks.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="READER")
public class Reader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="READER_ID")
	private int readerid;
	
	@Column(name = "READER_MAIL_ID")
	private String readerMailId;
	
	@Column(name = "READER_NAME")
	private String readerName;
	
	@Column(name = "PAYMENT_ID")
	private int paymentId;
	
	@Column(name= "IS_REFUNDED")
	private boolean isRefunded;
	

	@OneToMany(mappedBy = "reader", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
     private List<Book> book;
	
	public int getReaderid() {
		return readerid;
	}

	public void setReaderid(int readerid) {
		this.readerid = readerid;
	}

	public String getReaderMailId() {
		return readerMailId;
	}

	public void setReaderMailId(String readerMailId) {
		this.readerMailId = readerMailId;
	}


	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
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

//	public List<Book> getBook() {
//		return book;
//	}
//
//	public void setBook(List<Book> book) {
//		this.book = book;
//	}

	public void setRefunded(boolean isRefunded) {
		this.isRefunded = isRefunded;
	}
}
