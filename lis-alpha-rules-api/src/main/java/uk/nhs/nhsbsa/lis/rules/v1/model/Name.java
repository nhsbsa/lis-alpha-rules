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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuffer returnStr=new StringBuffer()
				.append(" title:").append(title)
				.append(" forenames:").append(forenames)
				.append(" surname:").append(surname);
		return returnStr.toString();
	}
	
	public String toJSONString(){
		StringBuffer returnStr=new StringBuffer()
				.append("{ \"title\":\"").append(title).append("\",")
				.append(" \"forenames\":\"").append(forenames).append("\",")
				.append(" \"surname\":\"").append(surname).append("\" }");
		return returnStr.toString(); 
	}

}
