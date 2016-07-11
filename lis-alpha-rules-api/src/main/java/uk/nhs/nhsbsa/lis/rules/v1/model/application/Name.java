package uk.nhs.nhsbsa.lis.rules.v1.model.application;

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
		StringBuilder sb = new StringBuilder();
		if (title != null) {
			sb.append(title).append(" ");
		}
		if (forenames != null) {
			sb.append(forenames).append(" ");
		}
		if (surname != null) {
			sb.append(surname).append(" ");
		}
		return sb.toString().trim();
	}

	
}
