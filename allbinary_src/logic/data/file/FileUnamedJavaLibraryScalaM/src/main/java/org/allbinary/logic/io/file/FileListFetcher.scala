/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file

import _root_.org.allbinary.logic.io.file.directory.DirectoryBooleanFileVisitor
import _root_.org.allbinary.logic.io.file.directory.DirectoryOrIncludeFileExtensionAndTrackedBooleanFileVisitor
import _root_.org.allbinary.logic.io.file.directory.DirectoryOrIncludeFileExtensionBooleanFileVisitor
import _root_.org.allbinary.logic.io.file.directory.SubDirectory
import _root_.org.allbinary.logic.io.file.filter.VisitorFileFilter
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

/**  *  * @author User  */
class FileListFetcher {
    import _root_.org.allbinary.logic.io.file.FileListFetcher.{*}

    private val subDirectory : SubDirectory = SubDirectory.getInstance()

    def getFiles(path : String) : BasicArrayList = {
        try {
            val files : BasicArrayList = this.subDirectory.search(AbFile.createAbFile(path))
            return files
        } catch {
            case e : Exception => {
                e.printStackTrace()
                System.out.println((("Error: " + e) + "\nMsg: ") + e.getMessage())
            }
        }
        return null
    }

    def getFiles(path : String, includeExtensions : Array[String]) : BasicArrayList = {
        try {
            val includeExtensionBasicArrayList : BasicArrayList = new BasicArrayListD()
            val size : Int = includeExtensions.length

            {
                var index : Int = 0
                while (index < size) {
                    includeExtensionBasicArrayList.add(includeExtensions(index))
                    index += 1
                }
            }
            val visitorFileFilter : VisitorFileFilter = new VisitorFileFilter(new DirectoryOrIncludeFileExtensionBooleanFileVisitor(includeExtensionBasicArrayList))
            val files : BasicArrayList = this.subDirectory.search(visitorFileFilter, AbFile.createAbFile(path))
            return files
        } catch {
            case e : Exception => {
                e.printStackTrace()
                System.out.println((("Error: " + e) + "\nMsg: ") + e.getMessage())
            }
        }
        return null
    }

    def getFiles(path : String, includeExtension : String) : BasicArrayList = {
        try {
            val includeExtensionBasicArrayList : BasicArrayList = new BasicArrayListD()
            includeExtensionBasicArrayList.add(includeExtension)
            val visitorFileFilter : VisitorFileFilter = new VisitorFileFilter(new DirectoryOrIncludeFileExtensionBooleanFileVisitor(includeExtensionBasicArrayList))
            val files : BasicArrayList = this.subDirectory.search(visitorFileFilter, AbFile.createAbFile(path))
            return files
        } catch {
            case e : Exception => {
                e.printStackTrace()
                System.out.println((("Error: " + e) + "\nMsg: ") + e.getMessage())
            }
        }
        return null
    }

    def getFiles(path : String, pathIncludes : String, includeExtension : String) : BasicArrayList = {
        try {
            val includeExtensionBasicArrayList : BasicArrayList = new BasicArrayListD()
            includeExtensionBasicArrayList.add(includeExtension)
            val visitorFileFilter : VisitorFileFilter = new VisitorFileFilter(new DirectoryOrIncludeFileExtensionBooleanFileVisitor(includeExtensionBasicArrayList, pathIncludes))
            val files : BasicArrayList = this.subDirectory.search(visitorFileFilter, AbFile.createAbFile(path))
            return files
        } catch {
            case e : Exception => {
                e.printStackTrace()
                System.out.println((("Error: " + e) + "\nMsg: ") + e.getMessage())
            }
        }
        return null
    }

    def getTrackedFiles(path : String, includeExtensions : Array[String]) : BasicArrayList = {
        try {
            val includeExtensionBasicArrayList : BasicArrayList = new BasicArrayListD()
            val size : Int = includeExtensions.length

            {
                var index : Int = 0
                while (index < size) {
                    includeExtensionBasicArrayList.add(includeExtensions(index))
                    index += 1
                }
            }
            val visitorFileFilter : VisitorFileFilter = new VisitorFileFilter(new DirectoryOrIncludeFileExtensionAndTrackedBooleanFileVisitor(includeExtensionBasicArrayList))
            val files : BasicArrayList = this.subDirectory.search(visitorFileFilter, AbFile.createAbFile(path))
            return files
        } catch {
            case e : Exception => {
                e.printStackTrace()
                System.out.println((("Error: " + e) + "\nMsg: ") + e.getMessage())
            }
        }
        return null
    }

    def getTrackedFiles(path : String, includeExtension : String) : BasicArrayList = {
        try {
            val includeExtensionBasicArrayList : BasicArrayList = new BasicArrayListD()
            includeExtensionBasicArrayList.add(includeExtension)
            val visitorFileFilter : VisitorFileFilter = new VisitorFileFilter(new DirectoryOrIncludeFileExtensionAndTrackedBooleanFileVisitor(includeExtensionBasicArrayList))
            val files : BasicArrayList = this.subDirectory.search(visitorFileFilter, AbFile.createAbFile(path))
            return files
        } catch {
            case e : Exception => {
                e.printStackTrace()
                System.out.println((("Error: " + e) + "\nMsg: ") + e.getMessage())
            }
        }
        return null
    }

    def getDirectories(path : String) : BasicArrayList = {
        try {
            val visitorFileFilter : VisitorFileFilter = new VisitorFileFilter(new DirectoryBooleanFileVisitor())
            val files : BasicArrayList = this.subDirectory.search(visitorFileFilter, AbFile.createAbFile(path))
            return files
        } catch {
            case e : Exception => {
                e.printStackTrace()
                System.out.println((("Error: " + e) + "\nMsg: ") + e.getMessage())
            }
        }
        return null
    }

}

object FileListFetcher {
    private val instance : FileListFetcher = new FileListFetcher()

    /**      * @return the instance      */
    def getInstance() : FileListFetcher = {
        return FileListFetcher.instance
    }

}


