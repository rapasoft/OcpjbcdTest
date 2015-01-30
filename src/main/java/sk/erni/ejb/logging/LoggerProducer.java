package sk.erni.ejb.logging;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

/**
 * @author rap
 */
@Default
public class LoggerProducer {

	@Produces
	@Log
	@Default
	public Logger createLogger(InjectionPoint injectionPoint) {
		Log log = injectionPoint.getAnnotated().getAnnotation(Log.class);
		return Logger.getLogger(log.forClass().getSimpleName());
	}

}
