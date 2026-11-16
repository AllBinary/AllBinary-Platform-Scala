/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.game.configuration.persistance.GamePersistanceStrings
import _root_.org.allbinary.game.input.mapping.PersistentInputMapping
import _root_.org.allbinary.input.motion.button.BasicTouchInputFactory
import _root_.org.allbinary.input.motion.gesture.TouchMotionGestureFactory
import _root_.org.allbinary.input.motion.gesture.TrackballMotionGestureFactory
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface

class PCGameInputMapping() extends PersistentInputMapping(GamePersistanceStrings.getInstance().SAVED_INPUT_CONFIGURATION_RECORD_ID) {

    override def init(abeClientInformation : AbeClientInformationInterface) : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.INIT)
        PCKeyFactory.getInstance()
        TouchMotionGestureFactory.getInstance()
        TrackballMotionGestureFactory.getInstance()
        //OrientationMotionGestureFactory.getInstance();
        BasicTouchInputFactory.getInstance()
        super.init(abeClientInformation)
        if ((this.getTotalMapped() == 0) || this.isDefaultNew()) {
            this.getInputMapping().addMapping(this.getDefault())
            this.save(abeClientInformation)
        }
    }

    override def isDelete(input : Input) : Boolean = {
        if (input eq PCKeyFactory.getInstance().DEL) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    override def isSystemInput(input : Input) : Boolean = {
        return false
    }

}


