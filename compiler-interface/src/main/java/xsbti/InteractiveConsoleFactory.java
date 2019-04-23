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

public interface InteractiveConsoleFactory {
  InteractiveConsoleInterface createConsole(
      String[] args,
      String bootClasspathString,
      String classpathString,
      String initialCommands,
      String cleanupCommands,
      ClassLoader loader,
      String[] bindNames,
      Object[] bindValues,
      Logger log
  );
}
