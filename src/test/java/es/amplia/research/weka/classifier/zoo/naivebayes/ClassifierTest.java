package es.amplia.research.weka.classifier.zoo.naivebayes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import es.amplia.research.weka.classifier.naivebayes.Classifier;
import es.amplia.research.weka.zoo.Animal;
import es.amplia.research.weka.zoo.Animal.Name;

public class ClassifierTest {

	private Classifier classifier;

	@Before
	public void setup() throws FileNotFoundException, ClassNotFoundException,
			IOException {
		this.classifier = new Classifier();
		classifier.learn("zoo",17);		
	}

	@Test
	public void aardvark() {
		Instance instance = new Animal.Builder()
				.withName(Name.aardvark).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void antelope() {
		Instance instance = new Animal.Builder()
				.withName(Name.antelope).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void bass() {
		Instance instance = new Animal.Builder()
				.withName(Name.bass).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withFins().withLegs(0).withTail()
				.build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.fish, Animal.Type.fromVal(classVal));
	}

	@Test
	public void bear() {
		Instance instance = new Animal.Builder()
				.withName(Name.bear).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void boar() {
		Instance instance = new Animal.Builder()
				.withName(Name.boar).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void buffalo() {
		Instance instance = new Animal.Builder()
				.withName(Name.buffalo).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void calf() {
		Instance instance = new Animal.Builder()
				.withName(Name.calf).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withDomestic().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void carp() {
		Instance instance = new Animal.Builder()
				.withName(Name.carp).withEggs().withAquatic().withToothed()
				.withBackbone().withFins().withLegs(0).withTail()
				.withDomestic().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.fish, Animal.Type.fromVal(classVal));
	}

	@Test
	public void catfish() {
		Instance instance = new Animal.Builder()
				.withName(Name.catfish).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withFins().withLegs(0).withTail()
				.build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.fish, Animal.Type.fromVal(classVal));
	}

	@Test
	public void cavy() {
		Instance instance = new Animal.Builder()
				.withName(Name.cavy).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withDomestic()
				.build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void cheetah() {
		Instance instance = new Animal.Builder()
				.withName(Name.cheetah).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void chicken() {
		Instance instance = new Animal.Builder()
				.withName(Name.chicken).withFeathers().withEggs().withAirbone()
				.withBackbone().withBreathes().withLegs(2).withTail()
				.withDomestic().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}

	@Test
	public void chub() {
		Instance instance = new Animal.Builder()
				.withName(Name.chub).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withFins().withLegs(0).withTail()
				.build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.fish, Animal.Type.fromVal(classVal));
	}

	@Test
	public void clam() {
		Instance instance = new Animal.Builder()
				.withName(Name.clam).withEggs().withPredator().withLegs(0)
				.build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.invertebrate, Animal.Type.fromVal(classVal));
	}

	@Test
	public void crab() {
		Instance instance = new Animal.Builder()
				.withName(Name.crab).withEggs().withAquatic().withPredator()
				.withLegs(4).build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.invertebrate, Animal.Type.fromVal(classVal));
	}

	@Test
	public void crayfish() {
		Instance instance = new Animal.Builder()
				.withName(Name.crayfish).withEggs().withAquatic()
				.withPredator().withLegs(6).build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.invertebrate, Animal.Type.fromVal(classVal));
	}

	@Test
	public void crow() {
		Instance instance = new Animal.Builder()
				.withName(Name.crow).withFeathers().withEggs().withAirbone()
				.withPredator().withBackbone().withBreathes().withLegs(2)
				.withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}

	@Test
	public void deer() {
		Instance instance = new Animal.Builder()
				.withName(Name.deer).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void dogfish() {
		Instance instance = new Animal.Builder()
				.withName(Name.dogfish).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withFins().withLegs(0).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.fish, Animal.Type.fromVal(classVal));
	}

	@Test
	public void dolphin() {
		Instance instance = new Animal.Builder()
				.withName(Name.dolphin).withMilk().withAquatic().withPredator()
				.withToothed().withBackbone().withBreathes().withFins()
				.withLegs(0).withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void dove() {
		Instance instance = new Animal.Builder()
				.withName(Name.dove).withFeathers().withEggs().withAirbone()
				.withBackbone().withBreathes().withLegs(2).withTail()
				.withDomestic().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}

	@Test
	public void duck() {
		Instance instance = new Animal.Builder()
				.withName(Name.duck).withFeathers().withEggs().withAirbone()
				.withAquatic().withBackbone().withBreathes().withLegs(2)
				.withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}

	@Test
	public void elephant() {
		Instance instance = new Animal.Builder()
				.withName(Name.elephant).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void flamingo() {
		Instance instance = new Animal.Builder()
				.withName(Name.flamingo).withFeathers().withEggs()
				.withAirbone().withBackbone().withBreathes().withLegs(2)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}

	@Test
	public void flea() {
		Instance instance = new Animal.Builder()
				.withName(Name.flea).withEggs().withBreathes().withLegs(6)
				.build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.insect, Animal.Type.fromVal(classVal));
	}

	@Test
	public void frog() {
		Instance instance = new Animal.Builder()
				.withName(Name.frog).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.amphibian, Animal.Type.fromVal(classVal));
	}

	@Test
	public void fruitbat() {
		Instance instance = new Animal.Builder()
				.withName(Name.fruitbat).withHair().withMilk().withAirbone()
				.withToothed().withBackbone().withBreathes().withLegs(2)
				.withTail().build();
		int classVal = classifier.classify(instance);		
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void giraffe() {
		Instance instance = new Animal.Builder()
				.withName(Name.giraffe).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);		
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void girl() {
		Instance instance = new Animal.Builder()
				.withName(Name.girl).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(2)
				.withDomestic().withCatsize().build();
		int classVal = classifier.classify(instance);		
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void gnat() {
		Instance instance = new Animal.Builder()
				.withName(Name.gnat).withEggs().withAirbone().withBreathes()
				.withLegs(6).build();
		int classVal = classifier.classify(instance);		
		Assert.assertEquals(Animal.Type.insect, Animal.Type.fromVal(classVal));
	}

	@Test
	public void goat() {
		Instance instance = new Animal.Builder()
				.withName(Name.goat).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withDomestic().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void gorilla() {
		Instance instance = new Animal.Builder()
				.withName(Name.gorilla).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(2).withCatsize()
				.build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void gull() {
		Instance instance = new Animal.Builder()
				.withName(Name.gull).withFeathers().withEggs().withAirbone()
				.withAquatic().withPredator().withBackbone().withBreathes()
				.withLegs(2).withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}

	@Test
	public void haddock() {
		Instance instance = new Animal.Builder()
				.withName(Name.haddock).withEggs().withAquatic().withToothed()
				.withBackbone().withFins().withLegs(0).withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.fish, Animal.Type.fromVal(classVal));
	}

	@Test
	public void hamster() {
		Instance instance = new Animal.Builder()
				.withName(Name.hamster).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withDomestic().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void hare() {
		Instance instance = new Animal.Builder()
				.withName(Name.hare).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void hawk() {
		Instance instance = new Animal.Builder()
				.withName(Name.hawk).withFeathers().withEggs().withAirbone()
				.withPredator().withBackbone().withBreathes().withLegs(2)
				.withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}

	@Test
	public void herring() {
		Instance instance = new Animal.Builder()
				.withName(Name.herring).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withFins().withLegs(0).withTail()
				.build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.fish, Animal.Type.fromVal(classVal));
	}

	@Test
	public void honeybee() {
		Instance instance = new Animal.Builder()
				.withName(Name.honeybee).withHair().withEggs().withAirbone()
				.withBreathes().withVenomous().withLegs(6).withDomestic()
				.build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.insect, Animal.Type.fromVal(classVal));
	}

	@Test
	public void housefly() {
		Instance instance = new Animal.Builder()
				.withName(Name.housefly).withHair().withEggs().withAirbone()
				.withBreathes().withLegs(6).build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.insect, Animal.Type.fromVal(classVal));
	}

	@Test
	public void kiwi() {
		Instance instance = new Animal.Builder()
				.withName(Name.kiwi).withFeathers().withEggs().withPredator()
				.withBackbone().withBreathes().withLegs(2).withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}

	@Test
	public void ladybird() {
		Instance instance = new Animal.Builder()
				.withName(Name.ladybird).withEggs().withAirbone()
				.withPredator().withBreathes().withLegs(6).build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.insect, Animal.Type.fromVal(classVal));
	}

	@Test
	public void lark() {
		Instance instance = new Animal.Builder()
				.withName(Name.lark).withFeathers().withEggs().withAirbone()
				.withBackbone().withBreathes().withLegs(2).withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}

	@Test
	public void leopard() {
		Instance instance = new Animal.Builder()
				.withName(Name.leopard).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void lion() {
		Instance instance = new Animal.Builder()
				.withName(Name.lion).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void lobster() {
		Instance instance = new Animal.Builder()
				.withName(Name.lobster).withEggs().withAquatic().withPredator()
				.withLegs(6).build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.invertebrate, Animal.Type.fromVal(classVal));
	}

	@Test
	public void lynx() {
		Instance instance = new Animal.Builder()
				.withName(Name.lynx).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void mink() {
		Instance instance = new Animal.Builder()
				.withName(Name.mink).withHair().withMilk().withAquatic()
				.withPredator().withToothed().withBackbone().withBreathes()
				.withLegs(4).withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void mole() {
		Instance instance = new Animal.Builder()
				.withName(Name.mole).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void mongoose() {
		Instance instance = new Animal.Builder()
				.withName(Name.mongoose).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void moth() {
		Instance instance = new Animal.Builder()
				.withName(Name.moth).withHair().withEggs().withAirbone()
				.withBreathes().withLegs(6).build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.insect, Animal.Type.fromVal(classVal));
	}

	@Test
	public void newt() {
		Instance instance = new Animal.Builder()
				.withName(Name.newt).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.amphibian, Animal.Type.fromVal(classVal));
	}

	@Test
	public void octopus() {
		Instance instance = new Animal.Builder()
				.withName(Name.octopus).withEggs().withAquatic().withPredator()
				.withLegs(8).withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.invertebrate, Animal.Type.fromVal(classVal));
	}

	@Test
	public void opossum() {
		Instance instance = new Animal.Builder()
				.withName(Name.opossum).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void oryx() {
		Instance instance = new Animal.Builder()
				.withName(Name.oryx).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void ostrich() {
		Instance instance = new Animal.Builder()
				.withName(Name.ostrich).withFeathers().withEggs()
				.withBackbone().withBreathes().withLegs(2).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}

	@Test
	public void parakeet() {
		Instance instance = new Animal.Builder()
				.withName(Name.parakeet).withFeathers().withEggs()
				.withAirbone().withBackbone().withBreathes().withLegs(2)
				.withTail().withDomestic().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}

	@Test
	public void penguin() {
		Instance instance = new Animal.Builder()
				.withName(Name.penguin).withFeathers().withEggs().withAquatic()
				.withPredator().withBackbone().withBreathes().withLegs(2)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}

	@Test
	public void pheasant() {
		Instance instance = new Animal.Builder()
				.withName(Name.pheasant).withFeathers().withEggs()
				.withAirbone().withBackbone().withBreathes().withLegs(2)
				.withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}

	@Test
	public void pike() {
		Instance instance = new Animal.Builder()
				.withName(Name.pike).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withFins().withLegs(0).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.fish, Animal.Type.fromVal(classVal));
	}

	@Test
	public void piranha() {
		Instance instance = new Animal.Builder()
				.withName(Name.piranha).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withFins().withLegs(0).withTail()
				.build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.fish, Animal.Type.fromVal(classVal));
	}

	@Test
	public void pitviper() {
		Instance instance = new Animal.Builder()
				.withName(Name.pitviper).withEggs().withPredator()
				.withToothed().withBackbone().withBreathes().withVenomous()
				.withLegs(0).withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.reptile, Animal.Type.fromVal(classVal));
	}

	@Test
	public void platypus() {
		Instance instance = new Animal.Builder()
				.withName(Name.platypus).withHair().withEggs().withMilk()
				.withAquatic().withPredator().withBackbone().withBreathes()
				.withLegs(4).withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void polecat() {
		Instance instance = new Animal.Builder()
				.withName(Name.polecat).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void pony() {
		Instance instance = new Animal.Builder()
				.withName(Name.pony).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withDomestic().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void porpoise() {
		Instance instance = new Animal.Builder()
				.withName(Name.porpoise).withMilk().withAquatic()
				.withPredator().withToothed().withBackbone().withBreathes()
				.withFins().withLegs(0).withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void puma() {
		Instance instance = new Animal.Builder()
				.withName(Name.puma).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void pussycat() {
		Instance instance = new Animal.Builder()
				.withName(Name.pussycat).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withDomestic().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void raccoon() {
		Instance instance = new Animal.Builder()
				.withName(Name.raccoon).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void reindeer() {
		Instance instance = new Animal.Builder()
				.withName(Name.reindeer).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail()
				.withDomestic().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void rhea() {
		Instance instance = new Animal.Builder()
				.withName(Name.rhea).withFeathers().withEggs().withPredator()
				.withBackbone().withBreathes().withLegs(2).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}

	@Test
	public void scorpion() {
		Instance instance = new Animal.Builder()
				.withName(Name.scorpion).withPredator().withBreathes()
				.withVenomous().withLegs(8).withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.invertebrate, Animal.Type.fromVal(classVal));
	}

	@Test
	public void seahorse() {
		Instance instance = new Animal.Builder()
				.withName(Name.seahorse).withEggs().withAquatic().withToothed()
				.withBackbone().withFins().withLegs(0).withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.fish, Animal.Type.fromVal(classVal));
	}

	@Test
	public void seal() {
		Instance instance = new Animal.Builder()
				.withName(Name.seal).withHair().withMilk().withAquatic()
				.withPredator().withToothed().withBackbone().withBreathes()
				.withFins().withLegs(0).withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void sealion() {
		Instance instance = new Animal.Builder()
				.withName(Name.sealion).withHair().withMilk().withAquatic()
				.withPredator().withToothed().withBackbone().withBreathes()
				.withFins().withLegs(2).withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void seasnake() {
		Instance instance = new Animal.Builder()
				.withName(Name.seasnake).withAquatic().withPredator()
				.withToothed().withBackbone().withVenomous().withLegs(0)
				.withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.reptile, Animal.Type.fromVal(classVal));
	}

	@Test
	public void seawasp() {
		Instance instance = new Animal.Builder()
				.withName(Name.seawasp).withEggs().withAquatic().withPredator()
				.withVenomous().withLegs(0).build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.invertebrate, Animal.Type.fromVal(classVal));
	}

	@Test
	public void skimmer() {
		Instance instance = new Animal.Builder()
				.withName(Name.skimmer).withFeathers().withEggs().withAirbone()
				.withAquatic().withPredator().withBackbone().withBreathes()
				.withLegs(2).withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}

	@Test
	public void skua() {
		Instance instance = new Animal.Builder()
				.withName(Name.skua).withFeathers().withEggs().withAirbone()
				.withAquatic().withPredator().withBackbone().withBreathes()
				.withLegs(2).withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}

	@Test
	public void slowworm() {
		Instance instance = new Animal.Builder()
				.withName(Name.slowworm).withEggs().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(0)
				.withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.reptile, Animal.Type.fromVal(classVal));
	}

	@Test
	public void slug() {
		Instance instance = new Animal.Builder()
				.withName(Name.slug).withEggs().withBreathes().withLegs(0)
				.build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.invertebrate, Animal.Type.fromVal(classVal));
	}

	@Test
	public void sole() {
		Instance instance = new Animal.Builder()
				.withName(Name.sole).withEggs().withAquatic().withToothed()
				.withBackbone().withFins().withLegs(0).withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.fish, Animal.Type.fromVal(classVal));
	}

	@Test
	public void sparrow() {
		Instance instance = new Animal.Builder()
				.withName(Name.sparrow).withFeathers().withEggs().withAirbone()
				.withBackbone().withBreathes().withLegs(2).withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}

	@Test
	public void squirrel() {
		Instance instance = new Animal.Builder()
				.withName(Name.squirrel).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(2).withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void starfish() {
		Instance instance = new Animal.Builder()
				.withName(Name.starfish).withEggs().withAquatic()
				.withPredator().withLegs(5).build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.invertebrate, Animal.Type.fromVal(classVal));
	}

	@Test
	public void stingray() {
		Instance instance = new Animal.Builder()
				.withName(Name.stingray).withEggs().withAquatic()
				.withPredator().withToothed().withBackbone().withVenomous()
				.withFins().withLegs(0).withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.fish, Animal.Type.fromVal(classVal));
	}

	@Test
	public void swan() {
		Instance instance = new Animal.Builder()
				.withName(Name.swan).withFeathers().withEggs().withAirbone()
				.withAquatic().withBackbone().withBreathes().withLegs(2)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}

	@Test
	public void termite() {
		Instance instance = new Animal.Builder()
				.withName(Name.termite).withEggs().withBreathes().withLegs(6)
				.build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.insect, Animal.Type.fromVal(classVal));
	}

	@Test
	public void toad() {
		Instance instance = new Animal.Builder()
				.withName(Name.toad).withEggs().withAquatic().withToothed()
				.withBackbone().withBreathes().withLegs(4).build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.amphibian, Animal.Type.fromVal(classVal));
	}

	@Test
	public void tortoise() {
		Instance instance = new Animal.Builder()
				.withName(Name.tortoise).withEggs().withBackbone()
				.withBreathes().withLegs(4).withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.reptile, Animal.Type.fromVal(classVal));
	}

	@Test
	public void tuatara() {
		Instance instance = new Animal.Builder()
				.withName(Name.tuatara).withEggs().withPredator().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.reptile, Animal.Type.fromVal(classVal));
	}

	@Test
	public void tuna() {
		Instance instance = new Animal.Builder()
				.withName(Name.tuna).withEggs().withAquatic().withPredator()
				.withToothed().withBackbone().withFins().withLegs(0).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.fish, Animal.Type.fromVal(classVal));
	}

	@Test
	public void vampire() {
		Instance instance = new Animal.Builder()
				.withName(Name.vampire).withHair().withMilk().withAirbone()
				.withToothed().withBackbone().withBreathes().withLegs(2)
				.withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void vole() {
		Instance instance = new Animal.Builder()
				.withName(Name.vole).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(4).withTail().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void vulture() {
		Instance instance = new Animal.Builder()
				.withName(Name.vulture).withFeathers().withEggs().withAirbone()
				.withPredator().withBackbone().withBreathes().withLegs(2)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}

	@Test
	public void wallaby() {
		Instance instance = new Animal.Builder()
				.withName(Name.wallaby).withHair().withMilk().withToothed()
				.withBackbone().withBreathes().withLegs(2).withTail()
				.withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void wasp() {
		Instance instance = new Animal.Builder()
				.withName(Name.wasp).withHair().withEggs().withAirbone()
				.withBreathes().withVenomous().withLegs(6).build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.insect, Animal.Type.fromVal(classVal));
	}

	@Test
	public void wolf() {
		Instance instance = new Animal.Builder()
				.withName(Name.wolf).withHair().withMilk().withPredator()
				.withToothed().withBackbone().withBreathes().withLegs(4)
				.withTail().withCatsize().build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.mammal, Animal.Type.fromVal(classVal));
	}

	@Test
	public void worm() {
		Instance instance = new Animal.Builder()
				.withName(Name.worm).withEggs().withBreathes().withLegs(0)
				.build();
		int classVal = classifier.classify(instance);
		Assert.assertEquals(Animal.Type.invertebrate, Animal.Type.fromVal(classVal));
	}

	@Test
	public void wren() {
		Instance instance = new Animal.Builder()
				.withName(Name.wren).withFeathers().withEggs().withAirbone()
				.withBackbone().withBreathes().withLegs(2).withTail().build();
		int classVal = classifier.classify(instance);		
		Assert.assertEquals(Animal.Type.bird, Animal.Type.fromVal(classVal));
	}
}
