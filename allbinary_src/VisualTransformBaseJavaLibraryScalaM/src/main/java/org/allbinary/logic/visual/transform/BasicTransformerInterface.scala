/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform

import _root_.java.io.InputStream
import _root_.javax.xml.transform.URIResolver
import _root_.javax.xml.transform.stream.StreamSource
import _root_.org.allbinary.logic.visual.transform.info.CompositeTransformInfoInterface

trait BasicTransformerInterface extends CompositeTransformInfoInterface {

    def setInputStream(inputStream : InputStream) : Unit

    def setURIResolver(uriResolver : URIResolver) : Unit

    def getStreamSource() : StreamSource

    def getInputStream() : InputStream

    def getURIResolver() : URIResolver

    def translate(xmlDocumentStr : String) : String

}


