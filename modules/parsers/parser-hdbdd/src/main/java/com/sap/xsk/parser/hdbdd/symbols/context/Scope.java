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
package com.sap.xsk.parser.hdbdd.symbols.context;

import com.sap.xsk.parser.hdbdd.symbols.Symbol;

public interface Scope {

    Scope getEnclosingScope(); // am I nested in another?

    void define(Symbol sym); // define sym in this com.sap.xsk.parser.hdbdd.symbols.scope

    Symbol resolve(String name); //

    boolean isDuplicateName(String id);
}
