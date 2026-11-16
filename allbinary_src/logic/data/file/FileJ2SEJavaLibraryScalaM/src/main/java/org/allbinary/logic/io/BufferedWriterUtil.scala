/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io

import _root_.java.io.BufferedWriter
import _root_.java.io.FileWriter
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.AbFileNativeUtil
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings

class BufferedWriterUtil {
    import _root_.org.allbinary.logic.io.BufferedWriterUtil.{*}

    private val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val commonLabels : CommonLabels = CommonLabels.getInstance()

    private val REMOVING_OLD : String = "Remove old for overwriting: "

    def overwrite(path : String, data : String) : Unit = {
        val abFile : AbFile = AbFile.createAbFile(path)
        if (abFile.exists()) {
            this.logUtil.putF(this.REMOVING_OLD + path, this, this.commonStrings.CREATE)
            abFile.delete()
        } else {
            //Create all of the directories that the file needs when it does not exist already.
            val name : String = AbPathData.getInstance().removeNameFromPath(path)
            val abFileDirectory : AbFile = AbFile.createAbFile(name)
            if (abFileDirectory.exists()) {
            } else {
                val stringBuilder : StringMaker = new StringMaker()
                this.logUtil.putF(stringBuilder.append(this.commonStrings.CREATE).append(this.commonLabels.COLON_SEP).append(name).toString(), this, this.commonStrings.CREATE)
                var result : Boolean = abFileDirectory.mkdirs()
                stringBuilder.delete(0, stringBuilder.length())
                this.logUtil.putF(stringBuilder.append(this.commonLabels.RESULT_).appendboolean(result).toString(), this, this.commonStrings.CREATE)
            }
        }
        this.write(abFile, data)
    }

    def overwrite(abFile : AbFile, data : String) : Unit = {
        if (abFile.exists()) {
            this.logUtil.putF(this.REMOVING_OLD + abFile.getPath(), this, this.commonStrings.CREATE)
            abFile.delete()
        } else {
            //Create all of the directories that the file needs when it does not exist already.
            val name : String = AbPathData.getInstance().removeNameFromPath(abFile.getAbsolutePath())
            val abFileDirectory : AbFile = AbFile.createAbFile(name)
            if (abFileDirectory.exists()) {
            } else {
                val stringBuilder : StringMaker = new StringMaker()
                this.logUtil.putF(stringBuilder.append(this.commonStrings.CREATE).append(this.commonLabels.COLON_SEP).append(name).toString(), this, this.commonStrings.CREATE)
                var result : Boolean = abFileDirectory.mkdirs()
                stringBuilder.delete(0, stringBuilder.length())
                this.logUtil.putF(stringBuilder.append(this.commonLabels.RESULT_).appendboolean(result).toString(), this, this.commonStrings.CREATE)
            }
        }
        this.write(abFile, data)
    }

    def write(abFile : AbFile, data : String) : Unit = {
        val fileOut : BufferedWriter = new BufferedWriter(new FileWriter(AbFileNativeUtil.get(abFile)))
        fileOut.write(data, 0, data.length())
        fileOut.newLine()
        fileOut.flush()
    }

}

object BufferedWriterUtil {
    private val instance : BufferedWriterUtil = new BufferedWriterUtil()

    /**      * @return the instance      */
    def getInstance() : BufferedWriterUtil = {
        return BufferedWriterUtil.instance
    }

}


