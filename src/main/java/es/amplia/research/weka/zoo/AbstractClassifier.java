package es.amplia.research.weka.zoo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weka.classifiers.Classifier;
import weka.core.Instance;

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
	
}
