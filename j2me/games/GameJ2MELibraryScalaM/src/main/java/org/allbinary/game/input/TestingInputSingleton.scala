/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.javax.microedition.lcdui.Canvas
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.game.layer.AllBinaryGameLayer
import _root_.org.allbinary.graphics.RectangleFactory
import _root_.org.allbinary.graphics.paint.NullPaintable
import _root_.org.allbinary.graphics.paint.PaintableInterface
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.view.ViewPosition

class TestingInputSingleton private() extends AllBinaryGameLayer(StringUtil.getInstance().EMPTY_STRING, RectangleFactory.SINGLETON, ViewPosition.getInstanceD()) with GameInputInterface {
    import _root_.org.allbinary.game.input.TestingInputSingleton.{*}

    val inputProcessorArray : Array[GameInputProcessor] = new Array[GameInputProcessor](InputFactory.getInstance().MAX)

    private var testInputPaintable : PaintableInterface = NullPaintable.getInstance()

    //Constructor
    {
        GameInputProcessorUtil.init(this.inputProcessorArray)
    }

    override def initInputProcessors() : Unit = {
    }

    def initInputProcessorsForTestInput(aTestInputInterface : TestInputInterface) : Unit = {
        val testInputInterface : TestInputInterface = aTestInputInterface
        this.testInputPaintable = testInputInterface
        this.inputProcessorArray(Canvas.UP) = new GameInputProcessor {
                override def processEvent(allbinaryLayerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit = {
                    testInputInterface.up()
                }

            }
        this.inputProcessorArray(Canvas.DOWN) = new GameInputProcessor {
                override def processEvent(allbinaryLayerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit = {
                    testInputInterface.down()
                }

            }
        this.inputProcessorArray(Canvas.LEFT) = new GameInputProcessor {
                override def processEvent(allbinaryLayerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit = {
                    testInputInterface.left()
                }

            }
        this.inputProcessorArray(Canvas.RIGHT) = new GameInputProcessor {
                override def processEvent(allbinaryLayerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit = {
                    testInputInterface.right()
                }

            }
        this.inputProcessorArray(Canvas.KEY_NUM7) = new GameInputProcessor {
                override def processEvent(allbinaryLayerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit = {
                    testInputInterface.strafeLeft()
                }

            }
        this.inputProcessorArray(Canvas.KEY_NUM9) = new GameInputProcessor {
                override def processEvent(allbinaryLayerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit = {
                    testInputInterface.strafeRight()
                }

            }
        GameInputProcessorUtil.init(this.inputProcessorArray)
    }

    def processInputList(allbinaryLayerManager : AllBinaryLayerManager, list : BasicArrayList) : Unit = this.synchronized {
        var key : Int = 0
        var gameKeyEvent : GameKeyEvent = null
        val size : Int = list.size()

        {
            var index : Int = 0
            while (index < size) {
                gameKeyEvent = (list.objectArray(index).asInstanceOf[GameKeyEvent])
                key = gameKeyEvent.getKey()
                this.inputProcessorArray(key).processEvent(allbinaryLayerManager, GameKeyEvent.NONE)
                index += 1
            }
        }
    }

    override def processInput(allbinaryLayerManager : AllBinaryLayerManager) : Unit = this.synchronized {
        this.processInputList(allbinaryLayerManager, this.getGameKeyEventList())
        this.getGameKeyEventList().clear()
    }

    override def paint(graphics : Graphics) : Unit = {
        this.testInputPaintable.paint(graphics)
    }

    override def implmentsGameInputInterface() : Boolean = {
        return true
    }

}

object TestingInputSingleton {
    private val instance : TestingInputSingleton = new TestingInputSingleton()

    def getInstance() : TestingInputSingleton = {
        return TestingInputSingleton.instance
    }

}


