/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.Canvas
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.canvas.BaseGameStatistics
import _root_.org.allbinary.canvas.GameStatisticsFactory

//HTMLForJ2ME
class NullDisplayable private() extends Canvas {
    import _root_.org.allbinary.game.displayable.canvas.NullDisplayable.{*}

    private val baseGameStatistics : BaseGameStatistics = GameStatisticsFactory.getInstance()

    override def paint(graphics : Graphics) : Unit = {
        this.baseGameStatistics.nextRefresh()
    }

}

object NullDisplayable {
    private val SINGLETON : NullDisplayable = new NullDisplayable()

    def getInstance() : NullDisplayable = {
        return NullDisplayable.SINGLETON
    }

}


