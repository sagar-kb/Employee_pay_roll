package Employee;

import java.util.ArrayList;

abstract class Employe{
	private String name;
	private int id;
	
	
	public Employe(String name,int  id) {
		this.name=name;
		this.id=id;
		
	}
	public String getname(){
		return name;
			
	}
	public int getid() {
		return id;
	}
	
	
	public abstract double calculatesalary();
	@Override
	public String toString() {
		return "employe[name="+name+", id="+id+", salary="+calculatesalary()+"]";
		
	}
	
}

class FullTimeEmploye extends Employe{
	
	private double monthlysalary;
	
	public FullTimeEmploye(String name, int id,double monthlysalary) {
		super(name, id);
		this.monthlysalary=monthlysalary;
	}
		
		
	
	
		
	
	@Override
	public double calculatesalary() {
		return monthlysalary;
		
	}
	
	
}

class parttimeemploye extends Employe{
	private int hoursworked;
	private double hourlyrate;
	
	public parttimeemploye(String name,int id,int hoursworked,double hourlyrate) {
		super(name, id);
		this.hourlyrate=hourlyrate;
		this.hoursworked=hoursworked;
		
	}
	@Override
	public double calculatesalary() {
		return hoursworked * hourlyrate;
	}
	
}


class payrollsystem{
	private ArrayList<Employe>employeelist;
	
	
	public payrollsystem() {
		employeelist=new ArrayList<>();
	}
	
	public void addemploye(Employe employe) {
		employeelist.add(employe);
	}
	public void removeemploye(int id) {
		Employe employetoremove =null;
		for(Employe employe : employeelist) {
			if(employe.getid()==id) {
				employetoremove = employe;
				break;
			}
			
		}
		if(employetoremove != null) {
			employeelist.remove(employetoremove);
		}
	}
	public void displayemploye() {
		for(Employe employe:employeelist) {
			System.out.println(employe);
		}
	}
}
public class main {

	public static void main(String[] args) {
		payrollsystem payrollsystem = new payrollsystem();
		FullTimeEmploye emp1 =new FullTimeEmploye("sagar", 1, 50000.00);
		parttimeemploye emp2 = new parttimeemploye( "ss",  2, 40,23 );
		payrollsystem.addemploye(emp1);
		payrollsystem.addemploye(emp2);
		System.out.println("initial employee details");
		payrollsystem.displayemploye();
		System.out.println("removed employe");
		payrollsystem.removeemploye(2);
		System.out.println("remaining employee detals");
		payrollsystem.displayemploye();

	}

}
