/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.dom

import _root_.javax.xml.transform.Source
import _root_.javax.xml.transform.TransformerException
import _root_.javax.xml.transform.URIResolver
import _root_.javax.xml.transform.stream.StreamSource
import _root_.org.allbinary.globals.FREEBLISKET_PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.crypt.file.CryptFileReader
import _root_.org.allbinary.logic.io.path.AbFilePath
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.info.template.TransformInfoTemplateData

class BasicUriResolver(param_extension : String) extends URIResolver {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val uriResolverStrings : URIResolverStrings = URIResolverStrings.getInstance()

    private var extension : String = null

    //TransformInfoInterface parentTransformInfoInterface,
    //Constructor
    {
        val extension : String = param_extension
        //this.parentTransformInfoInterface = parentTransformInfoInterface;
        this.extension = extension
    }

    def getExtension() : String = {
        return this.extension
    }

    def resolve(href : String, base : String) : Source = {
        try {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(URLGLOBALS.getMainPath())
            stringBuffer.append(FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH)
            stringBuffer.append(href)
            val abPath : AbPath = (new AbFilePath(stringBuffer.toString())).asInstanceOf[AbPath]
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().XMLLOGGING)) {
                stringBuffer.delete(0, stringBuffer.length())
                stringBuffer.append(this.uriResolverStrings.ATTEMPT)
                stringBuffer.append(href)
                stringBuffer.append(this.uriResolverStrings.BASE)
                stringBuffer.append(base)
                stringBuffer.append(this.uriResolverStrings.NEW_PATH)
                stringBuffer.append(abPath.toString())
                stringBuffer.append(this.uriResolverStrings.NOTE)
                stringBuffer.append(FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH)
                stringBuffer.append(this.uriResolverStrings.URL_GLOBAL)
                stringBuffer.append(this.uriResolverStrings.REQUIRED_EXTENSION)
                stringBuffer.append(this.extension)
                this.logUtil.putF(stringBuffer.toString(), this, this.uriResolverStrings.RESOLVE)
            }
            return new StreamSource(new CryptFileReader(TransformInfoTemplateData.getInstance().UNCRYPTED_EXTENSION, TransformInfoTemplateData.getInstance().ENCRYPTED_EXTENSION).getInputStream(abPath))
        } catch {
            case e : TransformerException => {
                throw e
            }
            case e : Exception => {
                throw new TransformerException(e)
            }
        }
        throw new IllegalStateException()
    }

    override def toString() : String = {
        try {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(URLGLOBALS.getMainPath())
            stringBuffer.append(FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH)
            stringBuffer.append(this.uriResolverStrings.IMPORT_URL)
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                //Log Error
                return "BasicUriResolver - Does not work without webapp path should be changed"
            }
        }
        throw new IllegalStateException()
    }

}


