import java.util.HashSet;
import java.util.Set;

public class Course {
	private String id;
	private String name;
	private String teacher=null;  //set teacher name of this course
	private double fee;
	private double cost;
	private int max;   //max allowed enroll
	public Set<Student> students=new HashSet<Student>();
	
	public Course() {
		
	}
	
	public void setTeacher(String teacher) {
		this.teacher=teacher;
	}
	public String getTeacher()
	{
		return teacher;
	}
	
	public Course(String id,String name,double fee,double cost) {
		this.setId(id);
		this.setName(name);
		this.setFee(fee);
		this.setCost(cost);
	}
	
	
	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	
}
