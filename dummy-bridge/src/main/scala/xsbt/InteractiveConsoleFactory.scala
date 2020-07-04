/*
 * Zinc - The incremental compiler for Scala.
 * Copyright Lightbend, Inc. and Mark Harrah
 *
 * Licensed under Apache License 2.0
 * (http://www.apache.org/licenses/LICENSE-2.0).
 *
 * See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 */

package xsbt

import scala.tools.sci.Logger

class InteractiveConsoleFactory extends scala.tools.sci.InteractiveConsoleFactory {
  def createConsole(
      args: Array[String],
      bootClasspathString: String,
      classpathString: String,
      initialCommands: String,
      cleanupCommands: String,
      loader: ClassLoader,
      bindNames: Array[String],
      bindValues: Array[AnyRef],
      log: Logger
  ): scala.tools.sci.InteractiveConsoleInterface =
    new InteractiveConsoleInterface(
      args,
      bootClasspathString,
      classpathString,
      initialCommands,
      cleanupCommands,
      loader,
      bindNames,
      bindValues,
      log
    )
}
