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

import com.fasterxml.jackson.databind.JsonNode;
import org.eel.kitchen.jsonschema.main.ValidationReport;
import org.eel.kitchen.jsonschema.syntax.SyntaxValidator;
import org.eel.kitchen.util.NodeType;
import org.eel.kitchen.util.RhinoHelper;

public final class PatternSyntaxValidator
    extends SyntaxValidator
{
    private static final PatternSyntaxValidator instance
        = new PatternSyntaxValidator();

    private PatternSyntaxValidator()
    {
        super("pattern", NodeType.STRING);
    }

    public static PatternSyntaxValidator getInstance()
    {
        return instance;
    }

    /**
     * Check that the value is a valid regex
     *
     * @see RhinoHelper#regexIsValid(String)
     */
    @Override
    protected void checkFurther(final JsonNode schema,
        final ValidationReport report)
    {
        final JsonNode node = schema.get(keyword);
        final String pattern = node.textValue();

        if (!RhinoHelper.regexIsValid(pattern))
            report.message("invalid regex " + pattern);
    }
}
