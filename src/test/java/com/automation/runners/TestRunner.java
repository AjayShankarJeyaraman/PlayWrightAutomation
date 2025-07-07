package com.automation.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports/cucumber.html, json:target/cucumber-reports/cucumber.json")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.automation.steps")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "${cucumber.filter.tags:@smoke}")
public class TestRunner {
} 