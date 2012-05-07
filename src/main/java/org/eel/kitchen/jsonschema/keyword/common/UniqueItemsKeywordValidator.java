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

package org.eel.kitchen.jsonschema.keyword.common;

import com.fasterxml.jackson.databind.JsonNode;
import org.eel.kitchen.jsonschema.keyword.KeywordValidator;
import org.eel.kitchen.jsonschema.main.ValidationContext;
import org.eel.kitchen.jsonschema.main.ValidationReport;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Keyword validator for the {@code uniqueItems} keyword (draft section
 * 5.15)</p>
 *
 * <p>Here again, Jackson's {@link JsonNode#equals(Object)} is a life (and
 * time) saver.
 * </p>
 */
public final class UniqueItemsKeywordValidator
    extends KeywordValidator
{
    private static final UniqueItemsKeywordValidator instance
        = new UniqueItemsKeywordValidator();

    private UniqueItemsKeywordValidator()
    {
        super("uniqueItems");
    }

    public static UniqueItemsKeywordValidator getInstance()
    {
        return instance;
    }

    @Override
    public ValidationReport validate(final ValidationContext context,
        final JsonNode instance)
    {
        final ValidationReport report = context.createReport();
        final boolean unique = context.getSchema().get(keyword)
            .booleanValue();

        if (!unique)
            return report;

        final Set<JsonNode> set = new HashSet<JsonNode>();

        for (final JsonNode node: instance)
            if (!set.add(node)) {
                report.message("items in the array are not unique");
                break;
            }

        return report;
    }
}
