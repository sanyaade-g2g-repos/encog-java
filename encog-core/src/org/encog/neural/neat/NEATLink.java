/*
 * Encog(tm) Core v3.0 - Java Version
 * http://www.heatonresearch.com/encog/
 * http://code.google.com/p/encog-java/
 
 * Copyright 2008-2011 Heaton Research, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *   
 * For more information on Heaton Research copyrights, licenses 
 * and trademarks visit:
 * http://www.heatonresearch.com/copyright
 */
package org.encog.neural.neat;

import org.encog.persist.BasicPersistedSubObject;
import org.encog.persist.Persistor;
import org.encog.persist.map.PersistConst;
import org.encog.persist.map.PersistedObject;

/**
 * Implements a link between two NEAT neurons.
 * 
 * NeuroEvolution of Augmenting Topologies (NEAT) is a genetic algorithm for the
 * generation of evolving artificial neural networks. It was developed by Ken
 * Stanley while at The University of Texas at Austin.
 * 
 * http://www.cs.ucf.edu/~kstanley/
 * 
 */
public class NEATLink extends BasicPersistedSubObject {

	public static final String FROM_NEURON = "fromNeuron";
	public static final String TO_NEURON = "toNeuron";
	
	/**
	 * The serial id.
	 */
	private static final long serialVersionUID = -4117045705080951946L;

	/**
	 * The source neuron.
	 */
	private NEATNeuron fromNeuron;

	/**
	 * Is this link recurrent.
	 */
	private boolean recurrent;

	/**
	 * The target neuron.
	 */
	private NEATNeuron toNeuron;

	/**
	 * The weight between the two neurons.
	 */
	private double weight;

	/**
	 * Default constructor, used mainly for persistance.
	 */
	public NEATLink() {

	}

	/**
	 * Construct a NEAT link.
	 * 
	 * @param weight
	 *            The weight between the two neurons.
	 * @param fromNeuron
	 *            The source neuron.
	 * @param toNeuron
	 *            The target neuron.
	 * @param recurrent
	 *            Is this a recurrent link.
	 */
	public NEATLink(final double weight, final NEATNeuron fromNeuron,
			final NEATNeuron toNeuron, final boolean recurrent) {
		this.weight = weight;
		this.fromNeuron = fromNeuron;
		this.toNeuron = toNeuron;
		this.recurrent = recurrent;
	}

	/**
	 * @return The source neuron.
	 */
	public NEATNeuron getFromNeuron() {
		return this.fromNeuron;
	}

	/**
	 * @return The target neuron.
	 */
	public NEATNeuron getToNeuron() {
		return this.toNeuron;
	}

	/**
	 * @return The weight of the link.
	 */
	public double getWeight() {
		return this.weight;
	}

	/**
	 * @return True if this is a recurrent link.
	 */
	public boolean isRecurrent() {
		return this.recurrent;
	}
	
	@Override
	public Persistor createPersistor() {
		return null;
	}
	
	public boolean supportsMapPersistence()
	{
		return true;
	}
	
	public void persistToMap(PersistedObject obj)
	{
		obj.clear(PersistConst.SUBTYPE_NEAT_LINK);
		
		obj.setProperty(FROM_NEURON,this.fromNeuron.getNeuronID(),true);
		obj.setProperty(TO_NEURON,this.toNeuron.getNeuronID(),true);
		obj.setProperty(PersistConst.RECURRENT,this.recurrent,true);
		obj.setProperty(PersistConst.WEIGHT,this.weight,true);

	}
	
	public void persistFromMap(PersistedObject obj)
	{
		obj.requireType(PersistConst.SUBTYPE_NEAT_LINK);
		this.recurrent = obj.getPropertyBoolean(PersistConst.RECURRENT, true);
		this.weight = obj.getPropertyDouble(PersistConst.WEIGHT, true);
	}
}
