/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.mapping

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.game.input.GameKey
import _root_.org.allbinary.game.input.GameKeyFactory
import _root_.org.allbinary.game.input.Input
import _root_.org.allbinary.game.input.InputFactory
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class InputToGameKeyMapping() extends InputMapping {
    import _root_.org.allbinary.game.input.mapping.InputToGameKeyMapping.{*}

    private val gameKeyFactory : GameKeyFactory = GameKeyFactory.getInstance()

    private val mappedGameKeys : Array[GameKey] = Array[GameKey](this.gameKeyFactory.UP, this.gameKeyFactory.DOWN, this.gameKeyFactory.LEFT, this.gameKeyFactory.RIGHT)

    private val platformToGameKeyMapping : Array[GameKey] = new Array[GameKey](InputFactory.getInstance().MAX)

    //6
    var negativePlatformToGameKeyMapping : Array[GameKey] = new Array[GameKey](0)

    //Constructor
    {
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        this.clear()
    }

    private def clear() : Unit = {

        {
            var index : Int = this.platformToGameKeyMapping.length - 1
            while (index >= 0) {
                this.platformToGameKeyMapping(index) = this.gameKeyFactory.NONE
                index -= 1
            }
        }
    }

    override def removeAll() : Unit = {
        super.removeAll()
        this.clear()
    }

    override def addMapping(inputToGameKeyMapping : InputToGameKeyMapping) : Unit = {
        //PreLogUtil.put(commonStrings.START, this, "InputToGameKeyMapping::add(InputToGameKeyMapping)");

        {
            var index : Int = inputToGameKeyMapping.getMaxMappable() - 1
            while (index >= 0) {
                val input : Input = inputToGameKeyMapping.getInstance(index)
                if (input ne this.gameKeyFactory.NONE) {
                    //PreLogUtil.put("Input: " + input, this, "InputToGameKeyMapping::add(InputToGameKeyMapping)");
                    this.addAll(input, inputToGameKeyMapping.getMappedInput(input))
                }
                index -= 1
            }
        }
    }

    private def addAll(input : Input, list : BasicArrayList) : Unit = {
        //PreLogUtil.put(commonStrings.START_LABEL + input + " == " + list, this, "InputToGameKeyMapping::addAll");

        {
            var index : Int = list.size() - 1
            while (index >= 0) {
                var mappedToInput : Input = list.objectArray(index).asInstanceOf[Input]
                //PreLogUtil.put("Input: " + input + " == " + mappedToInput, this, "InputToGameKeyMapping::addAll");
                this.add(input, mappedToInput)
                index -= 1
            }
        }
    }

    override def add(input : Input, mappedToInput : Input) : Unit = {
        //this.logUtil.putF(this.commonStrings.START_LABEL + input + " == " + mappedToInput, this, "InputToGameKeyMapping::add");
        super.add(input, mappedToInput)
        this.set(input, mappedToInput)
    }

    override def remove(input : Input, mappedToInput : Input) : Unit = {
        this.logUtil.putF(new StringMaker().append(CommonLabels.getInstance().START_LABEL).append(StringUtil.getInstance().toString(input)).append(" == ").append(StringUtil.getInstance().toString(mappedToInput)).toString(), this, "InputToGameKeyMapping::remove")
        super.remove(input, mappedToInput)
        this.set(input, this.gameKeyFactory.NONE)
    }

    private def set(input : Input, mappedToInput : Input) : Unit = {
        var id : Int = mappedToInput.getId()
        if ((id >= 0) && (id < this.platformToGameKeyMapping.length)) {
            this.platformToGameKeyMapping(id) = input.asInstanceOf[GameKey]
        }
    }

    def getMaxMappable() : Int = {
        return this.platformToGameKeyMapping.length
    }

    //This may not work at some point for a new platform since I have special mappings at the high end like touch and motion inputs
    def getReverseInstance(id : Int) : BasicArrayList = {
        var list : BasicArrayList = new BasicArrayListD()
        val inputFactory : InputFactory = InputFactory.getInstance()

        {
            var index : Int = 0
            while (index < this.platformToGameKeyMapping.length) {
                if (this.platformToGameKeyMapping(index).getId() == id) {
                    var input : Input = inputFactory.getInstanceById(index)
                    if (input != null) {
                        list.add(input)
                    }
                }
                index += 1
            }
        }
        return list
    }

    /*     public GameKey getInstance(Canvas canvas, int id)     {         //Using getKeyCode and updating the mapping would probably be better         //canvas.getKeyCode(id);         if(id < 0)         {             //This is lower than using the generated table             return this.getInstance(canvas.getGameAction(id));         }         else         {             return this.getInstance(id);         }     }     */
    private def initGameKey(canvas : Canvas, gameKey : GameKey) : Unit = {
        var key : Int = canvas.getKeyCode(gameKey.getId())
        if ((key < 0) && (-key < this.negativePlatformToGameKeyMapping.length)) {
            this.negativePlatformToGameKeyMapping(-key) = gameKey
        } else if (key > 0) {
            if (this.platformToGameKeyMapping(key) eq this.gameKeyFactory.NONE) {
                this.platformToGameKeyMapping(key) = gameKey
            }
        } else {
            PreLogUtil.putOE(new StringMaker().append(gameKey.toString()).append(CommonSeps.getInstance().COLON_SEP).appendint(key).toString(), this, this.commonStrings.INIT, new Exception())
        }
    }

    private def getSmallestCanvasGameKeyCode(canvas : Canvas) : Int = {
        var nextKey : Int = 0
        var smallestKey : Int = 0

        {
            var index : Int = this.mappedGameKeys.length
            while ({ index -= 1; index } >= 0) {
                nextKey = canvas.getKeyCode(this.mappedGameKeys(index).getId())
                if (nextKey < smallestKey) {
                    smallestKey = nextKey
                }
            }
        }
        return smallestKey
    }

    def init(canvas : Canvas) : Unit = {
        try {
            var negativePlatformToGameKeyMapping : Array[GameKey] = new Array[GameKey](0)
            var smallestKey : Int = this.getSmallestCanvasGameKeyCode(canvas)
            if (smallestKey < 0) {
                smallestKey -= 1
                if (smallestKey < -256) {
                    smallestKey = -256
                }
                negativePlatformToGameKeyMapping = new Array[GameKey](-smallestKey)

                {
                    var index : Int = negativePlatformToGameKeyMapping.length
                    while ({ index -= 1; index } >= 0) {
                        negativePlatformToGameKeyMapping(index) = this.gameKeyFactory.NONE
                    }
                }
                this.negativePlatformToGameKeyMapping = negativePlatformToGameKeyMapping
            }

            {
                var index : Int = this.mappedGameKeys.length
                while ({ index -= 1; index } >= 0) {
                    this.initGameKey(canvas, this.mappedGameKeys(index))
                }
            }
        } catch {
            case t : Throwable => {
                //catch everything here little dangerous but I don't ever want to fail just because of failed mapping for j2me game keys
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.INIT, t)
            }
        }
    }

    def getInstanceForCanvas(canvas : Canvas, id : Int) : GameKey = {
        //return this.getInstance(id);
        if ((id >= 0) && (id < this.platformToGameKeyMapping.length)) {
            return this.platformToGameKeyMapping(id)
        } else if ((id < 0) && (-id < this.negativePlatformToGameKeyMapping.length)) {
            return this.negativePlatformToGameKeyMapping(-id)
        } else {
            return this.gameKeyFactory.NONE
        }
        throw new IllegalStateException()
    }

    def getInstance(id : Int) : GameKey = {
        if ((id >= 0) && (id < this.platformToGameKeyMapping.length)) {
            return this.platformToGameKeyMapping(id)
        } else if ((id < 0) && (-id < this.negativePlatformToGameKeyMapping.length)) {
            return this.negativePlatformToGameKeyMapping(-id)
        } else {
            return this.gameKeyFactory.NONE
        }
        throw new IllegalStateException()
    }

}

object InputToGameKeyMapping {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getNullInstance() : InputToGameKeyMapping = {
        if (InputToGameKeyMapping.instance eq NullUtil.getInstance().NULL_OBJECT) {
            InputToGameKeyMapping.instance = new InputToGameKeyMapping()
        }
        return InputToGameKeyMapping.instance.asInstanceOf[InputToGameKeyMapping]
    }

}


