package es.amplia.research.weka.zoo.j48;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import es.amplia.research.weka.zoo.AbstractLearner;

/**
 * 
 * @author cbadenes
 * 
 */
public class Learner extends AbstractLearner{

	final static Logger logger = LoggerFactory.getLogger(Learner.class);

	private J48 tree;

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

			List<String> options = new ArrayList<>();
			options.add("-U"); // unpruned tree
			options.add("-C 0.05");         // confidence threshold for pruning. (Default: 0.25)
		    options.add("-M 1");            // minimum number of instances per leaf. (Default: 2)
		    //options.add("-R");            // use reduced error pruning. No subtree raising is performed.
		    options.add("-N 3");            // number of folds for reduced error pruning. One fold is used as the pruning set. (Default: 3)
		    //options.add("-B");            // Use binary splits for nominal attributes.
		    //options.add("-S");            // not perform subtree raising.
		    //options.add("-L");            // not clean up after the tree has been built.
		    //options.add("-A");            // if set, Laplace smoothing is used for predicted probabilites.
		    //options.add("-Q");            // The seed for reduced-error pruning.
			
			this.tree = new J48();
		    tree.setOptions(options.toArray(new String[options.size()]));
		    		    
			tree.buildClassifier(trainData);
			logger.info("J48 Classifier is trained");
			
			Evaluation eval = new Evaluation(trainData);
			 eval.evaluateModel(tree, testData);
			 logger.info(eval.toSummaryString("\nResults\n======\n", false));
			
		} catch (IOException e) {
			logger.error("Error IO", e);
		} catch (Exception e) {
			logger.error("Problem found when training", e);
		}
	}


	@Override
	protected Classifier getClassifier() {
		return this.tree;
	}
	

	
}
