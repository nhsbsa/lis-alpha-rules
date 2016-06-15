package net.nhs.nhsbsa.lis.rules.app.assembler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.nhs.nhsbsa.lis.rules.app.exception.ExceptionUtils;

@Service
public class AssemblerService implements IAssemblerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssemblerService.class);
	
	@Autowired
	private List<IAssembler<?, ?>> assemblers;
	
	@Override
	public void map(Object source, Object destination) {
		
		IAssembler<Object, Object> assembler = find(source.getClass(), destination.getClass());
		assembler.map(source, destination);
	}

	@SuppressWarnings("unchecked")
	private IAssembler<Object, Object> find(Class<? extends Object> src, Class<? extends Object> dst) {
		
		for (IAssembler<?, ?> candidate : assemblers) {
			if (candidate.accept(src, dst)) {
				LOGGER.info("Found assembler ({} > {}) {}", new Object[]{
						src, dst, candidate.getClass().getName()
				});
				return (IAssembler<Object, Object>) candidate;
			}
		}
		throw ExceptionUtils.illegalArgument("No IAssembler available to map {} to {}", new Object[]{
				src, dst
		});
	}

}
