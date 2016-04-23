[![Build Status](https://travis-ci.org/concordion/concordion-logging-tooltip-extension-demo.svg?branch=master)](https://travis-ci.org/concordion/concordion-logging-tooltip-extension-demo)
[![Apache License 2.0](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Introduction
------------------

This project demonstrates the usage of the [Concordion](http://concordion.org) [Logging Tooltip Extension](http://github.com/concordion/concordion-logging-tooltip-extension) with [Selenium WebDriver](http://docs.seleniumhq.org/projects/webdriver/).

Example output is shown [here](http://concordion.github.io/concordion-logging-tooltip-extension-demo/spec/org/concordion/ext/demo/selenium/LoggingTooltipDemo.html).
    
Running the tests
---------------------------

The tests use Selenium's FirefoxDriver, so you'll need to have Firefox installed (or you could change the code to use a different driver).
    
The download includes support to run the tests with either <a href="http://www.gradle.org/">Gradle</a> or <a href="http://maven.apache.org/">Maven</a>.  
    
### Using Gradle
1. [Download](http://www.gradle.org/downloads.html) and [install](http://www.gradle.org/installation.html) Gradle (this has been tested with 2.1)
1. From a command line opened at the location to which this package has been unzipped, run `gradle clean test`
1. View the Concordion output under the subfolder `build/reports/spec/org/concordion/ext/demo/selenium/`
    
### Using Maven
1. Download and install maven (this has been tested with 3.0.3)
1. From a command line opened at the location to which this package has been unzipped, run `mvn test`
1. View the Concordion output under the subfolder `target/concordion/org/concordion/ext/demo/selenium/`

### Running from your IDE
Import as a Gradle or as a Maven project. This may require additional plugins to be installed to support Gradle or Maven.

Under the `src/test/java` folder, find the `ExceptionTranslatorDemo` class in the `org.concordion.ext.demo.selenium` package and run as a JUnit test. The location of the Concordion output is shown on the standard output console.

What you should see
--------------------------------
The test will open a Firefox browser and perform some Google searches.
    
### JUnit output
The test should pass successfully.

### Concordion output
The output folder should contain the following specification. (You can see an example of it [here](http://concordion.github.io/concordion-logging-tooltip-extension-demo/spec/org/concordion/ext/demo/selenium/LoggingTooltipDemo.html)).
    
#### LoggingTooltipDemo.html

This should show 2 blue information icons.  Hover over these icons to show information logged during the running of the example.

The bulk of the output is logged by the `SeleniumEventLogger` class, which implements [WebDriverEventListener](https://github.com/Selenium2/Selenium2/blob/master/java/client/src/org/openqa/selenium/support/events/WebDriverEventListener.java). 

The result text is logged from the `GoogleResultsPage`.

Logging the implementation details in this way allows us to ["retain a clear separation between intent and implementation, yet allow non-developers to be reassured that the test has been implemented correctly"](http://blog.davidpeterson.co.uk/2011/01/concordion-extensions.html).

By default this extension logs all output written using `java.util.logging`, with [configuration options](https://github.com/concordion/concordion-logging-tooltip-extension#custom-configuration) to restrict the output that is included.
    
Potential Issues
------------------------
### Proxy

If you are behind a HTTP proxy server, you may need to configure the proxy to allow access to www.google.com

The easiest way to do this may be to add the following lines to the Site() constructor:

>    System.setProperty("http.proxyHost", "<i>proxy.host</i>");
>    System.setProperty("http.proxyPort", "<i>proxy.port</i>");

where <i>`proxy.host`</i> is the host name of the proxy server, and <i>`proxy.port`</i> is the port number.

If your proxy requires authentication, you will also need to set the properties `http.ProxyUser` and `http.proxyPassword`.
  
Additional Gradle Files
-----------------------
`dev.gradle` is only needed if you want to run against snapshot or local builds of the concordion-screenshot-extension.
`publish.gradle` is only needed if you want to publish the output to Github pages.

If copying the project for your own use, you probably won't want either of these files.

Mailing List
-----------------
Feel free to discuss this demo project on the Concordion [mailing list](https://groups.google.com/d/forum/concordion).
