/*
 * Encog Workbench v1.x
 * http://www.heatonresearch.com/encog/
 * http://code.google.com/p/encog-java/
 * 
 * Copyright 2008, Heaton Research Inc., and individual contributors.
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
package org.encog.workbench.models;

import javax.swing.event.ListDataListener;

import org.encog.neural.persist.EncogPersistedCollection;

public class EncogListModel extends CommonListModel {

	private final EncogPersistedCollection encogCollection;

	public EncogListModel(final EncogPersistedCollection theEncogCollection) {
		this.encogCollection = theEncogCollection;
	}

	public void addListDataListener(final ListDataListener listener) {
		getListeners().add(listener);
	}

	public Object getElementAt(final int i) {
		if (i >= this.encogCollection.getList().size()) {
			return null;
		} 
		return this.encogCollection.getList().get(i);
		
	}

	/**
	 * @return the encogCollection
	 */
	public EncogPersistedCollection getEncogCollection() {
		return this.encogCollection;
	}

	public int getSize() {
		return this.encogCollection.getList().size();
	}

	public void removeListDataListener(final ListDataListener listener) {
		getListeners().remove(listener);
	}

}