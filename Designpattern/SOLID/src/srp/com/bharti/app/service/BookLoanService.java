package srp.com.bharti.app.service;

import java.util.UUID;

import srp.com.bharti.app.model.Book;
import srp.com.bharti.app.model.Member;

public class BookLoanService {
	public void bookLoanMemberDetails(Member member, Book book) {
		 
		System.out.println("Member Name:- " + member.getName() + "\nBook Title:- " + book.getTitle());
	}
}
