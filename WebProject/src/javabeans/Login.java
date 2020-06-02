package javabeans;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Login implements Serializable{
private String email;
private String pass;
private int user_id;
private int login_count;
private int buy_count;
private long day_diff;
private LocalDateTime last_login;

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public int getLogin_count() {
	return login_count;
}
public void setLogin_count(int login_count) {
	this.login_count = login_count;
}
public int getBuy_count() {
	return buy_count;
}
public void setBuy_count(int buy_count) {
	this.buy_count = buy_count;
}
public LocalDateTime getLast_login() {
	return last_login;
}
public void setLast_login(LocalDateTime last_login) {
	this.last_login = last_login;
}
public long getDay_diff() {
	return day_diff;
}
public void setDay_diff(long day_diff) {
	this.day_diff = day_diff;
}
}
