/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot * */
/* Generated Code Do Not Modify */
package org.allbinary.layer

import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonSeps

/**  *  * @author User  */
class LayerManagerLogging extends LayerManagerLoggingBase {
    import _root_.org.allbinary.layer.LayerManagerLogging.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val stringBuilder : StringMaker = new StringMaker()

    private val APPEND : String = "append"

    private val APPEND_ : String = " append: "

    private val _AT_ : String = " at: "

    private val ATTEMPT_REMOVE_ : String = " Remove Attempt: "

    private val REMOVE_ : String = " Remove: "

    private val REMOVE : String = "remove"

    private val DID_NOT_REMOVE : String = " Did not remove: "

    private val CLEAR : String = " Clear List"

    override def append(layerInterface : AllBinaryLayer) : Unit = {
        this.stringBuilder.delete(0, this.stringBuilder.length())
        this.logUtil.putF(this.stringBuilder.appendint(TsUtil.getInstance().hashCode(this)).append(this.APPEND_).append(layerInterface.getName()).toString(), this, this.APPEND)
    }

    override def appendAt(layerInterface : AllBinaryLayer, index : Int) : Unit = {
        this.stringBuilder.delete(0, this.stringBuilder.length())
        this.logUtil.putF(this.stringBuilder.appendint(TsUtil.getInstance().hashCode(this)).append(this.APPEND_).append(layerInterface.getName()).append(this._AT_).appendint(index).toString(), this, this.APPEND)
    }

    override def remove(layerInterface : AllBinaryLayer) : Unit = {
        if (layerInterface == null) {
            this.stringBuilder.delete(0, this.stringBuilder.length())
            this.logUtil.putF(this.stringBuilder.appendint(TsUtil.getInstance().hashCode(this)).append(this.ATTEMPT_REMOVE_).append(StringUtil.getInstance().toString(layerInterface)).toString(), this, this.REMOVE)
        } else {
            this.stringBuilder.delete(0, this.stringBuilder.length())
            this.logUtil.putF(this.stringBuilder.appendint(TsUtil.getInstance().hashCode(this)).append(this.ATTEMPT_REMOVE_).append(layerInterface.getName()).toString(), this, this.REMOVE)
        }
    }

    override def removeResult(layerManager : LayerManager, layerInterface : AllBinaryLayer, result : Boolean) : Unit = {
        if (layerInterface == null) {
            this.stringBuilder.delete(0, this.stringBuilder.length())
            this.logUtil.putF(this.stringBuilder.appendint(TsUtil.getInstance().hashCode(this)).append(this.REMOVE_).append(StringUtil.getInstance().toString(layerInterface)).toString(), this, this.REMOVE)
        } else if (result) {
            if (LayerManagerLogging.removeFailed) {
                this.stringBuilder.delete(0, this.stringBuilder.length())
                this.logUtil.putF(this.stringBuilder.appendint(TsUtil.getInstance().hashCode(this)).append(this.REMOVE_).append(layerInterface.getName()).toString(), this, this.REMOVE)
            }
        } else {
            this.stringBuilder.delete(0, this.stringBuilder.length())
            //this.logUtil.put(stringBuilder.append(DID_NOT_REMOVE).append(layerInterface.toString()).toString(), this, REMOVE, new Exception());
            this.logUtil.putF(this.stringBuilder.appendint(TsUtil.getInstance().hashCode(this)).append(this.DID_NOT_REMOVE).append(layerInterface.getName()).toString(), this, this.REMOVE)
            //this.log(layerManager);
            LayerManagerLogging.removeFailed = true
        }
    }

    private def log(layerManager : LayerManager) : Unit = {
        this.stringBuilder.delete(0, this.stringBuilder.length())
        val size : Int = layerManager.getSize()
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        this.stringBuilder.append(Integer.toHexString(TsUtil.getInstance().hashCode(layerManager))).append(commonSeps.COLON_SEP)
        this.stringBuilder.appendint(size).append(commonSeps.COLON_SEP)
        var allBinaryLayer : AllBinaryLayer = null

        {
            var index : Int = 0
            while (index < size) {
                allBinaryLayer = (layerManager.getLayerAt(index).asInstanceOf[AllBinaryLayer])
                this.stringBuilder.append(allBinaryLayer.getName()).append(commonSeps.COMMA)
                index += 1
            }
        }
        this.logUtil.putF(this.stringBuilder.toString(), this, this.REMOVE)
    }

    override def clear() : Unit = {
        this.stringBuilder.delete(0, this.stringBuilder.length())
        this.logUtil.putF(this.stringBuilder.appendint(TsUtil.getInstance().hashCode(this)).append(this.CLEAR).toString(), this, this.CLEAR)
    }

}

object LayerManagerLogging {
    private val instance : LayerManagerLogging = new LayerManagerLogging()

    /**      * @return the instance      */
    def getInstance() : LayerManagerLogging = {
        return LayerManagerLogging.instance
    }

    private var removeFailed : Boolean = false

}


