package de.gesellix.gradle.debian.tasks.jdeb

import org.vafer.jdeb.shaded.compress.compress.archivers.tar.TarArchiveEntry
import spock.lang.Specification

class ClosureFilenameMapperTest extends Specification {

  def tarArchiveEntry

  def setup() {
    tarArchiveEntry = Mock(TarArchiveEntry)
  }

  def "accepts filename-mapping == null"() {
    when:
    new ClosureFilenameMapper(null, null, null).map(tarArchiveEntry)
    then:
    0 * tarArchiveEntry.setName(_)
  }

  def "updates filename when filename-mapping != null"() {
    given:
    tarArchiveEntry.name >> "/initial_name"
    when:
    new ClosureFilenameMapper(null, null, { path -> "/another/path" + path }).map(tarArchiveEntry)
    then:
    1 * tarArchiveEntry.setName("/another/path/initial_name")
  }

  def "accepts user and group == null"() {
    when:
    new ClosureFilenameMapper(null, null, null).map(tarArchiveEntry)
    then:
    0 * tarArchiveEntry.setUserName(_)
    0 * tarArchiveEntry.setGroupName(_)
  }

  def "accepts filename-mapping =! null"() {
    when:
    new ClosureFilenameMapper("user", "group", null).map(tarArchiveEntry)
    then:
    1 * tarArchiveEntry.setUserName("user")
    1 * tarArchiveEntry.setGroupName("group")
  }
}
