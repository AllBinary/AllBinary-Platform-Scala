/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.data

import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.control.search.SearchRequest

class TransformStoreDocumentFactory private() {
    import _root_.org.allbinary.logic.visual.transform.data.TransformStoreDocumentFactory.{*}

}

object TransformStoreDocumentFactory {
    def getInstance(pageContext : PageContext, weblisketSession : WeblisketSession) : TransformDocumentInterface = {
        return (new TransformStoreDocument(pageContext, weblisketSession)).asInstanceOf[TransformDocumentInterface]
    }

    def getInstance(searchRequest : SearchRequest) : TransformDocumentInterface = {
        return (new TransformStoreDocument(searchRequest)).asInstanceOf[TransformDocumentInterface]
    }

}


