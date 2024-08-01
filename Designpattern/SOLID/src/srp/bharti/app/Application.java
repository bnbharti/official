package srp.bharti.app;

import java.util.UUID;

import srp.com.bharti.app.model.Book;
import srp.com.bharti.app.model.Member;
import srp.com.bharti.app.service.BookLoanService;

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
