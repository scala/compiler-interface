package testpkg

import java.io.{ InputStream, ByteArrayInputStream }
import xsbti.{ BasicVirtualFileRef, VirtualFile }

case class StringVirtualFile(path: String, content: String)
    extends BasicVirtualFileRef(path)
    with VirtualFile {
  override def contentHash(): Long = content.hashCode
  override def id(): String = path
  override def name(): String = path.split("/").last
  override def names(): Array[String] = path.split("/")
  override def input(): InputStream = new ByteArrayInputStream(content.getBytes("UTF-8"))
  override def toString(): String = s"StringVirtualFile($path, <content>)"
}
