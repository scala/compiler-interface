/*
 * Scala compiler interface
 *
 * Copyright Lightbend, Inc. and Mark Harrah
 *
 * Licensed under Apache License 2.0
 * (http://www.apache.org/licenses/LICENSE-2.0).
 *
 * See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 */

package scala.tools.sci;

/** Scaladoc Interface as of Zinc 1.2.0. */
public interface ScaladocInterface1 {
  void run(String[] args, Logger log, Reporter delegate);
}
