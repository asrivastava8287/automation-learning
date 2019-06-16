package FrameworkRestApi.com.utility;

import org.aeonbits.owner.Config;

import org.aeonbits.owner.Config.Sources;

@Sources({
	"file:src/test/resources/PropertyFiles/Config.Properties"
})
public interface Configproperty extends Config{

	String baseuri();
	String basepath();
	String testDataSheetName();
	
}
