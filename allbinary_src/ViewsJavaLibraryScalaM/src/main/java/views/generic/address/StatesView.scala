/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.address

import _root_.org.allbinary.business.user.address.StreetAddressData
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.globals.FREEBLISKET_PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.LineReader
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class StatesView() extends DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    def toXmlNode(document : Document) : Node = {
        try {
            var node : Node = document.createElement(StreetAddressData.STATES)
            var statesFile : String = (URLGLOBALS.getMainPath() + FREEBLISKET_PATH_GLOBALS.getInstance().LINEDATAPATH) + "states.txt"
            var lineReader : LineReader = new LineReader(statesFile)

            {
                while (lineReader.hasNext()) {
                    var option : String = lineReader.next()
                    node.appendChild(ModDomHelper.createNameValueNodes(document, StreetAddressData.STATE, option))
                }
            }
            return node
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil.put(this.commonStrings.FAILURE, this, "toXmlNode", e)
                }
                //throw e;
                return null
            }
        }
        throw new IllegalStateException()
    }

}


