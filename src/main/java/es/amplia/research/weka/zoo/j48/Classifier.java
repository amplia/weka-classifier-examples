package es.amplia.research.weka.zoo.j48;

import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weka.classifiers.trees.J48;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;
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