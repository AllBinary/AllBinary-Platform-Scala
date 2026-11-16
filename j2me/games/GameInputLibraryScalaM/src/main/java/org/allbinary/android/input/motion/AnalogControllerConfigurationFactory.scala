/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.input.motion

import _root_.org.allbinary.android.input.motion.event.AnalogControllerConfigurationEvent
import _root_.org.allbinary.android.input.motion.event.AnalogControllerConfigurationEventHandler
import _root_.org.allbinary.logic.math.ScaleFactorFactory

class AnalogControllerConfigurationFactory private() {
    import _root_.org.allbinary.android.input.motion.AnalogControllerConfigurationFactory.{*}

    val SCALE_FACTOR : Int = ScaleFactorFactory.getInstance().DEFAULT_SCALE_FACTOR

    val SCALE_VALUE : Int = ScaleFactorFactory.getInstance().DEFAULT_SCALE_VALUE

    private var available : Boolean = false

    private val analogControllerConfigurationEvent : AnalogControllerConfigurationEvent = new AnalogControllerConfigurationEvent(this)

    def isAvailable() : Boolean = {
        return this.available
    }

    def setAvailable(available : Boolean) : Unit = {
        //this.logUtil.putF(this.commonStrings.START_LABEL + available, this, "setAvailable");
        this.available = available
        AnalogControllerConfigurationEventHandler.getInstance().fireEvent(this.analogControllerConfigurationEvent)
    }

}

object AnalogControllerConfigurationFactory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : AnalogControllerConfigurationFactory = new AnalogControllerConfigurationFactory()

    def getInstance() : AnalogControllerConfigurationFactory = {
        return AnalogControllerConfigurationFactory.instance
    }

}


