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
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpStoreInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.template.TransformInfoTemplateData

class StoreUriResolver(param_parentTransformInfoInterface : TransformInfoInterface, param_basicURIResolver : BasicUriResolver) extends URIResolver {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val uriResolverStrings : URIResolverStrings = URIResolverStrings.getInstance()

    private var basicURIResolver : BasicUriResolver = null

    private var parentTransformInfoInterface : TransformInfoInterface = null

    //Constructor
    {
        val parentTransformInfoInterface : TransformInfoInterface = param_parentTransformInfoInterface
        val basicURIResolver : BasicUriResolver = param_basicURIResolver
        this.parentTransformInfoInterface = parentTransformInfoInterface
        this.basicURIResolver = basicURIResolver
    }

    def resolve(href : String, base : String) : Source = {
        try {
            val stringBuffer : StringMaker = new StringMaker()
            val transformInfoHttpStoreInterface : TransformInfoHttpStoreInterface = this.parentTransformInfoInterface.asInstanceOf[TransformInfoHttpStoreInterface]
            stringBuffer.append(URLGLOBALS.getMainPath()).append(FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH).append(transformInfoHttpStoreInterface.getStoreName()).append(AbPathData.getInstance().SEPARATOR).append(href)
            val fileAbPath : AbPath = (new AbFilePath(stringBuffer.toString())).asInstanceOf[AbPath]
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().XMLLOGGING)) {
                stringBuffer.delete(0, stringBuffer.length())
                stringBuffer.append(this.uriResolverStrings.ATTEMPT)
                stringBuffer.append(href)
                stringBuffer.append(this.uriResolverStrings.BASE)
                stringBuffer.append(base)
                stringBuffer.append(this.uriResolverStrings.NEW_PATH)
                stringBuffer.append(fileAbPath.toString())
                stringBuffer.append(this.uriResolverStrings.NOTE)
                stringBuffer.append(FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH)
                stringBuffer.append(this.uriResolverStrings.URL_GLOBAL)
                stringBuffer.append(this.uriResolverStrings.REQUIRED_EXTENSION)
                stringBuffer.append(this.basicURIResolver.getExtension())
                this.logUtil.putF(stringBuffer.toString(), this, this.uriResolverStrings.RESOLVE)
            }
            return new StreamSource(new CryptFileReader(TransformInfoTemplateData.getInstance().UNCRYPTED_EXTENSION, TransformInfoTemplateData.getInstance().ENCRYPTED_EXTENSION).getInputStream(fileAbPath))
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
            return (URLGLOBALS.getMainPath() + FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH) + "{Store Name if Any}/{import url}"
        } catch {
            case e : Exception => {
                //Log Error
                return "StoreUriResolver - Does not work without webapp path should be changed"
            }
        }
        throw new IllegalStateException()
    }

}


