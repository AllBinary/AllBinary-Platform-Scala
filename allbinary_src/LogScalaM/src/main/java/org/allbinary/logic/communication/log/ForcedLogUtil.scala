/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.PreLogUtil

class ForcedLogUtil {
    import _root_.org.allbinary.logic.communication.log.ForcedLogUtil.{*}

}

object ForcedLogUtil {
    //"Should not be called"
    def log(message : String, anyType : Object) : Unit = {
        try {
            throw new Exception(message)
        } catch {
            case e : Exception => {
                //this.logUtil.put(CommonStrings.getInstance().EXCEPTION, object, "log", e);
                PreLogUtil.putOE(CommonStrings.getInstance().EXCEPTION, anyType, "log", e)
            }
        }
    }

}


