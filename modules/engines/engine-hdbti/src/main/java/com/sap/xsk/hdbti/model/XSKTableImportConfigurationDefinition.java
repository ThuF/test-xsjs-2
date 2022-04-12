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
package com.sap.xsk.hdbti.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class XSKTableImportConfigurationDefinition {

  private String table;
  private String schema;
  private String file;
  private String hdbtiFileName;
  private Boolean header = Boolean.FALSE;
  private Boolean useHeaderNames = Boolean.FALSE;
  private String delimField;
  private String delimEnclosing;
  private Boolean distinguishEmptyFromNull = Boolean.TRUE;
  private Map<String, ArrayList<String>> keysAsMap;

  public String getTable() {
    return table;
  }

  public void setTable(String table) {
    this.table = table;
  }

  public String getSchema() {
    return schema;
  }

  public void setSchema(String schema) {
    this.schema = schema;
  }

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public String getHdbtiFileName() {
    return hdbtiFileName;
  }

  public void setHdbtiFileName(String hdbtiFileName) {
    this.hdbtiFileName = hdbtiFileName;
  }

  public Boolean getHeader() {
    return header;
  }

  public void setHeader(Boolean header) {
    this.header = header;
  }

  public Boolean getUseHeaderNames() {
    return useHeaderNames;
  }

  public void setUseHeaderNames(Boolean useHeaderNames) {
    this.useHeaderNames = useHeaderNames;
  }

  public String getDelimField() {
    return delimField;
  }

  public void setDelimField(String delimField) {
    this.delimField = delimField;
  }

  public String getDelimEnclosing() {
    return delimEnclosing;
  }

  public void setDelimEnclosing(String delimEnclosing) {
    this.delimEnclosing = delimEnclosing;
  }

  public Boolean getDistinguishEmptyFromNull() {
    return distinguishEmptyFromNull;
  }

  public void setDistinguishEmptyFromNull(Boolean distinguishEmptyFromNull) {
    this.distinguishEmptyFromNull = distinguishEmptyFromNull;
  }

  public Map<String, ArrayList<String>> getKeysAsMap() {
    return keysAsMap;
  }

  public void setKeysAsMap(Map<String, ArrayList<String>> keysAsMap) {
    this.keysAsMap = keysAsMap;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    XSKTableImportConfigurationDefinition that = (XSKTableImportConfigurationDefinition) o;
    return table.equals(that.table) && schema.equals(that.schema) && file.equals(that.file);
  }

  @Override
  public int hashCode() {
    return Objects.hash(table, schema, file);
  }
}
