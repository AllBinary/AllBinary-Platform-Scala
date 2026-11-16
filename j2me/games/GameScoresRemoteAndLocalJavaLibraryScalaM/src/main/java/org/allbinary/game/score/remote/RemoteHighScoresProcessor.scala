/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score.remote

import _root_.org.allbinary.game.GameInfo
import _root_.org.allbinary.game.GameInfoData
import _root_.org.allbinary.game.configuration.GameConfigurationCentral
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.xmlrpc.XmlRpcAbeClient
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.system.security.crypt.jcehelper.NoCrypt
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.HashtableUtil

class RemoteHighScoresProcessor() extends RemoteHighScoresProcessorInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val noCrypt : NoCrypt = new NoCrypt()

    //String customerUserName,
    def process(remoteHighScores : RemoteHighScores, abeClientInformation : AbeClientInformationInterface, gameInfo : GameInfo) : Unit = this.synchronized {
        this.logUtil.putF("Begin Remote HighScores Retrieval", this, this.commonStrings.PROCESS)
        val gameInfoData : GameInfoData = GameInfoData.getInstance()
        // System.out.println(message);
        val hashtable : ABHashtable[Object, Object] = abeClientInformation.toHashtable()
        HashtableUtil.getInstance().putAll(gameInfo.toHashtable(), hashtable)
        //hashtable.put(RemoteHighScoresData.getInstance().GAME_INFO, gameInfo.toString());
        hashtable.put(gameInfoData.SOFTWARE_INFORMATION, remoteHighScores.getSoftwareInformation().toString())
        hashtable.put(remoteHighScores.ASCENDING, remoteHighScores.getAscending().toString())
        val displayInfoSingleton : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        hashtable.put(displayInfoSingleton.ORIENTATION, BooleanFactory.getInstance().toStringb(displayInfoSingleton.isPortrait()))
        hashtable.put(RemoteHighScoresData.getInstance().GAME_CONFIGURATION, GameConfigurationCentral.getInstance().toString())
        if (XmlRpcAbeClient.isOnline) {
            var resultHashtable : ABHashtable[Object, Object] = new XmlRpcRemoteHighScoresClient(abeClientInformation, "highscoresservicessl.php", "HighScoresService.process").get(hashtable, this.noCrypt).asInstanceOf[ABHashtable[Object, Object]]
            remoteHighScores.update(resultHashtable)
        }
    }

}


