package uk.nhs.nhsbsa.lis.rules.v1.model;

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
	
	
	@Override
	public String toString() {
		return "NationalInsuranceNo [nino=" + nino + "]";
	}
	
	

}
