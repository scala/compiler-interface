package testpkg

import scala.collection.mutable
import xsbti._
import xsbti.api.{ DefinitionType, DependencyContext, ClassLike }
import APIEvent._

class TestAPICallback extends APICallback with APIEventHolder {
  val apis: mutable.Map[VirtualFileRef, Set[ClassLike]] = mutable.Map.empty

  override def startSource(source: VirtualFile): Unit = {
    assert(
      !apis.contains(source),
      s"The startSource can be called only once per source file: $source"
    )
    apis(source) = Set.empty
    push(StartSource(source))
  }

  override def startClassLike(dt: Int, name: String, isTopLevel: Boolean): Unit =
    push(StartClassLike(dt, name, isTopLevel))

  override def endClassLike(): Unit = push(EndClassLike)

  override def endSource(): Unit = push(EndSource)
}

trait APIEventHolder {
  private[this] val _events = mutable.ArrayBuffer.empty[APIEvent]
  protected def push(event: APIEvent): Unit = _events += event
  def events: List[APIEvent] = _events.toList
}
