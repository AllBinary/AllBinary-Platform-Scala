/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file.directory

import _root_.org.allbinary.java.runtime.process.git.GitProcessHelper
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.CommonDataFileStrings
import _root_.org.allbinary.logic.io.file.visitor.IncludeFileExtensionsBooleanFileVisitor
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class DirectoryOrIncludeFileExtensionAndTrackedBooleanFileVisitor private (super_1 : BasicArrayList, constructor_ : Unit) extends IncludeFileExtensionsBooleanFileVisitor(super_1) {
    import _root_.org.allbinary.logic.io.file.directory.DirectoryOrIncludeFileExtensionAndTrackedBooleanFileVisitor.{*}

    private val trackedStrings : TrackedStrings = TrackedStrings.getInstance()

    private val gitProcessHelper : GitProcessHelper = GitProcessHelper.getInstance()

    private var includesString : String = null

    def this(filterStringBasicArrayList : BasicArrayList, includesString : String) = {
        this(filterStringBasicArrayList, ())
        this.includesString = includesString
    }

    def this(filterStringBasicArrayList : BasicArrayList) = {
        this(filterStringBasicArrayList, ())
        this.includesString = null
    }

    override def visit(file : AbFile) : _root_.java.lang.Boolean = {
        if (file.isDirectory()) {
            return _root_.java.lang.Boolean.TRUE
        }
        if ((this.includesString == null) || (file.getAbsolutePath().indexOf(this.includesString) >= 0)) {
            return super.visit(file)
        } else {
            return _root_.java.lang.Boolean.FALSE
        }
        throw new IllegalStateException()
    }

    override def visit(file : AbFile, fileNameString : String) : _root_.java.lang.Boolean = {
        val filePath : String = file.getPath()
        if (super.visit(file, fileNameString)) {
            //System.out.println("path: " + filePath);
            if (!((filePath.contains(this.trackedStrings.APPLICATION) || filePath.contains(this.trackedStrings.APP)) || filePath.contains(this.trackedStrings.HTML_TEMP))) {
                if (!(filePath.contains(this.trackedStrings.TARGET_PATH_WINDOWS) || filePath.contains(this.trackedStrings.TARGET_PATH_UNIX))) {
                    //System.out.println("Not target path");
                    if (this.gitProcessHelper.isTracked(file)) {
                        //System.out.println("tracked");
                        return _root_.java.lang.Boolean.TRUE
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
        return _root_.java.lang.Boolean.FALSE
    }

}

object DirectoryOrIncludeFileExtensionAndTrackedBooleanFileVisitor {
    def main(args : Array[String]) : Unit = {
        val commonFileStrings : CommonDataFileStrings = CommonDataFileStrings.getInstance()
        val list : BasicArrayList = new BasicArrayListD()
        list.add(commonFileStrings.JAVA)
        val filePath : String = "G:\\mnt\\bc\\mydev\\games\\ZeptoRacer\\platform\\j2se\\ZeptoRacerStaticPathsJ2SEM\\target\\dependency\\org\\allbinary\\logic\\system\\security\\licensing\\ZeptoRacerPCClientInformation.java"
        val result : Boolean = new DirectoryOrIncludeFileExtensionAndTrackedBooleanFileVisitor(list).visit(AbFile.createAbFileFromRawPath(filePath))
        //.isGitTracked(AbFile.createAbFileFromRawPath(filePath));
        System.out.println((filePath + " is Tracked: ") + result)
    }

}


