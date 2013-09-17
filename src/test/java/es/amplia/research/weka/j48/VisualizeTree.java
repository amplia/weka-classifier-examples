package es.amplia.research.weka.j48;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import es.amplia.research.weka.zoo.Animal;
import es.amplia.research.weka.zoo.Animal.Name;
import es.amplia.research.weka.zoo.j48.Classifier;

public class VisualizeTree {

	private Classifier classifier;
	private Instances instances;

	@Before
	public void setup() throws FileNotFoundException, ClassNotFoundException,
			IOException {
		this.classifier = new Classifier();
		classifier.load();

		// Classify
		FastVector typeVal = new FastVector(7);
		typeVal.addElement(Animal.Type.mammal.name());
		typeVal.addElement(Animal.Type.bird.name());
		typeVal.addElement(Animal.Type.reptile.name());
		typeVal.addElement(Animal.Type.fish.name());
		typeVal.addElement(Animal.Type.amphibian.name());
		typeVal.addElement(Animal.Type.insect.name());
		typeVal.addElement(Animal.Type.invertebrate.name());

		FastVector nameVal = new FastVector(100);
		for (Name animal : Animal.Name.values()) {
			nameVal.addElement(animal.name());
		}
		
		FastVector booleanVal = new FastVector(2);
		booleanVal.addElement("false");
		booleanVal.addElement("true");

		FastVector fvWekaAttributes = new FastVector(18);
		fvWekaAttributes.addElement(new Attribute("animal", 	nameVal, 0));
		fvWekaAttributes.addElement(new Attribute("hair", 		booleanVal, 1));
		fvWekaAttributes.addElement(new Attribute("feathers",	booleanVal, 2));
		fvWekaAttributes.addElement(new Attribute("eggs", 		booleanVal, 3));
		fvWekaAttributes.addElement(new Attribute("milk", 		booleanVal, 4));
		fvWekaAttributes.addElement(new Attribute("airborne",	booleanVal, 5));
		fvWekaAttributes.addElement(new Attribute("aquatic", 	booleanVal,	6));
		fvWekaAttributes.addElement(new Attribute("predator",	booleanVal, 7));
		fvWekaAttributes.addElement(new Attribute("toothed", 	booleanVal,	8));
		fvWekaAttributes.addElement(new Attribute("backbone",	booleanVal, 9));
		fvWekaAttributes.addElement(new Attribute("breathes",	booleanVal, 10));
		fvWekaAttributes.addElement(new Attribute("venomous",	booleanVal, 11));
		fvWekaAttributes.addElement(new Attribute("fins", 		booleanVal, 12));
		fvWekaAttributes.addElement(new Attribute("legs", 13));
		fvWekaAttributes.addElement(new Attribute("tail", 		booleanVal, 14));
		fvWekaAttributes.addElement(new Attribute("domestic",	booleanVal, 15));
		fvWekaAttributes.addElement(new Attribute("catsize", 	booleanVal,	16));
		fvWekaAttributes.addElement(new Attribute("type", 		typeVal, 17));

		this.instances = new Instances("Test relation", fvWekaAttributes, 1);
		instances.setClassIndex(17);
	}
	
	@Test
	public void visualize() throws Exception {
		((es.amplia.research.weka.zoo.j48.Classifier)this.classifier).visualize();
		Thread.currentThread().sleep(300000);
	}
	
}
