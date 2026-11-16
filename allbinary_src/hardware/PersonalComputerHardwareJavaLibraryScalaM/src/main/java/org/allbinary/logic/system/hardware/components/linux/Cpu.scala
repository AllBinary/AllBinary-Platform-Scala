/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.hardware.components.linux

import _root_.java.io.FileReader
import _root_.java.io.LineNumberReader
import _root_.java.util.HashMap
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.FilePathData
import _root_.org.allbinary.logic.io.file.directory.SubDirectory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.hardware.components.interfaces.CpuInterface
import _root_.org.allbinary.logic.system.hardware.components.interfaces.HardwareComponentInterface
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList

class Cpu() extends CpuInterface with HardwareComponentInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val CPUFILE : String = "/proc/cpuinfo"

    private var cpuHashMap : HashMap[Object, Object] = null

    //Constructor
    {
        this.init(this.CPUFILE)
    }

    def this(filePath : String) = {
        this()
        this.init(filePath)
    }

    private def init(filePath : String) : Unit = {
        var lineNumberReader : LineNumberReader = null
        try {
            this.init(lineNumberReader, filePath)
        } catch {
            case e : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().OS)) {
                    this.logUtil.put(new StringMaker().append("Cpu Data: ").append(this.toString()).toString(), this, this.commonStrings.CONSTRUCTOR, e)
                }
                throw e
            }
        }
    }

    private def init(param_lineNumberReader : LineNumberReader, filePath : String) : Unit = {
        var lineNumberReader : LineNumberReader = param_lineNumberReader
        try {
            var fileReader : FileReader = new FileReader(filePath)
            lineNumberReader = new LineNumberReader(fileReader)
            this.cpuHashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            if (lineNumberReader == null) {
                //Find file
                val fileVector : BasicArrayList = SubDirectory.getInstance().search(filePath, AbFile.createAbFile(FilePathData.getInstance().PATH_START))
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().OS)) {
                    this.logUtil.putF(new StringMaker().append("Cpu File BasicArrayList Size: ").appendint(fileVector.size()).toString(), this, this.commonStrings.CONSTRUCTOR)
                }
                //size() > 0
                if (!fileVector.isEmpty()) {
                    var file : AbFile = fileVector.get(0).asInstanceOf[AbFile]
                    lineNumberReader = new LineNumberReader(new FileReader(file.getPath()))
                }
            }
            if (lineNumberReader != null) {
                var nextLine : String = lineNumberReader.readLine()
                //lineNumberReader != null && 

                {
                    while (nextLine != null) {
                        var index : Int = nextLine.indexOf(':')
                        if (index >= 0) {
                            var key : String = nextLine.substring(0, index)
                            var valueIndex : Int = index + 1
                            var value : String = nextLine.substring(valueIndex, nextLine.length())
                            if (key.indexOf(CpuInfo.PROCESSOR.toString()) >= 0) {
                                this.cpuHashMap.put(CpuInfo.PROCESSOR, value)
                            }
                            if (key.indexOf(CpuInfo.VENDORID.toString()) >= 0) {
                                this.cpuHashMap.put(CpuInfo.VENDORID, value)
                            }
                            if (key.indexOf(CpuInfo.CPUFAMILY.toString()) >= 0) {
                                this.cpuHashMap.put(CpuInfo.CPUFAMILY, value)
                            }
                            if (key.indexOf(CpuInfo.MODEL.toString()) >= 0) {
                                this.cpuHashMap.put(CpuInfo.MODEL, value)
                            }
                            if (key.indexOf(CpuInfo.MODELNAME.toString()) >= 0) {
                                this.cpuHashMap.put(CpuInfo.MODELNAME, value)
                            }
                            if (key.indexOf(CpuInfo.STEPPING.toString()) >= 0) {
                                this.cpuHashMap.put(CpuInfo.STEPPING, value)
                            }
                            if (key.indexOf(CpuInfo.CPUMHZ.toString()) >= 0) {
                                this.cpuHashMap.put(CpuInfo.CPUMHZ, value)
                            }
                            if (key.indexOf(CpuInfo.CACHESIZE.toString()) >= 0) {
                                this.cpuHashMap.put(CpuInfo.CACHESIZE, value)
                            }
                        }
                        nextLine = lineNumberReader.readLine()
                    }
                }
            }
        } finally {
            if (lineNumberReader != null) {
                lineNumberReader.close()
            }
        }
    }

    def getProcessor() : String = {
        return this.cpuHashMap.get(CpuInfo.PROCESSOR).asInstanceOf[String]
    }

    def getVendorId() : String = {
        return this.cpuHashMap.get(CpuInfo.VENDORID).asInstanceOf[String]
    }

    def getCpuFamily() : String = {
        return this.cpuHashMap.get(CpuInfo.CPUFAMILY).asInstanceOf[String]
    }

    def getModel() : String = {
        return this.cpuHashMap.get(CpuInfo.MODEL).asInstanceOf[String]
    }

    def getModelName() : String = {
        return this.cpuHashMap.get(CpuInfo.MODELNAME).asInstanceOf[String]
    }

    def getStepping() : String = {
        return this.cpuHashMap.get(CpuInfo.STEPPING).asInstanceOf[String]
    }

    def getCpuSpeed() : String = {
        return this.cpuHashMap.get(CpuInfo.CPUMHZ).asInstanceOf[String]
    }

    def getCacheSize() : String = {
        return this.cpuHashMap.get(CpuInfo.CACHESIZE).asInstanceOf[String]
    }

    def compareTo(cpuInterface : CpuInterface) : Boolean = {
        return true
    }

    def compareTo(componentInterface : HardwareComponentInterface) : Boolean = {
        return true
    }

    override def toString() : String = {
        val commonLabels : CommonLabels = CommonLabels.getInstance()
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        val stringMaker : StringMaker = new StringMaker()
        stringMaker.append(CpuInfo.PROCESSOR.toString()).append(commonLabels.COLON_SEP).append(this.getProcessor())
        stringMaker.append(commonSeps.NEW_LINE)
        stringMaker.append(CpuInfo.VENDORID.toString()).append(commonLabels.COLON_SEP).append(this.getVendorId())
        stringMaker.append(commonSeps.NEW_LINE)
        stringMaker.append(CpuInfo.CPUFAMILY.toString()).append(commonLabels.COLON_SEP).append(this.getCpuFamily())
        stringMaker.append(commonSeps.NEW_LINE)
        stringMaker.append(CpuInfo.MODEL.toString()).append(commonLabels.COLON_SEP).append(this.getModel())
        stringMaker.append(commonSeps.NEW_LINE)
        stringMaker.append(CpuInfo.MODELNAME.toString()).append(commonLabels.COLON_SEP).append(this.getModelName())
        stringMaker.append(commonSeps.NEW_LINE)
        stringMaker.append(CpuInfo.STEPPING.toString()).append(commonLabels.COLON_SEP).append(this.getStepping())
        stringMaker.append(commonSeps.NEW_LINE)
        stringMaker.append(CpuInfo.CPUMHZ.toString()).append(commonLabels.COLON_SEP).append(this.getCpuSpeed())
        stringMaker.append(commonSeps.NEW_LINE)
        stringMaker.append(CpuInfo.CACHESIZE.toString()).append(commonLabels.COLON_SEP).append(this.getCacheSize())
        return stringMaker.toString()
    }

}


