package es.amplia.research.weka.zoo.naivebayes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.core.Instance;

/**
 * 
 * @author cbadenes
 *
 */
public class Classifier {
	
	private static final Logger logger = LoggerFactory.getLogger(Classifier.class);
	
	private NaiveBayes tree;

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
	

	public int classify(Instance instance) {
		try {
			double pred = this.tree.classifyInstance(instance);
			return (int) pred;
		} catch (Exception e) {
			logger.error("Problem found when classifying the text",e);
			return -1;
		}
	}	
}