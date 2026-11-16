/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class AcceptableResponse(param_candidate : String, param_tagName : String, param_index : Int) {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    //Constructor
    {
        val candidate : String = param_candidate
        val tagName : String = param_tagName
        val index : Int = param_index
        this.logUtil.putF(tagName, this, this.commonStrings.CONSTRUCTOR)
        var acceptableResponseUtil : AcceptableResponseUtil = AcceptableResponseUtil.getInstance()
        acceptableResponseUtil.candidateVector.addAt(index, candidate)
        acceptableResponseUtil.tagNameVector.addAt(index, tagName)
    }

}


