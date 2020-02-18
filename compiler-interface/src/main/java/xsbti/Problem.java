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

package xsbti;

import java.util.Optional;

public interface Problem
{
	String category();
	Severity severity();
	String message();
	Position position();

  // Default value to avoid breaking binary compatibility
  /**
   * If present, the string shown to the user when displaying this Problem.
   * Otherwise, the Problem will be shown in an implementation-defined way
   * based on the values of its other fields.
   */
  default Optional<String> rendered() { return Optional.empty(); }
}
