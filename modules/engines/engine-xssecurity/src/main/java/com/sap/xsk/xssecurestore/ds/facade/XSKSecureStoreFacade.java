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
package com.sap.xsk.xssecurestore.ds.facade;

import com.sap.xsk.xssecurestore.ds.api.IXSKSecureStoreModel;
import com.sap.xsk.xssecurestore.ds.api.XSKSecureStoreException;
import com.sap.xsk.xssecurestore.ds.model.XSKSecureStoreContent;
import com.sap.xsk.xssecurestore.ds.service.XSKSecureStoreCoreService;
import org.eclipse.dirigible.api.v3.security.UserFacade;
import org.eclipse.dirigible.commons.api.scripting.IScriptingFacade;

public class XSKSecureStoreFacade implements IScriptingFacade {

  private static final XSKSecureStoreCoreService xskSecureStoreCoreService = new XSKSecureStoreCoreService();

  public XSKSecureStoreFacade() {
  }

  public static final void store(String storeId, String dataId, String value) throws XSKSecureStoreException {
    xskSecureStoreCoreService.createSecureStoreValue(storeId, IXSKSecureStoreModel.VALUE_APP_USER, dataId, value);
  }

  public static final boolean existsStore(String storeId) throws XSKSecureStoreException {
    return xskSecureStoreCoreService.existsSecureStore(storeId);
  }

  public static final String read(String storeId, String dataId) throws XSKSecureStoreException {
    XSKSecureStoreContent xskSecureStoreContent = xskSecureStoreCoreService
        .findSecureStoreContent(storeId, IXSKSecureStoreModel.VALUE_APP_USER, dataId);

    if (xskSecureStoreContent == null) {
      return null;
    }

    return new String(xskSecureStoreContent.getDataValue());
  }

  public static final void remove(String storeId, String dataId) throws XSKSecureStoreException {
    xskSecureStoreCoreService.deleteSecureStoreValue(storeId, IXSKSecureStoreModel.VALUE_APP_USER, dataId);
  }

  public static final String readForUser(String storeId, String dataId) throws XSKSecureStoreException {
    XSKSecureStoreContent xskSecureStoreContent = xskSecureStoreCoreService.findSecureStoreContent(storeId, UserFacade.getName(), dataId);

    if (xskSecureStoreContent == null) {
      return null;
    }

    return new String(xskSecureStoreContent.getDataValue());
  }

  public static final void storeForUser(String storeId, String dataId, String value) throws XSKSecureStoreException {
    xskSecureStoreCoreService.createSecureStoreValue(storeId, UserFacade.getName(), dataId, value);
  }

  public static final void removeForUser(String storeId, String dataId) throws XSKSecureStoreException {
    xskSecureStoreCoreService.deleteSecureStoreValue(storeId, UserFacade.getName(), dataId);
  }
}
