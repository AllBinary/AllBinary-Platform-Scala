/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game

import _root_.org.allbinary.time.TimeDelayHelper

class Intermission() extends IntermissionInterface {

    private var enabled : Boolean = false

    private val timeElapsedHelper : TimeDelayHelper = new TimeDelayHelper(0)

    private var intermissionEnableListener : IntermissionEnableListenerInterface = NullIntermissionEnableListener.getInstance()

    override def setListener(enableListener : IntermissionEnableListenerInterface) : Unit = {
        this.intermissionEnableListener = enableListener
    }

    override def getTimeDelayHelper() : TimeDelayHelper = {
        return this.timeElapsedHelper
    }

    override def setEnabled(enabled : Boolean) : Unit = {
        this.enabled = enabled
        if (this.isEnabled()) {
            this.getTimeDelayHelper().setStartTimeTNT()
        }
        this.intermissionEnableListener.notifyIntermission(enabled)
    }

    override def isEnabled() : Boolean = {
        return this.enabled
    }

}


