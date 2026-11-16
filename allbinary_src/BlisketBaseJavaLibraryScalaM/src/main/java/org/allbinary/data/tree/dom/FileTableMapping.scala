/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.dom

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tables.TableMappingInterface
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.FileData
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.io.path.PathUtil

class FileTableMapping(param_file : AbFile) extends TableMappingInterface {

    private var file : AbFile = null

    //Constructor
    {
        val file : AbFile = param_file
        this.file = file
    }

    def getKey() : Object = {
        return this.file.getPath().asInstanceOf[Object]
    }

    //Used for inserting into database   
    def toVector() : BasicArrayList = {
        val filePropertyVector : BasicArrayList = new BasicArrayListD()
        filePropertyVector.add(this.file.getAbsolutePath())
        filePropertyVector.add(this.file.getCanonicalPath())
        filePropertyVector.add(this.file.getName())
        filePropertyVector.add(this.file.getParent())
        filePropertyVector.add(this.file.getPath())
        return filePropertyVector
    }

    //Used for updating viewinfo in database   
    def toHashMap() : HashMap[Object, Object] = {
        val filePropertyHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        val pathData : AbPathData = AbPathData.getInstance()
        val pathUtil : PathUtil = PathUtil.getInstance()
        val rootFileName : String = pathData.getNameFromPath(pathUtil.getWithoutExtension(this.file.getPath()))
        val fileData : FileData = FileData.getInstance()
        filePropertyHashMap.put(fileData.ROOT_NAME, rootFileName)
        filePropertyHashMap.put(fileData.ISFILE, _root_.java.lang.Boolean.valueOf(this.file.isFile()).toString())
        filePropertyHashMap.put(fileData.ISDIRECTORY, _root_.java.lang.Boolean.valueOf(this.file.isDirectory()).toString())
        filePropertyHashMap.put(fileData.ISHIDDEN, _root_.java.lang.Boolean.valueOf(this.file.isHidden()).toString())
        filePropertyHashMap.put(fileData.ISABSOLUTE, _root_.java.lang.Boolean.valueOf(this.file.isAbsolute()).toString())
        filePropertyHashMap.put(fileData.ABSOLUTE_PATH, file.getAbsolutePath())
        filePropertyHashMap.put(fileData.CANONICAL_PATH, file.getCanonicalPath())
        filePropertyHashMap.put(fileData.NAME, file.getName())
        filePropertyHashMap.put(fileData.PARENT, file.getParent())
        filePropertyHashMap.put(fileData.PATH, file.getPath())
        return filePropertyHashMap
    }

}


