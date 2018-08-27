import java.util.HashSet;
import java.util.Set;

public class Student { //store student info
	private String name; 
	private int age;
	private String address="Address Unknown";
	public Set<Course> course=new HashSet<Course>();
	
	public Student() {
		
	}
	public Student(String name,int age) {
		this.setName(name);
		this.setAge(age);
	}
	
	public Student(String name,int age,String address) {
		this(name,age);
		this.setAddress(address);
	}
	//setter and getter of student
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Course> getCourse() {
		return course;
	}
	public void setCourse(Set<Course> course) {
		this.course = course;
	}
	
	
}
