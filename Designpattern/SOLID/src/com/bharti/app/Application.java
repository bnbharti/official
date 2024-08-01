package com.bharti.app;

import java.util.UUID;

import com.bharti.app.srp.model.Book;
import com.bharti.app.srp.model.Member;
import com.bharti.app.srp.service.BookLoanService;

public class Application {

	public static void main(String[] args) {
		System.out.println("Test");
		Member member = new Member();
		member.setMemberId(UUID.randomUUID());
		member.setName("Narendra");
		Book book = new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone");
		BookLoanService bookLoanService = new BookLoanService();
		bookLoanService.bookLoanMemberDetails(member, book);
	}

}
