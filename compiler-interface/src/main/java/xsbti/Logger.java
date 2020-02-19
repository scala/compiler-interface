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

import java.util.function.Supplier;

public interface Logger {
  void error(Supplier<String> msg);

  void warn(Supplier<String> msg);

  void info(Supplier<String> msg);

  void debug(Supplier<String> msg);

  void trace(Supplier<Throwable> exception);
}
