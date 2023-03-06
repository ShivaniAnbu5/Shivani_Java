package MementoPattern;


public class Notes {
	private String note;

	public void setNotes(String note) {
		this.note = note;
	}
	
	public String getNotes() {
		return note;
	}

	public Memento saveNotesToMemento() {
		return new Memento(this.note);
	}

	public String getNotesFromMemento(Memento memento) {
		return memento.getNotes();
	}
	
	
	//Inner class
	public static class Memento {
		
		private String note;
		
		private Memento(String note) {
			this.note = note;
		}

		
		public String getNotes() {
			return note;
		}

	}
}
