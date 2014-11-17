package JsonClasses;

public class CreateNoteJson implements java.io.Serializable {

		private  final long serialVersionUID = 1L;
		private String overallID = "createNote";
		private String createdBy;
		private String dateTime;
		private String text;
		private int eventID;
		private int noteID;
		
		//Getters and setters for everything

		
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public String getDateTime() {
			return dateTime;
		}
		public void setDateTime(String dateTime) {
			this.dateTime = dateTime;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public int getEventID() {
			return eventID;
		}
		public void setEventID(int eventID) {
			this.eventID = eventID;
		}
		public int getNoteID() {
			return noteID;
		}
		public void setNoteID(int noteID) {
			this.noteID = noteID;
		}
		public String getOverallID() {
			return overallID;
		}
		public void setOverallID(String overallID) {
			this.overallID = overallID;
		}
			
		
}