package es.amplia.research.weka.naivebayes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import es.amplia.research.weka.zoo.Animal;
import es.amplia.research.weka.zoo.Animal.Name;
import es.amplia.research.weka.zoo.naivebayes.Classifier;

public class ClassifierTest {

	private Instances instances;
	private Classifier classifier;

	@Before
	public void setup() throws FileNotFoundException, ClassNotFoundException,
			IOException {
		this.classifier = new Classifier();
		classifier.load();

		// Classify
		FastVector typeVal = new FastVector(7);
		typeVal.addElement(Animal.Type.mammal.name());
		typeVal.addElement(Animal.Type.bird.name());
		typeVal.addElement(Animal.Type.reptile.name());
		typeVal.addElement(Animal.Type.fish.name());
		typeVal.addElement(Animal.Type.amphibian.name());
		typeVal.addElement(Animal.Type.insect.name());
		typeVal.addElement(Animal.Type.invertebrate.name());

		FastVector nameVal = new FastVector(100);
		for (Name animal : Animal.Name.values()) {
			nameVal.addElement(animal.name());
		}

		FastVector booleanVal = new FastVector(2);
		booleanVal.addElement("false");
		booleanVal.addElement("true");

		FastVector fvWekaAttributes = new FastVector(18);
		fvWekaAttributes.addElement(new Attribute("animal", 	nameVal, 0));
		fvWekaAttributes.addElement(new Attribute("hair", 		booleanVal, 1));
		fvWekaAttributes.addElement(new Attribute("feathers",	booleanVal, 2));
		fvWekaAttributes.addElement(new Attribute("eggs", 		booleanVal, 3));
		fvWekaAttributes.addElement(new Attribute("milk", 		booleanVal, 4));
		fvWekaAttributes.addElement(new Attribute("airborne",	booleanVal, 5));
		fvWekaAttributes.addElement(new Attribute("aquatic", 	booleanVal,	6));
		fvWekaAttributes.addElement(new Attribute("predator",	booleanVal, 7));
		fvWekaAttributes.addElement(new Attribute("toothed", 	booleanVal,	8));
		fvWekaAttributes.addElement(new Attribute("backbone",	booleanVal, 9));
		fvWekaAttributes.addElement(new Attribute("breathes",	booleanVal, 10));
		fvWekaAttributes.addElement(new Attribute("venomous",	booleanVal, 11));
		fvWekaAttributes.addElement(new Attribute("fins", 		booleanVal, 12));
		fvWekaAttributes.addElement(new Attribute("legs", 13));
		fvWekaAttributes.addElement(new Attribute("tail", 		booleanVal, 14));
		fvWekaAttributes.addElement(new Attribute("domestic",	booleanVal, 15));
		fvWekaAttributes.addElement(new Attribute("catsize", 	booleanVal,	16));
		fvWekaAttributes.addElement(new Attribute("type", 		typeVal, 17));

		this.instances = new Instances("Test relation", fvWekaAttributes, 1);
		instances.setClassIndex(17);
	}

	@Test
	public void aardvark() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.aardvark).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void antelope() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.antelope).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void bass() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.bass).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withFins().withLegs(0).withTail()
				.build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.fish.name(), classType);
	}

	@Test
	public void bear() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.bear).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void boar() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.boar).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void buffalo() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.buffalo).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void calf() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.calf).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withDomestic().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void carp() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.carp).withEggs().withAquatic().withToothed()
				.withBackbone().withFins().withLegs(0).withTail()
				.withDomestic().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.fish.name(), classType);
	}

	@Test
	public void catfish() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.catfish).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withFins().withLegs(0).withTail()
				.build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.fish.name(), classType);
	}

	@Test
	public void cavy() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.cavy).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withDomestic()
				.build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void cheetah() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.cheetah).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void chicken() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.chicken).withFeathers().withEggs().withAirbone()
				.withBackbone().withBreathes().withLegs(2).withTail()
				.withDomestic().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}

	@Test
	public void chub() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.chub).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withFins().withLegs(0).withTail()
				.build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.fish.name(), classType);
	}

	@Test
	public void clam() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.clam).withEggs().withPredator().withLegs(0)
				.build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.invertebrate.name(), classType);
	}

	@Test
	public void crab() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.crab).withEggs().withAquatic().withPredator()
				.withLegs(4).build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.invertebrate.name(), classType);
	}

	@Test
	public void crayfish() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.crayfish).withEggs().withAquatic()
				.withPredator().withLegs(6).build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.invertebrate.name(), classType);
	}

	@Test
	public void crow() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.crow).withFeathers().withEggs().withAirbone()
				.withPredator().withBackbone().withBreathes().withLegs(2)
				.withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}

	@Test
	public void deer() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.deer).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void dogfish() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.dogfish).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withFins().withLegs(0).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.fish.name(), classType);
	}

	@Test
	public void dolphin() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.dolphin).withMilk().withAquatic().withPredator()
				.withToothed().withBackbone().withBreathes().withFins()
				.withLegs(0).withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void dove() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.dove).withFeathers().withEggs().withAirbone()
				.withBackbone().withBreathes().withLegs(2).withTail()
				.withDomestic().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}

	@Test
	public void duck() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.duck).withFeathers().withEggs().withAirbone()
				.withAquatic().withBackbone().withBreathes().withLegs(2)
				.withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}

	@Test
	public void elephant() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.elephant).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void flamingo() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.flamingo).withFeathers().withEggs()
				.withAirbone().withBackbone().withBreathes().withLegs(2)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}

	@Test
	public void flea() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.flea).withEggs().withBreathes().withLegs(6)
				.build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.insect.name(), classType);
	}

	@Test
	public void frog() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.frog).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.amphibian.name(), classType);
	}

	@Test
	public void fruitbat() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.fruitbat).withHair().withMilk().withAirbone()
				.withToothed().withBackbone().withBreathes().withLegs(2)
				.withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void giraffe() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.giraffe).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void girl() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.girl).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(2)
				.withDomestic().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void gnat() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.gnat).withEggs().withAirbone().withBreathes()
				.withLegs(6).build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.insect.name(), classType);
	}

	@Test
	public void goat() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.goat).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withDomestic().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void gorilla() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.gorilla).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(2).withCatsize()
				.build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void gull() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.gull).withFeathers().withEggs().withAirbone()
				.withAquatic().withPredator().withBackbone().withBreathes()
				.withLegs(2).withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}

	@Test
	public void haddock() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.haddock).withEggs().withAquatic().withToothed()
				.withBackbone().withFins().withLegs(0).withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.fish.name(), classType);
	}

	@Test
	public void hamster() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.hamster).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withDomestic().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void hare() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.hare).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void hawk() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.hawk).withFeathers().withEggs().withAirbone()
				.withPredator().withBackbone().withBreathes().withLegs(2)
				.withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}

	@Test
	public void herring() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.herring).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withFins().withLegs(0).withTail()
				.build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.fish.name(), classType);
	}

	@Test
	public void honeybee() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.honeybee).withHair().withEggs().withAirbone()
				.withBreathes().withVenomous().withLegs(6).withDomestic()
				.build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.insect.name(), classType);
	}

	@Test
	public void housefly() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.housefly).withHair().withEggs().withAirbone()
				.withBreathes().withLegs(6).build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.insect.name(), classType);
	}

	@Test
	public void kiwi() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.kiwi).withFeathers().withEggs().withPredator()
				.withBackbone().withBreathes().withLegs(2).withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}

	@Test
	public void ladybird() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.ladybird).withEggs().withAirbone()
				.withPredator().withBreathes().withLegs(6).build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.insect.name(), classType);
	}

	@Test
	public void lark() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.lark).withFeathers().withEggs().withAirbone()
				.withBackbone().withBreathes().withLegs(2).withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}

	@Test
	public void leopard() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.leopard).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void lion() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.lion).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void lobster() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.lobster).withEggs().withAquatic().withPredator()
				.withLegs(6).build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.invertebrate.name(), classType);
	}

	@Test
	public void lynx() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.lynx).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void mink() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.mink).withHair().withMilk().withAquatic()
				.withPredator().withToothed().withBackbone().withBreathes()
				.withLegs(4).withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void mole() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.mole).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void mongoose() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.mongoose).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void moth() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.moth).withHair().withEggs().withAirbone()
				.withBreathes().withLegs(6).build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.insect.name(), classType);
	}

	@Test
	public void newt() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.newt).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.amphibian.name(), classType);
	}

	@Test
	public void octopus() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.octopus).withEggs().withAquatic().withPredator()
				.withLegs(8).withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.invertebrate.name(), classType);
	}

	@Test
	public void opossum() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.opossum).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void oryx() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.oryx).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void ostrich() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.ostrich).withFeathers().withEggs()
				.withBackbone().withBreathes().withLegs(2).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}

	@Test
	public void parakeet() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.parakeet).withFeathers().withEggs()
				.withAirbone().withBackbone().withBreathes().withLegs(2)
				.withTail().withDomestic().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}

	@Test
	public void penguin() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.penguin).withFeathers().withEggs().withAquatic()
				.withPredator().withBackbone().withBreathes().withLegs(2)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}

	@Test
	public void pheasant() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.pheasant).withFeathers().withEggs()
				.withAirbone().withBackbone().withBreathes().withLegs(2)
				.withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}

	@Test
	public void pike() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.pike).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withFins().withLegs(0).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.fish.name(), classType);
	}

	@Test
	public void piranha() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.piranha).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withFins().withLegs(0).withTail()
				.build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.fish.name(), classType);
	}

	@Test
	public void pitviper() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.pitviper).withEggs().withPredator()
				.withToothed().withBackbone().withBreathes().withVenomous()
				.withLegs(0).withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.reptile.name(), classType);
	}

	@Test
	public void platypus() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.platypus).withHair().withEggs().withMilk()
				.withAquatic().withPredator().withBackbone().withBreathes()
				.withLegs(4).withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void polecat() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.polecat).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void pony() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.pony).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withDomestic().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void porpoise() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.porpoise).withMilk().withAquatic()
				.withPredator().withToothed().withBackbone().withBreathes()
				.withFins().withLegs(0).withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void puma() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.puma).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void pussycat() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.pussycat).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withDomestic().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void raccoon() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.raccoon).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void reindeer() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.reindeer).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withDomestic().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void rhea() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.rhea).withFeathers().withEggs().withPredator()
				.withBackbone().withBreathes().withLegs(2).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}

	@Test
	public void scorpion() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.scorpion).withPredator().withBreathes()
				.withVenomous().withLegs(8).withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.invertebrate.name(), classType);
	}

	@Test
	public void seahorse() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.seahorse).withEggs().withAquatic().withToothed()
				.withBackbone().withFins().withLegs(0).withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.fish.name(), classType);
	}

	@Test
	public void seal() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.seal).withHair().withMilk().withAquatic()
				.withPredator().withToothed().withBackbone().withBreathes()
				.withFins().withLegs(0).withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void sealion() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.sealion).withHair().withMilk().withAquatic()
				.withPredator().withToothed().withBackbone().withBreathes()
				.withFins().withLegs(2).withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void seasnake() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.seasnake).withAquatic().withPredator()
				.withToothed().withBackbone().withVenomous().withLegs(0)
				.withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.reptile.name(), classType);
	}

	@Test
	public void seawasp() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.seawasp).withEggs().withAquatic().withPredator()
				.withVenomous().withLegs(0).build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.invertebrate.name(), classType);
	}

	@Test
	public void skimmer() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.skimmer).withFeathers().withEggs().withAirbone()
				.withAquatic().withPredator().withBackbone().withBreathes()
				.withLegs(2).withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}

	@Test
	public void skua() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.skua).withFeathers().withEggs().withAirbone()
				.withAquatic().withPredator().withBackbone().withBreathes()
				.withLegs(2).withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}

	@Test
	public void slowworm() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.slowworm).withEggs().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(0)
				.withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.reptile.name(), classType);
	}

	@Test
	public void slug() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.slug).withEggs().withBreathes().withLegs(0)
				.build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.invertebrate.name(), classType);
	}

	@Test
	public void sole() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.sole).withEggs().withAquatic().withToothed()
				.withBackbone().withFins().withLegs(0).withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.fish.name(), classType);
	}

	@Test
	public void sparrow() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.sparrow).withFeathers().withEggs().withAirbone()
				.withBackbone().withBreathes().withLegs(2).withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}

	@Test
	public void squirrel() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.squirrel).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(2).withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void starfish() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.starfish).withEggs().withAquatic()
				.withPredator().withLegs(5).build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.invertebrate.name(), classType);
	}

	@Test
	public void stingray() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.stingray).withEggs().withAquatic()
				.withPredator().withToothed().withBackbone().withVenomous()
				.withFins().withLegs(0).withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.fish.name(), classType);
	}

	@Test
	public void swan() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.swan).withFeathers().withEggs().withAirbone()
				.withAquatic().withBackbone().withBreathes().withLegs(2)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}

	@Test
	public void termite() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.termite).withEggs().withBreathes().withLegs(6)
				.build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.insect.name(), classType);
	}

	@Test
	public void toad() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.toad).withEggs().withAquatic().withToothed()
				.withBackbone().withBreathes().withLegs(4).build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.amphibian.name(), classType);
	}

	@Test
	public void tortoise() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.tortoise).withEggs().withBackbone()
				.withBreathes().withLegs(4).withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.reptile.name(), classType);
	}

	@Test
	public void tuatara() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.tuatara).withEggs().withPredator().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.reptile.name(), classType);
	}

	@Test
	public void tuna() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.tuna).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withFins().withLegs(0).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.fish.name(), classType);
	}

	@Test
	public void vampire() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.vampire).withHair().withMilk().withAirbone()
				.withToothed().withBackbone().withBreathes().withLegs(2)
				.withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void vole() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.vole).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void vulture() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.vulture).withFeathers().withEggs().withAirbone()
				.withPredator().withBackbone().withBreathes().withLegs(2)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}

	@Test
	public void wallaby() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.wallaby).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(2).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void wasp() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.wasp).withHair().withEggs().withAirbone()
				.withBreathes().withVenomous().withLegs(6).build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.insect.name(), classType);
	}

	@Test
	public void wolf() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.wolf).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.mammal.name(), classType);
	}

	@Test
	public void worm() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.worm).withEggs().withBreathes().withLegs(0)
				.build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.invertebrate.name(), classType);
	}

	@Test
	public void wren() {
		Instance instance = new Animal.Builder().withDataSet(instances)
				.withName(Name.wren).withFeathers().withEggs().withAirbone()
				.withBackbone().withBreathes().withLegs(2).withTail().build();
		int classVal = classifier.classify(instance);
		String classType = (classVal >= 0) ? instances.classAttribute().value(
				classVal) : "";
		Assert.assertEquals(Animal.Type.bird.name(), classType);
	}
}
