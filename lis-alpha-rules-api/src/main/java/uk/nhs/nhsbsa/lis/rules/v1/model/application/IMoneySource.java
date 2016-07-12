package uk.nhs.nhsbsa.lis.rules.v1.model.application;

/**
 * Income interface
 * @author lorob
 *
 */
public interface IMoneySource {
	
	public Boolean getReceiving();
	public IntervalValue getValue();
	public Enum<?> getType();
}
