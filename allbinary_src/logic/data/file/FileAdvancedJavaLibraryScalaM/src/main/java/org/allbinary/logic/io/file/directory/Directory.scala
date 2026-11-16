/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file.directory

import _root_.java.io.FileFilter
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.FileFactory
import _root_.org.allbinary.logic.io.file.FileWrapperUtil
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class Directory private() {
    import _root_.org.allbinary.logic.io.file.directory.Directory.{*}

    def create(directoryAbPath : AbPath) : Boolean = {
        return this.create(directoryAbPath.toFileSystemString())
    }

    def remove(existingDirectoryAbPath : AbPath) : Unit = {
        this.remove(existingDirectoryAbPath.toFileSystemString())
    }

    //returns true if directories already exist or if creation was successful
    private def create(directory : String) : Boolean = {
        try {
            val directoryFile : AbFile = FileFactory.getInstance().getInstance(directory)
            if (!directoryFile.isDirectory()) {
                //{
                PreLogUtil.put("Creating Directories: " + directory, this, "create")
                //}
                if (!directoryFile.mkdirs()) {
                    return false
                }
            }
            return true
        } catch {
            case e : Exception => {
                //{
                PreLogUtil.putOE("Error Creating Directories: " + directory, this, "create", e)
                //}
                return false
            }
        }
        throw new IllegalStateException()
    }

    //see if directory contains files if not remove directory
    private def remove(existingDirectory : String) : Unit = {
        val existingDirectoryFile : AbFile = FileFactory.getInstance().getInstance(existingDirectory)
        if (existingDirectoryFile.isDirectory()) {
            if (existingDirectoryFile.list().length > 0) {
                throw new Exception(("Did not remove category: " + existingDirectory) + " because files exist")
            } else if (existingDirectoryFile.delete()) {
                //{
                PreLogUtil.put("Successfully Removed: " + existingDirectory, "Directory", "remove")
            }
        } else {
            throw new Exception("Category Directory Is Missing:" + existingDirectory)
        }
    }

    def search(fileFilter : FileFilter, file : AbFile) : BasicArrayList = {
        return this.search(fileFilter, file, false)
    }

    //Find the files matching the FileFilter in the given directory
    def search(fileFilter : FileFilter, file : AbFile, isRecursiveSearch : Boolean) : BasicArrayList = {
        val fileList : BasicArrayList = new BasicArrayListD()
        var recursiveFileList : BasicArrayList = null
        if (file.isDirectory()) {
            //System.out.println("Is a Directory");
            val fileArray : Array[Object] = file.listFilesFileFilter(fileFilter)
            if (fileArray == null) {
                return fileList
            }
            val files : Array[AbFile] = FileWrapperUtil.wrapFiles(fileArray)
            if (files == null) {
                return fileList
            }
            val size : Int = files.length

            {
                var index : Int = 0
                while (index < size) {
                    fileList.add(files(index))
                    if (isRecursiveSearch) {
                        recursiveFileList = this.search(fileFilter, files(index), isRecursiveSearch)
                        fileList.addAllList(recursiveFileList)
                    }
                    index += 1
                }
            }
        }
        return fileList
    }

    def search(file : AbFile) : BasicArrayList = {
        return this.search(file, false)
    }

    //Return the files in the given directory
    def search(file : AbFile, isRecursiveSearch : Boolean) : BasicArrayList = {
        val fileList : BasicArrayList = new BasicArrayListD()
        var recursiveFileList : BasicArrayList = null
        if (file.isDirectory()) {
            val fileArray : Array[Object] = file.listFiles()
            if (fileArray == null) {
                return fileList
            }
            val files : Array[AbFile] = FileWrapperUtil.wrapFiles(fileArray)
            if (files == null) {
                return fileList
            }

            {
                var index : Int = 0
                while (index < files.length) {
                    fileList.add(files(index))
                    if (isRecursiveSearch) {
                        recursiveFileList = this.search(files(index), isRecursiveSearch)
                        fileList.addAllList(recursiveFileList)
                    }
                    index += 1
                }
            }
        }
        return fileList
    }

    def search(searchValue : String, file : AbFile) : BasicArrayList = {
        return this.search(searchValue, file, false)
    }

    //Find the files matching the searchValue in the given directory
    def search(searchValue : String, file : AbFile, isRecursiveSearch : Boolean) : BasicArrayList = {
        val fileList : BasicArrayList = new BasicArrayListD()
        var recursiveFileList : BasicArrayList = null
        if (file.isDirectory()) {
            val fileArray : Array[Object] = file.listFiles()
            if (fileArray == null) {
                return fileList
            }
            val files : Array[AbFile] = FileWrapperUtil.wrapFiles(fileArray)
            if (files == null) {
                return fileList
            }

            {
                var index : Int = 0
                while (index < files.length) {
                    if (files(index).getPath().indexOf(searchValue) >= 0) {
                        fileList.add(files(index))
                    }
                    if (isRecursiveSearch) {
                        recursiveFileList = this.search(searchValue, files(index), isRecursiveSearch)
                        fileList.addAllList(recursiveFileList)
                    }
                    index += 1
                }
            }
        }
        return fileList
    }

    def search(level : Int, file : AbFile) : BasicArrayList = {
        return this.search(level, file, false)
    }

    def search(level : Int, file : AbFile, isRecursiveSearch : Boolean) : BasicArrayList = {
        val fileList : BasicArrayList = new BasicArrayListD()
        var recursiveFileList : BasicArrayList = null
        if (file.isDirectory()) {
            val fileArray : Array[Object] = file.listFiles()
            if (fileArray == null) {
                return fileList
            }
            val files : Array[AbFile] = FileWrapperUtil.wrapFiles(fileArray)
            if (files == null) {
                return fileList
            }

            {
                var index : Int = 0
                while (index < files.length) {
                    fileList.add(files(index))
                    if (level <= 0) {
                        return fileList
                    }
                    recursiveFileList = this.search(level - 1, files(index), isRecursiveSearch)
                    fileList.addAllList(recursiveFileList)
                    index += 1
                }
            }
        }
        return fileList
    }

}

object Directory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : Directory = new Directory()

    /**      * @return the instance      */
    def getInstance() : Directory = {
        return Directory.instance
    }

}


