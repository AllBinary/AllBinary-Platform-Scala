/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.feature

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.game.commands.GameCommandsFactory

class MultiPlayerGameFeatureFactory private() {
    import _root_.org.allbinary.game.configuration.feature.MultiPlayerGameFeatureFactory.{*}

    //final Canvas canvas
    def addCommands(anyType : Object) : Unit = {
        val gameCommandsFactory : GameCommandsFactory = GameCommandsFactory.getInstance()
        val canvas : Canvas = anyType.asInstanceOf[Canvas]
        canvas.addCommand(gameCommandsFactory.QUIT_COMMAND)
    }

}

object MultiPlayerGameFeatureFactory {
    private val instance : MultiPlayerGameFeatureFactory = new MultiPlayerGameFeatureFactory()

    def getInstance() : MultiPlayerGameFeatureFactory = {
        return MultiPlayerGameFeatureFactory.instance
    }

}


