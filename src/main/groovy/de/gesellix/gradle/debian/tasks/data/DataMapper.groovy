package de.gesellix.gradle.debian.tasks.data

import org.gradle.api.tasks.Input

class DataMapper {

  @Input
  String fileMode
  @Input
  String userName
  @Input
  String groupName
}
