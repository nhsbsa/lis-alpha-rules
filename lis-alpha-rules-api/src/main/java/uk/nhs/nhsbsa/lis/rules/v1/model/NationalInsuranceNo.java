package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Class for National Insurance No (NINO)
 * @author lorob
 *
 */
public class NationalInsuranceNo {
	private String nino;
	
	public NationalInsuranceNo(){
		
	}
	
	/**
	 * @param nino
	 */
	public NationalInsuranceNo(String nino){
		this.nino=nino;
	}

	public String getNINO() {
		return nino;
	}

	public void setNINO(String nINO) {
		nino = nINO;
	}
	
	public boolean isValidNINO(){
		String NINOPattern = "^\\s*[a-zA-Z]{2}(?:\\s*\\d\\s*){6}[a-zA-Z]?\\s*$";

	    // Create a Pattern object
		if(nino==null||nino.length()==0){ return false;}
		try{
			Pattern pattern = Pattern.compile(NINOPattern);
			Matcher m = pattern.matcher(nino);
			return m.matches();
		}catch(PatternSyntaxException pe){
			return false;
		}
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuffer returnStr=new StringBuffer(" NINO:");
		returnStr.append(nino);
		return returnStr.toString();
	}
	
	public String toJSONString(){
		StringBuffer returnStr=new StringBuffer("\"NINO\":\"");
		returnStr.append(nino).append("\"");
		return returnStr.toString();
	}

}
