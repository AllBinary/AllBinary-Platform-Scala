/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform

import _root_.java.io.InputStream
import _root_.java.io.StringBufferInputStream
import _root_.javax.xml.transform.URIResolver
import _root_.javax.xml.transform.stream.StreamSource
import _root_.org.allbinary.data.tree.dom.XslHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.generator.TransformInfoObjectConfigGenerator
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.generator.TransformInfoObjectConfigGeneratorFactory
import _root_.org.allbinary.string.CommonStrings

class AbTransformer(param_transformInfoInterface : TransformInfoInterface) extends BasicTransformerInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var transformInfoInterface : TransformInfoInterface = null

    private var inputStream : InputStream = null

    private var uriResolver : URIResolver = null

    //Constructor for template/xsl imports for an existing transform to get the imports source stream
    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        this.transformInfoInterface = transformInfoInterface
    }

    def getTransformInfoInterface() : TransformInfoInterface = {
        return this.transformInfoInterface
    }

    def setInputStream(inputStream : InputStream) : Unit = {
        this.inputStream = inputStream
    }

    def setURIResolver(uriResolver : URIResolver) : Unit = {
        this.uriResolver = uriResolver
    }

    def getInputStream() : InputStream = {
        return this.inputStream
    }

    def getURIResolver() : URIResolver = {
        return this.uriResolver
    }

    def getStreamSource() : StreamSource = {
        return new StreamSource(this.getInputStream())
    }

    def translate(xmlDocumentStr : String) : String = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().XMLLOGGING)) {
                this.logUtil.putF("xml: \n" + xmlDocumentStr, this, "translate(String xmlDocumentStr)")
            }
            if (this.getURIResolver() == null) {
                throw new Exception("No URIResolver")
            }
            var result : String = XslHelper.getInstance().translate(this.getURIResolver(), new StreamSource(this.getInputStream()), new StreamSource(new StringBufferInputStream(xmlDocumentStr)))
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().XSLLOGGING)) {
                this.logUtil.putF("translated xml: " + result, this, "translate(String xmlDocumentStr)")
            }
            var transformInfoObjectConfigGeneratorInterface : TransformInfoObjectConfigGenerator = TransformInfoObjectConfigGeneratorFactory.getInstance().getInstance(this.getTransformInfoInterface())
            return transformInfoObjectConfigGeneratorInterface.process(result)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil.put(this.transformInfoInterface.log(), this, "translate(document)", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


