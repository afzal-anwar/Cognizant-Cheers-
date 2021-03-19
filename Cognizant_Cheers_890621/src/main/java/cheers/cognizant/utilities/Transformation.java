package cheers.cognizant.utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class Transformation implements IAnnotationTransformer {

	// Method to Modify TestNG behaviour
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		IRetryAnalyzer retry = annotation.getRetryAnalyzer();

		if (retry == null)
			annotation.setRetryAnalyzer(Retry.class);

	}

}
