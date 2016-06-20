package uk.nhs.nhsbsa.lis.rules.v1.model;

public class Name {

	private String title;
	
	private String forenames;
	
	private String surname;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getForenames() {
		return forenames;
	}

	public void setForenames(String forenames) {
		this.forenames = forenames;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Name [title=" + title + ", forenames=" + forenames + ", surname=" + surname + "]";
	}

	
}
