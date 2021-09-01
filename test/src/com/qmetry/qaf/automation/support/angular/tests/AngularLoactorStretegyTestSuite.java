/**
 * 
 */
package com.qmetry.qaf.automation.support.angular.tests;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.support.angular.AngularLocatiorStrategy;
import com.qmetry.qaf.automation.util.LocatorUtil;
import com.qmetry.qaf.automation.util.Validator;
import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

/**
 * @author chirag.jayswal
 *
 */
public class AngularLoactorStretegyTestSuite {

	@Test(dataProvider = "angLocTestData")
	public void TestAngularLoactorStretegy(String stretegyName,String value, By expectedResult) {
		Validator.assertThat(getBundle().containsKey(stretegyName),Matchers.equalTo(true));

		By actual = LocatorUtil.getBy(String.format("%s=%s", stretegyName,value));
		Validator.assertThat(actual.toString(),Matchers.equalToIgnoringCase(expectedResult.toString()));
	}
	
	@DataProvider(name = "angLocTestData")
	Object[][] seDp() {
		return new Object[][] {
			// String stretegyName,String value, By expectedResult
			new Object[] { "angular-model", "my-modle", new AngularLocatiorStrategy.AngularModel("my-modle") }, 
			new Object[] { "angular-binding", "my-binding", new AngularLocatiorStrategy.AngularBinding("my-binding") }, 
			new Object[] { "angular-exact-binding", "my-exact-binding", new AngularLocatiorStrategy.AngularExcatBinding("my-exact-binding") }, 
			new Object[] { "angular-options", "my-options", new AngularLocatiorStrategy.AngularOptions("my-options") }, 
			new Object[] { "angular-repeater", "my-repeater", new AngularLocatiorStrategy.AngularRepeater("my-repeater") }, 
			new Object[] { "angular-exact-repeater", "my-exact-repeater", new AngularLocatiorStrategy.AngularExactRepeater("my-exact-repeater") }, 
			new Object[] { "angular-buttontext", "my-buttontext", new AngularLocatiorStrategy.AngularButtonText("my-buttontext") }, 
			new Object[] { "angular-partial-buttontext", "my-partial-buttontext", new AngularLocatiorStrategy.AngularPartialButtonText("my-partial-buttontext") }
		};
	}

}
