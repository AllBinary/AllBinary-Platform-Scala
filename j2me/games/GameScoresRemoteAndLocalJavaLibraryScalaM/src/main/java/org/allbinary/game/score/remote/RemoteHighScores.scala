/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.score.remote

import _root_.java.util.Enumeration
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.game.GameInfo
import _root_.org.allbinary.game.score.HighScore
import _root_.org.allbinary.game.score.HighScores
import _root_.org.allbinary.game.score.RemoteErrorHighScoresSingletonFactory
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.SoftwareInformation
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.EnumerationUtil

class RemoteHighScores private(param_abeClientInformation : AbeClientInformationInterface, param_softwareInformation : SoftwareInformation, param_gameInfo : GameInfo, param_heading : String, param_columnTwoHeading : String, param_ascending : _root_.java.lang.Boolean, param_preload : Boolean) extends HighScores(param_gameInfo.toString(), param_heading, param_columnTwoHeading) {
    import _root_.org.allbinary.game.score.remote.RemoteHighScores.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val enumerationUtil : EnumerationUtil = EnumerationUtil.getInstance()

    private var abeClientInformation : AbeClientInformationInterface = null

    private var softwareInformation : SoftwareInformation = null

    private var ascending : _root_.java.lang.Boolean = null

    val ASCENDING : String = "ASCENDING"

    //Constructor
    {
        val abeClientInformation : AbeClientInformationInterface = param_abeClientInformation
        val softwareInformation : SoftwareInformation = param_softwareInformation
        val gameInfo : GameInfo = param_gameInfo
        val heading : String = param_heading
        val columnTwoHeading : String = param_columnTwoHeading
        val ascending : _root_.java.lang.Boolean = param_ascending
        val preload : Boolean = param_preload
        this.abeClientInformation = abeClientInformation
        this.softwareInformation = softwareInformation
        this.setAscending(ascending)
        if (preload) {
            RemoteHighScoresProcessorFactory.getInstance().process(this, this.abeClientInformation, gameInfo)
        }
    }

    //@Override
    override def addHighScore(newHighScore : HighScore) : Unit = {
        RemoteHighScoresSubmissionProcessorFactory.getInstance().process(this, this.abeClientInformation, newHighScore)
    }

    //This is called when the data comes back in the response
    def update(hashtable : ABHashtable[Object, Object]) : Unit = {
        this.getList().clear()
        val vector : BasicArrayList = hashtable.get(RemoteHighScoresData.getInstance().HIGH_SCORES.asInstanceOf[Object]).asInstanceOf[BasicArrayList]
        if (vector != null) {
            val size : Int = vector.size()

            {
                var index : Int = 0
                while (index < size) {
                    val highScoreVector : BasicArrayList = vector.get(index).asInstanceOf[BasicArrayList]
                    val displayName : String = highScoreVector.get(0).asInstanceOf[String]
                    val score : String = highScoreVector.get(1).asInstanceOf[String]
                    val longScore : Long = _root_.java.lang.Long.parseLong(score)
                    //Long.valueOf(score).longValue()
                    val highScore : HighScore = new HighScore(-1, displayName, null, longScore)
                    this.getList().add(highScore)
                    index += 1
                }
            }
        } else {
            val NEXT_ELEMENT : String = new StringMaker().append(CommonLabels.getInstance().NEXT).append("Element: ").toString()
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            val enumeration : Enumeration[? <: Object] = hashtable.elements().asInstanceOf[Enumeration[? <: Object]]
            var nextElement : Object = null

            {
                while (this.enumerationUtil.hasMoreElements(enumeration)) {
                    nextElement = this.enumerationUtil.nextElement(enumeration)
                    this.logUtil.putF(NEXT_ELEMENT + nextElement, this, commonStrings.PROCESS)
                }
            }
        }
    }

    private def setAscending(ascending : _root_.java.lang.Boolean) : Unit = {
        this.ascending = ascending
    }

    def getAscending() : _root_.java.lang.Boolean = {
        return this.ascending
    }

    def getSoftwareInformation() : SoftwareInformation = {
        return this.softwareInformation
    }

}

object RemoteHighScores {
    private val hashTable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    def getInstance(abeClientInformation : AbeClientInformationInterface, softwareInformation : SoftwareInformation, gameInfo : GameInfo, heading : String, columnTwoHeading : String, isAscending : _root_.java.lang.Boolean) : HighScores = this.synchronized {
        return RemoteHighScores.getInstancePreload(abeClientInformation, softwareInformation, gameInfo, heading, columnTwoHeading, isAscending, true)
    }

    def getInstancePreload(abeClientInformation : AbeClientInformationInterface, softwareInformation : SoftwareInformation, gameInfo : GameInfo, heading : String, columnTwoHeading : String, isAscending : _root_.java.lang.Boolean, preload : Boolean) : HighScores = this.synchronized {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            var highScores : HighScores = RemoteHighScores.hashTable.get(gameInfo).asInstanceOf[HighScores]
            if (highScores == null) {
                highScores = new RemoteHighScores(abeClientInformation, softwareInformation, gameInfo, heading, columnTwoHeading, isAscending, preload)
                RemoteHighScores.hashTable.put(gameInfo, highScores)
            }
            return highScores
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                logUtil.put(commonStrings.EXCEPTION, RemoteErrorHighScoresSingletonFactory.getInstance(), commonStrings.GET_INSTANCE, e)
                return RemoteErrorHighScoresSingletonFactory.getInstance()
            }
        }
        throw new IllegalStateException()
    }

}


