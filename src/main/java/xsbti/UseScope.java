/*
 * Zinc - The incremental compiler for Scala.
 * Copyright 2011 - 2017, Lightbend, Inc.
 * Copyright 2008 - 2010, Mark Harrah
 * This software is released under the terms written in LICENSE.
 */

package xsbti;

/**
 * Defines the scope in which a name hash was captured.
 *
 * The incremental compiler uses [[UseScope]] to determine some Scala semantics
 * assumed in the presence of a name in a concrete position. For instance,
 * [[PatMatTarget]] is used for names that appear as the target types of a
 * pattern match.
 *
 * The order of declaration of these is crucial. Don't change it.
 */
public enum UseScope {
    // Don't add more than 6 scopes. Otherwise, change `Mapper` implementation.
    Default, Implicit, PatMatTarget
}

