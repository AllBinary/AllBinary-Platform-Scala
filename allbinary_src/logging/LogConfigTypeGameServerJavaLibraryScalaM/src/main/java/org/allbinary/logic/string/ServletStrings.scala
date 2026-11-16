/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.string


/**  *  * @author user  */
class ServletStrings {
    import _root_.org.allbinary.logic.string.ServletStrings.{*}

    val DOPOST : String = "doPost"

    val DOGET : String = "doGet"

    val REQUEST_EXCEPTION : String = "Request Failed"

}

object ServletStrings {
    private val instance : ServletStrings = new ServletStrings()

    /**      * @return the instance      */
    def getInstance() : ServletStrings = {
        return ServletStrings.instance
    }

}


