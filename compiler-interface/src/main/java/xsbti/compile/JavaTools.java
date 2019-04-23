/*
 * Compiler Interface
 *
 * Copyright 2011 - 2019, Lightbend, Inc.
 * Copyright 2008 - 2010, Mark Harrah
 *
 * Licensed under Apache License 2.0
 * (http://www.apache.org/licenses/LICENSE-2.0).
 */

package xsbti.compile;

/**
 * Represent an interface of the toolchain of Java compilation that gives
 * access javadoc generation and Java compilation.
 */
public interface JavaTools {
  /** Return an implementation of the Java compiler (javac). */
  JavaCompiler javac();

  /** Return an implementation of a Javadoc generator. */
  Javadoc javadoc();
}
