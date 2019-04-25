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
 * Scaladoc Interface as of Zinc 1.2.0.
 */
public interface ScaladocInterface1 {
  void run(String[] args, Logger log, Reporter delegate);
}
