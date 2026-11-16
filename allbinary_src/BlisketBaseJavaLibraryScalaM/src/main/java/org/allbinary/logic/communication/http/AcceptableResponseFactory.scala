/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http


class AcceptableResponseFactory {
    import _root_.org.allbinary.logic.communication.http.AcceptableResponseFactory.{*}

    val HTML : AcceptableResponse = new AcceptableResponse("text/html", "html", 0)

    val WML : AcceptableResponse = new AcceptableResponse("text/wml", "wml", 1)

    val VXML : AcceptableResponse = new AcceptableResponse("text/vxml", "vxml", 2)

}

object AcceptableResponseFactory {
    private val instance : AcceptableResponseFactory = new AcceptableResponseFactory()

    def getInstance() : AcceptableResponseFactory = {
        return AcceptableResponseFactory.instance
    }

}


