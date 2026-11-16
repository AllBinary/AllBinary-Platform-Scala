/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

class PartnerIdentifierFileUtil {
    import _root_.org.allbinary.logic.system.security.licensing.PartnerIdentifierFileUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val FILE_NAME : String = "partner.txt"

    def get() : String = {
        try {
            val resourceUtil : ResourceUtil = ResourceUtil.getInstance()
            //int size = inputStreamReader.read(chars);
            var partnerString : String = StringUtil.getInstance().EMPTY_STRING
            //inputStreamReader.close();
            return partnerString
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.GET, e)
                return StringUtil.getInstance().NULL_STRING
            }
        }
        throw new IllegalStateException()
    }

}

object PartnerIdentifierFileUtil {
    private val instance : PartnerIdentifierFileUtil = new PartnerIdentifierFileUtil()

    def getInstance() : PartnerIdentifierFileUtil = {
        return PartnerIdentifierFileUtil.instance
    }

}


