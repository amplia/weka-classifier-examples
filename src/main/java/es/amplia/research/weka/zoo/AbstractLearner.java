package es.amplia.research.weka.zoo;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.converters.ArffLoader.ArffReader;

/**
 * 
 * @author cbadenes
 * 
 */
public abstract class AbstractLearner {

	final static Logger logger = LoggerFactory.getLogger(AbstractLearner.class);

	protected Instances readData(String data) throws IOException{
		String trainFileName = "src/main/resources/"+data+".arff";
		BufferedReader reader = new BufferedReader(new FileReader(trainFileName));
		ArffReader arff = new ArffReader(reader);
		Instances instances = arff.getData();
		reader.close();
		return instances;
	}
	
	abstract protected Classifier getClassifier();
	
	public void saveModel(String fileName) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(fileName));
			out.writeObject(getClassifier());
			out.close();
			logger.info("Saved model to: {}", fileName);
		} catch (IOException e) {
			logger.error("Problem found when writing", e);
		}
	}
}
