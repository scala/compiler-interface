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

import java.io.File;

/**
 * Define the changes that can occur to the dependencies of a given compilation run.
 */
public interface DependencyChanges {
    /** Check whether there have been any change in the compilation dependencies. */
	boolean isEmpty();

    /**
     * Return the modified binaries since the last compilation run.
     * These modified binaries are either class files or jar files.
     */
	File[] modifiedBinaries();

	/**
	 * Return the modified class names since the last compilation run.
     * These class names are mapped to sources and not binaries.
	 */
	String[] modifiedClasses();
}