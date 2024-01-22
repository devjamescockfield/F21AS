
public class NoMatchingIDException extends Exception {

	public NoMatchingIDException(String id){
		super("ID Not Found = " + id);
	}
}
