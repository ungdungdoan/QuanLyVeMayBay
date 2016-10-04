public class Employee implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String address;
	
	public Employee() {
		this("", 0 ,"");
	}

	public Employee(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

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

	public Employee outS(String name , int age, String address) {
		Employee e = new Employee(name, age, address);
		return e;
	}	
}