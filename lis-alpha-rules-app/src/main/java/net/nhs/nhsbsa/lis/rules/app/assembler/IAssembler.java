package net.nhs.nhsbsa.lis.rules.app.assembler;

public interface IAssembler<S, D> {

	public boolean accept(Class<?> source, Class<?> destination);
	
	public void map(S source, D destination);
}
