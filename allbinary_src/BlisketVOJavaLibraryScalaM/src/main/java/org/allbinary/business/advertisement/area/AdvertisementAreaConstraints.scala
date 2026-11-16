/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement.area

import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.logic.control.contraints.display.browser.DisplayInBrowserContraints
import _root_.org.allbinary.logic.control.contraints.display.browser.DisplayInBrowserContraintsInterface
import _root_.org.allbinary.logic.control.contraints.size.TwoDimensionalConstraint
import _root_.org.allbinary.logic.control.contraints.size.TwoDimensionalConstraintInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class AdvertisementAreaConstraints(param_document : Document) extends AdvertisementAreaConstraintsInterface {

    private var displayInBrowserContraintsInterface : DisplayInBrowserContraintsInterface = null

    private var twoDimensionConstraintsInterface : TwoDimensionalConstraintInterface = null

    //Constructor
    {
        val document : Document = param_document
        var node : Node = DomSearchHelper.getNode(AdvertisementAreaData.getInstance().NAME, document.getChildNodes())
        this.displayInBrowserContraintsInterface = new DisplayInBrowserContraints(node)
        this.twoDimensionConstraintsInterface = new TwoDimensionalConstraint(node)
    }

    def setDisplayInBrowserContraints(displayInBrowserContraintsInterface : DisplayInBrowserContraintsInterface) : Unit = {
        this.displayInBrowserContraintsInterface = displayInBrowserContraintsInterface
    }

    def getTwoDimensionContraints(twoDimensionConstraintsInterface : TwoDimensionalConstraintInterface) : Unit = {
        this.twoDimensionConstraintsInterface = twoDimensionConstraintsInterface
    }

    def getDisplayInBrowserContraints() : DisplayInBrowserContraintsInterface = {
        return this.displayInBrowserContraintsInterface
    }

    def getTwoDimensionContraints() : TwoDimensionalConstraintInterface = {
        return this.twoDimensionConstraintsInterface
    }

}


