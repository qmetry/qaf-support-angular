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

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.ByAngularBinding;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularExactBinding;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.ByAngularOptions;
import com.paulhammant.ngwebdriver.ByAngularPartialButtonText;
import com.paulhammant.ngwebdriver.ByAngularRepeater;

/**
 * This class defines custom locator strategies for anngular js using
 * <a href="https://github.com/paul-hammant/ngWebDriver">ngWebDriver</a> that
 * can be used with qaf. Either use qualified class name as locator strategy or
 * create short name by using properties.
 * <ul>
 * <li>angular-model
 * <li>angular-binding
 * <li>angular-exact-binding
 * <li>angular-options
 * <li>angular-repeater
 * <li>angular-exact-repeater
 * <li>angular-buttontext
 * <li>angular-partial-buttontext
 * </ul>
 * 
 * Example Usage: to use angulare model locator strategy:
 * <p>
 * <code>
 * angular-model=modelname
 * </code>
 * </p>
 * 
 * 
 * @author chirag.jayswal
 */
public class AngularLocatiorStrategy {
	public static final String ROOT_SELECTOR = getBundle().getString("angular.root.selector",
			"[ng-app]");

	public static class AngularModel extends ByAngular {
		public AngularModel(String model) {
			super(new ByAngularModel(ROOT_SELECTOR, model));
		}
	}

	public static class AngularBinding extends ByAngular {
		public AngularBinding(String binding) {
			super(new ByAngularBinding(ROOT_SELECTOR, binding));
		}
	}

	public static class AngularExcatBinding extends ByAngular {
		public AngularExcatBinding(String binding) {
			super(new ByAngularExactBinding(ROOT_SELECTOR, binding));
		}
	}

	public static class AngularOptions extends ByAngular {
		public AngularOptions(String options) {
			super(new ByAngularOptions(ROOT_SELECTOR, options));
		}
	}

	public static class AngularRepeater extends ByAngular {
		public AngularRepeater(String locator) {
			super(new ByAngularRepeater(ROOT_SELECTOR, locator, false));
		}
	}

	public static class AngularExactRepeater extends ByAngular {
		public AngularExactRepeater(String locator) {
			super(new ByAngularRepeater(ROOT_SELECTOR, locator, true));
		}
	}

	public static class AngularButtonText extends ByAngular {
		public AngularButtonText(String text) {
			super(new ByAngularButtonText(ROOT_SELECTOR, text));
		}
	}

	public static class AngularPartialButtonText extends ByAngular {
		public AngularPartialButtonText(String text) {
			super(new ByAngularPartialButtonText(ROOT_SELECTOR, text));
		}
	}

	protected abstract static class ByAngular extends By {
		private By ngby;

		public ByAngular(By by) {
			ngby = by;
		}

		@Override
		public List<WebElement> findElements(SearchContext context) {
			return ngby.findElements(context);
		}
		
		@Override
		public String toString() {
			return ngby.toString();
		}
	}

}
