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

import xsbti.compile.*;
import java.io.File;

/** Compiler Interface as of Zinc 1.2.0. */
public interface CompilerInterface1 {
  /** Returns a new compiler used for caching. */
  CachedCompiler newCompiler(
      String[] options, Output output, Logger initialLog, Reporter initialDelegate);

  void run(
      VirtualFile[] sources,
      DependencyChanges changes,
      APICallback callback,
      OldCallback oldCallback,
      Logger log,
      Reporter delegate,
      CompileProgress progress,
      CachedCompiler cached);
}
