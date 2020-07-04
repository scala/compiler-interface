package testpkg

import xsbti._
import xsbti.api.DefinitionType

sealed trait APIEvent
object APIEvent {
  case class StartSource(src: VirtualFile) extends APIEvent
  case class StartClassLike(definitionType: Int, name: String, isTopLevel: Boolean) extends APIEvent
  case object EndClassLike extends APIEvent
  case object EndSource extends APIEvent
}
