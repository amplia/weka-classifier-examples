package es.amplia.research.weka.classifier;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader.ArffReader;

public abstract class AbstractClassifier {

	private static final Logger logger = LoggerFactory.getLogger(Classifier.class);
	
	protected Classifier tree;
	
	public int classify(Instance instance) {
		try {
			double[] distribution = this.tree.distributionForInstance(instance);
			StringBuilder builder = new StringBuilder().append("[");
			int index = 0;
			for (double d : distribution) {
				builder.append(instance.attribute(17).value(index++)).append(":").append(d).append(",");
			}
			builder.append("]");
			logger.info("'{}' distributed as: {}", instance.attribute(0).value(instance.index(0)), builder.toString());
			
			
			double pred = this.tree.classifyInstance(instance);
			return (int) pred;
		} catch (Exception e) {
			logger.error("Problem found when classifying the text",e);
			return -1;
		}
	}	
	
	protected Instances readData(String data) throws IOException{
		String trainFileName = "src/main/resources/"+data+".arff";
		BufferedReader reader = new BufferedReader(new FileReader(trainFileName));
		ArffReader arff = new ArffReader(reader);
		Instances instances = arff.getData();
		reader.close();
		return instances;
	}
	
	public void saveModel(String fileName) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(fileName));
			out.writeObject(this.tree);
			out.close();
			logger.info("Saved model to: {}", fileName);
		} catch (IOException e) {
			logger.error("Problem found when writing", e);
		}
	}
	
}
