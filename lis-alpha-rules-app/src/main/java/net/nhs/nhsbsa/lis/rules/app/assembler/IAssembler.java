package net.nhs.nhsbsa.lis.rules.app.assembler;

public interface IAssembler<S, D> {

	public void map(S source, D destination);
}
