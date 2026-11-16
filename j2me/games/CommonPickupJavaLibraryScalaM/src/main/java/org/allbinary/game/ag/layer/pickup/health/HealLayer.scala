/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.pickup.health

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.health.HealthInterface
import _root_.org.allbinary.game.health.HealthVisitorInterface
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.view.ViewPosition

class HealLayer() extends AllBinaryLayer(StringUtil.getInstance().EMPTY_STRING, new Rectangle(PointFactory.getInstance().ZERO_ZERO, 0, 0), ViewPosition.getInstanceD()) with HealthVisitorInterface {

    override def paint(graphics : Graphics) : Unit = {
    }

    override def visit(healthInterface : HealthInterface) : Unit = {
        //If not alive then heal should fail
        if (healthInterface.isAlive()) {
            healthInterface.healMax()
        } else {
            this.logUtil.putF("Heal attempt on dead: Does not currently occur", this, "visit")
        }
    }

}


