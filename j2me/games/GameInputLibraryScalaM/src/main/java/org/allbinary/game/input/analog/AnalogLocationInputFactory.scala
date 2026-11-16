/* Generated Code Do Not Modify */
package org.allbinary.game.input.analog

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class AnalogLocationInputFactory private() {
    import _root_.org.allbinary.game.input.analog.AnalogLocationInputFactory.{*}

    private val list : BasicArrayList = new BasicArrayListD()

    def addPlayer(playerInputId : Int) : Unit = {
        var analogLocationInput : AnalogLocationInput = AnalogLocationInput.NULL_ANALOG_LOCATION_INPUT
        if (playerInputId < this.list.size()) {
            analogLocationInput = this.list.get(playerInputId).asInstanceOf[AnalogLocationInput]
        }
        if (analogLocationInput eq AnalogLocationInput.NULL_ANALOG_LOCATION_INPUT) {
            analogLocationInput = new AnalogLocationInput(playerInputId)
            this.list.add(analogLocationInput)
        }
    }

    def getInstanceForPlayer(playerInputId : Int) : AnalogLocationInput = {
        return this.list.get(playerInputId).asInstanceOf[AnalogLocationInput]
    }

    def getList() : BasicArrayList = {
        return this.list
    }

}

object AnalogLocationInputFactory {
    private val instance : AnalogLocationInputFactory = new AnalogLocationInputFactory()

    def getInstance() : AnalogLocationInputFactory = {
        return AnalogLocationInputFactory.instance
    }

}


