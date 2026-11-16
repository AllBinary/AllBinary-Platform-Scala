/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.info

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class EmailInfo private () {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var basicEmailInfo : BasicEmailInfo = null

    private var htmlAttachment : String = null

    private var contentBase : String = null

    def this(basicEmailInfo : BasicEmailInfo, htmlAttachment : String, contentBase : String) = {
        this()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            this.logUtil.putF(commonStrings.START, this, commonStrings.CONSTRUCTOR)
        }
        this.init(basicEmailInfo, null, null)
    }

    def this(basicEmailInfo : BasicEmailInfo) = {
        this()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            this.logUtil.putF(commonStrings.START, this, commonStrings.CONSTRUCTOR)
        }
        this.init(basicEmailInfo, null, null)
    }

    private def init(basicEmailInfo : BasicEmailInfo, htmlAttachment : String, contentBase : String) : Unit = {
        this.basicEmailInfo = basicEmailInfo
        this.htmlAttachment = htmlAttachment
        this.contentBase = contentBase
    }

    def getBasicEmailInfo() : BasicEmailInfo = {
        return this.basicEmailInfo
    }

    def getHtmlAttachment() : String = {
        return this.htmlAttachment
    }

    def getContentBase() : String = {
        return this.contentBase
    }

    override def toString() : String = {
        return "Email Info: \n " + this.getBasicEmailInfo().toString()
    }

}


