package es.amplia.research.weka.zoo.naivebayes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import es.amplia.research.weka.zoo.AbstractLearner;

/**
 * 
 * @author cbadenes
 * 
 */
public class Learner extends AbstractLearner{

	final static Logger logger = LoggerFactory.getLogger(Learner.class);

	private NaiveBayes tree;

	public static void main(String[] args) {
		Learner learner = new Learner();
		learner.learn("zoo");
		learner.saveModel("zooClassifier.dat");		
	}	
	
	public void learn(String dataType) {

		try {			
			Instances trainData = readData(dataType+"-train");
			Instances testData = readData(dataType+"-test");

			trainData.setClassIndex(17);
			testData.setClassIndex(17);
		    		    
		    this.tree = new NaiveBayes();
		    
			tree.buildClassifier(trainData);
			logger.info("NaiveBayes Classifier is trained");			
		} catch (IOException e) {
			logger.error("Error IO", e);
		} catch (Exception e) {
			logger.error("Problem found when training", e);
		}
	}
	
	public void eval(String dataType){
		try {
			Instances trainData = readData(dataType+"-train");
			Instances testData = readData(dataType+"-test");
			trainData.setClassIndex(17);
			testData.setClassIndex(17);
			Evaluation eval = new Evaluation(trainData);
			eval.evaluateModel(tree, testData);
			logger.info(eval.toSummaryString("\nSummary\n======\n", false));
			logger.info(eval.toClassDetailsString("\nClass Details\n======\n"));
			logger.info(eval.toMatrixString("\nConfusion Matrix: false positives and false negatives\n======\n"));			
		} catch (IOException e) {
			logger.error("Error IO", e);
		} catch (Exception e) {
			logger.error("Problem found when training", e);
		}
	}


	@Override
	protected weka.classifiers.Classifier getClassifier() {
		return this.tree;
	}
}
