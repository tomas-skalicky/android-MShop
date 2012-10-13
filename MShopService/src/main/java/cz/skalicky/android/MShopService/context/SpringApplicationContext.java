package cz.skalicky.android.MShopService.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * Implements the Singleton design pattern.
 * 
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 *         &lt;skalicky.tomas@gmail.com&gt;
 */
@Service
public class SpringApplicationContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext = null;

	/**
	 * Private constructor prevents instantiation from other classes.
	 */
	private SpringApplicationContext() {
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// Implementation of the Singleton design pattern.
		if (SpringApplicationContext.applicationContext == null) {
			synchronized (this) {
				if (SpringApplicationContext.applicationContext == null) {
					SpringApplicationContext.applicationContext = applicationContext;
				} else {
					throw new RuntimeException(
							"Application context already set.");
				}
			}
		} else {
			throw new RuntimeException("Application context already set.");
		}
	}

	public static Object getBean(String beanName) {
		return SpringApplicationContext.applicationContext.getBean(beanName);
	}
}
