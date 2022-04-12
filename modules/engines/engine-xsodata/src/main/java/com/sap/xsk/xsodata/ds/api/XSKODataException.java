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
package com.sap.xsk.xsodata.ds.api;

/**
 * The Data Structures Exception.
 */
public class XSKODataException extends Exception {

  private static final long serialVersionUID = 5800180600419241248L;

  /**
   * Instantiates a new data structures exception.
   */
  public XSKODataException() {
    super();
  }

  /**
   * Instantiates a new data structures exception.
   *
   * @param message            the message
   * @param cause              the cause
   * @param enableSuppression  the enable suppression
   * @param writableStackTrace the writable stack trace
   */
  public XSKODataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  /**
   * Instantiates a new data structures exception.
   *
   * @param message the message
   * @param cause   the cause
   */
  public XSKODataException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Instantiates a new data structures exception.
   *
   * @param message the message
   */
  public XSKODataException(String message) {
    super(message);
  }

  /**
   * Instantiates a new data structures exception.
   *
   * @param cause the cause
   */
  public XSKODataException(Throwable cause) {
    super(cause);
  }

}
