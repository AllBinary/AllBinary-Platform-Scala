/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.log

import _root_.java.io.File
import _root_.java.io.FileOutputStream
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.input.automation.ImageOutputData
import _root_.org.allbinary.logic.java.number.LongUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

class FrameLog(param_frame : _root_.java.lang.Long) {
    import _root_.org.allbinary.input.automation.log.FrameLog.{*}

    private var frame : _root_.java.lang.Long = null

    private var infoStringBuffer : StringMaker = new StringMaker()

    private var actionsStringBuffer : StringMaker = new StringMaker()

    //Constructor
    {
        val frame : _root_.java.lang.Long = param_frame
        this.frame = frame
    }

    def addInfo(infoString : String) : Unit = {
        this.infoStringBuffer.append(infoString)
    }

    def addActions(vectorOfStrings : BasicArrayList) : Unit = {
        val size : Int = vectorOfStrings.size()

        {
            var index : Int = 0
            while (index < size) {
                this.addAction(vectorOfStrings.get(index).asInstanceOf[String])
                index += 1
            }
        }
    }

    def addAction(action : String) : Unit = {
        this.actionsStringBuffer.append(action)
        this.actionsStringBuffer.append(CommonSeps.getInstance().NEW_LINE)
    }

    def write() : Unit = {
        var filePathStringBuffer : StringMaker = new StringMaker()
        filePathStringBuffer.append(ImageOutputData.SAVE_PATH)
        filePathStringBuffer.append(LongUtil.fillIn(this.frame.toString()))
        filePathStringBuffer.append(".txt")
        var filePath : String = filePathStringBuffer.toString()
        var fileOutputStream : FileOutputStream = new FileOutputStream(new File(filePath))
        fileOutputStream.write(FrameLog.frameBytes)
        fileOutputStream.write(getFrame().toString().getBytes())
        fileOutputStream.write('\n')
        fileOutputStream.write(FrameLog.info)
        fileOutputStream.write(this.infoStringBuffer.toString().getBytes())
        fileOutputStream.write('\n')
        fileOutputStream.write(FrameLog.actions)
        fileOutputStream.write(this.actionsStringBuffer.toString().getBytes())
        fileOutputStream.close()
    }

    def getFrame() : _root_.java.lang.Long = {
        return this.frame
    }

}

object FrameLog {
    private var frameBytes : Array[Byte] = new String("Frame: ").getBytes()

    private var info : Array[Byte] = new String("Info: \n").getBytes()

    private var actions : Array[Byte] = new String("Actions: \n").getBytes()

}


