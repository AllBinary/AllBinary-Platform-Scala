/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.Canvas
import _root_.javax.microedition.lcdui.Graphics

//Temp should not be in any build
class NullDisplayable private() extends Canvas {
    import _root_.org.allbinary.game.displayable.canvas.NullDisplayable.{*}

    override def paint(graphics : Graphics) : Unit = {
    }

}

object NullDisplayable {
    private val SINGLETON : NullDisplayable = new NullDisplayable()

    def getInstance() : NullDisplayable = {
        return NullDisplayable.SINGLETON
    }

}


