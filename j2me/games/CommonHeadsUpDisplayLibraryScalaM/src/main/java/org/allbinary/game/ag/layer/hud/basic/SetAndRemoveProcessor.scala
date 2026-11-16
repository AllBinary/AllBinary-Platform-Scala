/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary * * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. * * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. * * Created By: Travis Berthelot * */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.hud.basic

import _root_.org.allbinary.canvas.Processor

class SetAndRemoveProcessor(param_updateMeasurementProcessor : PlayerGameNotificationHud) extends Processor {

    private var updateMeasurementProcessor : PlayerGameNotificationHud = null

    //Constructor
    {
        val updateMeasurementProcessor : PlayerGameNotificationHud = param_updateMeasurementProcessor
        this.updateMeasurementProcessor = updateMeasurementProcessor
    }

    override def process() : Unit = {
        this.updateMeasurementProcessor.setAndRemoveProcess()
    }

}


