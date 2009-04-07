/*
 * Encog Artificial Intelligence Framework v2.x
 * Java Version
 * http://www.heatonresearch.com/encog/
 * http://code.google.com/p/encog-java/
 * 
 * Copyright 2008-2009, Heaton Research Inc., and individual contributors.
 * See the copyright.txt in the distribution for a full listing of 
 * individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.encog.neural.activation;

import org.encog.neural.NeuralNetworkError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ActivationLinear: The Linear layer is really not an activation function at
 * all. The input is simply passed on, unmodified, to the output. This
 * activation function is primarily theoretical and of little actual use.
 * Usually an activation function that scales between 0 and 1 or -1 and 1 should
 * be used.
 */
public class ActivationLinear extends  BasicActivationFunction {

	/**
	 * Serial id for this class.
	 */
	private static final long serialVersionUID = -5356580554235104944L;
	
	/**
	 * The logging object.
	 */
	@SuppressWarnings("unused")
	final private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * A threshold function for a neural network.
	 * 
	 * @param d
	 *            The input to the function.
	 * @return The output from the function.
	 */
	public void activationFunction(final double[] d) {

	}

	/**
	 * Some training methods require the derivative.
	 * 
	 * @param d
	 *            The input.
	 * @return The output.
	 */
	public void derivativeFunction(final double[] d) {
		throw new NeuralNetworkError(
				"Can't use the linear activation function "
						+ "where a derivative is required.");
	}
	
	public Object clone()
	{
		return new ActivationLinear();
	}
}
