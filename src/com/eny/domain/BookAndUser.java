package com.eny.domain;

/**
 * @author lxl
 * 图书用户关联表
 */
public class BookAndUser {
	private Book book;

	private User user;

	public Book getBook() {
		return book;
	}

	@Override
	public String toString() {
		return "BookAndUser{" +
				"book=" + book +
				", user=" + user +
				'}';
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
