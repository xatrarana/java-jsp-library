package com.xcr.library.DAO;

public class User_Book {
    private  int id;
    private  int userId;
    private  int bookId;
    private String startDate;
    private String endDate;
    private  String userName;
    private  String bookName;
    public User_Book(){};
    public User_Book(int id, int userId, int bookId, String startDate, String endDate, String userName, String bookName){
            this.id = id;
            this.userId = userId;
            this.bookId = bookId;
            this.startDate = startDate;
            this.endDate = endDate;
            this.userName = userName;
            this.bookName = bookName;
    }


    public  void setId(int id){
        this.id = id;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getUserId() {
        return userId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getBookName() {
        return bookName;
    }

    public String getUserName() {
        return userName;
    }

    public int getId() {
        return id;
    }
}
