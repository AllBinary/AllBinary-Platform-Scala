/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.path

import _root_.org.allbinary.logic.io.file.FilePathData
import _root_.org.allbinary.logic.io.file.FilePathUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.string.CommonSeps

class AbPath(param_aPath : String, param_name : String) {
    import _root_.org.allbinary.logic.io.path.AbPath.{*}

    private val commonSeps : CommonSeps = CommonSeps.getInstance()

    private val abPathData : AbPathData = AbPathData.getInstance()

    private val abPathUtil : PathUtil = PathUtil.getInstance()

    private val EMPTY_STRING : String = StringUtil.getInstance().EMPTY_STRING

    var schema : String = this.EMPTY_STRING

    private var path : String = this.EMPTY_STRING

    //private int port;
    var nameP : String = this.EMPTY_STRING

    private var hasSchemaP : Boolean = false

    private var numberOfSeps : Int = 0

    //Constructor
    {
        val aPath : String = param_aPath
        val name : String = param_name
        val stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        if (!stringValidationUtil.isEmpty(aPath)) {
            this.schema = this.getSchema(aPath)
            //this.name = AbPathUtil.getName(aPath);
            this.nameP = name
            this.path = this.abPathUtil.adjustEnd(this.abPathUtil.adjust(this.getPathFromPath(aPath)))
        } else {
            this.init()
            if (!stringValidationUtil.isEmpty(name)) {
                this.nameP = name
            }
        }
    }

    private def init() : Unit = {
        this.schema = this.EMPTY_STRING
        this.setPath(this.abPathData.SEPARATOR)
        //this.port = -1;  //use the schemas default port
        this.nameP = this.EMPTY_STRING
    }

    def getSchema(aPath : String) : String = {
        var beginIndex : Int = aPath.indexOf(this.commonSeps.COLON)
        if (beginIndex >= 0) {
            this.hasSchemaP = true
            return aPath.substring(0, beginIndex)
        }
        this.hasSchemaP = false
        return this.EMPTY_STRING
    }

    def hasSchema() : Boolean = {
        return this.hasSchemaP
    }

    def getPathFromPath(aPath : String) : String = {
        val filePathData : FilePathData = FilePathData.getInstance()
        var tempPath : String = aPath
        /*       if(!this.hasName())       {          this.path = AbPathUtil.adjustEnd(this.path);       }        */
        if (!this.hasSchema()) {
            tempPath = this.abPathUtil.adjustStart(tempPath)
        } else {
            var beginIndex : Int = tempPath.indexOf(this.commonSeps.COLON)
            if (beginIndex >= 0) {
                beginIndex += 1

                {
                    while ((tempPath.charAt(beginIndex) == this.abPathData.SEPARATORCHAR) || (tempPath.charAt(beginIndex) == filePathData.SEPARATORCHAR)) {
                        beginIndex += 1
                        this.numberOfSeps += 1
                        if (this.numberOfSeps > 2) {
                            throw new Exception("Should Not Have More Than Two Seps")
                        }
                    }
                }
                tempPath = tempPath.substring(beginIndex, tempPath.length())
            }
        }
        return tempPath
    }

    def setName(name : String) : Unit = {
        this.nameP = name
    }

    def getName() : String = {
        return this.nameP
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        if (this.hasSchema()) {
            stringBuffer.append(this.schema)
            //unix/networke schema sep
            stringBuffer.append(AbPath.NETWORK_SEP)
        }
        stringBuffer.append(this.getPath())
        stringBuffer.append(this.nameP)
        /*       if(this.hasName())       {       }        */
        return stringBuffer.toString()
    }

    //this.getSchema() + "://" + this.getServer() + CommonSeps.getInstance().COLON + this.getPort() + AbPathData.SEPARATOR;
    def toFileSystemString() : String = {
        if (this.hasSchema()) {
            val filePathData : FilePathData = FilePathData.getInstance()
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(this.schema)
            stringBuffer.append(this.commonSeps.COLON)
            stringBuffer.append(filePathData.PATH_START)
            stringBuffer.append(FilePathUtil.adjust(this.getPath()))
            stringBuffer.append(this.nameP)
            return stringBuffer.toString()
        } else {
            return FilePathUtil.adjust(this.getPath()) + this.nameP
        }
        throw new IllegalStateException()
    }

    /**      * @return the path      */
    def getPath() : String = {
        return this.path
    }

    /**      * @param path the path to set      */
    def setPath(path : String) : Unit = {
        this.path = path
    }

}

object AbPath {
    def createAbPath() : AbPath = {
        try {
            val EMPTY_STRING : String = StringUtil.getInstance().EMPTY_STRING
            return new AbPath(EMPTY_STRING, EMPTY_STRING)
        } catch {
            case ex : Exception => {
                throw new RuntimeException()
            }
        }
        throw new IllegalStateException()
    }

    private val NETWORK_SEP : String = ":/"

}


