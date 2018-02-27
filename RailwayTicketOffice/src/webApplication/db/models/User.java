package webApplication.db.models;

//// Constructor train(ticket + route)
public class User {

	private String firstName;
	private String lastName;
	private String email;
	private String login;
	private String password;
	private boolean role;

	public User() {
	}

	public User(String firstName, String lastName, String email, String login, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.login = login;
		this.password = password;
		this.role = false;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public boolean isRole() {
		return role;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
}
