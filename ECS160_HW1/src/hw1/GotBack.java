package hw1;
import java.io.*;
import hw1.BadOperationException;
import hw1.FileOutputter;

public class GotBack implements LBState{
	// Singleton
	private static GotBack instance;
	
	private GotBack(){}
	
	public static GotBack getInst() throws IOException{	

		if(instance == null) {
			instance = new GotBack();
			FileOutputter.write("GotBack Instance Created\n");	
			return instance;
		}
		return instance;
	}
	
	@Override
	public void shelf(LibraryBook book) throws IOException {
		book.setState(OnShelf.getInst());
		FileOutputter.write("Leaving State GotBack for State OnShelf\n");
		book.Notify(this.toString(), "OnShelf");  
	}
	@Override
	public void issue(LibraryBook book) throws IOException  {
		BadOperationException.throwError("issue", instance.toString());
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
		return "GotBack";
	}
}
