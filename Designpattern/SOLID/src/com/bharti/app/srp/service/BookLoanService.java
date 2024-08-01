package com.bharti.app.srp.service;

import java.util.UUID;

import com.bharti.app.srp.model.Book;
import com.bharti.app.srp.model.Member;

public class BookLoanService {
	public void bookLoanMemberDetails(Member member, Book book) {
		 
		System.out.println("Member Name:- " + member.getName() + "\nBook Title:- " + book.getTitle());
	}
}
