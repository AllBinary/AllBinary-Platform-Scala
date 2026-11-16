/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http

import _root_.org.allbinary.string.CommonSeps

class HttpData private() {
    import _root_.org.allbinary.logic.communication.http.HttpData.{*}

    var EQUALS : String = null

    var PARAM_SEP : String = null

    var URL_PARAM_SEP : String = null

    val URL_LABEL : String = "Url: "

    //Constructor
    {
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        this.EQUALS = commonSeps.EQUALS
        this.PARAM_SEP = commonSeps.AMPERSAND
        this.URL_PARAM_SEP = commonSeps.QUESTION
    }

}

object HttpData {
    private val instance : HttpData = new HttpData()

    /**      * @return the instance      */
    def getInstance() : HttpData = {
        return HttpData.instance
    }

}


