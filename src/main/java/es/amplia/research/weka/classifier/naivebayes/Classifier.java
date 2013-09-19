package es.amplia.research.weka.classifier.naivebayes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.amplia.research.weka.classifier.AbstractClassifier;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instance;
import weka.core.Instances;

/**
 * 
 * @author cbadenes
 *
 */
public class Classifier extends AbstractClassifier{
	
	private static final Logger logger = LoggerFactory.getLogger(Classifier.class);
	
	public void load(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
		Object tmp = in.readObject();
		this.tree = (NaiveBayes) tmp;
		in.close();
		logger.info("Loaded model from file: {}",fileName );
	}

	public void learn(String dataType, int classIndex) {

		try {			
			Instances trainData = readData(dataType+"-train");
			Instances testData = readData(dataType+"-test");

			trainData.setClassIndex(classIndex);
			testData.setClassIndex(classIndex);
		    		    
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
	
}