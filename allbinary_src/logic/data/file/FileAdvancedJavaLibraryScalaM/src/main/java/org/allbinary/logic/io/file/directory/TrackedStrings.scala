/*  * AllBinary Open License Version 1  * Copyright (c) 2026 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file.directory


/**  *  * @author User  */
class TrackedStrings {
    import _root_.org.allbinary.logic.io.file.directory.TrackedStrings.{*}

    val TARGET_PATH_WINDOWS : String = "\\target\\"

    val TARGET_PATH_UNIX : String = "/target/"

    val HTML_TEMP : String = "HTMLTemp"

    val APPLICATION : String = "Application"

    val APP : String = "\\app"

    val GIT_COMMAND : String = "git"

    val CHANGE_DIRECTORY_OPTION : String = "-C"

    val LIST_FILES_COMMAND : String = "ls-files"

    val ERROR_UNMATCH_OPTION : String = "--error-unmatch"

    val PATHSPEC_SEPARATOR : String = "--"

    val SEP_BY_NULL_CHAR_INSTEAD_OF_NEW_LINE : String = "-z"

}

object TrackedStrings {
    private val instance : TrackedStrings = new TrackedStrings()

    /**      * @return the instance      */
    def getInstance() : TrackedStrings = {
        return TrackedStrings.instance
    }

}


