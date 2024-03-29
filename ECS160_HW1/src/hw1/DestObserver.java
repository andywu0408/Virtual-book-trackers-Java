package hw1;

import java.io.IOException;

public class DestObserver implements Observer{
	private String name;
	private LibraryBook book;
	private boolean hasObserved;
	
	public DestObserver(String name) {
		this.name = name;
		hasObserved = false;
	}
	
	@Override
	// ex. Ji OBSERVED Design Patterns REACHING STATE: Borrowed
	public void update(String src, String dest, LibraryBook book) {
		try {
			FileOutputter.write(name + " OBSERVED " + book.name +
					 " REACHING STATE: " + dest + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void setHasObserved(boolean b) {
		this.hasObserved = b;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	
	@Override
	public String toString() {
		return this.name;
	}

	// only equals if this & rhs both are DestObserver and they have same name
	@Override
	public boolean equals(Object rhs) {
		if (!(rhs instanceof DestObserver)) { 
            return false; 
        } 
		DestObserver castedRhs = (DestObserver) rhs; 
		return this.name == castedRhs.name;
	}
	
	@Override
	public int hashCode() {
	    return Integer.parseInt(this.name);  
	}

}
