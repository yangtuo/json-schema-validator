/*
 * Copyright (c) 2012, Francis Galiegue <fgaliegue@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Lesser GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.eel.kitchen.jsonschema.syntax.common;

import org.eel.kitchen.jsonschema.syntax.SimpleSyntaxValidator;
import org.eel.kitchen.util.NodeType;

/**
 * Syntax validator for the {@code additionalProperties} keyword (draft section
 * 5.3)
 */
public final class AdditionalPropertiesSyntaxValidator
    extends SimpleSyntaxValidator
{
    private static final AdditionalPropertiesSyntaxValidator instance
        = new AdditionalPropertiesSyntaxValidator();

    public static AdditionalPropertiesSyntaxValidator getInstance()
    {
        return instance;
    }

    private AdditionalPropertiesSyntaxValidator()
    {
        super("additionalProperties", NodeType.OBJECT, NodeType.BOOLEAN);
    }
}
