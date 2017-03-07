package teacherUtils;

public class Teacher 
{
	public final String firstName, lastName;
	private String status; 
	
	private String departement;
	
	
	public Teacher(String fName, String lName, String status, String departement)
	{
		firstName = fName;
		lastName = lName;
		this.status = status;
		this.departement = departement;
	}
	
	public Teacher (String [] infos)
	{
		if (infos != null && infos.length < 4) throw new IllegalArgumentException("Erreur ! entrée incorrecte");
		firstName = infos[0];
		lastName = infos[1];
		status = infos[2];
		departement = infos[3];
	}
	
	public String getDepartement()
	{
		return departement;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	
	@Override 
	public String toString()
	{
		String s = "";
		s += "Fist name : "+firstName+"\n";
		s += "Last name : "+lastName+"\n";
		s += "Status : "+status+"\n";
		s += "Departement : "+departement;
		return s;
	}
	

}
