package uk.nhs.nhsbsa.lis.rules.v1.model.application;

/**
 * Class for contact details taken from HC1 form
 * @author lorob
 *
 */
public class ContactDetails {
	private String telephoneNumber;
	private String mobileNumber;
	private String emailAddress;
	private String preferredContactValue;
	
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPreferredContactValue() {
		return preferredContactValue;
	}
	/**
	 * This should be the value from either telephone\mobile or email
	 * to use a preferred.  
	 * @param preferredContactValue
	 */
	public void setPreferredContactValue(String preferredContactValue) {
		this.preferredContactValue = preferredContactValue;
	}
	@Override
	public String toString() {
		return "ContactDetails [telephoneNumber=" + telephoneNumber + ", mobileNumber=" + mobileNumber
				+ ", emailAddress=" + emailAddress + ", preferredContactValue=" + preferredContactValue + "]";
	}
	
}
