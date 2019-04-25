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

/**
 * Console Interface as of Zinc 1.2.0.
 */
public interface ConsoleInterface1 {
  void run(
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

  String[] commandArguments(
    String[] args,
    String bootClasspathString,
    String classpathString,
    Logger log);
}
