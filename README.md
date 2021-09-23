[![License](https://img.shields.io/github/license/qmetry/qaf-support-angular.svg)](http://www.opensource.org/licenses/mit-license.php)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.qmetry/qaf-support-angular/badge.svg)](https://mvnrepository.com/artifact/com.qmetry/qaf-support-angular/latest)
[![GitHub tag](https://img.shields.io/github/tag/qmetry/qaf-support-angular.svg)](https://github.com/qmetry/qaf-support-angular/tags)
[![javadoc](https://javadoc.io/badge2/com.qmetry/qaf-support-angular/javadoc.svg)](https://javadoc.io/doc/com.qmetry/qaf-support-angular)
# qaf-support-angular
qmetry automation framework angular web support - custom locator stretegies specific to angularjs

This provides following angular specific [locator stretegy](https://qmetry.github.io/qaf/latest/locating_elements.html) using [ngWebDriver](https://github.com/paul-hammant/ngWebDriver#ngwebdriver) by @paul-hammant 

 - angular-model
 - angular-binding
 - angular-exact-binding
 - angular-options
 - angular-repeater
 - angular-exact-repeater
 - angular-buttontext
 - angular-partial-buttontext

 ### Usage: 
 - Add [qaf-support-angular dependency](https://mvnrepository.com/artifact/com.qmetry/qaf-support-angular/latest) to your project
 - Provide root selector using `angular.root.selector` property. Default value is `[ng-app]`
 - Use any of the [locator strategy](https://qmetry.github.io/qaf/latest/locating_elements.html) listed above. For example, to find element using angulare model [locator strategy](https://qmetry.github.io/qaf/latest/locating_elements.html):
```
my.eleusing.angmodel=angular-model=modelname
#self decriptive
my.eleusing.angmodel={'locator':'angular-model=<locator value>','desc':'example element on sample page'}
```
See also [utility methods](/src/com/qmetry/qaf/automation/support/angular/Utils.java) and [custom element](src/com/qmetry/qaf/automation/support/angular/AngularWebElement.java)
