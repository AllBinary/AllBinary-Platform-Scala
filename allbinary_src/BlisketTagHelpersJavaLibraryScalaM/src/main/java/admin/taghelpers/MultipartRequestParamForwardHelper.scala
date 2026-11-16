/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.globals.GLOBALS2
import _root_.org.allbinary.logic.communication.http.request.RequestMapInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.tags.HelperTag

class MultipartRequestParamForwardHelper(param_parentHelperTag : HelperTag, param_page : String, param_command : String, param_paramVector : BasicArrayList, param_pageContext : PageContext) {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var pageContext : PageContext = null

    private var requestMapInterface : RequestMapInterface = null

    private var page : String = null

    private var command : String = null

    private var paramVector : BasicArrayList = null

    //Constructor
    {
        val parentHelperTag : HelperTag = param_parentHelperTag
        val page : String = param_page
        val command : String = param_command
        val paramVector : BasicArrayList = param_paramVector
        val pageContext : PageContext = param_pageContext
        this.pageContext = pageContext
        this.page = page
        this.command = command
        this.paramVector = paramVector
        this.requestMapInterface = InventoryItemViewParentTagHelper.getInstance().getRequestMapInterface(parentHelperTag)
    }

    def forward() : Unit = {
        try {
            if (this.shouldForward()) {
                var params : String = this.getParams()
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append(this.page)
                stringBuffer.append(params)
                this.pageContext.forward(stringBuffer.toString())
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, "forward()", e)
                }
            }
        }
    }

    private def getParams() : String = {
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        val AMP : String = commonSeps.AMPERSAND
        val QUESTION : String = commonSeps.QUESTION
        val EQUALS : String = commonSeps.EQUALS
        val hashMap : HashMap[Object, Object] = this.requestMapInterface.getRequestHashMap().asInstanceOf[HashMap[Object, Object]]
        var stringBuffer : StringMaker = new StringMaker()
        var size : Int = this.paramVector.size()

        {
            var index : Int = 0
            while (index < size) {
                //TWB - Update using specified values from tag?
                var key : String = this.paramVector.get(index).asInstanceOf[String]
                var value : String = hashMap.get(key).asInstanceOf[String]
                if (index != 0) {
                    stringBuffer.append(AMP)
                } else {
                    stringBuffer.append(QUESTION)
                }
                stringBuffer.append(key)
                stringBuffer.append(EQUALS)
                stringBuffer.append(value)
                index += 1
            }
        }
        return stringBuffer.toString()
    }

    //Forward if no command is needed or if command is correct
    private def shouldForward() : Boolean = {
        val hashMap : HashMap[Object, Object] = this.requestMapInterface.getRequestHashMap().asInstanceOf[HashMap[Object, Object]]
        var requestCommand : String = hashMap.get(GLOBALS2.ADMINCOMMAND).asInstanceOf[String]
        if (StringValidationUtil.getInstance().isEmpty(this.command) || (!StringValidationUtil.getInstance().isEmpty(requestCommand) && (this.command.compareTo(requestCommand) == 0))) {
            return true
        }
        return false
    }

}


