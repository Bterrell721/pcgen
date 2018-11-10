/*
 * Missing License Header, Copyright 2016 (C) Andrew Maitland <amaitland@users.sourceforge.net>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package pcgen.cdom.facet.model;

import pcgen.cdom.enumeration.CharID;
import pcgen.cdom.facet.base.AbstractListFacet;
import pcgen.cdom.facet.event.DataFacetChangeEvent;
import pcgen.cdom.facet.event.DataFacetChangeListener;
import pcgen.cdom.helper.CNAbilitySelection;
import pcgen.core.Ability;

public class SimpleAbilityFacet extends AbstractListFacet<CharID, Ability>
		implements DataFacetChangeListener<CharID, CNAbilitySelection>
{

	@Override
	public void dataAdded(DataFacetChangeEvent<CharID, CNAbilitySelection> dfce)
	{
		add(dfce.getCharID(), dfce.getCDOMObject().getCNAbility().getAbility());
	}

	@Override
	public void dataRemoved(DataFacetChangeEvent<CharID, CNAbilitySelection> dfce)
	{
		remove(dfce.getCharID(), dfce.getCDOMObject().getCNAbility().getAbility());
	}

}
