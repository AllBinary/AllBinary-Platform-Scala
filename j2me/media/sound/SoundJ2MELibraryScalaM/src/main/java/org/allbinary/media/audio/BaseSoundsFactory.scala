/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio


class BaseSoundsFactory extends SoundsFactoryInterface {

    private var initialized : Boolean = false

    override def init() : Unit = {
    }

    override def getSoundInterfaceArray() : Array[Sound] = {
        return new Array[Sound](0)
    }

    override def setInitialized(initialized : Boolean) : Unit = {
        this.initialized = initialized
    }

    override def isInitialized() : Boolean = {
        return this.initialized
    }

}


