package MementoPattern;

import java.util.ArrayList;
import java.util.List;

import MementoPattern.Notes.Memento;

//Behavioral design pattern

//Memento pattern is used to restore the state of an object to a previous state or the state wanted.
//Its useful in case of error or failure.
//The intent of this pattern is to capture the internal state of an object and providing a mean for restoring the object into the initial state when needed without revealing the details of implementation
//It delegates the creation of the object's state snapshot to the object itself making the original object's data safe and secure

public class Main {
	private List<Memento> mementoList;
	private Notes note;
	
	public Main() {
		// TODO Auto-generated constructor stub
		mementoList = new ArrayList<>();
		note = new Notes();
	}
	
	public void write(String notes) {
		note.setNotes(notes);
		mementoList.add(note.saveNotesToMemento());
	}
	
	public String undo(int index){
		return note.getNotesFromMemento(mementoList.get(index));
	}
	
	public String getCurrentState() {
		return note.getNotes();
	}
	
	public static void main(String[] args) {

		Main mementoPattern = new Main();
		
		mementoPattern.write("Hi");
		mementoPattern.write("Hi Hello");
		mementoPattern.write("Hi Hello world");
		mementoPattern.write("Hi Hello world !!!");
		
		System.out.println("Current state: "+mementoPattern.getCurrentState());
		
		System.out.println(mementoPattern.undo(2));
		System.out.println(mementoPattern.undo(1));
		System.out.println(mementoPattern.undo(0));

	}
}
