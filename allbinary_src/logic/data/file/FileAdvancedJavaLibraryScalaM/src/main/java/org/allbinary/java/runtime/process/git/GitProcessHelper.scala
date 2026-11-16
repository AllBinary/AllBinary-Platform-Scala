/*  * AllBinary Open License Version 1  * Copyright (c) 2026 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.java.runtime.process.git

import _root_.java.io.File
import _root_.java.io.IOException
import _root_.java.nio.charset.StandardCharsets
import _root_.java.util.ArrayList
import _root_.java.util.List
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.AbFileNativeUtil
import _root_.org.allbinary.logic.io.file.directory.TrackedStrings
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings

//Do not use this instead just skip target, build, Application paths.
class GitProcessHelper private() {
    import _root_.org.allbinary.java.runtime.process.git.GitProcessHelper.{*}

    private val trackedStrings : TrackedStrings = TrackedStrings.getInstance()

    //Constructor
    {
        val logUtil : LogUtil = LogUtil.getInstance()
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val THIS_IS_SLOW : String = "This is slow consider path exclusion instead"
        logUtil.putF(THIS_IS_SLOW, this, commonStrings.CONSTRUCTOR)
    }

    def trackedFiles(rootAsString : String, pathspec : String) : List[String] = {
        return this.trackedFiles(rootAsString, pathspec, ".java")
    }

    def trackedFiles(rootAsString : String, pathspec : String, suffix : String) : List[String] = {
        val process : Process = new ProcessBuilder(this.trackedStrings.GIT_COMMAND, this.trackedStrings.CHANGE_DIRECTORY_OPTION, rootAsString, this.trackedStrings.LIST_FILES_COMMAND, this.trackedStrings.SEP_BY_NULL_CHAR_INSTEAD_OF_NEW_LINE, this.trackedStrings.PATHSPEC_SEPARATOR, pathspec).redirectError(ProcessBuilder.Redirect.INHERIT).start()
        val output : Array[Byte] = process.getInputStream().readAllBytes()
        val exitCode : Int = process.waitFor()
        if (exitCode != 0) {
            throw new IllegalStateException(new StringMaker().append("git ls-files failed for ").append(rootAsString).append(" with exit code ").appendint(exitCode).toString())
        }
        val files : List[String] = new ArrayList()
        var start : Int = 0
        var relativePath : String = null

        {
            var index : Int = 0
            while (index < output.length) {
                if (output(index) == 0) {
                    relativePath = new String(output, start, index - start, StandardCharsets.UTF_8)
                    if (relativePath.endsWith(suffix)) {
                        files.add(relativePath)
                    }
                    start = index + 1
                }
                index += 1
            }
        }
        return files
    }

    def isTracked(file : AbFile) : Boolean = {
        try {
            val nativeFile : File = AbFileNativeUtil.get(file)
            val parentFile : File = nativeFile.getParentFile()
            val process : Process = new ProcessBuilder(this.trackedStrings.GIT_COMMAND, this.trackedStrings.CHANGE_DIRECTORY_OPTION, parentFile.getPath(), this.trackedStrings.LIST_FILES_COMMAND, this.trackedStrings.ERROR_UNMATCH_OPTION, this.trackedStrings.PATHSPEC_SEPARATOR, nativeFile.getName()).redirectErrorStream(true).start()
            process.getInputStream().readAllBytes()
            return process.waitFor() == 0
        } catch {
            case e : Exception => {
                return false
            }
        }
        throw new IllegalStateException()
    }

}

object GitProcessHelper {
    private val instance : GitProcessHelper = new GitProcessHelper()

    /**      * @return the instance      */
    def getInstance() : GitProcessHelper = {
        return GitProcessHelper.instance
    }

}


