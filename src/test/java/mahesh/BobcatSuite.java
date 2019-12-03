package mahesh;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.concurrent.ConcurrentSuite;

import mahesh.GuiceModule;
import mahesh.feedback.StartFormComponentTest;
import mahesh.login.AuthorizationTest;
import mahesh.summer.ImageComponentTest;
import mahesh.summer.SectionHeaderComponentTest;

@Modules(GuiceModule.class)
@RunWith(ConcurrentSuite.class)
@Suite.SuiteClasses({ AuthorizationTest.class, ImageComponentTest.class, SectionHeaderComponentTest.class,
		StartFormComponentTest.class })
public class BobcatSuite {

}