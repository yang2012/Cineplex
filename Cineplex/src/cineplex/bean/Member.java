package cineplex.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.GenericGenerator;

public class Member {
	public static final int NORMAL = 0;
	public static final int VIP = 1;
	
	public static final int MALE = 0;
	public static final int FEMALE = 1;
	
	public static final int AVTIVE = 0;
	public static final int SUSPEND = 1;
	public static final int INACTIVE = 2;
	
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private int mid;
	
	@Column(name="username", length=20)
	private String username;
	@Column(name="password", length=20)
	private String password;

	@Column(name="identification", length=20)
	private String identification;
	@Column(name="name", length=20)
	private String name;
	@Column(name="age", length=20)
	private int age;
	@Column(name="sex")
	private int sex;
	@Column(name="account")
	private double account;
	@Column(name="state")
	private int state;
	
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@OrderBy(value="tid ASC")
	private List<Ticket> tickets = new ArrayList<Ticket>();
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@OrderBy(value="crid ASC")	
	private List<ConsumeRecord> consumeRecords = new ArrayList<ConsumeRecord>();
	
	
	public int getMId() {
		return mid;
	}
	public void setMId(int mid) {
		this.mid = mid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
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
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public double getAccount() {
		return account;
	}
	public void setAccount(double account) {
		this.account = account;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	public List<ConsumeRecord> getConsumeRecords() {
		return consumeRecords;
	}
	public void setConsumeRecords(List<ConsumeRecord> consumeRecords) {
		this.consumeRecords = consumeRecords;
	}
	
	
}
