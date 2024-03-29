package hw1;
import java.io.*;
import hw1.BadOperationException;
import hw1.FileOutputter;

public class OnShelf implements LBState {
	// Singleton
	private static OnShelf instance;
	
	private OnShelf(){}
	
	public static OnShelf getInst() throws IOException{	
		if(instance == null) {
			instance = new OnShelf();
			FileOutputter.write("OnShelf Instance Created\n");	
			return instance;
		}
		return instance;
	}
	
	@Override
	public void shelf(LibraryBook book) throws IOException {
		BadOperationException.throwError("shelf", instance.toString());
	}
	@Override
	public void issue(LibraryBook book) throws IOException {
		book.setState(Borrowed.getInst());
		FileOutputter.write("Leaving State OnShelf for State Borrowed\n");
		book.Notify(this.toString(), "Borrowed");  
	}
	@Override
	public void extend(LibraryBook book) throws IOException {
		BadOperationException.throwError("extend", instance.toString());
	}
	@Override
	public void returnIt(LibraryBook book) throws IOException {
		BadOperationException.throwError("returnIt", instance.toString());
	}
	@Override
	public String toString() {
		return "OnShelf";
	}
}
