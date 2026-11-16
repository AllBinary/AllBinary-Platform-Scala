/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.generator

import _root_.java.io.IOException
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tables.generator.IdGeneratorEntity
import _root_.org.allbinary.data.tables.generator.IdGeneratorEntityFactory
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.LogUtil

class UniqueIdGenerator() extends IdGeneratorInterface {
    import _root_.org.allbinary.data.generator.UniqueIdGenerator.{EXT as _, *}
    def EXT : String = _root_.org.allbinary.data.generator.UniqueIdGenerator.EXT

    val logUtil : LogUtil = LogUtil.getInstance()

    private var idGeneratorEntity : IdGeneratorEntity = null

    private var name : String = null

    //Constructor
    {
        this.idGeneratorEntity = IdGeneratorEntityFactory.getInstance().asInstanceOf[IdGeneratorEntity]
    }

    def initialize(value : Int) : Unit = {
        try {
            var vector : BasicArrayList = new BasicArrayListD()
            vector.add(this.name)
            vector.add(_root_.java.lang.Long.valueOf(value).toString())
            this.idGeneratorEntity.insert(vector)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().IDLOGGING)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(commonStrings.EXCEPTION, this, "initialize", e)
                }
            }
        }
    }

    def setFile(filePathName : String, name : String) : Unit = this.synchronized {
        this.name = name
    }

    def getNext() : String = this.synchronized {
        try {
            var idLong : _root_.java.lang.Long = this.idGeneratorEntity.get(this.name)
            var newValue : _root_.java.lang.Long = _root_.java.lang.Long.valueOf(idLong.longValue() + 1)
            this.idGeneratorEntity.update(this.name, newValue)
            return idLong.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().IDLOGGING)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(commonStrings.EXCEPTION, this, "getNext", e)
                }
                return "Error"
            }
        }
        throw new IllegalStateException()
    }

}

object UniqueIdGenerator {
    val EXT : String = ".unq"

}


