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

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.util.ResourceBundle;

import static java.lang.String.format;

public class AhrefLabel extends JLabel {

    private static final String URL_TEMPLATE = "<html><font size=\"%s\"><a href=\"%s\">%s</a></font></html>";

    public AhrefLabel(String url, String urlText, String toolTipText, String htmlLinkColor, int fontSize) {
        setText(urlText != null ? format(URL_TEMPLATE, fontSize, url, urlText) : format(URL_TEMPLATE, fontSize, url, url));
        setForeground(htmlLinkColor != null ? Color.decode(htmlLinkColor) : Color.blue.brighter());
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setToolTipText(toolTipText);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(URI.create(url));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(AhrefLabel.this, format(localize("ahreflabel.error.text"), url), localize("ahreflabel.error.title"), JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public AhrefLabel(String url, String urlText, String toolTipText) {
        this(url, urlText, toolTipText, null, 3);
    }

    public AhrefLabel(String url, String urlText) {
        this(url, urlText, null, null, 3);
    }

    public AhrefLabel(String url) {
        this(url, null, null, null, 3);
    }

    private String localize(String key) {
        ResourceBundle bundle = ResourceBundle.getBundle(format("%s/i18n/MessagesBundle", getClass().getPackageName().replace(".", "/")));
        return bundle.getString(key);
    }
}