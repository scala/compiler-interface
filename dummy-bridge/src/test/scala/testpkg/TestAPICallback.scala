package testpkg

import xsbti._
import xsbti.api.{ DependencyContext, ClassLike }

class TestAPICallback extends APICallback {

  val apis: scala.collection.mutable.Map[VirtualFileRef, Set[ClassLike]] =
    scala.collection.mutable.Map.empty

  override def startSource(source: VirtualFile): Unit = {
    assert(
      !apis.contains(source),
      s"The startSource can be called only once per source file: $source"
    )
    apis(source) = Set.empty
  }
}
