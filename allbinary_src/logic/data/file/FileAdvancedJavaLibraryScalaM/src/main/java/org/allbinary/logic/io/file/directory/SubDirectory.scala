/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file.directory

import _root_.java.io.FileFilter
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.util.BasicArrayList

class SubDirectory private() {
    import _root_.org.allbinary.logic.io.file.directory.SubDirectory.{*}

    private val directory : Directory = Directory.getInstance()

    // Find the files matching the FileFilter in the given directory
    def search(fileFilter : FileFilter, file : AbFile) : BasicArrayList = {
        return this.directory.search(fileFilter, file, true)
    }

    // Return the files in the given directory
    def search(file : AbFile) : BasicArrayList = {
        return this.directory.search(file, true)
    }

    // Find the files matching the searchValue in the given directory
    def search(searchValue : String, file : AbFile) : BasicArrayList = {
        return this.directory.search(searchValue, file, true)
    }

    def search(level : Int, file : AbFile) : BasicArrayList = {
        return this.directory.search(level, file, true)
    }

}

object SubDirectory {
    private val instance : SubDirectory = new SubDirectory()

    def getInstance() : SubDirectory = {
        return SubDirectory.instance
    }

    def toString(files : BasicArrayList) : String = {
        var stringBuffer : StringMaker = new StringMaker()
        val NEW_LINE : String = CommonSeps.getInstance().NEW_LINE
        val size : Int = files.size()

        {
            var index : Int = 0
            while (index < size) {
                var file : AbFile = files.get(index).asInstanceOf[AbFile]
                stringBuffer.append(file.getPath())
                stringBuffer.append(NEW_LINE)
                index += 1
            }
        }
        return stringBuffer.toString()
    }

}


