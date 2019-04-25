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

import xsbti.compile.*;
import java.io.File;

/**
 * Compiler Interface as of Zinc 1.2.0.
 */
public interface CompilerInterface1 {
  /** Returns a new compiler used for caching. */
  CachedCompiler newCompiler(
    String[] options,
    Output output,
    Logger initialLog,
    Reporter initialDelegate
  );

  void run(
    File[] sources,
    DependencyChanges changes,
    AnalysisCallback callback,
    Logger log,
    Reporter delegate,
    CompileProgress progress,
    CachedCompiler cached
  );
}
