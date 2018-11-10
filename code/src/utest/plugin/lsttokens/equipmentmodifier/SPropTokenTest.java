/*
 * Copyright (c) 2007 Tom Parker <thpr@users.sourceforge.net>
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 */
package plugin.lsttokens.equipmentmodifier;

import org.junit.Test;

import pcgen.cdom.base.Constants;
import pcgen.core.EquipmentModifier;
import pcgen.rules.persistence.CDOMLoader;
import pcgen.rules.persistence.token.CDOMPrimaryToken;
import plugin.lsttokens.testsupport.AbstractTextPropertyTokenTestCase;
import plugin.lsttokens.testsupport.CDOMTokenLoader;

public class SPropTokenTest extends
		AbstractTextPropertyTokenTestCase<EquipmentModifier>
{
	static SpropToken token = new SpropToken();
	static CDOMTokenLoader<EquipmentModifier> loader = new CDOMTokenLoader<>();

	@Override
	public Class<EquipmentModifier> getCDOMClass()
	{
		return EquipmentModifier.class;
	}

	@Override
	public CDOMLoader<EquipmentModifier> getLoader()
	{
		return loader;
	}

	@Override
	public CDOMPrimaryToken<EquipmentModifier> getToken()
	{
		return token;
	}

	@Test
	public void testInvalidDoubleClear()
	{
		assertFalse(parse(".CLEAR|.CLEAR|Second"));
		assertNoSideEffects();
	}

	@Test
	public void testInvalidClearAsVariable()
	{
		assertFalse(parse("Second|.CLEAR"));
		assertNoSideEffects();
	}

	@Test
	public void testValidClear()
	{
		assertTrue(parse(Constants.LST_DOT_CLEAR));
	}
}
