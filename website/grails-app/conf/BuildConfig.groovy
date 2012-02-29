grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenLocal()
        mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {

        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        provided (group:'org.codehaus.groovy.modules.http-builder', module:'http-builder', version:'0.5.0')
        runtime 'mysql:mysql-connector-java:5.1.13' 
        compile 'org.apache.activemq:activemq-core:5.3.0'

		test "org.seleniumhq.selenium:selenium-support:2.17.0"
        test 'org.seleniumhq.selenium:selenium-firefox-driver:2.17.0'
        test 'org.seleniumhq.selenium:selenium-chrome-driver:2.17.0'
        test "org.codehaus.geb:geb-spock:0.6.1"

    }

	plugins {
		test ":spock:0.5-groovy-1.7"
    	test ":geb:0.6.1"
		test ":functional-test:1.2.7"
		test ":functional-test-development:0.2"
	}
}
coverage {
    exclusions = [
        "**/functional/**"    ]

}
grails.plugin.location.common = "../common"
grails.plugin.location.payment = "../payment"

grails.war.resources = { stagingDir ->
    delete(file:"${stagingDir}/WEB-INF/classes/test/helper/TestDataHelper.class")
    delete(dir:"${stagingDir}/WEB-INF/classes/test")
}
