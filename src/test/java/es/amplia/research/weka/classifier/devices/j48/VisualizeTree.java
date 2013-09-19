package es.amplia.research.weka.classifier.devices.j48;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import weka.core.Instances;
import es.amplia.research.weka.classifier.j48.Classifier;

public class VisualizeTree {

	private Classifier classifier;
	
	@Before
	public void setup() throws FileNotFoundException, ClassNotFoundException,
			IOException {
		this.classifier = new Classifier();
		classifier.learn("devices",4);		
	}
	
	@Test
	public void visualize() throws Exception {
		((es.amplia.research.weka.classifier.j48.Classifier)this.classifier).visualize();
		Thread.currentThread().sleep(300000);
	}
	
}
