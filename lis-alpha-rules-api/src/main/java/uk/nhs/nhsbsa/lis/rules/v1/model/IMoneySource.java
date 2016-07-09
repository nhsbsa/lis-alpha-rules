package uk.nhs.nhsbsa.lis.rules.v1.model;

/**
 * Income interface
 * @author lorob
 *
 */
public interface IMoneySource {
	
	public enum Type {
		RESOURCE,
		REQUIREMENT;
	}
	public Boolean getReceiving();
	public IntervalValue getValue();
	public Type moneySourceType();
}
