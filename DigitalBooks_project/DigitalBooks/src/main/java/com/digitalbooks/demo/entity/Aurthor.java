package com.digitalbooks.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AURTHOR")
public class Aurthor {
	     
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="AURTHOR_ID")
	    private int id;
	     
	    @Column
	    private String email;
	     
	    @Column
	    private String password;
	     
	    @Column(name = "first_name")
	    private String firstName;
	     
	    @Column(name = "last_name")
	    private String lastName;
	    
	    @Column(name = "logged_in")
	    private boolean isLoggedin;
	    
	    public boolean isLoggedin() {
			return isLoggedin;
		}

		public void setLoggedin(boolean isLoggedin) {
			this.isLoggedin = isLoggedin;
		}

		public List<Book> getBooks() {
			return books;
		}

		public void setBooks(List<Book> books) {
			this.books = books;
		}

		@OneToMany(mappedBy = "aurthor", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	    private List<Book> books;


		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	    
	    
	     
}
