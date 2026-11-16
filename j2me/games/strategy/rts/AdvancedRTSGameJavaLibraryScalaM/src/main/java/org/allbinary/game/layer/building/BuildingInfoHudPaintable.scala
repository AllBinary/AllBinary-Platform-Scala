/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.building

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.ag.layer.hud.basic.NumberStringHud
import _root_.org.allbinary.game.ag.layer.hud.basic.NumberStringHudFactory
import _root_.org.allbinary.game.layer.SelectionHudPaintable
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.game.graphics.hud.BasicHudFactory
import _root_.org.allbinary.game.layer.NullPathFindingLayer
import _root_.org.allbinary.game.layer.PathFindingLayerInterface
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.logic.math.MathUtil

/**  *  * @author user  */
class BuildingInfoHudPaintable private() extends SelectionHudPaintable {
    import _root_.org.allbinary.game.layer.building.BuildingInfoHudPaintable.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val HEALTH : String = "Health:"

    private var productivityHud : NumberStringHud = null

    private var efficiencyHud : NumberStringHud = null

    private var healthHud : NumberStringHud = null

    private var maxHealthHud : NumberStringHud = null

    private var rtsLayer : PathFindingLayerInterface = NullPathFindingLayer.NULL_PATH_FINDING_LAYER

    private var currentHealth : Int = 0

    //Constructor
    {
        val numberStringHudFactory : NumberStringHudFactory = NumberStringHudFactory.getInstance()
        var productivityHud : NumberStringHud = numberStringHudFactory.NULL_NUMBER_STRING_HUD
        var efficiencyHud : NumberStringHud = numberStringHudFactory.NULL_NUMBER_STRING_HUD
        var healthHud : NumberStringHud = numberStringHudFactory.NULL_NUMBER_STRING_HUD
        var maxHealthHud : NumberStringHud = numberStringHudFactory.NULL_NUMBER_STRING_HUD
        try {
            var index : Int = 0
            val basicHudFactory : BasicHudFactory = BasicHudFactory.getInstance()
            val basicColor : BasicColor = this.getBasicColorP()
            val textX : Int = this.textX
            val y : Int = this.y
            val firstIndex : Int = index
            class ProductivityNumberStringHud() extends NumberStringHud("Productivity:", 999, basicHudFactory.ABSOLUTE, basicHudFactory.HORIZONTAL, 0, basicColor) {

                override def updateMeasurement(graphics : Graphics) : Unit = {
                    val font : Font = graphics.getFont()
                    this.updateMaxWidth = textX
                    this.updateMaxHeight = y + ((firstIndex + 1) * font.getHeight())
                    super.updateMeasurement(graphics)
                }

            }


            productivityHud = new ProductivityNumberStringHud()
            index += 1
            val secondIndex : Int = index
            class EfficiencyNumberStringHud() extends NumberStringHud("Efficiency:", 999, basicHudFactory.ABSOLUTE, basicHudFactory.HORIZONTAL, 0, basicColor) {

                override def updateMeasurement(graphics : Graphics) : Unit = {
                    super.updateMeasurement(graphics)
                    val font : Font = graphics.getFont()
                    this.updateMaxWidth = textX
                    this.updateMaxHeight = y + ((secondIndex + 1) * font.getHeight())
                }

            }


            efficiencyHud = new EfficiencyNumberStringHud()
            index += 1
            val HEALTH : String = this.HEALTH
            val thirdIndex : Int = index
            class HealthNumberStringHud() extends NumberStringHud(HEALTH, 99999, basicHudFactory.ABSOLUTE, basicHudFactory.HORIZONTAL, 0, basicColor) {

                override def updateMeasurement(graphics : Graphics) : Unit = {
                    val font : Font = graphics.getFont()
                    this.updateMaxWidth = textX
                    this.updateMaxHeight = y + ((thirdIndex + 1) * font.getHeight())
                    super.updateMeasurement(graphics)
                }

            }


            val totalLength : Int = HEALTH.length() + 1
            healthHud = new HealthNumberStringHud()
            val fourthIndex : Int = index
            class MaxHealthNumberStringHud() extends NumberStringHud("/ ", 99999, basicHudFactory.ABSOLUTE, basicHudFactory.HORIZONTAL, 0, basicColor) {

                override def updateMeasurement(graphics : Graphics) : Unit = {
                    super.updateMeasurement(graphics)
                    val font : Font = graphics.getFont()
                    this.updateMaxWidth = textX + (totalLength * font.getHeight())
                    this.updateMaxHeight = y + ((fourthIndex + 1) * font.getHeight())
                }

            }


            maxHealthHud = new MaxHealthNumberStringHud()
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR, e)
            }
        }
        this.productivityHud = productivityHud
        this.efficiencyHud = efficiencyHud
        this.healthHud = healthHud
        this.maxHealthHud = maxHealthHud
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        val totalLength : Int = this.HEALTH.length() + MathUtil.getInstance().getTotalDigits(this.currentHealth)
        this.maxHealthHud.setX(this.textX + MyFontProcessor.defaultStringWidth(font, totalLength))
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    override def setBasicColorP(basicColor : BasicColor) : Unit = {
        super.setBasicColorP(basicColor)
        this.productivityHud.setBasicColorP(basicColor)
        this.efficiencyHud.setBasicColorP(basicColor)
        this.healthHud.setBasicColorP(basicColor)
        this.maxHealthHud.setBasicColorP(basicColor)
    }

    override def paint(graphics : Graphics) : Unit = {
        super.paint(graphics)
        this.myFontProcessor.process(graphics)
        this.productivityHud.paint(graphics)
        this.efficiencyHud.paint(graphics)
        this.healthHud.paint(graphics)
        this.maxHealthHud.paint(graphics)
        this.getAnimationInterface().paintXY(graphics, this.imageX, this.y)
    }

    override def updateSelectionInfo() : Unit = {
        val buildingLayer : BuildingLayer = this.rtsLayer.asInstanceOf[BuildingLayer]
        this.setName(buildingLayer.getName())
        this.setAnimationInterface(buildingLayer.getVerticleBuildAnimationInterface())
        this.productivityHud.set(buildingLayer.getProductivity())
        this.efficiencyHud.set(buildingLayer.getEfficiency() / 100)
        this.currentHealth = buildingLayer.getHealthInterface().getHealth()
        this.healthHud.set(this.currentHealth)
        this.myFontProcessor = this.updateMyFontProcessor
        this.maxHealthHud.set(buildingLayer.getHealthInterface().getMaxHealth())
    }

    def setRtsLayer(rtsLayer : PathFindingLayerInterface) : Unit = {
        this.rtsLayer = rtsLayer
    }

}

object BuildingInfoHudPaintable {
    private val instance : BuildingInfoHudPaintable = new BuildingInfoHudPaintable()

    def getInstance() : BuildingInfoHudPaintable = {
        return BuildingInfoHudPaintable.instance
    }

}


