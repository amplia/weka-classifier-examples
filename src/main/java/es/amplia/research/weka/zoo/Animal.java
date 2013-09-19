package es.amplia.research.weka.zoo;

import java_cup.internal_error;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

/**
 * 
 * @author cbadenes
 *
 */
public class Animal {

	private static FastVector fvWekaAttributes = new FastVector(18);
	private static Instances instances;
	
	static {
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
		
		instances = new Instances("Test relation", fvWekaAttributes, 1);
		instances.setClassIndex(17);
	}
	
	
	public enum Name {
		aardvark, antelope, bass, bear, boar, buffalo, calf, carp, catfish, cavy, cheetah, chicken, chub, clam, crab, crayfish, 
		crow, deer, dogfish, dolphin, dove, duck, elephant, flamingo, flea, frog, fruitbat, giraffe, girl, gnat, goat, gorilla, 
		gull, haddock, hamster, hare, hawk, herring, honeybee, housefly, kiwi, ladybird, lark, leopard, lion, lobster, lynx, mink, 
		mole, mongoose, moth, newt, octopus, opossum, oryx, ostrich, parakeet, penguin, pheasant, pike, piranha, pitviper, platypus, 
		polecat, pony, porpoise, puma, pussycat, raccoon, reindeer, rhea, scorpion, seahorse, seal, sealion, seasnake, seawasp, skimmer, 
		skua, slowworm, slug, sole, sparrow, squirrel, starfish, stingray, swan, termite, toad, tortoise, tuatara, tuna, vampire, vole, 
		vulture, wallaby, wasp, wolf, worm, wren
	};
	
	public enum Type {
		mammal, bird, reptile, fish, amphibian, insect, invertebrate;
		
		public static Type fromVal(int val) {
			return Type.valueOf(instances.classAttribute().value(val));
		}
		
	};	
	
	private Name name;
	private Boolean hair;
	private Boolean feathers;
	private Boolean eggs;
	private Boolean milk;
	private Boolean airbone;
	private Boolean aquatic;
	private Boolean predator;
	private Boolean toothed;
	private Boolean backbone;
	private Boolean breathes;
	private Boolean venomous;
	private Boolean fins;
	private Integer legs;
	private Boolean tail;
	private Boolean domestic;
	private Boolean catsize;
	
		
	private Animal(Builder builder) {
	  this.name = builder.name;
	  this.hair = builder.hair;
	  this.feathers = builder.feathers;
	  this.eggs = builder.eggs;
	  this.milk = builder.milk;
	  this.airbone = builder.airbone;
	  this.aquatic = builder.aquatic;
	  this.predator = builder.predator;
	  this.toothed = builder.toothed;
	  this.backbone = builder.backbone;
	  this.breathes = builder.breathes;
	  this.venomous = builder.venomous;
	  this.fins = builder.fins;
	  this.legs = builder.legs;
	  this.tail = builder.tail;
	  this.domestic = builder.domestic;
	  this.catsize = builder.catsize;
	}
	public static class Builder{
		
		private Name name;
		private Boolean hair 		= false;
		private Boolean feathers	= false;
		private Boolean eggs		= false;
		private Boolean milk		= false;
		private Boolean airbone		= false;
		private Boolean aquatic		= false;
		private Boolean predator	= false;
		private Boolean toothed		= false;
		private Boolean backbone	= false;	
		private Boolean breathes	= false;
		private Boolean venomous	= false;
		private Boolean fins		= false;
		private Integer legs		= 2;
		private Boolean tail		= false;
		private Boolean domestic	= false;
		private Boolean catsize		= false;
		
		public Builder withName(Name animal) {
		  this.name = animal;
		  return this;
		}
		public Builder withHair() {
		  this.hair = true;
		  return this;
		}
		public Builder withFeathers() {
		  this.feathers = true;
		  return this;
		}
		public Builder withEggs() {
		  this.eggs = true;
		  return this;
		}
		public Builder withMilk() {
		  this.milk = true;
		  return this;
		}
		public Builder withAirbone() {
		  this.airbone = true;
		  return this;
		}
		public Builder withAquatic() {
		  this.aquatic = true;
		  return this;
		}
		public Builder withPredator() {
		  this.predator = true;
		  return this;
		}
		public Builder withToothed() {
		  this.toothed = true;
		  return this;
		}
		public Builder withBackbone() {
		  this.backbone = true;
		  return this;
		}
		public Builder withBreathes() {
		  this.breathes = true;
		  return this;
		}
		public Builder withVenomous() {
		  this.venomous = true;
		  return this;
		}
		public Builder withFins() {
		  this.fins = true;
		  return this;
		}
		public Builder withLegs(Integer legs) {
		  this.legs = legs;
		  return this;
		}
		public Builder withTail() {
		  this.tail = true;
		  return this;
		}
		public Builder withDomestic() {
		  this.domestic = true;
		  return this;
		}
		public Builder withCatsize() {
		  this.catsize = true;
		  return this;
		}
		public Instance build() {
			Instance instance = new Instance(18);	
			instance.setDataset(instances);
			instance.setValue(0,	name.name());
			instance.setValue(1, 	hair.toString());
			instance.setValue(2, 	feathers.toString());
			instance.setValue(3, 	eggs.toString());
			instance.setValue(4, 	milk.toString());
			instance.setValue(5, 	airbone.toString());
			instance.setValue(6, 	aquatic.toString());
			instance.setValue(7, 	predator.toString());
			instance.setValue(8, 	toothed.toString());
			instance.setValue(9, 	backbone.toString());
			instance.setValue(10, 	breathes.toString());
			instance.setValue(11, 	venomous.toString());
			instance.setValue(12, 	fins.toString());
			instance.setValue(13, 	legs);
			instance.setValue(14, 	tail.toString());
			instance.setValue(15, 	domestic.toString());
			instance.setValue(16, 	catsize.toString());
			return instance;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
