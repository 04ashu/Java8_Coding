package Notes;

public class Notes {
	
	int id;
	String name;
	long tagId;
	
	public Notes() {
		super();
		
	}
	
	
	
	public Notes(int id, String name, long tagId) {
		super();
		this.id = id;
		this.name = name;
		this.tagId = tagId;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getTagId() {
		return tagId;
	}
	public void setTagId(long tagId) {
		this.tagId = tagId;
	}
	@Override
	public String toString() {
		return "Notes [id=" + id + ", name=" + name + ", tagId=" + tagId + "]";
	}
	
	
	
	

}
