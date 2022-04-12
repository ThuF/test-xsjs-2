/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company and XSK contributors
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License, v2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-FileCopyrightText: 2022 SAP SE or an SAP affiliate company and XSK contributors
 * SPDX-License-Identifier: Apache-2.0
 */
package com.sap.xsk.parser.hdbsequence.custom;


import com.google.gson.*;
import com.sap.xsk.parser.hdbsequence.exceptions.XSKHDBSequenceMissingPropertyException;
import com.sap.xsk.parser.hdbsequence.models.XSKHDBSEQUENCEModel;

import java.lang.reflect.Type;
import java.util.Objects;

public class XSKHDBSEQUENCEModelAdapter implements JsonDeserializer<XSKHDBSEQUENCEModel> {

    protected static String handleStringLiteral(String value) {
        if (value != null && value.length() > 1) {
            String subStr = value.substring(1, value.length() - 1);
            String escapedQuote = subStr.replace("\\\"", "\"");
            return escapedQuote.replace("\\\\", "\\");
        }

        return value;
    }

    @Override
    public XSKHDBSEQUENCEModel deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context)
            throws JsonParseException {

        XSKHDBSEQUENCEModel model = new Gson().fromJson(jsonElement, type);
        if (model.hasMandatoryFieldsMissing()) {
            String properties = String.join(",", model.getMissingProps());
            throw new XSKHDBSequenceMissingPropertyException(String.format("Missing mandatory fields among  %s!", properties));
        }
        model.setSchema(handleStringLiteral(model.getSchema()));
        if (Objects.nonNull(model.getResetBy())) {
            model.setResetBy(handleStringLiteral(model.getResetBy()));
        }
        if (Objects.nonNull(model.getDependsOnTable())) {
            model.setDependsOnTable(handleStringLiteral(model.getDependsOnTable()));
        }
        if (Objects.nonNull(model.getDependsOnView())) {
            model.setDependsOnView(handleStringLiteral(model.getDependsOnView()));
        }
        return model;
    }
}
