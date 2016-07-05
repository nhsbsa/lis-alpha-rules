package uk.nhs.nhsbsa.lis.rules.v1.droolsengine;

import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.nhs.nhsbsa.util.ObjectIndex;

public class IndexEventListener implements RuleRuntimeEventListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(IndexEventListener.class);

	private ObjectIndex index;
	
	public IndexEventListener(ObjectIndex index) {
		super();
		this.index = index;
	}

	@Override
	public void objectDeleted(ObjectDeletedEvent arg0) {
		LOGGER.info("Deleted {}", arg0);
	}

	@Override
	public void objectInserted(ObjectInsertedEvent arg0) {
		LOGGER.info("Inserted {}", arg0);
	}
	
	@Override
	public void objectUpdated(ObjectUpdatedEvent arg0) {
		LOGGER.info("Updated {}", arg0);
	}

}
