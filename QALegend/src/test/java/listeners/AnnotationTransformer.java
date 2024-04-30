package listeners;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements org.testng.IAnnotationTransformer{
	public void transform(ITestAnnotation annotation,Class testclass,Constructor testConstructor, Method testMethod)
	{
	annotation.setRetryAnalyzer(RetryAnalyser.class);
	}
}
