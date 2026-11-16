/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.types


class AuthorizationTypeFactory {
    import _root_.org.allbinary.business.user.commerce.money.payment.types.AuthorizationTypeFactory.{*}

    val NONE : AuthorizationType = new AuthorizationType("None")

    val VOICE : AuthorizationType = new AuthorizationType("Voice")

    val RETINAL : AuthorizationType = new AuthorizationType("Retinal")

    val IMAGE : AuthorizationType = new AuthorizationType("Image")

    val DNA : AuthorizationType = new AuthorizationType("DNA")

    val PRINT : AuthorizationType = new AuthorizationType("Print")

    val CHIP : AuthorizationType = new AuthorizationType("Chip")

}

object AuthorizationTypeFactory {
    private val instance : AuthorizationTypeFactory = new AuthorizationTypeFactory()

    def getInstance() : AuthorizationTypeFactory = {
        return AuthorizationTypeFactory.instance
    }

}


