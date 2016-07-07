package uk.nhs.nhsbsa.lis.rules.v1.model;

/**
 * Income interface
 * @author lorob
 *
 */
public interface IMoneySource {
	
	public Boolean isReceiving();
	public IntervalValue getValue();
}
