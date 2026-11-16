/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.AbFileInputStream
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author User  */
class FileUtil2 private() {
    import _root_.org.allbinary.logic.io.file.FileUtil2.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val streamUtil : StreamUtil = StreamUtil.getInstance()

    def loadFileAsList(file : AbFile, max : Int, byteArray1 : Array[Byte]) : BasicArrayList = {
        var inputStream : AbFileInputStream = null
        try {
            inputStream = AbFileInputStream.createFromAbFile(file)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.ADD, e)
            }
        }
        return SimpleFileUtil.getInstance().loadFileAsList(inputStream, max, byteArray1)
    }

}

object FileUtil2 {
    private val instance : FileUtil2 = new FileUtil2()

    /**      * @return the instance      */
    def getInstance() : FileUtil2 = {
        return FileUtil2.instance
    }

}


