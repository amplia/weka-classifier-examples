package es.amplia.research.weka.classifier.j48;

import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import java_cup.internal_error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;
import es.amplia.research.weka.classifier.AbstractClassifier;

/**
 * 
 * @author cbadenes
 *
 */
public class Classifier extends AbstractClassifier {
	
	private static final Logger logger = LoggerFactory.getLogger(Classifier.class);
	
	public void load(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
		Object tmp = in.readObject();
		this.tree = (J48) tmp;
		in.close();
		logger.info("Loaded model: {}",fileName );		
	}
	
	public void learn(String dataType, int classIndex) {

		try {			
			Instances trainData = readData(dataType+"-train");
			Instances testData = readData(dataType+"-test");

			trainData.setClassIndex(classIndex);
			testData.setClassIndex(classIndex);

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
	
	
	public void visualize() throws Exception{
		// display classifier
	     final javax.swing.JFrame jf = 
	       new javax.swing.JFrame("Weka Classifier Tree Visualizer: J48");
	     jf.setSize(500,400);
	     jf.getContentPane().setLayout(new BorderLayout());
	     TreeVisualizer tv = new TreeVisualizer(null,((J48)tree).graph(),new PlaceNode2());
	     jf.getContentPane().add(tv, BorderLayout.CENTER);
	     jf.addWindowListener(new java.awt.event.WindowAdapter() {
	       public void windowClosing(java.awt.event.WindowEvent e) {
	         jf.dispose();
	       }
	     });
	 
	     jf.setVisible(true);
	     tv.fitToScreen();
	}

	
}