/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.hardware.android

import _root_.java.io.Closeable
import _root_.java.io.FileReader
import _root_.java.io.LineNumberReader
import _root_.org.allbinary.logic.io.NullCloseable
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.hardware.HardwareInterface
import _root_.org.allbinary.logic.system.hardware.components.android.UnknownHardware
import _root_.org.allbinary.logic.system.hardware.components.interfaces.HardwareComponentInterface
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

/**  *  * @author Berthelot, Travis  * @version 1.0  */
class AndroidHardware() extends HardwareInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var componentInterfaceVector : BasicArrayList = new BasicArrayListD()

    private val PROC_BUS_INPUT_DIRECTORY : String = "/proc/bus/input/"

    private val DEVICES : String = this.PROC_BUS_INPUT_DIRECTORY + "devices/"

    //private final String HANDLERS = PROC_BUS_INPUT_DIRECTORY + "handlers/";
    private val MINHARDWARE : Int = 3

    //Constructor
    {
        this.init(this.DEVICES)
        val size : Int = this.componentInterfaceVector.size()
        if (size < this.MINHARDWARE) {
            throw new Exception("Not Enough Data For A Valid License On Linux")
        }
    }

    private def init(filePath : String) : Unit = {
        var lineNumberReader : Closeable = NullCloseable.NULL_CLOSEABLE
        try {
            lineNumberReader = this.get(filePath)
        } catch {
            case e : Exception => {
                this.logUtil.put("Hardware Data: " + this.toString(), this, this.commonStrings.INIT, e)
                throw e
            }
        } finally {
            if (lineNumberReader != null) {
                //this.logUtil.putF("closing", this, this.commonStrings.INIT);
                lineNumberReader.close()
            }
        }
    }

    private def get(filePath : String) : LineNumberReader = {
        this.componentInterfaceVector = new BasicArrayListD()
        val pciFile : FileReader = new FileReader(filePath)
        val lineNumberReader : LineNumberReader = new LineNumberReader(pciFile)
        //{
        this.logUtil.putF("File Found", this, this.commonStrings.CONSTRUCTOR)
        var nextLine : String = lineNumberReader.readLine()
        //lineNumberReader != null && 

        {
            while (nextLine != null) {
                //this.logUtil.putF("Found Hardware Device: " + componentInterfaceVector.size(), this, this.commonStrings.INIT);
                nextLine = lineNumberReader.readLine()
                this.componentInterfaceVector.add(new UnknownHardware(nextLine))
            }
        }
        /*             else             {                 this.logUtil.putF("Could not load File", this, this.commonStrings.INIT);             }          */
        return lineNumberReader
    }

    override def getComponent(index : Int) : HardwareComponentInterface = {
        return this.componentInterfaceVector.get(index).asInstanceOf[HardwareComponentInterface]
    }

    override def toString() : String = {
        val stringBuilder : StringMaker = new StringMaker()
        val size : Int = this.componentInterfaceVector.size()
        //stringBuilder.appendint(size);

        {
            var index : Int = 0
            while (index < size) {
                var componentInterface : HardwareComponentInterface = this.componentInterfaceVector.get(index).asInstanceOf[HardwareComponentInterface]
                stringBuilder.append(componentInterface.toString())
                stringBuilder.append(CommonSeps.getInstance().NEW_LINE)
                index += 1
            }
        }
        return stringBuilder.toString()
    }

    override def compareTo(hardwareInterface : HardwareInterface) : Boolean = {
        return true
    }

    override def difference(hardwareInterface : HardwareInterface) : ABHashtable[Object, Object] = {
        return StdUtil.getInstance().NULL_TABLE
    }

}


