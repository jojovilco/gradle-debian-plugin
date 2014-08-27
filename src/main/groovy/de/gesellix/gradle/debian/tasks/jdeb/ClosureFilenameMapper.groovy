package de.gesellix.gradle.debian.tasks.jdeb

import org.vafer.jdeb.mapping.Mapper
import org.vafer.jdeb.shaded.compress.compress.archivers.tar.TarArchiveEntry

class ClosureFilenameMapper implements Mapper {

  private String userName
  private String groupName
  private Closure mapping

  def ClosureFilenameMapper(String userName, String groupName, Closure mapping) {
    this.userName = userName
    this.groupName = groupName
    this.mapping = mapping
  }

  def TarArchiveEntry map(TarArchiveEntry e) {
    if (userName != null) e.setUserName(userName)
    if (groupName != null) e.setGroupName(groupName)
    if (mapping != null) {
      e.setName(mapping(e.getName()))
    }
    return e
  }
}
