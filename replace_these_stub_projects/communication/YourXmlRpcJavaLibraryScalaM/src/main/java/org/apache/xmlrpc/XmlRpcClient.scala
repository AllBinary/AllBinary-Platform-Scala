/* Generated Code Do Not Modify */
package org.apache.xmlrpc

import _root_.java.io.IOException
import _root_.java.net.MalformedURLException
import _root_.java.net.URL
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.init.crypt.jcehelper.CryptInterface
import _root_.org.allbinary.logic.NullUtil

class XmlRpcClient(param_url : String) extends XmlRpcHandler {

    private var url : URL = null

    //    }
    //Constructor
    {
        val url : String = param_url
        //this(new URL(url));
        this.url = new URL(url)
    }

    //    }
    def getURL() : URL = {
        return this.url
    }

    def setBasicAuthentication(user : String, password : String) : Unit = {
    }

    override def execute(method : String, params : BasicArrayList) : Object = {
        return NullUtil.getInstance().NULL_OBJECT
    }

    def executeWithCrypt(method : String, params : BasicArrayList, cryptInterface : CryptInterface) : Object = {
        return NullUtil.getInstance().NULL_OBJECT
    }

}


