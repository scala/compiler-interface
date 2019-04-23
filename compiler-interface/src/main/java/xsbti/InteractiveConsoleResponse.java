/*
 * Compiler Interface
 *
 * Copyright 2011 - 2019, Lightbend, Inc.
 * Copyright 2008 - 2010, Mark Harrah
 *
 * Licensed under Apache License 2.0
 * (http://www.apache.org/licenses/LICENSE-2.0).
 */

package xsbti;

/** Public interface for repl responses. */
public interface InteractiveConsoleResponse {
  InteractiveConsoleResult result();

  String output();
}
