package de.gesellix.gradle.debian.tasks.data

import org.gradle.api.tasks.Input

class DataDirectoryMapper {

  @Input
  Closure filename
  @Input
  String userName
  @Input
  String groupName
}
