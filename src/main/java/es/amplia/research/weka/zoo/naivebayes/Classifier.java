package es.amplia.research.weka.zoo.naivebayes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.amplia.research.weka.zoo.AbstractClassifier;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instance;

/**
 * 
 * @author cbadenes
 *
 */
public class Classifier extends AbstractClassifier{
	
	private static final Logger logger = LoggerFactory.getLogger(Classifier.class);
	
	public void load(){
		Learner learner = new Learner();
		learner.learn("zoo");
		this.tree = (NaiveBayes) learner.getClassifier();
		logger.info("Created model ");
	}
	
	
	public void load(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
		Object tmp = in.readObject();
		this.tree = (NaiveBayes) tmp;
		in.close();
		logger.info("Loaded model from file: {}",fileName );
	}

	
}