/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform

import _root_.org.allbinary.data.tree.dom.document.mapping.DomDocumentMappingInterface
import _root_.org.allbinary.logic.visual.transform.data.TransformDocumentInterface
import _root_.org.allbinary.logic.visual.transform.info.CompositeTransformInfoInterface

trait TransformInterface extends DomDocumentMappingInterface with CompositeTransformInfoInterface {

    def getTypeId() : Int

    def setTransformDocumentInterface(viewDocumentInterface : TransformDocumentInterface) : Unit

    def getTransformDocumentInterface() : TransformDocumentInterface

    //public String getEditorView()
    def view() : String

}


