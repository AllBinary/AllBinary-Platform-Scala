/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.game.input.analog.AnalogLocationInputFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker

class LocalPlayerInputIdFactory private() {
    import _root_.org.allbinary.game.input.LocalPlayerInputIdFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val MAX_NUMBER_OF_PLAYERS : Int = 6

    private val MAX_FAST_DEVICEID : Int = 65

    private val deviceIdToplayerId : Array[Int] = new Array[Int](this.MAX_FAST_DEVICEID)

    private val playerIdToDeviceId : Array[Int] = new Array[Int](this.MAX_NUMBER_OF_PLAYERS)

    private val playersInPlay : Array[Boolean] = new Array[Boolean](this.MAX_NUMBER_OF_PLAYERS)

    private var totalDevicesMapped : Int = 0

    //Constructor
    {

        {
            var index : Int = this.deviceIdToplayerId.length - 1
            while (index >= 0) {
                this.deviceIdToplayerId(index) = -1
                index -= 1
            }
        }
    }

    def getDeviceId(playerInputId : Int) : Int = {
        return this.playerIdToDeviceId(playerInputId)
    }

    def getPlayerForDevice(deviceId : Int) : Int = {
        var index : Int = 0
        if (deviceId < this.MAX_FAST_DEVICEID) {
            var playerInputId : Int = this.deviceIdToplayerId(deviceId)
            if (playerInputId != -1) {
                //this.logUtil.putF("Fast Find DeviceId: ").append(deviceId).append(" at playerInputId: ").append(playerInputId, this, "getPlayerForDevice");
                return playerInputId
            }
        } else {

            {
                index = this.totalDevicesMapped - 1
                while (index >= 0) {
                    if (this.playerIdToDeviceId(index) == deviceId) {
                        //this.logUtil.putF("Found DeviceId: ").append(deviceId).append(" at playerInputId: ").append(index, this, "getPlayerForDevice");
                        return index
                    }
                    index -= 1
                }
            }
        }
        index = this.totalDevicesMapped
        //Add New Player for device
        if (deviceId < this.MAX_FAST_DEVICEID) {
            this.deviceIdToplayerId(deviceId) = index
        } else {
            this.logUtil.putF(new StringMaker().append("Added DeviceId: ").appendint(deviceId).append(" beyond fast Id list").toString(), this, "getPlayerForDevice")
        }
        this.playerIdToDeviceId(index) = deviceId
        AnalogLocationInputFactory.getInstance().addPlayer(this.totalDevicesMapped)
        this.totalDevicesMapped += 1
        this.logUtil.putF(new StringMaker().append("Added DeviceId: ").appendint(deviceId).append(" at: ").appendint(index).append(" Total: ").appendint(this.totalDevicesMapped).toString(), this, "getPlayerForDevice")
        //int playerNum = OuyaController.getPlayerNumByDeviceId(deviceId);
        return index
    }

    /**      * @return the currentNumberOfPlayers      */
    def getTotalDevicesInPlay() : Int = {
        var total : Int = 0

        {
            var index : Int = this.totalDevicesMapped - 1
            while (index >= 0) {
                if (this.playersInPlay(index) == true) {
                    total += 1
                }
                index -= 1
            }
        }
        return total
    }

    /*     public boolean isDeviceInPlay(int deviceId)     {         return playersInPlay[this.getPlayerForDevice(deviceId)];     }      public void setDeviceInPlay(int deviceId)     {         int playerInputId = this.getPlayerForDevice(deviceId);         this.logUtil.putF("Setting DeviceInPlay with DEVICE_ID_LABEL: ").append(deviceId).append(" playerInputId: ").append(playerInputId, this, "setDeviceInPlay");         this.playersInPlay[playerInputId] = true;     }      public void setDeviceOutOfPlay(int deviceId)     {         int playerInputId = this.getPlayerForDevice(deviceId);         this.logUtil.putF("Setting DeviceOutOfPlay with DEVICE_ID_LABEL: ").append(deviceId).append(" playerInputId: ").append(playerInputId, this, "setDeviceInPlay");         this.playersInPlay[playerInputId] = false;     }     */
    def isPlayerInPlay(playerInputId : Int) : Boolean = {
        return this.playersInPlay(playerInputId)
    }

    def setPlayerInPlay(playerInputId : Int) : Unit = {
        this.logUtil.putF(new StringMaker().append("Setting PlayerInPlay with playerInputId: ").appendint(playerInputId).toString(), this, "setPlayerInPlay")
        this.playersInPlay(playerInputId) = true
    }

    def setPlayerOutOfPlay(playerInputId : Int) : Unit = {
        this.logUtil.putF(new StringMaker().append("Setting PlayerOutOfPlay with playerInputId: ").appendint(playerInputId).toString(), this, "setPlayerOutOfPlay")
        this.playersInPlay(playerInputId) = false
    }

    /**      * @return the inPlayToDeviceId      */
    def getPlayersInPlay() : Array[Boolean] = {
        return this.playersInPlay
    }

}

object LocalPlayerInputIdFactory {
    private val instance : LocalPlayerInputIdFactory = new LocalPlayerInputIdFactory()

    def getInstance() : LocalPlayerInputIdFactory = {
        return LocalPlayerInputIdFactory.instance
    }

}


