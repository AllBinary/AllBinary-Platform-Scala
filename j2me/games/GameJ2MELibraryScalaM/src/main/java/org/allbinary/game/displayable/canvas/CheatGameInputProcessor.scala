/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.game.input.GameKeyFactory
import _root_.org.allbinary.game.input.PlayerGameInput
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.game.input.event.GameKeyEventUtil
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.special.SpecialGameInputFactory
import _root_.org.allbinary.game.layer.special.SpecialGameInputInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class CheatGameInputProcessor(param_gameCanvas : AllBinaryGameCanvas) extends PlayerGameInput(new BasicArrayListD(), new BasicArrayListD(), -1) {
    import _root_.org.allbinary.game.displayable.canvas.CheatGameInputProcessor.{*}

    private val PROCESS_GAME : String = "processGame"

    private var gameCanvas : AllBinaryGameCanvas = null

    private val gameKeyFactory : GameKeyFactory = GameKeyFactory.getInstance()

    //Constructor
    {
        val gameCanvas : AllBinaryGameCanvas = param_gameCanvas
        this.gameCanvas = gameCanvas
    }

    //    public static int z;
    override def update() : Unit = this.synchronized {
        try {
            val gameLayerManager : AllBinaryGameLayerManager = this.gameCanvas.getLayerManager()
            val list : BasicArrayList = this.getGameKeyEventList()
            val size : Int = list.size()

            {
                var index : Int = 0
                scala.util.boundary { (break_N77958 : scala.util.boundary.Label[Unit]) ?=>
                    while (index < size) {
                        val anyType : Object = list.objectArray(index)
                        val key : Int = GameKeyEventUtil.getKey(anyType)
                        if (key == this.gameKeyFactory.LEVEL_DOWN.getId()) {
                            CheatGameInputProcessor.inputProcessor.strafeLeft()
                            //this.gameCanvas.buildGame(true);
                            scala.util.boundary.break()(using break_N77958)
                        } else if (key == this.gameKeyFactory.LEVEL_UP.getId()) {
                            CheatGameInputProcessor.inputProcessor.strafeRight()
                            //this.gameCanvas.buildGame(true);
                            scala.util.boundary.break()(using break_N77958)
                        }
                        if (key == this.gameKeyFactory.LEFT.getId()) {
                            CheatGameInputProcessor.inputProcessor.left()
                            //                    this.logUtil.putF(new StringMaker().append("x: ").append(x).toString(), this, PROCESS_GAME);
                            scala.util.boundary.break()(using break_N77958)
                        } else if (key == this.gameKeyFactory.RIGHT.getId()) {
                            CheatGameInputProcessor.inputProcessor.right()
                            //                    this.logUtil.putF(new StringMaker().append("x: ").append(x).toString(), this, PROCESS_GAME);
                            scala.util.boundary.break()(using break_N77958)
                        } else if (key == this.gameKeyFactory.UP.getId()) {
                            CheatGameInputProcessor.inputProcessor.up()
                            //                    this.logUtil.putF(new StringMaker().append("y: ").append(y).toString(), this, PROCESS_GAME);   
                            scala.util.boundary.break()(using break_N77958)
                        } else if (key == this.gameKeyFactory.DOWN.getId()) {
                            CheatGameInputProcessor.inputProcessor.down()
                            //                    this.logUtil.putF(new StringMaker().append("y: ").append(y).toString(), this, PROCESS_GAME);
                            scala.util.boundary.break()(using break_N77958)
                        } else if (key == this.gameKeyFactory.KEY_NUM1.getId()) {
                            CheatGameInputProcessor.inputProcessor.special1(gameLayerManager, GameKeyEvent.NONE)
                            //                    this.logUtil.putF(new StringMaker().append("z: ").append(z).toString(), this, PROCESS_GAME);
                            scala.util.boundary.break()(using break_N77958)
                        } else if (key == this.gameKeyFactory.KEY_NUM3.getId()) {
                            CheatGameInputProcessor.inputProcessor.special2(gameLayerManager, GameKeyEvent.NONE)
                            //                    this.logUtil.putF(new StringMaker().append("z: ").append(z).toString(), this, PROCESS_GAME);
                            scala.util.boundary.break()(using break_N77958)
                        }
                        index += 1
                    }
                }
            }
            list.clear()
        } catch {
            case breakException: scala.util.boundary.Break[?] => throw breakException
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.UPDATE, e)
            }
        }
    }

}

object CheatGameInputProcessor {
    var inputProcessor : SpecialGameInputInterface = SpecialGameInputFactory.NO_SPECIAL_GAME_INPUT

}


