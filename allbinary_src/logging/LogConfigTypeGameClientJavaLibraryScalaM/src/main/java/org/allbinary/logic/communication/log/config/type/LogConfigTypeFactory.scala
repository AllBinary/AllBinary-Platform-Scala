/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log.config.`type`


/**  *  * @author User  */
class LogConfigTypeFactory private() {
    import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.{*}

    private val NO_DESCRIPTION : String = "No Description"

    val OS : LogConfigType = new LogConfigType("Operating System", this.NO_DESCRIPTION)

    val FACTORYERROR : LogConfigType = new LogConfigType("Factory Error", this.NO_DESCRIPTION)

    //Constructor
    {
        LogConfigTypes.LOGGING.add(OS)
        LogConfigTypes.LOGGING.add(this.FACTORYERROR)
    }

}

object LogConfigTypeFactory {
    private val instance : LogConfigTypeFactory = new LogConfigTypeFactory()

    /**      * @return the instance      */
    def getInstance() : LogConfigTypeFactory = {
        return LogConfigTypeFactory.instance
    }

}


