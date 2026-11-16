/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image.gui

import _root_.org.allbinary.media.image.analysis.ImageAnalysisResults
import _root_.org.allbinary.media.image.analysis.ImageColorRangeResults
import _root_.org.allbinary.media.image.analysis.ImageColorResults
import _root_.org.allbinary.string.CommonPhoneStrings

class ImageAnalysisResultsJPanel(param_imageAnalysisResultsArray : Array[ImageAnalysisResults]) extends _root_.javax.swing.JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var avgBlueJTextField : _root_.javax.swing.JTextField = null

    private var avgGreenJTextField : _root_.javax.swing.JTextField = null

    private var avgRedJTextField : _root_.javax.swing.JTextField = null

    private var jComboBox1 : _root_.javax.swing.JComboBox[Object] = null

    private var jLabel1 : _root_.javax.swing.JLabel = null

    private var jLabel10 : _root_.javax.swing.JLabel = null

    private var jLabel11 : _root_.javax.swing.JLabel = null

    private var jLabel12 : _root_.javax.swing.JLabel = null

    private var jLabel13 : _root_.javax.swing.JLabel = null

    private var jLabel2 : _root_.javax.swing.JLabel = null

    private var jLabel3 : _root_.javax.swing.JLabel = null

    private var jLabel4 : _root_.javax.swing.JLabel = null

    private var jLabel5 : _root_.javax.swing.JLabel = null

    private var jLabel6 : _root_.javax.swing.JLabel = null

    private var jLabel7 : _root_.javax.swing.JLabel = null

    private var jLabel8 : _root_.javax.swing.JLabel = null

    private var jLabel9 : _root_.javax.swing.JLabel = null

    private var matchingPixelsJTextField : _root_.javax.swing.JTextField = null

    private var maxBlueJTextField : _root_.javax.swing.JTextField = null

    private var maxGreenJTextField : _root_.javax.swing.JTextField = null

    private var maxRedJTextField : _root_.javax.swing.JTextField = null

    private var minBlueJTextField : _root_.javax.swing.JTextField = null

    private var minGreenJTextField : _root_.javax.swing.JTextField = null

    private var minRedJTextField : _root_.javax.swing.JTextField = null

    private var percentMatchingJTextField : _root_.javax.swing.JTextField = null

    private var totalPixelsJTextField : _root_.javax.swing.JTextField = null

    //Constructor
    {
        val imageAnalysisResultsArray : Array[ImageAnalysisResults] = param_imageAnalysisResultsArray
        this.initComponents()
        /*         for(int index = 0; index < imageAnalysisResultsArray.length; index++)         {         }         */
        val imageAnalysisResults : ImageAnalysisResults = imageAnalysisResultsArray(0)
        this.updateImageColorRangeResults(imageAnalysisResults)
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        this.jLabel1 = new _root_.javax.swing.JLabel()
        this.jLabel2 = new _root_.javax.swing.JLabel()
        this.jLabel3 = new _root_.javax.swing.JLabel()
        this.percentMatchingJTextField = new _root_.javax.swing.JTextField()
        this.totalPixelsJTextField = new _root_.javax.swing.JTextField()
        this.matchingPixelsJTextField = new _root_.javax.swing.JTextField()
        this.jComboBox1 = new _root_.javax.swing.JComboBox[Object]()
        this.jLabel4 = new _root_.javax.swing.JLabel()
        this.jLabel5 = new _root_.javax.swing.JLabel()
        this.jLabel6 = new _root_.javax.swing.JLabel()
        this.jLabel7 = new _root_.javax.swing.JLabel()
        this.avgRedJTextField = new _root_.javax.swing.JTextField()
        this.avgGreenJTextField = new _root_.javax.swing.JTextField()
        this.avgBlueJTextField = new _root_.javax.swing.JTextField()
        this.minGreenJTextField = new _root_.javax.swing.JTextField()
        this.jLabel8 = new _root_.javax.swing.JLabel()
        this.jLabel9 = new _root_.javax.swing.JLabel()
        this.jLabel10 = new _root_.javax.swing.JLabel()
        this.minRedJTextField = new _root_.javax.swing.JTextField()
        this.minBlueJTextField = new _root_.javax.swing.JTextField()
        this.jLabel11 = new _root_.javax.swing.JLabel()
        this.jLabel12 = new _root_.javax.swing.JLabel()
        this.jLabel13 = new _root_.javax.swing.JLabel()
        this.maxRedJTextField = new _root_.javax.swing.JTextField()
        this.maxGreenJTextField = new _root_.javax.swing.JTextField()
        this.maxBlueJTextField = new _root_.javax.swing.JTextField()
        this.jLabel1.setText("Matching Pixels:")
        this.jLabel2.setText("Total Pixels:")
        this.jLabel3.setText("Percent Matching:")
        this.percentMatchingJTextField.setEditable(false)
        this.totalPixelsJTextField.setEditable(false)
        this.matchingPixelsJTextField.setEditable(false)
        this.jComboBox1.setModel(new _root_.javax.swing.DefaultComboBoxModel[Object](Array[String](CommonPhoneStrings.getInstance().ONE).asInstanceOf[Array[Object]]))
        this.jComboBox1.setEnabled(false)
        this.jLabel4.setText("Image:")
        this.jLabel5.setText("Average Red:")
        this.jLabel6.setText("Average Green:")
        this.jLabel7.setText("Average Blue:")
        this.avgRedJTextField.setEditable(false)
        this.avgGreenJTextField.setEditable(false)
        this.avgBlueJTextField.setEditable(false)
        this.minGreenJTextField.setEditable(false)
        this.jLabel8.setText("Min Red:")
        this.jLabel9.setText("Min Green:")
        this.jLabel10.setText("Min Blue:")
        this.minRedJTextField.setEditable(false)
        this.minBlueJTextField.setEditable(false)
        this.jLabel11.setText("Max Red:")
        this.jLabel12.setText("Max Green:")
        this.jLabel13.setText("Max Blue:")
        this.maxRedJTextField.setEditable(false)
        this.maxGreenJTextField.setEditable(false)
        this.maxBlueJTextField.setEditable(false)
        var layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this)
        this.setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel3).addComponent(jLabel2).addComponent(jLabel1).addComponent(jLabel5).addComponent(jLabel6).addComponent(jLabel7).addComponent(jLabel4)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(jComboBox1, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 81, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(avgBlueJTextField, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 81, _root_.java.lang.Short.MAX_VALUE).addComponent(avgGreenJTextField, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 81, _root_.java.lang.Short.MAX_VALUE).addComponent(avgRedJTextField, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 81, _root_.java.lang.Short.MAX_VALUE).addComponent(totalPixelsJTextField, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 81, _root_.java.lang.Short.MAX_VALUE).addComponent(percentMatchingJTextField, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 81, _root_.java.lang.Short.MAX_VALUE).addComponent(matchingPixelsJTextField, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 81, _root_.java.lang.Short.MAX_VALUE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel12).addComponent(jLabel13).addComponent(jLabel8).addComponent(jLabel9).addComponent(jLabel10).addComponent(jLabel11)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(minRedJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 82, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(maxGreenJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 82, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(minGreenJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 82, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(minBlueJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 82, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(maxRedJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 82, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(maxBlueJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 82, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(18, _root_.java.lang.Short.MAX_VALUE)))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4).addComponent(jComboBox1, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(matchingPixelsJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel8).addComponent(minRedJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(totalPixelsJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel9).addComponent(minGreenJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(percentMatchingJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel10).addComponent(minBlueJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel5).addComponent(avgRedJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel11).addComponent(maxRedJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel6).addComponent(avgGreenJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(maxGreenJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel12)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel7).addComponent(avgBlueJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel13).addComponent(maxBlueJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE))))
    }

    // </editor-fold>//GEN-END:initComponents
    private def updateImageColorRangeResults(imageAnalysisResults : ImageAnalysisResults) : Unit = {
        val imageColorRangeResults : ImageColorRangeResults = imageAnalysisResults.getImageColorRangeResults()
        this.matchingPixelsJTextField.setText(new _root_.java.lang.Long(imageColorRangeResults.getMatchingPixelsChecked()).toString())
        this.totalPixelsJTextField.setText(new _root_.java.lang.Long(imageColorRangeResults.getTotalPixelsChecked()).toString())
        this.percentMatchingJTextField.setText(new _root_.java.lang.Float(imageColorRangeResults.getPercent()).toString())
        var imageColorResults : ImageColorResults = imageAnalysisResults.getImageColorResults()
        this.avgRedJTextField.setText(new _root_.java.lang.Float(imageColorResults.getColorAverage().getAvgRed()).toString())
        this.avgGreenJTextField.setText(new _root_.java.lang.Float(imageColorResults.getColorAverage().getAvgGreen()).toString())
        this.avgBlueJTextField.setText(new _root_.java.lang.Float(imageColorResults.getColorAverage().getAvgBlue()).toString())
        this.minRedJTextField.setText(new _root_.java.lang.Long(imageColorResults.getColorRange().getMinRed()).toString())
        this.minGreenJTextField.setText(new _root_.java.lang.Long(imageColorResults.getColorRange().getMinGreen()).toString())
        this.minBlueJTextField.setText(new _root_.java.lang.Long(imageColorResults.getColorRange().getMinBlue()).toString())
        this.maxRedJTextField.setText(new _root_.java.lang.Long(imageColorResults.getColorRange().getMaxRed()).toString())
        this.maxGreenJTextField.setText(new _root_.java.lang.Long(imageColorResults.getColorRange().getMaxGreen()).toString())
        this.maxBlueJTextField.setText(new _root_.java.lang.Long(imageColorResults.getColorRange().getMaxBlue()).toString())
    }

}


