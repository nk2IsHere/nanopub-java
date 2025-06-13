package org.nanopub;

import org.junit.Test;
import org.nanopub.CheckNanopub.Report;

import java.io.File;

public class CheckValidNanopubsTest {
 
	@Test
	public void runTest() throws Exception {
		for (File testFile : new File("src/test/resources/testsuite/valid/plain/").listFiles()) {
			testPlain(testFile.getName());
		}
		for (File testFile : new File("src/test/resources/testsuite/valid/trusty/").listFiles()) {
			testTrusty(testFile.getName());
		}
		for (File testFile : new File("src/test/resources/testsuite/valid/signed/").listFiles()) {
			testSigned(testFile.getName());
		}
	}

	public void testPlain(String filename) throws Exception {
		CheckNanopub c = CliRunner.initJc(new CheckNanopub(), new String[] {"src/test/resources/testsuite/valid/plain/" + filename});
		Report report = c.check();
		System.out.println(report.getSummary() + " " + filename);
		assert report.areAllValid();
	}

	public void testTrusty(String filename) throws Exception {
		CheckNanopub c = CliRunner.initJc(new CheckNanopub(), new String[] {"src/test/resources/testsuite/valid/trusty/" + filename});
		Report report = c.check();
		System.out.println(report.getSummary() + " " + filename);
		assert report.areAllTrusty();
	}

	public void testSigned(String filename) throws Exception {
		CheckNanopub c = CliRunner.initJc(new CheckNanopub(), new String[] {"src/test/resources/testsuite/valid/signed/" + filename});
		Report report = c.check();
		System.out.println(report.getSummary() + " " + filename);
		assert report.areAllSigned();
	}

}
