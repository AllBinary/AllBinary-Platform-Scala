/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListUtil

class NoButtonsBuilder extends BaseTouchInput {

    val logUtil : LogUtil = LogUtil.getInstance()

    override def getList() : BasicArrayList = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
            val list : BasicArrayList = BasicArrayListUtil.getInstance().getImmutableInstance()
            return list
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.GET_LIST, e)
                return BasicArrayListUtil.getInstance().getImmutableInstance()
            }
        }
        throw new IllegalStateException()
    }

}


