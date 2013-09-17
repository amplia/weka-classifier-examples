package es.amplia.research.weka.zoo.j48;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weka.classifiers.trees.J48;
import es.amplia.research.weka.zoo.AbstractClassifier;

/**
 * 
 * @author cbadenes
 *
 */
public class Classifier extends AbstractClassifier {
	
	private static final Logger logger = LoggerFactory.getLogger(Classifier.class);
	
	public void load(){
		Learner learner = new Learner();
		learner.learn("zoo");
		this.tree = (J48) learner.getClassifier();
		logger.info("Model Created ");
	}
	
	public void load(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
		Object tmp = in.readObject();
		this.tree = (J48) tmp;
		in.close();
		logger.info("Loaded model: {}",fileName );		
	}

	
}