package org.antlr.works.plugin;

import org.antlr.works.IDE;
import org.antlr.works.plugin.container.PCXJApplicationDelegate;
import org.antlr.works.plugin.container.PluginWindow;
import org.antlr.xjlib.appkit.app.XJApplication;

import javax.swing.*;
/*

[The "BSD licence"]
Copyright (c) 2005-2006 Jean Bovet
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
notice, this list of conditions and the following disclaimer in the
documentation and/or other materials provided with the distribution.
3. The name of the author may not be used to endorse or promote products
derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

*/

public class PluginTester {

    private PluginWindow window;
    private JSplitPane vertical;

    private void createAndShowGUI() {
        XJApplication.setDelegate(new PCXJApplicationDelegate());
        XJApplication.setPropertiesPath(IDE.PROPERTIES_PATH);
        
        window = new PluginWindow();
        window.load("/Users/bovet/Grammars/syntax.g");

        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("Plugin Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);

        frame.add(window.getRootPane());

        frame.pack();
        frame.setVisible(true);
        window.becomingVisibleForTheFirstTime();
        vertical.setDividerLocation((int)(window.getContentPane().getHeight()*0.5));
    }

    public void assemble() {
//        window.getContentPane().add(panel);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PluginTester().createAndShowGUI();
            }
        });
    }

}
