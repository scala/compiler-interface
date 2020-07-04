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

package scala.tools.sci;

import java.nio.file.Path;

public interface APICallback {

  interface DefinitionType {
    int TRAIT = 0;
    int CLASS_DEF = 1;
    int MODULE = 2;
    int PACKAGE_MODULE = 3;
  }

  default void startSource(VirtualFile src) {
    // startSource needs to be VirtualFile because it needs to read the stamp.
  }

  default void endSource() {}

  default void startClassLike(int definitionType, String name, boolean isTopLevel) {}

  default void endClassLike() {}

  default void startClassLikeDef(int definitionType, String name) {}

  default void endClassLikeDef() {}

  /** register the last seen value as a nonLocalClass and consume it */
  default void saveNonLocalClass() {}

  /**
   * Cache the last seen value by id.
   *
   * @param id a key to store the last seen value.
   */
  default void registerSharedWith(long id) {}

  /**
   * Retrieve a value by id
   *
   * @param id a key for a shared value
   */
  default void sharedValue(long id) {}

  default void startStrictLazy() {}

  default void endStrictLazy() {}

  default void embedLazy(Runnable task) {}

  default void forceAllLazy() {}

  default void startStructure() {}

  default void endStructure() {}

  default void endTypeSequence() {}

  default void endClassDefinitionSequence() {}

  default void startVal(String name) {}

  default void endVal() {}

  default void startDef(String name) {}

  default void endDef() {}

  default void startParamList(boolean isImplicit) {}

  default void endParamList() {}

  default void endParamLists() {}

  default void startProjection(String selected) {}

  default void endProjection() {}

  default void startConstant(String value) {}

  default void endConstant() {}

  default void startSingleton() {}

  default void endSingleton() {}

  default void startPath() {}

  default void endPath() {}

  default void emptyType() {}

  default void id(String name) {}

  default void thisId() {}

  default void publicAPI() {}

  default void localAPI(boolean isProtected) {}

  default void qualifiedAPI(boolean isProtected, String optionalQualifier) {}

  default void modifiers(
      boolean isAbstract,
      boolean isOverride,
      boolean isFinal,
      boolean isSealed,
      boolean isImplicit,
      boolean isLazy,
      boolean isMacro,
      boolean isSuperAccessor) {}
}
