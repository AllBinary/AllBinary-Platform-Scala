/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration

import _root_.javax.microedition.lcdui.Gauge

class GameConfigurationGauge(param_gameConfiguration : GameConfiguration) extends Gauge(param_gameConfiguration.getName(), param_gameConfiguration.isModifiable().booleanValue(), param_gameConfiguration.getMaxValue().intValue() - param_gameConfiguration.getMinValue().intValue(), param_gameConfiguration.getValue().intValue() - param_gameConfiguration.getMinValue().intValue()) {

    //Constructor
    {
        val gameConfiguration : GameConfiguration = param_gameConfiguration
    }

}


