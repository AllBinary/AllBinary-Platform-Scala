/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io


class AbIOSystem {
    import _root_.org.allbinary.logic.io.AbIOSystem.{*}

    private val `type` : String = "java.io"

    /**      * @return the type      */
    def getType() : String = {
        return this.`type`
    }

    def isType(`type` : String) : Boolean = {
        if (this.`type`.compareTo(`type`) == 0) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

}

object AbIOSystem {
    private val instance : AbIOSystem = new AbIOSystem()

    /**      * @return the instance      */
    def getInstance() : AbIOSystem = {
        return AbIOSystem.instance
    }

}


