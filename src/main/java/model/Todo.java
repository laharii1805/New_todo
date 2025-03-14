package model;

import java.sql.Date;
//bean

public class Todo {
    private int id;
    private String rollno;
    private String title;
    private String description;
    private Date last_date;
    private String status;

    public Todo() {}

    public Todo(int id, String rollno, String title, String description,Date last_date, String status) {
        this.id = id;
        this.rollno= rollno;
        this.title = title;
        this.description = description;
        this.last_date = last_date;
        this.status = status;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getRollno() {
		return rollno;
	}
	
	public void setRollno(String rollno) {
		this.rollno= rollno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getLast_date() {
		return last_date;
	}

	public void setLast_date(Date last_date) {
		this.last_date = last_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    // Getters and Setters
    
}