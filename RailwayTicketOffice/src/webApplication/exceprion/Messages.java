package webApplication.exceprion;
//Message for exception
public class Messages {

	//web error messages
	public static final String ERROR_EMPTY_FIELDS = "Fields must be filled";
	public static final String ERROR_VALID_EMAIL = "Invalid email address";
	public static final String ERROR_VALID_PASSWORD = "Passwords don't match or less than 6 characters";
	public static final String ERROR_VALID_LOGIN = "This login has already exists: ";
	public static final String ERROR_VALID_USER= "Wrong name or password";
	public static final String ERROR_VALID_ID = "In field must be only digits";
	public static final String ERROR_VALID_ADMIN_ORDER_FIELD = "In field must be only letters";
	public static final String ERROR_NO_TICKET = "No vacant tables!";
	public static final String ERROR_NOT_FOUND_ROUTE = "Route not found";
	public static final String ERROR_KEY_IS_NOT_VALID = "Key is not valid";
	//DB error messages
	public static final String ERROR_NOT_FOUND_DRIVER = "Driver not found";
	public static final String ERROR_CANNOT_OBTAIN_CONNECTION = "Cannot obtain a connection from the pool";
	public static final String ERROR_CANNOT_ADD_USER ="Cannot add user";
	public static final String ERROR_CANNOT_FIND_USER_BY_ID="Cannot find user by id";
	public static final String ERROR_CANNOT_FIND_USER_BY_LOGIN ="Cannot find user by login";
	public static final String ERROR_CANNOT_FIND_ROUTE="Cannot find route";
	public static final String ERROR_CANNOT_FIND_STATION="Cannot find station";
	public static final String ERROR_CANNOT_ADD_NEW_ROUTE ="Cannot add new route";
	public static final String ERROR_CANNOT_ADD_NEW_DATA="Cannot add new data";
	public static final String ERROR_CANNOT_FIND_ADDED_ROUTE="Cannot find added route";
	public static final String ERROR_CANNOT_DELETE_ROUTE="Cannot delete route";
	public static final String ERROR_CANNOT_DELETE_STATION="Cannot delete station";
	public static final String ERROR_CANNOT_TICKED_CREATE="Cannot ticket create";
	public static final String ERROR_CANNOT_WORK_TO_DB="Cannot work to ticket in DB";
	
	
	
}