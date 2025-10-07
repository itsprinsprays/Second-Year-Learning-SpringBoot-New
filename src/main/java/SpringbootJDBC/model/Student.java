package SpringbootJDBC.model;

public class Student {
	private String FullName,section;
	private int age, id;
	
	public Student(String FullName, String section, int age, int id) {
		this.FullName = FullName;
		this.section = section;
		this.age = age;
		this.id = id;
	}
	
	public String getFullName() { return FullName; }
	public String getSection() { return section; }
	public int getAge() { return age; }
	public int getID() { return id; }
	
	public void setFullName(String FullName) { this.FullName = FullName; }
	public void setSection(String section) { this.section = section; }
	public void setAge(int age) { this.age = age; }
	public void setID(int id) { this.id = id; }
}
