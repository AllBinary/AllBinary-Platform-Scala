/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game


class NullIntermissionEnableListener private() extends IntermissionEnableListenerInterface {
    import _root_.org.allbinary.game.NullIntermissionEnableListener.{*}

    override def notifyIntermission(enable : Boolean) : Unit = {
    }

}

object NullIntermissionEnableListener {
    private val SINGLETON : IntermissionEnableListenerInterface = new NullIntermissionEnableListener()

    def getInstance() : IntermissionEnableListenerInterface = {
        return NullIntermissionEnableListener.SINGLETON
    }

}


