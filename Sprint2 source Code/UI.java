import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class UI {

    private static final int FRAME_WIDTH = 1200;
    private static final int FRAME_HEIGHT = 800;

    private final BoardPanel boardPanel;
    private final TabbedPanel tabbedPanel = new TabbedPanel();
    private final InfoPanel infoPanel = new InfoPanel();
    private final CommandPanel commandPanel = new CommandPanel();

    UI(Tokens characters, Weapons weapons) {
        JFrame frame = new JFrame();
        boardPanel = new BoardPanel(characters, weapons);
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setTitle("Cluedo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(boardPanel, BorderLayout.WEST);
        frame.add(tabbedPanel, BorderLayout.CENTER);
        frame.add(infoPanel, BorderLayout.EAST);
        frame.add(commandPanel,BorderLayout.PAGE_END);
        frame.setExtendedState(frame.MAXIMIZED_BOTH);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    public String getCommand() {
        return commandPanel.getCommand();
    }

    public void display() {
        boardPanel.refresh();
    }

    public void displayString(String string) {
        infoPanel.addText(string);
    }
}