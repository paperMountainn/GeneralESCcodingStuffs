package Evosuite;

import java.util.List;

import org.evosuite.EvoSuite;
import org.evosuite.Properties;
import org.evosuite.Properties.Algorithm;
import org.evosuite.result.TestGenerationResult;

public class Test {

	@SuppressWarnings("unchecked")
	public void evosuite(String targetClass, String cp) {
		EvoSuite evo = new EvoSuite();
		Properties.TARGET_CLASS = targetClass;
		Properties.ALGORITHM = Algorithm.MONOTONIC_GA;
		Properties.TRACK_COVERED_GRADIENT_BRANCHES = true;
		
		String[] command = new String[] {"-generateSuite", "-class", targetClass, 
				"-projectCP", cp, "-Dsearch_budget", "30"};
		
		List<List<TestGenerationResult>> list 
			= (List<List<TestGenerationResult>>) evo.parseCommandLine(command);
		for(List<TestGenerationResult> l: list) {
			for(TestGenerationResult r: l) {
				System.out.println(r);
			}		
		}		
	}
	
	public static void main(String[] args) {
		String targetClass = "Example";
		/*String cp = "bin";*/
		String cp = "C:\\Users\\admin\\Documents\\GitHub\\GeneralCodingPurposes\\Advanced-Testing-W8\\src\\main\\java\\Evosuite\\";
		String cp1 = "C:\\Users\\admin\\Documents\\GitHub\\GeneralCodingPurposes\\Advanced-Testing-W8\\build\\classes\\java\\main\\Evosuite\\";

		String cp2 = ".";
		Test t = new Test();
		t.evosuite(targetClass, cp1);
	}

}
