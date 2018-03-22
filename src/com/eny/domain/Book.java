package com.eny.domain;



import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lxl
 * 2017年9月11日
 *	图书信息实体
 */
public class Book {


	public Book() {}

	public Book(Integer bookId) {
		this.bookId = bookId;
	}

	/**
	 *主键ID
	 */
	private Integer bookId;

	/**
	 * 图书名称
	 */
	private String bookName;

	/**
	 * 图书类别信息实体
	 */
	private Category bookCategory;

	/**
	 * 作者
	 */
	private String bookAuthor;

	/**
	 * 出版社
	 */
	private String press;

	/**
	 * 出版时间
	 */
	private Date publishDate;

	/**
	 * 图书价格
	 */
	private Double bookPrice;

	/**
	 * 剩余图书数量
	 */
	private int bookNum;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Category getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(Category bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getPublishDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(publishDate);
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	@Override
	public int hashCode() {
		return this.bookId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Book){
			Book book = (Book)obj;
			if(book.getBookId().equals(this.bookId)){
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Book{" +
				"bookId=" + bookId +
				", bookName='" + bookName + '\'' +
				", bookCategory=" + bookCategory +
				", bookAuthor='" + bookAuthor + '\'' +
				", press='" + press + '\'' +
				", publishDate='" + publishDate + '\'' +
				", bookPrice=" + bookPrice +
				", bookNum=" + bookNum +
				'}';
	}

}
