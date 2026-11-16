/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http

import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class AcceptableResponseGenerator private() {
    import _root_.org.allbinary.logic.communication.http.AcceptableResponseGenerator.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def get(httpServletRequest : HttpServletRequest) : String = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        try {
            var acceptableResponseUtil : AcceptableResponseUtil = AcceptableResponseUtil.getInstance()
            var acceptable : String = httpServletRequest.getHeader("accept")
            var result : String = acceptableResponseUtil.getTagName(0)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTP)) {
                this.logUtil.putF("Request Type: " + acceptable, this, commonStrings.GET)
            }
            if (acceptable != null) {
                var size : Int = acceptableResponseUtil.size()

                {
                    var index : Int = 0
                    while (index < size) {
                        //if(beginIndex >=0)
                        if (acceptable.compareTo(acceptableResponseUtil.get(index)) == 0) {
                            result = acceptableResponseUtil.getTagName(index)
                        }
                        index += 1
                    }
                }
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTP)) {
                this.logUtil.putF("Response Type: " + result, this, commonStrings.GET)
            }
            return result
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.GET, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}

object AcceptableResponseGenerator {
    private val instance : AcceptableResponseGenerator = new AcceptableResponseGenerator()

    def getInstance() : AcceptableResponseGenerator = {
        return AcceptableResponseGenerator.instance
    }

}


