/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log.config.`type`

import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.communication.log.config.LoggingInitInfo
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.w3c.dom.Node

class LogConfigTypes private() {
    import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.{JSP_ERROR_NO_FUNCTION as _, *}
    def JSP_ERROR_NO_FUNCTION : String = _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.JSP_ERROR_NO_FUNCTION

}

object LogConfigTypes {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    val JSP_ERROR_NO_FUNCTION : String = "in JSP Not In Function"

    var LOGGING : BasicArrayList = new BasicArrayListD()

    {
        LogConfigTypes.init()
    }

    /*    public static synchronized void init(PrintWriter printWriter)    {       try       {          LoggingInitInfo loggingInitInfo = new LoggingInitInfo();          BasicArrayList logConfigTypeVector = loggingInitInfo.getTypeVector();          printWriter.print("Number Of Log Configs: " + loggingInitInfo.getNumberOfLogConfigs() + "<br/>");          printWriter.print("Number Of Log Config Type Names: " + logConfigTypeVector.size() + "<br/>");               iter = logConfigTypeVector;          while(iter.hasNext())          {             LogConfigType logConfigType = (LogConfigType) iter.next();             String nextLogTypeName = (String) logConfigType.getName();             printWriter.print("Log Type Name: " + nextLogTypeName + "<br/>");          }          LogConfigTypes.LOGGING.addAll(logConfigTypeVector);          LogConfigTypes.LOGGING.add(LogConfigTypes.NETBEANS_MODULE);       }       catch(Exception e)       {          printWriter.print("Unable to initialize LogconfigTypes: <br/>" + e.getMessage());       }    }     */
    def init() : Unit = this.synchronized {
        try {
            PreLogUtil.put("Initialize LogconfigTypes", "LogConfigTypes", "init()")
            LogConfigTypeFactory.getInstance()
            //Load the Specified configuration files
            val loggingInitInfo : LoggingInitInfo = new LoggingInitInfo()
            val logConfigTypeVector : BasicArrayList = LoggingInitInfo.getTypeList()
            PreLogUtil.put("Number Of Log Configs: " + loggingInitInfo.getNumberOfLogConfigs(), "LogConfigTypes", "init()")
            PreLogUtil.put("Number Of Log Config Type Names: " + logConfigTypeVector.size(), "LogConfigTypes", "init()")
            LogConfigTypes.LOGGING.addAllList(logConfigTypeVector)
            LogConfigTypes.LOGGING.add(LogConfigTypeFactory.getInstance().NETBEANS_MODULE)
        } catch {
            case e : Exception => {
                PreLogUtil.putSE("Unable to initialize LogConfigTypes", "LogConfigTypes", "init()", e)
            }
        }
    }

    def getInstance(node : Node) : LogConfigType = {
        val nameValueNode : Node = DomSearchHelper.getNode(LogConfigTypeData.getInstance().NAME, node.getChildNodes())
        val name : String = DomNodeHelper.getTextNodeValue(nameValueNode)
        val descriptionValueNode : Node = DomSearchHelper.getNodeNoThrow(LogConfigTypeData.getInstance().DESCRIPTION, node.getChildNodes())
        if (descriptionValueNode != null) {
            val description : String = DomNodeHelper.getTextNodeValue(descriptionValueNode)
        }
        val availableLogConfigTypes : BasicArrayList = LogConfigType.availableLogConfigTypes
        val size : Int = availableLogConfigTypes.size()
        var logConfigType : LogConfigType = null

        {
            var index : Int = 0
            while (index < size) {
                logConfigType = availableLogConfigTypes.get(index).asInstanceOf[LogConfigType]
                if (logConfigType.getName().compareTo(name) == 0) {
                    return logConfigType
                }
                index += 1
            }
        }
        throw new Exception("No Such LogConfigType: " + name)
    }

}


