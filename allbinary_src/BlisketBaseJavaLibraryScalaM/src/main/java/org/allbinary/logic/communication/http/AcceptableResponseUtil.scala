/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.StdUtil

class AcceptableResponseUtil {
    import _root_.org.allbinary.logic.communication.http.AcceptableResponseUtil.{*}

    val candidateVector : BasicArrayList = new BasicArrayListD()

    val tagNameVector : BasicArrayList = new BasicArrayListD()

    def get(index : Int) : String = {
        return this.candidateVector.get(index).asInstanceOf[String]
    }

    def getTagName(index : Int) : String = {
        return this.tagNameVector.get(index).asInstanceOf[String]
    }

    def size() : Int = {
        return this.candidateVector.size()
    }

}

object AcceptableResponseUtil {
    private val instance : AcceptableResponseUtil = new AcceptableResponseUtil()

    def getInstance() : AcceptableResponseUtil = {
        return AcceptableResponseUtil.instance
    }

    {
        TsUtil.getInstance().hashCode(AcceptableResponseFactory.getInstance().HTML)
    }

}


