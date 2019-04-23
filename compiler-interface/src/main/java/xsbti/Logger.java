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

import java.util.function.Supplier;

public interface Logger {
	void error(Supplier<String> msg);
	void warn(Supplier<String> msg);
	void info(Supplier<String> msg);
	void debug(Supplier<String> msg);
	void trace(Supplier<Throwable> exception);
}
