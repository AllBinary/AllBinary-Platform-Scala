/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.hud.basic.score

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.ag.layer.hud.basic.NumberStringHud
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory

class ScoreHudWidget(param_maxscore : Int, param_location : Int, param_direction : Int, param_bufferZone : Int, param_basicColor : BasicColor) extends NumberStringHud("Pts ", param_maxscore, param_location, param_direction, param_bufferZone, param_basicColor) {
    import _root_.org.allbinary.game.ag.layer.hud.basic.score.ScoreHudWidget.{*}

    //Constructor
    {
        val maxscore : Int = param_maxscore
        val location : Int = param_location
        val direction : Int = param_direction
        val bufferZone : Int = param_bufferZone
        val basicColor : BasicColor = param_basicColor
        this.updateMaxHeight = 14
    }

    //    }
    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.updateMaxWidth = font.getSize() * 5
        super.updateMeasurement(graphics)
    }

}

object ScoreHudWidget {
    def getInstance(maxscore : Int, location : Int, direction : Int) : ScoreHudWidget = {
        return new ScoreHudWidget(maxscore, location, direction, 2, BasicColorFactory.getInstance().GREY)
    }

}


