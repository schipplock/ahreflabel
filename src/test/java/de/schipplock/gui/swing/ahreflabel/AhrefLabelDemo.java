/*
 * Copyright 2022 Andreas Schipplock
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.schipplock.gui.swing.ahreflabel;

import de.schipplock.gui.swing.lafmanager.LAFManager;
import de.schipplock.gui.swing.svgicon.SvgIconManager;
import de.schipplock.gui.swing.svgicon.SvgIcons;
import net.miginfocom.swing.MigLayout;

import java.awt.*;
import java.util.Locale;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class AhrefLabelDemo extends JFrame {

    public AhrefLabelDemo() {
        setupFrame();
    }

    private void centerFrame() {
        GraphicsDevice screen = MouseInfo.getPointerInfo().getDevice();
        Rectangle r = screen.getDefaultConfiguration().getBounds();
        int x = (r.width - this.getWidth()) / 2 + r.x;
        int y = (r.height - this.getHeight()) / 2 + r.y;
        setLocation(x, y);
    }

    private void setupFrame() {
        setIconImages(SvgIconManager.getBuiltinWindowIconImages(SvgIcons.SVGICON_DATABASE, "#d15000"));
        setPreferredSize(new Dimension(200, 70));
        setMinimumSize(new Dimension(200, 70));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centerFrame();

        LAFManager.create().setLookAndFeelByName("FlatLaf IntelliJ");
        setTitle("AhrefLabel Demo");

        JPanel mainPanel = new JPanel(new MigLayout(""));

        JPanel actionPanel = new JPanel(new MigLayout(""));
        actionPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        var ahrefLabel = new AhrefLabel("https://schipplock.de");

        mainPanel.add(new JLabel("<html><b>Website:</b></html>"), "");
        mainPanel.add(ahrefLabel, "");
        getContentPane().add(mainPanel);
        pack();
    }

    public static void createAndShowGui() {
        JFrame frame = new AhrefLabelDemo();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Locale.setDefault(Locale.forLanguageTag("en-US"));
        SwingUtilities.invokeLater(AhrefLabelDemo::createAndShowGui);
    }
}
