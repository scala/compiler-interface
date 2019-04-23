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

import xsbti.compile.analysis.ReadCompilations;
import xsbti.compile.analysis.ReadSourceInfos;
import xsbti.compile.analysis.ReadStamps;

import java.io.Serializable;

/**
 * Represents the analysis interface of an incremental compilation.
 * <p>
 * The analysis interface conforms the public API of the Analysis files that
 * contain information about the incremental compilation of a project.
 */
public interface CompileAnalysis extends Serializable {
    /**
     * Returns a read-only stamps interface that allows users to map files to stamps.
     *
     * @return A read-only stamps interface to query for stamps.
     * @see xsbti.compile.analysis.Stamp
     */
    public ReadStamps readStamps();

    /**
     * Returns a read-only source infos interface that allows users to get compiler
     * information on every source file they wish to.
     *
     * @return A read-only source infos interface.
     * @see xsbti.compile.analysis.SourceInfo
     */
    public ReadSourceInfos readSourceInfos();

    /**
     * Returns a read-only interface to check information about the incremental compilations.
     *
     * @return A read-only compilation info interface.
     * @see xsbti.compile.analysis.Compilation
     */
    public ReadCompilations readCompilations();
}
