/*
 * Encog(tm) Core v2.5 
 * http://www.heatonresearch.com/encog/
 * http://code.google.com/p/encog-java/
 * 
 * Copyright 2008-2010 by Heaton Research Inc.
 * 
 * Released under the LGPL.
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
 * 
 * Encog and Heaton Research are Trademarks of Heaton Research, Inc.
 * For information on Heaton Research trademarks, visit:
 * 
 * http://www.heatonresearch.com/copyright.html
 */

package org.encog.neural.data;

import java.awt.Graphics;

import junit.framework.TestCase;

public class TestNeuralDataError extends TestCase {
	public void testNeuralDataError()
	{
		try
		{
			int i=0;
			if(i==0)
				throw new NeuralDataError("test");
			TestCase.assertTrue(false);
		}
		catch(NeuralDataError e)
		{
		}
		
		try
		{
			Graphics g = null;
			g.create();
		}
		catch(NullPointerException e)
		{
			try
			{
				int i=0;
				if(i==0)
					throw new NeuralDataError(e);
				TestCase.assertTrue(false);
			}
			catch(NeuralDataError e2)
			{
				
			}
		}
	}
}
