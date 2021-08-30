/*******************************************************************************
 * Copyright (c) 2021 Infostretch Corporation
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package com.qmetry.qaf.automation.support.angular;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.NgWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;

/**
 * @author chirag.jayswal
 * 
 *  TODO: add additional wait/verify/assert methods 
 */
public class AngularWebElement extends QAFWebComponent {
	private NgWebDriver ngDriver;
	
	/**
	 * @param locator
	 */
	public AngularWebElement(String locator) {
		super(locator);
	}

	/**
	 * @param driver
	 */
	public AngularWebElement(QAFExtendedWebDriver driver) {
		super(driver);
	}

	/**
	 * @param driver
	 * @param by
	 */
	public AngularWebElement(QAFExtendedWebDriver driver, By by) {
		super(driver, by);
	}

	/**
	 * @param parent
	 * @param locator
	 */
	public AngularWebElement(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
	}
	
    public void mutate(final String variable, final String value) {
         getNgWebDriver().mutate(this, variable,value);

    }

    public String retrieveJson(final String variable) {
        return getNgWebDriver().retrieveJson(this, variable);

    }

    public Object retrieve(WebElement element, final String variable) {
        return getNgWebDriver().retrieve(this, variable);
    }

    public String retrieveAsString(WebElement element, final String variable) {
        return retrieve(element, variable).toString();
    }

    public Long retrieveAsLong(WebElement element, final String variable) {
        Object rv = retrieve(element, variable);
        if (rv instanceof Double) {
            return ((Double) rv).longValue();
        }
        return (Long) rv;
    }

    public Object evaluateScript(String script) {
        return getNgWebDriver().evaluateScript(this, script);
    }
    
    public  NgWebDriver getNgWebDriver() {
    	if(null==ngDriver) {
    		ngDriver = new NgWebDriver(getWrappedDriver()).withRootSelector(AngularLocatiorStrategy.ROOT_SELECTOR);
    	}
    	return ngDriver;
	}

}
