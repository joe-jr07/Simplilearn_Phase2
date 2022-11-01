package model;

public interface UserDAO {
	boolean signIn(User user);
	boolean signUp(User user);
}
