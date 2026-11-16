/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.resources

import _root_.org.allbinary.game.configuration.GameConfigurationCentral
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

class BasicGameResources() {
    import _root_.org.allbinary.game.layer.resources.BasicGameResources.{stringBuffer as _, *}
    def stringBuffer : StringMaker = _root_.org.allbinary.game.layer.resources.BasicGameResources.stringBuffer

    val logUtil : LogUtil = LogUtil.getInstance()

    var RESOURCE : String = StringUtil.getInstance().EMPTY_STRING

    var RESOURCE_DESTROY : String = StringUtil.getInstance().EMPTY_STRING

    def init(ROOT : String, SIZE : Array[String]) : Unit = {
        try {
            var scale : Int = GameConfigurationCentral.getInstance().SCALE.getValue().intValue()
            if ((scale > 1) && ((scale - 1) < SIZE.length)) {
                this.append(ROOT, SIZE(scale - 1))
            } else {
                throw new Exception(new StringMaker().append("Invalid Value: ").appendint(scale).toString())
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.INIT, e)
            }
        }
    }

    def append(ROOT : String, sizeString : String) : Unit = {
        val DESTROY : String = "_destroy"
        val string : String = this.getString()
        BasicGameResources.stringBuffer.delete(0, BasicGameResources.stringBuffer.length())
        BasicGameResources.stringBuffer.append(ROOT)
        BasicGameResources.stringBuffer.append(string)
        BasicGameResources.stringBuffer.append(sizeString)
        this.RESOURCE = BasicGameResources.stringBuffer.toString()
        BasicGameResources.stringBuffer.delete(0, BasicGameResources.stringBuffer.length())
        BasicGameResources.stringBuffer.append(ROOT)
        BasicGameResources.stringBuffer.append(DESTROY)
        BasicGameResources.stringBuffer.append(string)
        BasicGameResources.stringBuffer.append(sizeString)
        this.RESOURCE_DESTROY = BasicGameResources.stringBuffer.toString()
    }

    def getString() : String = {
        return GameGraphicsResourceUtil.getInstance().getName()
    }

}

object BasicGameResources {
    val stringBuffer : StringMaker = new StringMaker()

}


